package com.demo.example.controller;

import com.demo.example.entity.Player;
import com.demo.example.service.PlayerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "PlayersAPI", description = "Players Endpoint for their management")
public class Controller {

    @Autowired
    PlayerServiceImpl service;

    @GetMapping("/getAllPlayers")
    public List<Player> getALlPlayers() {
        return service.getAllPlayers();
    }

    @GetMapping("/getPlayerById/{playerId}")
    public Player getPlayerById(@PathVariable long playerId) {
        return service.getPlayerById(playerId);
    }

    @PostMapping("/savePlayer")
    public Player savePlayer(@RequestBody Player player) {
        return service.savePlayer(player);
    }

    @PutMapping("/updatePlayer/{playerId}")
    public Player updatePlayer(@RequestBody Player player, @PathVariable long playerId){
        return service.updatePlayer(player, playerId);
    }

    @DeleteMapping("/deletePlayer/{playerId}")
    public String deletePlayer(@PathVariable long playerId) {
        return  service.deletePlayer(playerId);
    }
}
