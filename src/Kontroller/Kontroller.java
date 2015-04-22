/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Kontroller;

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
        Map<String, Bruker> brukerRegister = new HashMap<>();
        Login login;
  
    public Kontroller(Stage primaryStage) throws Exception{
        login = new Login(primaryStage, this );
    }
    public Bruker finnBruker(String Bruker){
        return brukerRegister.get(Bruker);
    }
    public boolean sjekkPassord(String bruker, String  passord){
        Bruker sjekkBruker = finnBruker(bruker);
        if(sjekkBruker == null) return false;
        return sjekkBruker.sjekkPassord(passord);
    }
    public void registrerKunde(){
        //System.out.println("we");
        System.out.println(b.toString());
    } 
    
    
    @Override
    public void handle(ActionEvent event) {
        /*
        if(event.getSource() == login.getKnappKundeLogginn()){
            boolean godkjent = sjekkPassord(login.getKunde(), login.getPassordKunde());
            System.out.println(godkjent);
        }
        if(event.getSource() == login.getKnappKonsulentLogginn()){
            boolean godkjent = sjekkPassord(login.getKunde(), login.getPassordKunde());
            System.out.println(godkjent);
        }
       // if(event.getSource() == 
    }
    

    
}
