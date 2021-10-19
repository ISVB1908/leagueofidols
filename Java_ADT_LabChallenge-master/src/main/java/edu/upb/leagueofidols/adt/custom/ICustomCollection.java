/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.leagueofidols.adt.custom;

import edu.upb.leagueofidols.adt.tree.ITree;

/**
 *
 * @author cahuc
 */

public interface ICustomCollection<K , T extends Comparable<T>> extends Iterable{

    void put(K key, T value);

    T findInKey(K key, T value);
    T findInAnyKey(T value);
    K findKey(T value);

    boolean existInKey(K key, T value);
    boolean existInAnyKey(T value);
    void printByKey(K key);
    void printAll();
}