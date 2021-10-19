/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.leagueofidols;

import java.time.LocalDateTime;

import edu.upb.leagueofidols.models.Player;
import edu.upb.leagueofidols.models.TierLevel;

/**
 *
 * @author cahuc
 */
public class Main {

    public static void main(String[] args) {
        League league = new League();

        
        Player p1t1 = new Player("Dr Malito", 1, LocalDateTime.now());
        Player p1t2 = new Player("The_Reaper", 1, LocalDateTime.now());
        Player p1t3 = new Player("ALL_MIGHTY", 1, LocalDateTime.now());

        Player p2t1 = new Player("Corronchilejano", 1, LocalDateTime.now());
        Player p2t2 = new Player("Devoramentes", 1, LocalDateTime.now());

        Player p3t2 = new Player("El_Santo", 1, LocalDateTime.now());

        league.addPlayerToTier(TierLevel.HERO, p1t1);
        league.addPlayerToTier(TierLevel.MASTER, p1t2);
        league.addPlayerToTier(TierLevel.IDOL, p1t3);
        league.addPlayerToTier(TierLevel.HERO, p2t1);
        league.addPlayerToTier(TierLevel.MASTER, p2t2);
        league.addPlayerToTier(TierLevel.MASTER, p3t2);

        league.printAllPlayers();
    }

}
