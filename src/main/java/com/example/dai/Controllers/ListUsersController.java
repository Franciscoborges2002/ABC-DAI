package com.example.dai.Controllers;

import com.example.dai.Services.ListUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/api/v1/users/all")
public class ListUsersController {

    private final ListUsersService listUsersService;

    @Autowired
    public ListUsersController(ListUsersService listUsersService) {
        this.listUsersService = listUsersService;
    }

    @GetMapping
    public String listAllUsers(){
        return listUsersService.list();
    }
}
