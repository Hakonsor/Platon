/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsikringstest;

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
          int femÅr= 5;
          int tiår = 10;
          
          double delta10 = 0.015;
          double delta5 = 0.01;
          double sum = 0;
          double byggVerdi;
          
          // bestemmer byggets verdi
             if (alder>=  tiÅr ){
                 byggVerdi = verdi - alder*verdi*delta10;
             }
             else if(alder>=femÅr){
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
      
      public double naturOgBrann( double skadebelop, double byggVerdi, int alder,  boolean FG){
          
      }
      
    }
   
    
    class Egenandel{
        
        
    }
    
    class Premie{
        
    }
    
   
}// end of interface regneBelop.
