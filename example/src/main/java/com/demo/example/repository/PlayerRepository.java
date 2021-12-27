package com.demo.example.repository;


import com.demo.example.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByPlayerName(String playerName);

    List<Player> findByPlayerNameIgnoreCase(String playerName);
    List<Player> findByPlayerNameContainsOrderByPlayerRatingAsc(String playerName);
    List<Player> findByPlayerNameContains(String playerName);

    List<Player> findByPlayerNameOrPlayerAge(String playerName, int playerAge);

    @Query("from Player where playerName = :playerName and playerAge = :playerAge")
    List<Player> getPlayerBasedOnTheirNameAndAge(String playerName, int playerAge);

    List<Player> findPlayerByPlayerAgeBetween(int startAge, int endAge);
}
