package edu.upb.leagueofidols;

import edu.upb.leagueofidols.models.Player;
import edu.upb.leagueofidols.models.TierLevel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cahuc
 */
public interface ILeague {

    void addPlayerToTier(TierLevel level, Player p);

    boolean isPlayerInTier(TierLevel level,String userName);
    Player findPlayerInTier(TierLevel level,String userName);

    boolean isPlayerInAnyTier(String userName);
    Player findPlayerInAnyTier(String userName);
    TierLevel getPlayerTier(String username);

    void removeFromTier(TierLevel level,Player p);
    void printTierPlayers(TierLevel level);
    void printAllPlayers();
    
}
