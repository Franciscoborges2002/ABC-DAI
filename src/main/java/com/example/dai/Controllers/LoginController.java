package com.example.dai.Controllers;

import com.example.dai.Data.LoginRequest;
import com.example.dai.Repositories.UsersRepository;
import com.example.dai.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/login")
public class LoginController {

    private final LoginService loginService;

    UsersRepository usersRepositorie = new UsersRepository();

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public String login(@RequestBody LoginRequest loginRequest) {//DTO -> Data Transfer Object//
        return loginService.login(loginRequest);
    }
}
