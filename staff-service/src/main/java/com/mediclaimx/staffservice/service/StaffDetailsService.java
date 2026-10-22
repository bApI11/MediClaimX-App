package com.mediclaimx.staffservice.service;

import com.mediclaimx.staffservice.config.StaffPrincipal;
import com.mediclaimx.staffservice.entity.Staff;
import com.mediclaimx.staffservice.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffDetailsService implements UserDetailsService {

    private final StaffRepository staffRepository;
    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        Staff staff=staffRepository.findByEmailIgnoreCaseOrPhone(identifier,identifier)
                .orElseThrow(()->new UsernameNotFoundException("Invalid email or phone number"));
        return new StaffPrincipal(
                staff.getId(),
                staff.getName(),
                staff.getEmail(),
                staff.getPassword(),
                staff.getRole(),
                staff.getStatus()
        );
    }
}
