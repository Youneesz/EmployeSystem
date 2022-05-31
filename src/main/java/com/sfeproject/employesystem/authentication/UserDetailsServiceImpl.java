package com.sfeproject.employesystem.authentication;

import com.sfeproject.employesystem.model.Employe;
import com.sfeproject.employesystem.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Employe> employe = employeRepository.findEmployeByEmailEmp(email);
        employe.orElseThrow(() -> new UsernameNotFoundException("User Not Found : " + email));
        return employe.map(UserDetailsImpl::new).get();
    }
}
