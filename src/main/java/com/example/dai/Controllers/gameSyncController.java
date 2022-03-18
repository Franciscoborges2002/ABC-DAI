package com.example.dai.Controllers;

import com.example.dai.Data.RawStatistics;
import com.example.dai.Services.gameSyncService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gamesync")
public class gameSyncController {

    @PostMapping
    public String gameSync(@RequestBody RawStatistics rawStatistics){
        return gameSyncService.gameSync(rawStatistics);
    }
}