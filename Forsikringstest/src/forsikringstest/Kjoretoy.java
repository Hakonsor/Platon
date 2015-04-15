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
public abstract class Kjoretoy extends Person{
    String regNr , type , modell , arsModell;
    
    public Kjoretoy( int premie , int egenandel, int tlf , String forsikrBet, String fornavn, String etternavn, String personNr, String gateAdr, String gateNr, String postNr, String regNr , String type , String modell ,String arsModell ){
        super(  premie ,  egenandel,  tlf , forsikrBet, fornavn,  etternavn,  personNr, gateAdr, gateNr, postNr);
        this.regNr = regNr;
        this.type = type;
        this.modell = modell;
        this.arsModell = arsModell;
    
}
    
}
