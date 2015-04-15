/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsikringstest;

import java.util.Date;

/**
 *
 * @author Therese, H�kon
 */
public abstract class Forsikringer {
    private int poliseNr;
    private int nestePolisNr = 100000;
    private int premie;
    private int egenandel;
    private String forsikrBet;
    private Date startDato;
    private Date sluttDato;

    private Forsikringer() {
        poliseNr = ++nestePolisNr;
    }
    public Forsikringer( int premie, int egenandel, String forsikrBet){
       this();
       this.premie = premie;
       this.egenandel = egenandel;
       this.forsikrBet = forsikrBet;

    }
   
    public int getPoliseNr(){
       return poliseNr;
   }
   
    public int getPremie(){
       return premie;
   }
   
    public int getEgenAndel(){
       return egenandel;
   }
   
    public String getForsikrBet(){
       return forsikrBet;
   }
   
    public void setStartDato( Date startDato ){
       this.startDato = startDato;
       
    }
   
    public void setSluttDato( Date sluttDato ){
       this.sluttDato = sluttDato;
       
    }
   
    public Date getStartDato(){
       return startDato;
   }
   
    public Date getSluttDato(){
       return sluttDato;
   } 
 }// end of abstract class Forsikringer
