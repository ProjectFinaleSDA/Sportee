package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.AuthenticationInfo;
import com.sportee.sportee.data.repositories.AuthenticationInfoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    private AuthenticationInfoRepository authenticationInfoRepository;

    public LoginService(AuthenticationInfoRepository authenticationInfoRepository) {
        this.authenticationInfoRepository = authenticationInfoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AuthenticationInfo a = authenticationInfoRepository.findByUserName(s)
                .orElseThrow(() -> new UsernameNotFoundException(s));
        return new CustomUserDetails(a);
    }


}
