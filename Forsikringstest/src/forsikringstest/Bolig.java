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
public abstract class Bolig extends Forsikringer {
    
    private int kvadrat;
    private String adresse;
    private String boligType ;
    private String byggeår ;
    private String metriale;
    private String standard;
    private String byggSum;
    private String inboSUm;
    
    public Bolig( int poliseNr , int premie , int egenandel , String forsikrBet,
                  int kvadrat, String adresse, String boligType, String byggeår,
                  String metriale, String standard, String byggSum, String inboSUm){
       super( poliseNr , premie , egenandel , forsikrBet );
       this.kvadrat = kvadrat;
       this.adresse = adresse;
       this.boligType = boligType;
       this.byggeår = byggeår;
       this.inboSUm = byggSum;
       
       
       
    }
    
}// end of class Bolig.
