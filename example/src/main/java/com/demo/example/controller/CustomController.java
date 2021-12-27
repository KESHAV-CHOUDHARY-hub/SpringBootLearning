package com.demo.example.controller;

import com.demo.example.entity.Player;
import com.demo.example.service.PlayerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Players Customized API", description = "These endpoints are created and customized")
public class CustomController {

    @Autowired
    PlayerServiceImpl service;

    @GetMapping("/getPlayerByName")
    @Operation(
            summary = "API - For Fetching Player By Their Names",
            description = "Fetching Player",
            tags = {"Player"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Player.class))
                    ),
                    @ApiResponse(
                            description = "Not-Found",
                            responseCode = "404",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal-Error",
                            responseCode = "500",
                            content = @Content
                    )
            }
    )
    public Player getPlayerByName(@RequestParam String playerName) {
        return service.getPlayerByName(playerName);
    }

    @GetMapping("/getPlayerByNameOrAge")
    @Operation(
            summary = "API - Fetch Player By Their Name Or Age",
            description = "Fetching Player",
            tags = {"Players"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode= "200",
                            content = @Content( mediaType = "application/json", schema = @Schema(implementation = Player.class))
                    ),
                    @ApiResponse(
                            description = "Not-Found",
                            responseCode = "404",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal-Error",
                            responseCode = "500",
                            content = @Content
                    )
            }
    )
    public List<Player> findPlayerByNameOrAge(@RequestParam String playerName, @RequestParam int playerAge) {
        return service.findPlayerByNameOrAge(playerName, playerAge);
    }


    @GetMapping("/getPlayerBasedOnTheirNameAndAge")
    @Operation(
            summary = "API - Fetch Player By Their Name And Age Using @Query",
            description = "Fetching Player",
            tags = {"Player"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode= "200",
                            content = @Content( mediaType = "application/json", schema = @Schema(implementation = Player.class))
                    ),
                    @ApiResponse(
                            description = "Not-Found",
                            responseCode = "404",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal-Error",
                            responseCode = "500",
                            content = @Content
                    )
            }
    )
    public List<Player> getPlayerBasedOnTheirNameAndAge(@RequestParam String playerName, @RequestParam int playerAge){
        return service.getPlayerBasedOnTheirNameAndAge(playerName, playerAge);
    }

    @GetMapping("/getPlayerBasedOnTheirNameContains")
    @Operation(
            summary = "API - Fetch Player By Their Name Contains",
            description = "Fetching Player",
            tags = {"Player"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode= "200",
                            content = @Content( mediaType = "application/json", schema = @Schema(implementation = Player.class))
                    ),
                    @ApiResponse(
                            description = "Not-Found",
                            responseCode = "404",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal-Error",
                            responseCode = "500",
                            content = @Content
                    )
            }
    )
    public List<Player> getPlayerBasedOnTheirNameContains(@RequestParam String playerName){
        return service.getPlayerBasedOnTheirNameContains(playerName);
    }

    @GetMapping("/findPlayerByAgeBetween")
    @Operation(
            summary = "API - Fetch Player By Their Age Between Starting and Ending Age As Provided In Input",
            description = "Fetching Player Based on Their Age Between",
            tags = {"Player"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode= "200",
                            content = @Content( mediaType = "application/json", schema = @Schema(implementation = Player.class))
                    ),
                    @ApiResponse(
                            description = "Not-Found",
                            responseCode = "404",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal-Error",
                            responseCode = "500",
                            content = @Content
                    )
            }
    )
    public List<Player> findPlayerByAgeBetween(@RequestParam int startAge, @RequestParam int endAge) {
        return service.findPlayerByAgeBetween(startAge, endAge);
    }

    @GetMapping("/findPlayerByPlayerNameInOrderWithTheirRating")
    @Operation(
            summary = "API - Fetch Player By Their Name Contains And In Ascending Order Of Their Rating",
            description = "Fetching Player Order By Rating Ascending",
            tags = {"Player"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode= "200",
                            content = @Content( mediaType = "application/json", schema = @Schema(implementation = Player.class))
                    ),
                    @ApiResponse(
                            description = "Not-Found",
                            responseCode = "404",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal-Error",
                            responseCode = "500",
                            content = @Content
                    )
            }
    )
    public List<Player> findPlayerByPlayerNameInOrderWithTheirRating(String playerName){
        return service.findPlayerByPlayerNameInOrderWithTheirRating(playerName);
    }

}
