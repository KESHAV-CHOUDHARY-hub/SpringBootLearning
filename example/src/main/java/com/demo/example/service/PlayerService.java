package com.demo.example.service;

import com.demo.example.entity.Player;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();

    Player savePlayer(Player player);

    String deletePlayer(long playerId);

    Player updatePlayer(Player player, long playerId);

    Player getPlayerById(long playerId);

    Player getPlayerByName(String playerName);

    List<Player> findPlayerByNameOrAge(String playerName, int playerAge);

    List<Player> getPlayerBasedOnTheirNameAndAge(String playerName, int playerAge);

    List<Player> getPlayerBasedOnTheirNameContains(String playerName);

    List<Player> findPlayerByAgeBetween(int startAge, int endAge);

    List<Player> findPlayerByPlayerNameInOrderWithTheirRating(String playerName);
}
