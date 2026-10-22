package com.mediclaimx.staffservice.config;

import com.mediclaimx.staffservice.enums.StaffRole;
import com.mediclaimx.staffservice.enums.StaffStatus;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Getter
@RequiredArgsConstructor
public class StaffPrincipal implements UserDetails {

    private final Long id;
    private final String name;
    private final String email;
    private final String password;
    private final StaffRole staffRole;
    private final StaffStatus status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }
}
