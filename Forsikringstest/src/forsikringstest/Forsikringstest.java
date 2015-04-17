/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forsikringstest;

import javafx.application.Application;
import static javafx.application.Application.launch;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Therese
 */
public class Forsikringstest extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //   Register r = new Register();
        launch(args);
    }
    
        @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setMaxHeight(640);
        primaryStage.setMinHeight(640);
        primaryStage.setMaxWidth(800);
        primaryStage.setMinWidth(800);

        primaryStage.setTitle("Logg inn");
        primaryStage.setScene(new Scene(root, 800, 640));
        primaryStage.show();
    }
    
}
