package com.demo.example.service;

import com.demo.example.entity.Player;
import com.demo.example.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository repository;

    @Override
    public List<Player> getAllPlayers() {
        return repository.findAll();
    }

    @Override
    public Player savePlayer(Player player) {
        return repository.save(player);
    }

    @Override
    public String deletePlayer(long playerId) {
        repository.deleteById(playerId);
        return "PLAYER DELETED SUCCESSFULLY";
    }

    @Override
    public Player updatePlayer(Player player, long playerId) {
        Player playerToBeUpdated = repository.findById(playerId).get();
        playerToBeUpdated.setPlayerName(player.getPlayerName());
        playerToBeUpdated.setPlayerAge(player.getPlayerAge());
        playerToBeUpdated.setPlayerRating(player.getPlayerRating());
        return repository.save(playerToBeUpdated);
    }

    @Override
    public Player getPlayerById(long playerId) {
        Optional<Player> player = repository.findById(playerId);
        if (player.isPresent()){
            return player.get();
        } else
            return new Player();
    }

    @Override
    public Player getPlayerByName(String playerName) {
        return repository.findByPlayerName(playerName);
    }

    @Override
    public List<Player> findPlayerByNameOrAge(String playerName, int playerAge) {
        return repository.findByPlayerNameOrPlayerAge(playerName, playerAge);
    }

    @Override
    public List<Player> getPlayerBasedOnTheirNameAndAge(String playerName, int playerAge) {
        return repository.getPlayerBasedOnTheirNameAndAge(playerName, playerAge);
    }

    @Override
    public List<Player> getPlayerBasedOnTheirNameContains(String playerName) {
        return repository.findByPlayerNameContains(playerName);
    }

    @Override
    public List<Player> findPlayerByAgeBetween(int startAge, int endAge) {
        return repository.findPlayerByPlayerAgeBetween(startAge, endAge);
    }

    @Override
    public List<Player> findPlayerByPlayerNameInOrderWithTheirRating(String playerName) {
        return repository.findByPlayerNameContainsOrderByPlayerRatingAsc(playerName);
    }
}
