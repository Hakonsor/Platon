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
    }

}//End of class
