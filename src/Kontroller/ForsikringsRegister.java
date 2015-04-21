/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroller;

import java.util.LinkedList;
import java.util.List;
import Forsikring.BilForsikring;

/**
 *
 * @author Therese
 */
public class ForsikringsRegister {
    private List <BilForsikring> bilListe;
    
    public ForsikringsRegister(){
        bilListe = new LinkedList(); 
    }
    
     // setter inn bilene, er testet
    public boolean settInnBil(BilForsikring b){
        boolean innsatt = bilListe.add(b);
        return innsatt;
     }
    
    // sletter et objekt, nb må legges i et arkiv for historikk
    public void slettForsikring(BilForsikring b){
        int indeks = bilListe.indexOf(b);
        bilListe.remove(b);
    }
     
     // skriver ut liste, er testet
     public String skrivUtBiler(StringBuilder s){
        bilListe.stream().forEach((b) -> {
            s.append(b.toString());
        });
        return s.toString();
    }
}// end of class ForsikringsRegister
     
