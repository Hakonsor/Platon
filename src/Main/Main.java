/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;


import GUI.KundeSide;
import GUI.Login;
import GUI.Registrer;
import Kontroller.Kontroller;
import Person.Kunde;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
       launch( args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Kontroller c = new Kontroller( primaryStage );


        /*
        for(int i = 0; i < 10000000; i++){
            Kunde k = new Kunde("TEst", "Test", "TEst", "Test", "Test", "Test");
            c.brukerRegister.put(String.valueOf(i), k);
            System.out.println(i);
        }
        */

    }

}//End of class
