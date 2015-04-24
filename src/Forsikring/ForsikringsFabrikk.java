/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

/**
 *
 * @author Therese
 */
public class ForsikringsFabrikk {
  
    
    public static Forsikringer lagForsikring(double bonus, double egenandel,
                int tlf, int kjorelengde,String regNr , String type ,String modell, String arsModell,  int kmStand){
                
        return new BilForsikring(bonus,egenandel,
                tlf, kjorelengde,regNr ,type ,modell,arsModell,kmStand);
    }// end of method
    
     public static Forsikringer lagForsikring(double bonus, String motorType, int lendgeFot, int motorStyrke,String regNr , String type,String modell, String arsModell){
    
         return new BatForsikring(bonus,motorType,lendgeFot,motorStyrke,regNr ,type,modell,arsModell);
       
  }
    
    // returnerer enten vanlig boligforsikring eller fritidsBoligForsikring avhengig av hva første parameter er.
    // returnerer null hvis det ikke er laget noen forsikring.
    public static Forsikringer lagForsikring(String bolig, boolean utleie, double kvadrat, String adresse, String boligType, String byggeår,
                  String metriale, String standard, double byggSum, double inboSUm){
        switch (bolig) {
            case "bolig":
                return new BoligForsikring(utleie,kvadrat, adresse, boligType, byggeår,
                        metriale, standard, byggSum, inboSUm);
            case "fritid":
                return new FritidsBolig(utleie,
                        kvadrat,adresse, boligType, byggeår,
                        metriale, standard, byggSum, inboSUm);
        }
        return null;
    }// end of method 
    
    public static Forsikringer lagForsikring(String reise){
        if(reise.equals("reise")){
         return new ReiseForsikring();
    }
        return null;
  }
    
}// end of class ForsikringsFabrikk
