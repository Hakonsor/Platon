/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kontroller;

import Forsikring.Forsikringer;
import GUI.KundeSide;
import GUI.Login;
import GUI.Registrer;
import Person.Bruker;
import Person.Kunde;
import java.util.HashMap;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/*
 *
 * @author hakon_000
 */

    public class Kontroller implements EventHandler<ActionEvent>{
        
        
        public static Map<String, Bruker> brukerRegister = new HashMap<>();
        
  
            public Kontroller(Stage primaryStage) throws Exception{
                loginVindu(primaryStage);
                }
            
            public void loginVindu(Stage primaryStage) {
                try {
                   Login login = new Login(primaryStage, this );
                }
                catch (java.lang.Exception jle){
                    System.out.println("Klarte ikke å åpne logginn vindu!");
                }
            }
             
            public void regVindu(){
                Registrer regVindu = new Registrer(new Stage(), this);
            }
            public void setForsikring(int bonusIndex, int egenandelIndex, int kjorelengdeIndex,  Kunde k){
                double bonus;
                switch (bonusIndex) {
                    case 1:  bonus = -20.0;
                        break;
                    case 2:  bonus = -10.0;
                        break;
                    case 3:  bonus = 0.0;
                        break;
                    case 4:  bonus = 10.0;
                        break;
                    case 5:  bonus = 20.0;
                        break;
                    case 6:  bonus = 30.0;
                        break;
                    case 7:  bonus = 40.0;
                        break;
                    case 8:  bonus = 50.0;
                        break;
                    case 9:  bonus = 60.0;
                        break;
                    case 10:  bonus = 70.0;
                        break;
                    case 11:  bonus = 75.0;
                        break;              
                    default: System.out.println("Har ikke valgt bonus");
                        return;
                }
                double egenandel;
                switch(egenandelIndex){
                    case 4:  bonus = 10.0;
                        break;
                    case 5:  bonus = 20.0;
                        break;
                    case 6:  bonus = 30.0;
                        break;
                    default:
                
                
                
                }
                
          //  k.addForsikring(new BilForsikring());
            }
            public void kundeSide(Stage primaryStage){
                KundeSide nyside = new KundeSide(primaryStage, this);
            }
            public Bruker finnBruker(String Bruker){
                return brukerRegister.get(Bruker);
            }
            public boolean sjekkPassord(String bruker, String  passord){
                Bruker sjekkBruker = finnBruker(bruker);
                if(sjekkBruker == null) return false;
                return sjekkBruker.sjekkPassord(passord);
            }
            public void nyKunde( Kunde b){
                brukerRegister.put(b.getKundeNokkel(), b);
            }
            public void registrerKunde(Kunde b){
                brukerRegister.put(b.getKundeNokkel(), b);
                System.out.println(b.toString());
            }
            public void addforsikring(Kunde kunde, String cbBonus, String cbEgenandel, String cbKjørelengde){
            if(cbBonus.matches("")){}
            }
    
    
    
        @Override
        public void handle(ActionEvent event) {
            // Vi tar i bruk lambda uttrykk istedenfor istedenfor
            // Metodene blir kjøre direkte med <knapp>.setOnAction( e -> regVindu())
        }
    }
    
