package com.example.dai.Controllers;

import com.example.dai.data.Class.Utilizador;
import com.example.dai.data.SignUpForm;
import com.example.dai.Services.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/api/v1/user")
public class UtilizadorController {

    private final UtilizadorService usersService;

    @Autowired
    public UtilizadorController(UtilizadorService listUsersService) {
        this.usersService = listUsersService;
    }

    @GetMapping
    public String listAllUsers(){
        return usersService.list();
    }

    @PostMapping
    public String createUser(@RequestBody SignUpForm signUpForm){return usersService.createUser(signUpForm); }

    @DeleteMapping
    public String deleteUser(@RequestBody Utilizador utilizadorRemover) {return usersService.removeUser(utilizadorRemover); }

    @PutMapping
    public String editUser(@RequestBody Utilizador utilizadorEditar) {return usersService.changeInfoUser(utilizadorEditar);}


}
