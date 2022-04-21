package com.example.dai.controller;

import com.example.dai.model.RawStatistics;
import com.example.dai.service.GameSyncService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gamesync")
public class GameSyncController {

    @PostMapping
    public String gameSync(@RequestBody RawStatistics rawStatistics){
        return GameSyncService.gameSync(rawStatistics);
    }
}