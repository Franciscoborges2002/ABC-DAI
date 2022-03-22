package com.example.dai.Services;

import org.springframework.stereotype.Service;

import static com.example.dai.Services.SignUpService.usersRepositorie;

@Service
public class ListUsersService {

    public String list(){
        return usersRepositorie.getUtilizadores().toString();
    }
}
