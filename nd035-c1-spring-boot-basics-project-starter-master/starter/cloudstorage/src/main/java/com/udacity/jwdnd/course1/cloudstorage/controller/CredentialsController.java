package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CredentialsController {

    public UserMapper userMapper;
    public CredentialService credentialService;

    public CredentialsController(UserMapper userMapper, CredentialService credentialService) {
        this.userMapper = userMapper;
        this.credentialService = credentialService;
    }

    @PostMapping("/addCredential")
    public String addCredential() {
        return null;
    }

    @GetMapping("/removeCredential")
    public String removeCredential() {
        return null;
    }


}
