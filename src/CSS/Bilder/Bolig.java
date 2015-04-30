/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSS.Bilder;

import Forsikring.Forsikringer;
import java.io.Serializable;

/**
 *
 * @author Therese, Håkon
 */
public abstract class Bolig extends Forsikringer implements Serializable {
    
    private double kvadrat;
    private double byggSum;
    private double innboSum;
    private int egenAndel = 4000;// minimumsverdi
    private String adresse;
    private String boligType ;
    private String byggeår ;
    private String metriale;
    private String standard;
    private boolean utleie;
    
    
    public Bolig( boolean utleie, double kvadrat, String adresse, String boligType, String byggeår,
                  String metriale, String standard, double byggSum, double inboSUm){
        super();
        this.kvadrat = kvadrat;
        this.adresse = adresse;
        this.boligType = boligType;
        this.byggeår = byggeår;
        this.byggSum = byggSum;
        this.innboSum = inboSUm;
        this.metriale = metriale;
        this.standard = standard;
        this.utleie = utleie;
        setPremie(premie(kvadrat, byggSum, innboSum));
    }
    
        public double getKvadrat(){
           return kvadrat;
        }
        public String adresse(){
           return adresse;
        }
        public String boligType(){
           return boligType;
        }
        public String byggear(){
           return byggeår;
        }
        public double byggSum(){
           return byggSum;
        }
        public double inboSum(){
           return innboSum;
        }
        public String materiale(){
           return metriale;
        }
        public String standard(){
           return standard;
        }
       
       
        // beregner egenandelen avhengig av skadetype, og om boligen er fg godkjent.
        public int egenandel(String skadeType, boolean fG ){
            int fGgodkjent = 4000;
            
            int brann= 3000;
            int vann = 15000;
            int ror = 25000;
            
            if(fG){
                egenAndel -= fGgodkjent;   
            }
            switch (skadeType) {
                case "brann":
                case "natur":
                    egenAndel += brann;
                    break;
                case "vann":
                    egenAndel += vann;
                    break;  
                case "rør":
                    egenAndel+= ror;
                    break;
            }
           
        
            return egenAndel;
    
        }// end of method egenandel
        
        // utbetaling av erstatningsbeløp, med regler.
        public int utbetaling( double skadeBelop , double verdi, int alder, double egenAndel ){
          double totalSkadeGrense = 0.75;
          int femAar= 5;
          int tiAar = 10;
          
          double delta10 = 0.015;
          double delta5 = 0.01;
          double sum;
          double byggVerdi;
          
          // bestemmer byggets verdi
          
          
             if (alder>=  tiAar ){
                 byggVerdi = verdi - alder*verdi*delta10;
             }
             else if(alder>=femAar){
                 byggVerdi = verdi - alder*verdi*delta5;
             }
             else{
                 byggVerdi = verdi;
             }
             
          // laveste skadegrense for totalskade her er det tatt hensyn til byggets alder:    
          double minTotal= byggVerdi* totalSkadeGrense;
          
          // sjekker om bygget er totalskadet, dvs skaden utgjør minst 75% av verdien til boligen.
          if (skadeBelop< minTotal){
              sum = skadeBelop - egenAndel;
          }
          else{
              sum = byggVerdi - egenAndel;
          }
          
          return (int)sum;
           
      }// end of method fullUtbetaling  
      
      // beregner premien utifra størrelsen på boligen og verdien på innboet og bygningen
      public int premie(double kvadrat, double byggSum, double innboSum){
          double prisPerKvadrat = 0.1;
          double prisPerByggVerdi = 0.0007;
          double prisPerInnbo= 0.003;
          double premium;
          
          premium = prisPerKvadrat*kvadrat + prisPerByggVerdi*byggSum + prisPerInnbo* innboSum;
          
          return(int) premium;
      }
        
    
}// end of class Bolig.
