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
public class UtbetalingBolig {
    // klassevariable, regler for beregning av forsikringssummer.
          private static double totalSkadeGrense = 0.75;
          private static  int femAar= 5;
          private static int tiAar = 10;
          private static double delta10 = 0.015;
          private static double delta5 = 0.01;
    // variable som brukes i metodene Utbetaling      
          private int sum;
          private int minTotal;
          private int byggVerdi;
          
    
      public int utbetaling( int skadeBelop , int verdi, int alder, int egenAndel){
          // bestemmer byggets verdi
             if ( alder>=  tiAar ){
                byggVerdi = ( int )(verdi-alder*verdi*delta10 );
             }
             else if( alder>=femAar ){
                 byggVerdi = ( int )( verdi - alder*verdi*delta5 );
             }
             else{
                 byggVerdi = verdi;
             }
             
          // laveste skadegrense for totalskade her er det tatt hensyn til byggets alder:    
          
          minTotal = ( int )( byggVerdi* totalSkadeGrense );
          
          // sjekker om bygget er totalskadet, dvs skaden utgjør minst 75% av verdien til boligen.
          if ( skadeBelop< minTotal ){
              sum = skadeBelop - egenAndel;
          }
          else{
              sum = byggVerdi - egenAndel;
          }
          return sum;
      }
    
      // beregner sum til utbetaling, dersom boligen er totalskadet, 0 hvis metoden ikke fører til noe beløp.
      public int utbetaling( int skadeBelop , int verdi, int alder, int egenAndel, int leie ){
          final int maxLeie = 25000;
          
          // bestemmer byggets verdi
             if (alder>=  tiAar ){
                byggVerdi = (int)(verdi-alder*verdi*delta10);
             }
             else if(alder>=femAar){
                 byggVerdi = (int)(verdi - alder*verdi*delta5);
             }
             else{
                 byggVerdi = verdi;
             }
             
          // laveste skadegrense for totalskade her er det tatt hensyn til byggets alder:    
          
          minTotal = (int)(byggVerdi* totalSkadeGrense);
          
          // sjekker om bygget er totalskadet, dvs skaden utgjør minst 75% av verdien til boligen.
          if ( skadeBelop <  minTotal ){
              sum = skadeBelop - egenAndel;
          }
          else{
              sum = byggVerdi - egenAndel;
          }
          
          // sjekker at det ikke blir betalt ut mer enn reglene tilsier, ift tapte leieinntekter.
    
             if( leie >= maxLeie ){
                 sum += maxLeie;
             }
             else{
                 sum += leie;
             }
          
          return sum;
           
      }// end of method Utbetaling
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
