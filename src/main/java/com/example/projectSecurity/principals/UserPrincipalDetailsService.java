package com.example.projectSecurity.principals;

import com.example.projectSecurity.Repository.UserRepository;
import com.example.projectSecurity.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository citizenRepository;

    public UserPrincipalDetailsService(UserRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User citizen = this.citizenRepository.findByUsername(s);
        UserPrincipal citizenPrincipal = new UserPrincipal(citizen);

        return citizenPrincipal;
    }
}
