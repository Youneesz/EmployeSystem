package com.sfeproject.employesystem.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(
                        "/actualites/getAll","/actualites/get/{id}","/actualites/update/{id}","/actualites/add","/actualites/delete/{id}",
                        "/conges/getall","/conges/get/{id}","/conges/update/{id}","/conges/add","/conges/delete/{id}",
                        "/demendesconge/getall","/demendesconge/get/{id}","/demendesconge/update/{id}","/demendesconge/add/{id_emp}/{id_conge}","/demendesconge/delete/{id}",
                        "/demendesPiece/getall","/demendesPiece/get/{id}","/demendesPiece/update/{id}","/demendesPiece/add","/demendesPiece/delete/{id}",
                        "/employes/getall","/employes/get/{id}","/employes/update/{id}","/employes/add","/employes/delete/{id}",
                        "/pieces/getall","/pieces/get/{id}","/pieces/update/{id}","/pieces/add","/pieces/delete/{id}",
                        "/piecesJointes/getAll","/piecesJointes/get/{id}","/piecesJointes/update/{id}","/piecesJointes/add","/piecesJointes/delete/{id}","/piecesJointes/pieceJointeFiltred/{id}",
                        "/affectations/getAll","/affectations/get/{id}","/affectations/update/{id}","/affectations/add","/affectations/delete/{id}",
                        "/taches/getAll","/taches/get/{id}","/taches/update/{id}","/taches/add","/taches/delete/{id}",
                        "/actualites/getAll","/actualites/get/{id}","/actualites/update/{id}","/actualites/add","/actualites/delete/{id}").hasRole("ADMIN")
                .antMatchers("/employes/get/{id}").hasAnyRole("USER")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
