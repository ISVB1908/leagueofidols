/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.leagueofidols;

import edu.upb.leagueofidols.models.Player;

import java.time.LocalDateTime;
import java.util.Iterator;

import edu.upb.leagueofidols.adt.custom.CustomEntry;
import edu.upb.leagueofidols.adt.custom.TierCollection;
import edu.upb.leagueofidols.adt.tree.PlayerTree;
import edu.upb.leagueofidols.exceptions.MyException;
import edu.upb.leagueofidols.models.TierLevel;

/**
 *
 * @author cahuc
 */
public class League implements ILeague{

	private TierCollection tiers;

	public League(){
		tiers = new TierCollection();
	}

	public TierCollection getTiers() {
		return tiers;
	}

	public void setTiers(TierCollection tiers) {
		this.tiers = tiers;
	}

	@Override
	public void addPlayerToTier(TierLevel level, Player p) {

		Iterator iter = tiers.iterator();

		CustomEntry current = null;
		while( iter.hasNext())
		{
			current =  (CustomEntry) iter.next();
			if(current.getKey().equals(level))
			{
				current.getValue().add(p);
			}
		}     
		current =  (CustomEntry) iter.next(); 
		if(current.getKey().equals(level))
		{
			current.getValue().add(p);
		}
	}

	@Override
	public boolean isPlayerInTier(TierLevel level, String userName) {
		Iterator iter = tiers.iterator();
		Player temp = new Player(userName, 0,  LocalDateTime.now());
		CustomEntry current = null;
		while( iter.hasNext())
		{
			current =  (CustomEntry) iter.next();
			if(current.getKey().equals(level))
			{   if(current.getValue().contains(temp))
			{
				return true;
			}

			}
		}     
		current =  (CustomEntry) iter.next(); 
		if(current.getKey().equals(level))
		{   if(current.getValue().contains(temp))
		{
			return true;
		}

		}
		return false;
	}

	@Override
	public Player findPlayerInTier(TierLevel level, String userName) {
		Iterator iter = tiers.iterator();
		Player temp = new Player(userName, 0,  LocalDateTime.now());
		CustomEntry current = null;
                boolean find=false;
		while( iter.hasNext())
		{
			current =  (CustomEntry) iter.next();
			if(current.getKey().equals(level))
			{   
                            if(current.getValue().contains(temp))
			{
                                find=true;
				return temp;
			}

			}
		}     
		current =  (CustomEntry) iter.next(); 
		if(current.getKey().equals(level))
                    
		{   if(current.getValue().contains(temp))
		{
                        find=true;
			return temp;
		}

		}if(find==false){
                throw new MyException("no esta bru");}
		return null;
	}

	@Override
	public boolean isPlayerInAnyTier(String userName) {
		Iterator iter = tiers.iterator();
		Player temp = new Player(userName, 0,  LocalDateTime.now());
		CustomEntry current = null;
		while( iter.hasNext())
		{
			current =  (CustomEntry) iter.next();
			   if(current.getValue().contains(temp))
			{
				return true;
			}

		}     
		current =  (CustomEntry) iter.next(); 
		   if(current.getValue().contains(temp))
		{
			return true;
		}
		return false;
	}

	@Override
	public Player findPlayerInAnyTier(String userName) {
		Iterator iter = tiers.iterator();
		Player temp = new Player(userName, 0,  LocalDateTime.now());
		CustomEntry current = null;
                boolean find=false;
		while( iter.hasNext())
		{
			current =  (CustomEntry) iter.next();
			  if(current.getValue().contains(temp))
			{
                                find=true;
				return temp;
			}

			
		}     
		current =  (CustomEntry) iter.next(); 
		   if(current.getValue().contains(temp))
		{
                        find=true;
			return temp;
		}if(find=false){
                
                  throw new MyException("no esta bru");
                }
		return null;
	}

	@Override
	public TierLevel getPlayerTier(String username) {
		Iterator iter = tiers.iterator();
		Player temp = new Player(username, 0,  LocalDateTime.now());
		CustomEntry current = null;
		while( iter.hasNext())
		{
			current =  (CustomEntry) iter.next();
			   if(current.getValue().contains(temp))
			{
				return (TierLevel) current.getKey();
			}

			
		}     
		current =  (CustomEntry) iter.next(); 
		   if(current.getValue().contains(temp))
		{
			return (TierLevel) current.getKey();
		}

		
		return null;
	}

	@Override
	public void removeFromTier(TierLevel level, Player p) {
		Iterator iter = tiers.iterator();
		CustomEntry current = null;
		while( iter.hasNext())
		{
			current =  (CustomEntry) iter.next();
			if(current.getKey().equals(level))
			{   if(current.getValue().contains(p))
			{
				current.getValue().delete(p);
			}

			}
		}     
		current =  (CustomEntry) iter.next(); 
		if(current.getKey().equals(level))
		{   if(current.getValue().contains(p))
		{
			current.getValue().delete(p);
		}

		}
		
	}

	@Override
	public void printTierPlayers(TierLevel level) {
        Iterator iter = tiers.iterator();
        CustomEntry current = null;
        while( iter.hasNext())
        {
            current =  (CustomEntry) iter.next();
            if(current.getKey().equals(level))
            {

                current.getValue().traverse();
            }
        }
        current =  (CustomEntry) iter.next(); 
        if(current.getKey().equals(level))
        {
            current.getValue().traverse();

        }

    }

	@Override
	public void printAllPlayers() {

        Iterator iter = tiers.iterator();
        CustomEntry current = null;
        while( iter.hasNext())
        {
            current =  (CustomEntry) iter.next();
            
                current.getValue().inverse();
            
        }
        current =  (CustomEntry) iter.next(); 

            current.getValue().inverse();

                    
	}
        
}

