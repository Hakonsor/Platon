/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

/**
 *
 * @author Therese, Håkon
 */
public class FritidsBolig extends Bolig {
    boolean utleie;
    
    public FritidsBolig(  boolean utleie, int premie , int egenandel , String forsikrBet,
                  int kvadrat, String adresse, String boligType, String byggeår,
                  String metriale, String standard, String byggSum, String inboSUm){
        super(  premie , egenandel ,  forsikrBet,
                  kvadrat, adresse, boligType, byggeår,
                  metriale, standard, byggSum, inboSUm);
        this.utleie = utleie;
    }
    
}
