/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import CSS.Bilder.Bolig;

/**
 *
 * @author Therese, Håkon
 */
public class FritidsBolig extends Bolig {
    boolean utleie;
    
    public FritidsBolig(boolean utleie,
         double kvadrat, String adresse, String boligType, String byggeår,
         String metriale, String standard, double byggSum, double inboSUm){
        
        super( utleie,kvadrat, adresse, boligType, byggeår,
                  metriale, standard, byggSum, inboSUm);
     
    }
    
}
