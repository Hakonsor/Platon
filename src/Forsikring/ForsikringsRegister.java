/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;


import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Therese
 */
public class ForsikringsRegister implements Serializable {
    
    private List <BilForsikring> bil;
    private List <BatForsikring> bat;
    private List <ReiseForsikring> reise;
    private List <BoligForsikring> bolig;
    private List <FritidsBolig> fritid;
   
     public ForsikringsRegister(){
        bil = new LinkedList();
        bat = new LinkedList();
        reise = new LinkedList();
        bolig = new LinkedList();
        fritid = new LinkedList();
    
        
       
     }

     // legger til et objekt i listen, ikke testet
     public void settInn(BilForsikring b){
         bil.add(b);
     }
     
     public void settInn(BatForsikring b){
         bat.add(b);
     }
     
     public void settInn(ReiseForsikring b){
         reise.add(b);
     }
     
     public void settInn(BoligForsikring b){
         bolig.add(b);
     }
     public void settInn(FritidsBolig b){
         fritid.add(b);
     }
     
     
     // viser en spesifikk liste 
     public <T extends Forsikringer> String visListe(int i){
          List l = finnListe(i);
          if(l.isEmpty()){
              return "Ingen forsikringer er registert på deg. ";
          }
          String s = hentString(l);
          return s;
    } 
      
      // finner liste, returnerer listen hvis den har innhold, hvis ikke så returnerer den null.
     public List finnListe(int i){
          if(i== 0){
               if(!bil.isEmpty()){
                    return bil;
               }
               else{
                    return null;
               }
          }
          else if(i== 1){
               if(!bat.isEmpty()){
                    return bat;
               }
               else{
                    return null;
               }   
          }
          else if(i == 2){
               if(!reise.isEmpty()){
                   return reise;
               }
               else{
                    return null;
               }
          }
          else if (i == 3){
               if(!bolig.isEmpty()){
                    return bolig;
               }
               else{
                    return null;
               }
          }
          else if(i == 4){
               if(!fritid.isEmpty()){
               return fritid;
               }
               else{
                    return null;
                }
          }
          return null;
      }// end of method finnListe
      
     // gjennomløper listen og returnerer objektenes toString() i en String.
     public <T extends Forsikringer> String hentString(List<T> register){
          Iterator<T> iter = register.iterator();
          StringBuilder sb = new StringBuilder();
          
          while (iter.hasNext()){
               T list = iter.next();
               sb.append(list.toString());
          }
          
          return sb.toString();
   
     }// end of method hentString. 
      
   
    
}// end of class ForsikringsRegister

    
