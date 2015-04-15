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
      // beregner sum til utbetaling, dersom boligen er totalskadet, -1 hvis metoden ikke fører til noe beløp.
      public double fullUtbetaling( double skadeBelop , double byggVerdi, int alder ){
          // regler for utbetaling, summen som betales ut avhenger av disse reglene.
          double totalSkadeGrense = 0.75;
          double aldersFradrag10Ar = 0.015;
          double aldersFradrag5Ar = 0.01;
          
          double minTotal= byggVerdi* totalSkadeGrense;
          if ( minTotal <= skadeBelop  && skadeBelop<= byggVerdi ){
            double sum;
               if(alder>= 10){
                    sum = byggVerdi - byggVerdi*alder*aldersFradrag10Ar;
                        return sum;
                }
                else if(alder>= 5){
                    sum = byggVerdi - byggVerdi*alder*aldersFradrag5Ar;
                        return sum;
                }
                else if(alder<5){
                   sum = byggVerdi;
                   return sum;
                }
               
          }
          return -1;
      }// end of method fullUtbetaling
    }
   
    
    class Egenandel{
        
    }
    
    class Premie{
        
    }
    
   
}// end of interface regneBelop.
