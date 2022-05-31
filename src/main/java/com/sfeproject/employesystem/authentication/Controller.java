package com.sfeproject.employesystem.authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @GetMapping("/")
    public String home(){
        return "<h1> Welcome to our app <h1/>";
    }

    @GetMapping("/user")
    public String homeUser(){
        return "<h1> Welcome user to our app <h1/>";
    }

    @GetMapping("/admin")
    public String homeAdmin(){
        return "<h1> Welcome admin to our app <h1/>";
    }



}
