/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kontroller;

import GUI.Login;
import GUI.Registrer;
import GUI.KundeSide;
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
        Login login;
  
    public Kontroller(Stage primaryStage) throws Exception{
        loginVindu(primaryStage);
    }
        public void loginVindu(Stage primaryStage) {
            try {
                login = new Login(primaryStage, this );
            }
            catch (java.lang.Exception jle){
                System.out.println("Klarte ikke å åpne logginn vindu!");
            }
        }

        public void regVindu(){
            Registrer regVindu = new Registrer(new Stage(), this);
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
    public void registrerKunde(Registrer regVindu){
        try{
        Kunde b = regVindu.getKunde();
        brukerRegister.put(b.getKundeNokkel(), b);
        System.out.println(b.toString());
       }
       catch (NullPointerException e){
           
       }
    } 
    
    
    @Override
    public void handle(ActionEvent event) {
       /*
        if(event.getSource() == login.getKnappKundeLogginn()){
            boolean godkjent = sjekkPassord(login.getKunde(), login.getPassordKunde());
            System.out.println(godkjent);
            KundeSide.Display();
        }
        if(event.getSource() == login.getKnappKonsulentLogginn()){
            boolean godkjent = sjekkPassord(login.getKunde(), login.getPassordKunde());
            System.out.println(godkjent);
        }*/
       // if(event.getSource() == 
    }
    

    
}
