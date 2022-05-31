package com.sfeproject.employesystem.authentication;

import com.sfeproject.employesystem.model.Employe;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private String email;
    private String motPasse;
    private List<GrantedAuthority> authorities;


    public UserDetailsImpl(Employe employe) {
        this.email = employe.getEmailEmp();
        this.motPasse = employe.getMotPasse();
        this.authorities = Arrays.stream(employe.getRole().getIntituleRole().split(","))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public UserDetailsImpl() { }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return motPasse;
    }

    @Override
    public String getUsername() {
        return email;
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
        return true;
    }
}
