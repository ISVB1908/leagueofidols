/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.leagueofidols.adt.tree;

/**
 *
 * @author cahuc
 */
public interface ITree<T extends Comparable<T>> {
    
    void add(T object);
    void find(T object);
    boolean contains(T object);
    void delete(T object);
    void traverse();
    void inverse();

}
