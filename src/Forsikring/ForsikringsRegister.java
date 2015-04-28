/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;


import Person.Kunde;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 *
 * @author Therese
 */
public class ForsikringsRegister implements Serializable {
    
    private List <Forsikringer>  forsikring;
    
   
     public ForsikringsRegister(){
        forsikring = new ArrayList(); 
     }

     // legger til et objekt i listen, og registrerer hvilken kuned den tilhører
     public void settInn(Kunde k,Forsikringer f){
         f.setKunde(k);
         forsikring.add(f);
     }
     
     // metoden returnerer en liste med forsikringer til en bestemt kunde. 
     // avhengig av valg: av en type eller av alle typer.
     public List finnForsikring(Kunde kunde, int forsType){
        
        List<Forsikringer> liste = new ArrayList<>();
            if( forsType == 0 ){
                forsikring.stream().filter((f) -> (f.getKunde().getKundeNr() == kunde.getKundeNr())).forEach((f) -> {
                    liste.add(f);
                });
            }
            else if( forsType == 1 ){
                forsikring.stream().filter((f) -> (f.getKunde().getKundeNr() == kunde.getKundeNr() && f instanceof BatForsikring)).forEach((f) -> {
                    liste.add(f);
                });
            }
            else if( forsType == 2 ){
                 forsikring.stream().filter((f) -> (f.getKunde().getKundeNr() == kunde.getKundeNr() && f instanceof ReiseForsikring)).forEach((f) -> {
                    liste.add(f);
                 });
            }
            else if ( forsType == 3){
                forsikring.stream().filter((f) -> (f.getKunde().getKundeNr() == kunde.getKundeNr() && f instanceof BilForsikring)).forEach((f) -> {
                    liste.add(f);
                });
            }
            else if(forsType == 4){
                forsikring.stream().filter((f) -> (f.getKunde().getKundeNr() == kunde.getKundeNr() && f instanceof FritidsBolig)).forEach((f) -> {
                    liste.add(f);
                });
            }
         return liste;
        }// end of method  finnForsKunde
        
        // henter ut alle forsikringene som er kjøpt et gitt år
        public List finnAntallForsikringer(Calendar c){
            List<Forsikringer> liste = new ArrayList<>();
            
            forsikring.stream().filter((f) -> (f.getStartDato().get(Calendar.YEAR) == c.get(Calendar.YEAR))).forEach((f) -> {
                liste.add(f);
        });
            
            
            return liste;
          
        }// end of method finnAntallForsikringer
        
        public Forsikringer finnForsPolise(int poliseNr){
          Iterator<Forsikringer> i = forsikring.iterator();
            while(i.hasNext()){
                Forsikringer f = i.next();
                 if (f.getPoliseNr()== poliseNr){
                      return f;
                 }
            }
          return null;
        }         
}// end of class ForsikringsRegister
     
     
     
     

     
     
     
     
     
    
   
   
    

 
