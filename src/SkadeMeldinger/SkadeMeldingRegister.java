/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Person.Bruker;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author hakon_000
 */
public class SkadeMeldingRegister implements Serializable{
    
    List <SkadeMelding> behandling;
    List <SkadeMelding> register;
    //ListIterator<SkadeMelding> i = behandling.listIterator();
    public SkadeMeldingRegister() {
        behandling = new LinkedList<>();
        register= new ArrayList<>();
    }

    // legger skademeldingen i behandlingskøen returnerer false om det gikk galt:
    public void leggIKø(SkadeMelding skade){
        behandling.add(skade);
    }//end method
    
    // returnerer antall ubehandlede skader
    public int visAntallIKø(){
       return behandling.size();
    }
    
    // henter ut neste i køen
    public SkadeMelding visNesteIKø(int index){
        int vis = index + 1;
        SkadeMelding skade = behandling.get(vis);
        
        return skade;
    }
    
    // bruker indexen til å finne forrige elementet i listen
    public SkadeMelding visForrige(int index){
        int vis = index - 1;
        SkadeMelding skade;
        if(vis <0){
            return null;
        }
        else{
            skade = behandling.get(vis);
        }
        return skade;
    }
    
    // flytter objekt fra behandling til registeret
    public void flyttTilRegister(int index){
        SkadeMelding skade =behandling.get(index);
        register.add(skade);
        boolean remove = behandling.remove(skade); 
    }
    
    
    // legger skademelcingen i registeret, den kommer fra køen
    //public void addSkadeMelding( SkadeMelding skademelding ) {
        
        //register.add(skademelding );
   // }
    

    // Metode som henter en liste over alle skademeldinger knyttet en bestemt bruker(kunde)
    public ArrayList<SkadeMelding> getSkadeMelding(Class forsikring, Bruker b) {
        ArrayList<SkadeMelding> liste = new ArrayList<>();
        register.stream().filter((skade) -> (forsikring.isAssignableFrom(skade.getForsikring().getClass()))).forEach((skade) -> {
            liste.add(skade);
        });
        return liste;
    }

}
