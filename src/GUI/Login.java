package GUI;


import Kontroller.Kontroller;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import static javafx.geometry.Pos.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.xml.soap.Node;

/**
 * Created by Magnus on 18.04.15.
 */
public class Login {
    private String LoginBilde = "Bilder/user.png";

    private Stage primaryStage;
    private Kontroller kontroll;

    private Button btnNyKunde;
    private Button btnKonsulentLogginn;
    private Button btnKundeLogginn;
    private Button btnNyKonsulent;
    
    TextField tfKundeBrukernavn;
    PasswordField pfKundePassord; 
    TextField tfKonsulentBrukernavn;
    PasswordField pfKonsulentPassord; 

    public Login(Stage primaryStage, Kontroller k) throws Exception {

        this.primaryStage = primaryStage;

        kontroll = k;
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

        Scene scene = new Scene(tabs, 1024, 768);
        primaryStage.setTitle("Logg inn");
        primaryStage.setScene(scene);

        scene.getStylesheets().add("CSS/login.css");
        primaryStage.show();
    }

    private void closeLogin(){
        primaryStage.hide();
    }

   
    private Pane kundeFane(){


        final Rectangle rect1 = new Rectangle(10, 10, 100, 100);
        rect1.setArcHeight(50);
        rect1.setArcWidth(50);
        rect1.setFill(Color.BLUE);
        rect1.setWidth(200);

        FadeTransition ft = new FadeTransition(Duration.millis(300), rect1);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        GridPane grid = new GridPane();
        grid.setAlignment(TOP_CENTER);
        //grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(100));

        ImageView loginImg = new ImageView(new Image(LoginBilde));
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

        ParallelTransition pt;

        tfKundeBrukernavn = new TextField();
        tfKundeBrukernavn.setPromptText("kundenr");
        tfKundeBrukernavn.setId("tfkundenr");
        tfKundeBrukernavn.setMaxWidth(200);
        GridPane.setHalignment(tfKundeBrukernavn, HPos.CENTER);

        FadeTransition ftBrukernavn = new FadeTransition(Duration.millis(1500), tfKundeBrukernavn);
        ftBrukernavn.setFromValue(0.3F);
        ftBrukernavn.setToValue(1.0F);
        ftBrukernavn.setCycleCount(1);
        ftBrukernavn.play();

        TranslateTransition ttb = new TranslateTransition(Duration.millis(1500), tfKundeBrukernavn);
        ttb.setFromX(350);
        ttb.setToX(0);
        ttb.setCycleCount(1);
        ttb.play();

        TranslateTransition ttbShake = new TranslateTransition(Duration.millis(100), tfKundeBrukernavn);
        ttbShake.setFromX(0);
        ttbShake.setToX(30);
        ttbShake.setFromX(30);
        ttbShake.setToX(-30);
        ttbShake.setFromX(-30);
        ttbShake.setToX(0);
        ttbShake.setCycleCount(3);

        pfKundePassord = new PasswordField();
        pfKundePassord.setPromptText("passord");
        pfKundePassord.setId("pfKundePassord");
        pfKundePassord.setMaxWidth(200);
        GridPane.setHalignment(pfKundePassord, HPos.CENTER);

        FadeTransition ftPassord = new FadeTransition(Duration.millis(1500), pfKundePassord);
        ftPassord.setFromValue(0.3F);
        ftPassord.setToValue(1.0F);
        ftPassord.setCycleCount(1);
        ttb.play();

        TranslateTransition ttp = new TranslateTransition(Duration.millis(1500), pfKundePassord);
        ttp.setFromX(-350);
        ttp.setToX(0);
        ttp.setCycleCount(1);
        ttp.play();

        TranslateTransition ttpShake = new TranslateTransition(Duration.millis(100), pfKundePassord);
        ttpShake.setFromX(0);
        ttpShake.setToX(30);
        ttpShake.setFromX(30);
        ttpShake.setToX(-30);
        ttpShake.setFromX(-30);
        ttpShake.setToX(0);
        ttpShake.setCycleCount(3);

        Label logginnInfo = new Label();
        logginnInfo.setText("");
        logginnInfo.setVisible(false);
        logginnInfo.setId("logginnInfo");
        GridPane.setHalignment(logginnInfo, HPos.CENTER);

        btnNyKunde = new Button("Ny Kunde");
        btnNyKunde.setId("btNyKunde");
        btnNyKunde.setMaxWidth(200);
        GridPane.setHalignment(btnNyKunde, HPos.CENTER);
        try {
            btnNyKunde.setOnAction(e -> kontroll.regVindu());
        }catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnKundeLogginn = new Button("Logg inn");
        btnKundeLogginn.setId("btnlogginn");
        btnKundeLogginn.setMaxWidth(200);
        GridPane.setHalignment(btnKundeLogginn, HPos.CENTER);


        try {
            btnKundeLogginn.setOnAction(e -> {
                if(kontroll.sjekkPassord(tfKundeBrukernavn.getText(), pfKundePassord.getText())){
                    primaryStage.close();
                    kontroll.kundeSide(primaryStage);
                    kontroll.setInnloggetBruker(tfKundeBrukernavn.getText());

                }
                else if (!logginnInfo.isVisible()) {
                    ttpShake.play();
                    ttbShake.play();
                    logginnInfo.setText("Feil passord/brukernavn");
                    logginnInfo.setVisible(true);
                    tfKundeBrukernavn.setId("error1");
                    pfKundePassord.setId("error2");
                }
            });
        }catch (Exception ex) {
            Logger.getLogger(KundeSide.class.getName()).log(Level.SEVERE, null, ex);
        }


        grid.add(loginImg, 0, 0);
        grid.add(velkommen, 0, 1);
        grid.add(info, 0, 2);
        grid.add(tfKundeBrukernavn, 0, 5);
        grid.add(pfKundePassord, 0, 6);
        grid.add(logginnInfo, 0, 7);
        grid.add(btnKundeLogginn, 0, 8);
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

        ImageView loginImg = new ImageView(new Image(LoginBilde));
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

        tfKonsulentBrukernavn = new TextField();
        tfKonsulentBrukernavn.setPromptText("brukernavn");
        tfKonsulentBrukernavn.setId("tfbrukernavn");
        tfKonsulentBrukernavn.setMaxWidth(200);
        GridPane.setHalignment(tfKonsulentBrukernavn, HPos.CENTER);

        pfKonsulentPassord = new PasswordField();
        pfKonsulentPassord.setPromptText("passord");
        pfKonsulentPassord.setId("pfbrukernavn");
        pfKonsulentPassord.setMaxWidth(200);
        GridPane.setHalignment(pfKonsulentPassord, HPos.CENTER);


        //Animasjon

        TranslateTransition ttpShake = new TranslateTransition(Duration.millis(100), pfKonsulentPassord);
        ttpShake.setFromX(0);
        ttpShake.setToX(30);
        ttpShake.setFromX(30);
        ttpShake.setToX(-30);
        ttpShake.setFromX(-30);
        ttpShake.setToX(0);
        ttpShake.setCycleCount(3);

        TranslateTransition ttbShake = new TranslateTransition(Duration.millis(100), tfKonsulentBrukernavn);
        ttbShake.setFromX(0);
        ttbShake.setToX(30);
        ttbShake.setFromX(30);
        ttbShake.setToX(-30);
        ttbShake.setFromX(-30);
        ttbShake.setToX(0);
        ttbShake.setCycleCount(3);


        Label logginnInfo = new Label();
        logginnInfo.setText("");
        logginnInfo.setVisible(false);
        logginnInfo.setId("logginnInfo");
        GridPane.setHalignment(logginnInfo, HPos.CENTER);

        btnKonsulentLogginn = new Button("Logg inn");
        btnKonsulentLogginn.setId("btnlogginn");
        btnKonsulentLogginn.setMaxWidth(200);
        GridPane.setHalignment(btnKonsulentLogginn, HPos.CENTER);
        try {
            btnKonsulentLogginn.setOnAction(e -> {
                if (kontroll.sjekkPassord(tfKonsulentBrukernavn.getText(), pfKonsulentPassord.getText())) {
                    primaryStage.close();
                    kontroll.konsulentSide(primaryStage);
                    kontroll.setInnloggetBruker(tfKonsulentBrukernavn.getText());
                }
                else if (!logginnInfo.isVisible()) {
                    ttpShake.play();
                    ttbShake.play();
                    logginnInfo.setText("Feil passord/brukernavn");
                    logginnInfo.setVisible(true);
                    tfKonsulentBrukernavn.setId("error1");
                    pfKonsulentPassord.setId("error2");
                }
            });
        }catch (Exception ex) {
            Logger.getLogger(KundeSide.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnNyKonsulent = new Button("Ny Konsulent");
        btnNyKonsulent.setId("btNyKonsulent");
        btnNyKonsulent.setMaxWidth(200);
        GridPane.setHalignment(btnNyKonsulent, HPos.CENTER);
        try {
            btnNyKonsulent.setOnAction(e -> kontroll.regKonsulent());
        }catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        grid.add(loginImg, 0, 0);
        grid.add(velkommen, 0, 1);
        grid.add(info, 0, 2);
        grid.add(tfKonsulentBrukernavn, 0, 5);
        grid.add(pfKonsulentPassord, 0, 6);
        grid.add(logginnInfo, 0, 7);
        grid.add(btnKonsulentLogginn, 0, 8);
        grid.add(btnNyKonsulent, 0, 9);


        return grid;
    }



    public Button getKnappKonsulentLogginn(){
        return btnKonsulentLogginn;
    }
    public Button getKnappKundeLogginn(){
        return btnKundeLogginn;  
    }
    public Button getKnappNyKonsulent(){
        return btnNyKonsulent;
    }    
    public String getKunde(){
        return tfKundeBrukernavn.getText();
    }
    public String getPassordKunde(){
        return pfKundePassord.getText();
    } 
    public String getKunsulent(){
        return tfKonsulentBrukernavn.getText();
    }
    public String getKunsulentPassord(){
        return pfKonsulentPassord.getText();
    } 
    
    



}//End of class

//kontroll.getInnloggetBruker().getFornavn()
