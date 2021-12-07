package com.kk.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjunkang
 */
@RestController
public class UserController {

//    @Value("${username}")
    private String username;
//    @Value("${password}")
    private String password;

    @GetMapping("username")
    public String getUsername(){
        return  username;
    }

    @GetMapping("password")
    public String getPassword(){
        return  password;
    }
}
