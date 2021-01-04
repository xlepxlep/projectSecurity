package com.example.projectSecurity.principals;

import com.example.projectSecurity.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private User citizen;

    public UserPrincipal(User citizen) {
        this.citizen = citizen;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        GrantedAuthority grantedAuthority =
                new SimpleGrantedAuthority("ROLE_"+this.citizen.getRoles());

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add( grantedAuthority);

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.citizen.getPassword();
    }

    @Override
    public String getUsername() {
        return this.citizen.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.citizen.getActive() == 1;
    }
}
