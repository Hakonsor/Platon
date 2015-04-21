/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Regnskap;

/**
 *
 * @author Therese
 */
public interface RegneBelop {
    
    class Utbetaling{
      // beregner sum til utbetaling, dersom boligen er totalskadet, 0 hvis metoden ikke fører til noe beløp.
      public double utbetalingBolig( double skadeBelop , double verdi, int alder, double egenAndel ){
          // regler for utbetaling, summen som betales ut avhenger av disse reglene.
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
          
          return sum;
           
      }// end of method fullUtbetaling
      
      
      
    }
   
    
    class Egenandel{
        public int egenandel(String skadeType, boolean fG ){
            int egenandel = 4000;
            int fGgodkjent = 4000;
            
            int brann= 3000;
            int vann = 15000;
            int ror = 25000;
            
            if(fG){
                egenandel -= fGgodkjent;   
            }
            switch (skadeType) {
                case "brann":
                case "natur":
                    egenandel += brann;
                    break;
                case "vann":
                    egenandel += vann;
                    break;  
                case "rør":
                    egenandel+= ror;
                    break;
            }
           
        
            return egenandel;
    
        }// end of method egenandel
    }
    
    class Premie{
        
    }
    
   
}// end of interface regneBelop.
