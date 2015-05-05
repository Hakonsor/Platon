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
         String materiale, String standard, double byggSum, double innboSum){
        
        super( utleie,kvadrat, adresse, boligType, byggeår,
                  materiale, standard, byggSum, innboSum);
     
    }
    
}
