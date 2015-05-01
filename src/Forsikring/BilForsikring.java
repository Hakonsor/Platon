/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import Person.Person;
import java.io.Serializable;

/**
 *
 * @author Therese, Håkon
 */
public class BilForsikring extends Kjoretoy implements Serializable {
    private int kjorelengde;
    
    public BilForsikring(double bonus, double egenandel, int kjorelengde, String regNr, String type, String arsModell, int kmStand, Person person){
                super(bonus,egenandel, regNr ,type, arsModell, null, null);
                this.kjorelengde = kjorelengde;
                premie = (premie(egenandel,bonus ));// premien settes
    }

    public int getKjorelengde(){
        return kjorelengde;
    }
    
        
    

    // angir hvor mye kunden får utbetalt, dersom uhellet skulle være ute.
     public int utbetal( int km , double kostnad, int egenandel){
          double delta = 0; // angir hvor stor andel av skaden som dekkes
          double belop;
          double utbetales = 0;
           
          if ( km > 350000 ){
               delta = 0.2;            
          }
          else if( km > 300000 && km <=350000 ){
               delta = 0.3; 
            }
            else if( km > 200000 && km <= 300000 ){
               delta = 0.4;
            }
            else if( km > 150000 && km <= 200000){
               delta = 0.6;   
            }
            else if( km > 100000 && km <= 150000 ){
               delta = 0.8;
            }
            else if(km <= 100000){
                delta = 0;
            }
        
        if( delta!= 0 ){
        belop = delta* kostnad;
        }
        else{
            belop = kostnad;
        }
            if( belop > egenandel ){
                  utbetales = belop;
            }
        
      return (int)utbetales;
     
   }// end of method
        
   /* // beregner premien på nyregisterte biler
    public double bonusNyRegBil(int skadeFrieAar){       
        double bonus = 0;
      
        if(skadeFrieAar <= 7){
            bonus = skadeFrieAar *0.1;
        }
        else if(skadeFrieAar <= 12){
            bonus = 0.7;
        }
        else if(skadeFrieAar > 12){
            bonus = 0.75;
        }
                
         return bonus;
       
    }// end of method 

    */
    // beregner bonusen etter skaden. parameteren angir hva bonusen var før skaden
    public double bonusEtterSkade(double bonus){
        if(bonus == 0){
            bonus -= 40;
        }
        if(bonus >= 10 && bonus <= 60){
            bonus -= 30;
        }
        if(bonus == 70){
            bonus -= 30;
        }
        if(bonus == 75){
            bonus -= 15;
        }
        return bonus;
    }// end of method

    // beregner premien basert på bonus etter en skade.
     public double premieEtterSkade( int grunnPremie, double nyBonus ){       
        double nyPremie = (100 - nyBonus)/100* grunnPremie;
        return nyPremie;     
     }// end of method

    // bestemmer premien utifra hva som velges som egenandel. 
    public double premie(double egenandel,double bonus){
        double grunnPremie = 20000;
        double premium;
        double rabatt = 0;
  
        if(egenandel == 10000){
            rabatt = 15;
        }
        else if(egenandel == 6000){
            rabatt = 10;
        }
        else if(egenandel == 4000){
            rabatt = 0;
        }
    
        premium = (100-rabatt-bonus )/100*grunnPremie;
    
        return premium;
    }// end of method premie
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Kjørelengde: ");
        sb.append(kjorelengde);
        
        return sb.toString();
     }// end of toString()
}// end of class BilForsikring.
