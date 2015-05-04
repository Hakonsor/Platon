/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;



import Forsikring.Forsikringer;
import Person.Bruker;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



/**
 *
 * @author  Therese
 * @author  Håkon
 * 
 */
public class SkadeMeldingRegister implements Serializable{
    
    private int  index;
    
    LinkedList <SkadeMelding> behandling;
    List <SkadeMelding> register;
    
    
    public SkadeMeldingRegister() {
        behandling = new LinkedList<>();
        register= new ArrayList<>();
    }

    // legger skademeldingen i behandlingskøen, og knytter en forsikring til skademeldingen.
    public void leggIKø(SkadeMelding skade){
        behandling.add(skade);
    }//end method
    
    // returnerer det første objektet i listen, hvis det ikke finnes 
    public SkadeMelding getFørste(){
        if(!behandling.isEmpty()){
            return behandling.getFirst();
        }
        return null;
    }
    
    // returnerer antall ubehandlede skader
    public int visAntallIKø(){
       return behandling.size();
    }
    
    public int visIndex(){
        if(behandling.isEmpty()){
            return 0;
        }
        else{
        int visIndex = index +1;
        return visIndex;
        }
    }
    
    
    
    // henter ut neste i køen
    public SkadeMelding visNesteIKø(){
       index++;
        if(index < behandling.size()){
            SkadeMelding skade = behandling.get(index);
            return skade;
        }
        else{
            index = 0;
            return getFørste();
           
        }
    }
    
    // bruker indexen til å finne forrige elementet i listen
    public SkadeMelding visForrigeIKø(){
        
        if(index == 0){
            index = behandling.size()-1;
           if(!behandling.isEmpty()){
               return behandling.getLast();
           }
           else{
               return null;
           }
        }
        index --;
        if(!behandling.isEmpty()){
        return behandling.get(index);
        }
        else {
            return null;
        }
    }
   
    
    // flytter objekt fra behandling til registeret
    public void flyttTilRegister(SkadeMelding skade){
        register.add(skade);
        boolean remove = behandling.remove(skade); 
        
    }
    

    // Metode som henter en liste over alle skademeldinger knyttet en bestemt bruker(kunde)
    public ArrayList<SkadeMelding> getSkadeMelding(Class forsikring, Bruker b) {
        ArrayList<SkadeMelding> liste = new ArrayList<>();
        register.stream().filter((skade) -> (forsikring.isAssignableFrom(skade.getForsikring().getClass()))).forEach((skade) -> {
            liste.add(skade);
        });
        return liste;
    }
    
    // metoden kaller på beregningsmetoder som setter utbetalingsbeløp pga skade, etc.
    /*public void setInfoSkade(SkadeMelding skade) {
        if (skade.getForsikring() instanceof BilForsikring) {
            BilSkadeMelding bilskade = (BilSkadeMelding) skade;
            int sum = bilskade.getForsikring().utbetal(30000, 50000.0, 6000);
            System.out.println("Bilskade:" + sum);

        } else if (skade.getForsikring() instanceof BatForsikring) {
            BatSkadeMelding batskade = (BatSkadeMelding) skade;
            int sum = batskade.getForsikring().utbetal(4000, 50000.0, 6000);
            System.out.println("Batskade:" + sum);
        } else if (skade.getForsikring() instanceof BoligForsikring) {
             BoligSkadeMelding boligskade = (BoligSkadeMelding) skade; 
 
        } else if (skade.getForsikring() instanceof FritidsBolig) {
             BoligSkadeMelding fritidskade = (BoligSkadeMelding) skade; 
        }*/
    }




