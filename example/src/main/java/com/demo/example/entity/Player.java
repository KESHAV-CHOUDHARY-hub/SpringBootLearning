package com.demo.example.entity;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;
    private String playerName;
    private int playerAge;
    private int playerRating;

    public Long getPlayerId() {
        return playerId;
    }

    public void setId(Long playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public int getPlayerRating() {
        return playerRating;
    }

    public void setPlayerRating(int playerRating) {
        this.playerRating = playerRating;
    }
}