package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
       // nyttVindu(Login.class, args);
        Controller controller = new Controller(args);


        //launch(Registrer.class, args);

    }

    public static void nyttVindu(Class nyttVindu, String[] args){
        launch(nyttVindu, args);

    }



    @Override
    public void start(Stage primaryStage) throws Exception {

    }

}//End of class
