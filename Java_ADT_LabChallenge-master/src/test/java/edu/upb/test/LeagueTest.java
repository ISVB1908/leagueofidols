/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.test;

import edu.upb.leagueofidols.ILeague;
import edu.upb.leagueofidols.League;
import edu.upb.leagueofidols.exceptions.MyException;
import edu.upb.leagueofidols.models.Player;
import edu.upb.leagueofidols.models.TierLevel;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author cahuc
 */
public class LeagueTest {

    ILeague league;

    public LeagueTest() {

    }

    @Before
    public void beforeTests() {
        league = new League();
    }

    @Test
    public void addPlayerToEmptyTier() {
        Player p = new Player("alverich", 1, LocalDateTime.now());
        league.addPlayerToTier(TierLevel.IDOL, p);
        assertTrue(league.isPlayerInTier(TierLevel.IDOL, "alverich"));
    }

    @Test
    public void addPlayerToMultipleEmptyTier() {
        Player p1 = new Player("Grum", 1, LocalDateTime.now());
        Player p2 = new Player("Thrall", 2, LocalDateTime.now());
        Player p3 = new Player("Arthas", 8, LocalDateTime.now());
        league.addPlayerToTier(TierLevel.IDOL, p1);
        league.addPlayerToTier(TierLevel.IDOL, p2);
        league.addPlayerToTier(TierLevel.HERO, p3);
        assertTrue(league.isPlayerInTier(TierLevel.IDOL, "Grum"));
        assertTrue(league.isPlayerInTier(TierLevel.IDOL, "Thrall"));
        assertTrue(league.isPlayerInTier(TierLevel.HERO, "Arthas"));
    }
    
    @Test
    public void addMultiplePlayersToEmptyTier() {
        Player p1 = new Player("Dr Malito", 1, LocalDateTime.now());
        Player p2 = new Player("Corronchilejano", 1, LocalDateTime.now());
        Player p3 = new Player("The_Reaper", 1, LocalDateTime.now());

        league.addPlayerToTier(TierLevel.HERO, p1);
        league.addPlayerToTier(TierLevel.HERO, p2);
        league.addPlayerToTier(TierLevel.HERO, p3);

        assertTrue(league.isPlayerInTier(TierLevel.HERO, "Dr Malito"));
        assertTrue(league.isPlayerInTier(TierLevel.HERO, "Corronchilejano"));
        assertTrue(league.isPlayerInTier(TierLevel.HERO, "The_Reaper"));

    }

    @Test(expected = MyException.class)
    public void playerNotInTier() {
        league.findPlayerInTier(TierLevel.IDOL, "NOOOOOOB");
    }

    @Test
    public void printAllPlayersInTier() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        Player p1 = new Player("Dr Malito", 1, LocalDateTime.now());
        Player p2 = new Player("Corronchilejano", 1, LocalDateTime.now());
        Player p3 = new Player("The_Reaper", 1, LocalDateTime.now());

        league.addPlayerToTier(TierLevel.HERO, p1);
        league.addPlayerToTier(TierLevel.HERO, p2);
        league.addPlayerToTier(TierLevel.HERO, p3);

        league.printTierPlayers(TierLevel.HERO);

        assertEquals("Corronchilejano" + System.getProperty("line.separator")
                + "Dr Malito" + System.getProperty("line.separator")
                + "The_Reaper" + System.getProperty("line.separator"), os.toString());

    }

    @Test
    public void printAllPlayersAllTiers() {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

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

        assertEquals("Dr Malito" + System.getProperty("line.separator")
                + "Corronchilejano" + System.getProperty("line.separator")
                + "The_Reaper" + System.getProperty("line.separator")
                + "Devoramentes" + System.getProperty("line.separator")
                + "El_Santo" + System.getProperty("line.separator")
                + "ALL_MIGHTY" + System.getProperty("line.separator"), os.toString());

    }

}
