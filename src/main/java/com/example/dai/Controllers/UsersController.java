package com.example.dai.Controllers;

import com.example.dai.Data.Class.Utilizador;
import com.example.dai.Data.SignUpForm;
import com.example.dai.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/api/v1/user")
public class UsersController {

    private final UsersService listUsersService;

    @Autowired
    public UsersController(UsersService listUsersService) {
        this.listUsersService = listUsersService;
    }

    @GetMapping
    public String listAllUsers(){
        return listUsersService.list();
    }

    @PostMapping
    public String createUser(@RequestBody SignUpForm signUpForm){return listUsersService.createUser(signUpForm); }

    @DeleteMapping
    public String deleteUser(@RequestBody Utilizador utilizadorRemover) {return listUsersService.removeUser(utilizadorRemover); }

    @PutMapping
    public String editUser(@RequestBody Utilizador utilizadorEditar) {return listUsersService.changeInfoUser(utilizadorEditar);}


}
