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
public class FritidsBolig extends Bolig {
    boolean utleie;
    
    public FritidsBolig( int poliseNr , int premie , int egenandel , String forsikrBet , boolean utleie ){
        super(poliseNr , premie , egenandel , forsikrBet);
        this.utleie = utleie;
    }
    
}
