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
       login = new Login(primaryStage);
        
    }
    
    public Bruker finnKunde(String Bruker){
      return brukerRegister.get(Bruker);
    }
    public boolean sjekkPassord(String bruker, String  passord){
      Bruker sjekkBruker = finnKunde(bruker);
      
    return false;
    }
    
    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == login.getKnappKundeLogginn()){
           // sjekkPassord((login.getKunde());
        }
        //if(event.getSource() == login.)
    }
    

    
}
