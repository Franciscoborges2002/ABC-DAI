package com.example.dai.Controllers;


import com.example.dai.Services.TrainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/trains/all")
public class ListTrainsController {

    @GetMapping
    public String listTrains(){
        return TrainService.listTrains();
    }
}
