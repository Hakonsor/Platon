/*
 * 
 */
package Forsikring;

import java.io.Serializable;

/**
 * Inneholder ingen egne datafelter.
 * Men er laget som individuell klasse for å kunne skille mellom 
 * fritidsbolig og bolig forsikringer, men også for å gjøre 
 * utvidelsesmulighetene enkle og synlige
 *
 * @author Therese
 */
public class BoligForsikring extends Bygg implements Serializable {
    
    public BoligForsikring(boolean utleie,
                  double kvadrat, String adresse, String boligType, int byggeår,
                  String materiale, String standard, double byggSum, double innboSum){
                  super(utleie, kvadrat, adresse, boligType, byggeår, materiale, standard, byggSum, innboSum);
                 
        
    }
}
