/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.leagueofidols.adt.custom;

import edu.upb.leagueofidols.adt.tree.ITree;
import edu.upb.leagueofidols.models.Player;

/**
 *
 * @author cahuc
 */
public class CustomEntry<K, V extends  ITree<?> > {

    private final K key;
    private V value;
    private CustomEntry<K, V> next;

    
    public CustomEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
    
    public CustomEntry(K key, V value, CustomEntry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public CustomEntry<K, V> getNext() {
        return next;
    }

    public K getKey() {
		return key;
	}

	public void setNext(CustomEntry<K, V> next) {
        this.next = next;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
    