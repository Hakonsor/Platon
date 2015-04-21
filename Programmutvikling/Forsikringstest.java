/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsikringstest;


import GUI.Login;
import GUI.Registrer;
import Kontroller.Controller;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Forsikringstest extends Application {

    public static void main(String[] args) {
       launch( args);
       //Controller controller = new Controller(args);
        

       

    }
/*
    public static void nyttVindu(Class nyttVindu, String[] args){
        launch(nyttVindu, args);

    }
*/



    @Override
    public void start(Stage primaryStage) throws Exception {
            Controller c = new Controller();
            Registrer r = new Registrer(primaryStage);
            
    }

}//End of class
