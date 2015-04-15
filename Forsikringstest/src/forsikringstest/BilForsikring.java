/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsikringstest;

/**
 *
 * @author Therese, Håkon
 */
public class BilForsikring extends Kjoretoy{
    int kjorelengde, prisKm, bonus;
    
    public BilForsikring(  int kjorelengde, int prisKm, int bonus, int premie , int egenandel, int tlf , String forsikrBet, String fornavn, String etternavn, String personNr, String gateAdr, String gateNr, String postNr, String regNr , String type , String modell ,String arsModell){
    super(premie ,  egenandel,  tlf , forsikrBet, fornavn,  etternavn,  personNr, gateAdr, gateNr, postNr, regNr , type , modell , arsModell);
    
    }
    
}
