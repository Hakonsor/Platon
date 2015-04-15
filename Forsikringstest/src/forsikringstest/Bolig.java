/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsikringstest;

/**
 *
 * @author Therese
 */
public abstract class Bolig extends Forsikringer {
    
    public Bolig( int poliseNr , int premie , int egenandel , String forsikrBet ){
        
       super( poliseNr , premie , egenandel , forsikrBet );
    }
}// end of class Bolig.
