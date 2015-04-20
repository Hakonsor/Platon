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
public class RegnReise {
    
    
    
    public double utbetalReise( double skadeSum, String typeSkade ){
        double utBetaling;
        double forsikringSum = 0;
        double utbetaling;
    if(typeSkade.equals("forsReisegods")){
        forsikringSum = 3000;
        
    }
     if(typeSkade.equals("forsReise")){
         forsikringSum = 20000;   
     }
    if(typeSkade.equals("person")){
        forsikringSum = 1000000;
    }
    
    
    if(skadeSum >= forsikringSum){
            utbetaling = forsikringSum;
        }
        else{
            utbetaling = skadeSum;
        }
    
        return utbetaling;
    }
}
