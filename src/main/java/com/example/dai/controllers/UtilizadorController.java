package com.example.dai.controllers;

import com.example.dai.data.classes.Utilizador;
import com.example.dai.model.UserAddModel;
import com.example.dai.services.UtilizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/api/v1/user")
public class UtilizadorController {

    private final UtilizadorService usersService;

    @Autowired
    public UtilizadorController(UtilizadorService listUsersService) {
        this.usersService = listUsersService;
    }

    @GetMapping
    public List<Utilizador> listAllUsers(){
        return usersService.list();
    }

    /*@PostMapping
    public String createUser(@RequestBody UserAddModel signUpForm){return usersService.createUser(signUpForm); }

    @DeleteMapping
    public String deleteUser(@RequestBody Utilizador utilizadorRemover) {return usersService.removeUser(utilizadorRemover); }

    @PutMapping
    public String editUser(@RequestBody Utilizador utilizadorEditar) {return usersService.changeInfoUser(utilizadorEditar);}
*/

}
