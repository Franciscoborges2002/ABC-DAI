package com.example.dai.Controllers;

import com.example.dai.Data.LoginForm;
import com.example.dai.Repositories.UsersRepositorie;
import com.example.dai.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value="/api/v1/login")
public class LoginController {

    private final LoginService loginService;

    UsersRepositorie usersRepositorie = new UsersRepositorie();

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public String login(@RequestBody LoginForm loginForm) {
        return LoginService.login(loginForm);
    }
}
