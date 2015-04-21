/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;

/**
 *
 * @author Therese, Håkon
 */
public abstract class Bolig extends Forsikringer implements Serializable {
    
    private int kvadrat;
    private String adresse;
    private String boligType ;
    private String byggeår ;
    private String metriale;
    private String standard;
    private String byggSum;
    private String inboSUm;
    
    public Bolig(  int premie , int egenandel , String forsikrBet,
                  int kvadrat, String adresse, String boligType, String byggeår,
                  String metriale, String standard, String byggSum, String inboSUm){
        super( premie , egenandel );
        this.kvadrat = kvadrat;
        this.adresse = adresse;
        this.boligType = boligType;
        this.byggeår = byggeår;
        this.byggSum = byggSum;
        this.inboSUm = inboSUm;
        this.metriale = metriale;
        this.standard = standard;
    }
    
        public int getKvadrat(){
           return kvadrat;
        }
        public String adresse(){
           return adresse;
        }
        public String boligType(){
           return boligType;
        }
        public String byggeår(){
           return byggeår;
        }
        public String byggSum(){
           return byggSum;
        }
        public String inboSUm(){
           return inboSUm;
        }
        public String metriale(){
           return metriale;
        }
        public String standard(){
           return standard;
        }
                
        
    
}// end of class Bolig.
