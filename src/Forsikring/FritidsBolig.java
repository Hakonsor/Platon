/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;



/**
 *
 * @author Therese, Håkon
 */
public class FritidsBolig extends Bygg implements Serializable{
    
    public FritidsBolig(boolean utleie,
         double kvadrat, String adresse, String boligType, int byggeår,
         String metriale, String standard, double byggSum, double inboSum){
        
        super( utleie,kvadrat, adresse, boligType, byggeår,
                  metriale, standard, byggSum, inboSum);
     
    }
    
}
