package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Node;

import javax.swing.*;
import java.awt.*;

import static javafx.geometry.Pos.*;

/**
 * Created by Magnus on 18.04.15.
 */
public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TabPane tabs = new TabPane();
        Tab tabKunde = new Tab();
        tabKunde.setText("Kunde");
        tabKunde.setClosable(false);
        tabKunde.setContent(kundeFane());

        Tab tabKonsulent = new Tab();
        tabKonsulent.setText("Konsulent");
        tabKonsulent.setClosable(false);
        tabKonsulent.setContent(konsulentFane());
        tabs.getTabs().addAll(tabKunde, tabKonsulent);

        Scene scene = new Scene(tabs, 800, 640);
        primaryStage.setTitle("Logg inn");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Login.class.getResource("login.css").toExternalForm());
        primaryStage.show();
    }



    private Pane kundeFane(){

        GridPane grid = new GridPane();
        grid.setAlignment(TOP_CENTER);
        //grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(100));

        ImageView loginImg = new ImageView(new Image("sample/user.png"));
        loginImg.setId("loginImg");
        loginImg.setPreserveRatio(true);
        loginImg.setFitWidth(128);
        GridPane.setHalignment(loginImg, HPos.CENTER);

        Label velkommen = new Label();
        velkommen.setText("Kunde Logginn");
        velkommen.setId("kunde_velkommen_tekst");
        GridPane.setHalignment(velkommen, HPos.CENTER);

        Label info = new Label();
        info.setText("Logg inn for å fortsette");
        info.setId("logginn_info");
        GridPane.setHalignment(info, HPos.CENTER);

        TextField tfKundenr = new TextField();
        tfKundenr.setPromptText("kundenr");
        tfKundenr.setId("tfkundenr");
        tfKundenr.setMaxWidth(200);
        GridPane.setHalignment(tfKundenr, HPos.CENTER);

        PasswordField pfKundenr = new PasswordField();
        pfKundenr.setPromptText("passord");
        pfKundenr.setId("pfkundenr");
        pfKundenr.setMaxWidth(200);
        GridPane.setHalignment(pfKundenr, HPos.CENTER);

        Label logginnInfo = new Label();
        logginnInfo.setText("feil passord!");
        logginnInfo.setId("logginnInfo");
        GridPane.setHalignment(logginnInfo, HPos.CENTER);

        Button btnLogginn = new Button("Logg inn");
        btnLogginn.setId("btnlogginn");
        btnLogginn.setMaxWidth(200);
        GridPane.setHalignment(btnLogginn, HPos.CENTER);

        Button btnNyKunde = new Button("Ny Kunde");
        btnNyKunde.setId("btNyKunde");
        btnNyKunde.setMaxWidth(200);
        GridPane.setHalignment(btnNyKunde, HPos.CENTER);


        grid.add(loginImg, 0, 0);
        grid.add(velkommen, 0, 1);
        grid.add(info, 0, 2);
        grid.add(tfKundenr, 0, 5);
        grid.add(pfKundenr, 0, 6);
        grid.add(logginnInfo, 0, 7);
        grid.add(btnLogginn, 0, 8);
        grid.add(btnNyKunde, 0, 9);

        return grid;
    }

    private Pane konsulentFane() {
        GridPane grid = new GridPane();
        grid.setAlignment(TOP_CENTER);
        //grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(100));

        ImageView loginImg = new ImageView(new Image("sample/user.png"));
        loginImg.setId("loginImg");
        loginImg.setPreserveRatio(true);
        loginImg.setFitWidth(128);
        GridPane.setHalignment(loginImg, HPos.CENTER);

        Label velkommen = new Label();
        velkommen.setText("Konsulent Logginn");
        velkommen.setId("konsulent_velkommen_tekst");
        GridPane.setHalignment(velkommen, HPos.CENTER);

        Label info = new Label();
        info.setText("Logg inn for å fortsette");
        info.setId("logginn_info");
        GridPane.setHalignment(info, HPos.CENTER);

        TextField tfBrukernavn = new TextField();
        tfBrukernavn.setPromptText("brukernavn");
        tfBrukernavn.setId("tfbrukernavn");
        tfBrukernavn.setMaxWidth(200);
        GridPane.setHalignment(tfBrukernavn, HPos.CENTER);

        PasswordField pfKundenr = new PasswordField();
        pfKundenr.setPromptText("passord");
        pfKundenr.setId("pfbrukernavn");
        pfKundenr.setMaxWidth(200);
        GridPane.setHalignment(pfKundenr, HPos.CENTER);

        Button btnLogginn = new Button("Logg inn");
        btnLogginn.setId("btnlogginn");
        btnLogginn.setMaxWidth(200);
        GridPane.setHalignment(btnLogginn, HPos.CENTER);

        Button btnNyKonsulent = new Button("Ny Konsulent");
        btnLogginn.setId("btNyKonsulent");
        btnNyKonsulent.setMaxWidth(200);
        GridPane.setHalignment(btnNyKonsulent, HPos.CENTER);


        grid.add(loginImg, 0, 0);
        grid.add(velkommen, 0, 1);
        grid.add(info, 0, 2);
        grid.add(tfBrukernavn, 0, 5);
        grid.add(pfKundenr, 0, 6);
      //  grid.add(logginnInfo, 0, 7);
        grid.add(btnLogginn, 0, 8);
        grid.add(btnNyKonsulent, 0, 9);

        return grid;
    }

}//End of class
