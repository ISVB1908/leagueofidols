/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.leagueofidols.models;

import java.time.LocalDateTime;
import lombok.Data;

/**
 *
 * @author cahucadi
 * Data anotattion allows to create getters and setters
 */
@Data
public class Player implements  Comparable<Player>{

	private String playerName;
	private int level;
	private LocalDateTime created;

	public Player(String playerName, int level, LocalDateTime created) {
		this.playerName = playerName;
		this.level = level;
		this.created = created;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
        public int compareTo(Player o) {
        int x = this.getPlayerName().toLowerCase().compareTo(o.getPlayerName().toLowerCase());

        if(x<0)
        { 
            return -1;
        }
        else if (x>0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
        }
    }
