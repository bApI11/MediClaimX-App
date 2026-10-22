package com.mediclaimx.authservice.filter;

import jakarta.ws.rs.core.HttpHeaders;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter
        implements GlobalFilter {

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        String token = exchange.getRequest()
                .getHeaders()
                .getFirst(HttpHeaders.AUTHORIZATION);

        if(token == null ||
                !token.startsWith("Bearer ")) {

            exchange.getResponse()
                    .setStatusCode(
                            HttpStatus.UNAUTHORIZED);

            return exchange.getResponse()
                    .setComplete();
        }

        return chain.filter(exchange);
    }
}