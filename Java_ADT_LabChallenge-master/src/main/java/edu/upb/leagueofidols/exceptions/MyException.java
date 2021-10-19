/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upb.leagueofidols.exceptions;

/**
 *
 * @author cahuc
 */
public class MyException extends RuntimeException {
    
    public MyException(String errorMessage ){
        super(errorMessage);
    }

}