package GUI;

import Kontroller.Kontroller;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import static javafx.geometry.Pos.*;

import javafx.geometry.Pos;
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
import javafx.stage.Stage;
import javafx.util.Duration;

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
    private VBox vBoxKunde;
    private VBox vBoxKonsulent;
    private GridPane gridKtext;
    private GridPane gridKunde;
    private GridPane gridKonstext;
    private GridPane gridKonsulent;
    private TextField tfKundeBrukernavn;
    private PasswordField pfKundePassord;
    private TextField tfKonsulentBrukernavn;
    private PasswordField pfKonsulentPassord;
    private Label infoKunde;
    private Label infoKonsulent;

    public Login(Stage primaryStage, Kontroller k) throws Exception {

        this.primaryStage = primaryStage;
        kontroll = k;
        TabPane tabs = new TabPane();

        Tab tabKunde = new Tab();
        tabKunde.setText("Kunde");
        tabKunde.setId("kunde");
        tabKunde.setClosable(false);
        tabKunde.setContent(kundeFane());

        Tab tabKonsulent = new Tab();
        tabKonsulent.setText("Konsulent");
        tabKonsulent.setId("konsulent");
        tabKonsulent.setClosable(false);
        tabKonsulent.setContent(konsulentFane());
        tabs.getTabs().addAll(tabKunde, tabKonsulent);

        Scene scene = new Scene(tabs, 1024, 768);
        primaryStage.setTitle("Logg inn");
        primaryStage.setScene(scene);

        scene.getStylesheets().add("CSS/login.css");
        primaryStage.show();
    }

    private void closeLogin() {
        primaryStage.hide();
    }

    private Pane kundeFane() {

        vBoxKunde = new VBox();
        vBoxKunde.setAlignment(Pos.CENTER);
        vBoxKunde.setSpacing(20);
        vBoxKunde.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left

        gridKtext = new GridPane();
        gridKtext.setAlignment(Pos.CENTER);

        infoKunde = new Label();
        infoKunde.setText("Logg inn for å fortsette...");
        infoKunde.setId("logginn_info");

        gridKtext.add(infoKunde, 0, 0);

        gridKunde = new GridPane();
        gridKunde.setAlignment(Pos.CENTER);
        gridKunde.setHgap(20);
        gridKunde.setVgap(10);

        tfKundeBrukernavn = new TextField();
        tfKundeBrukernavn.setPromptText("kundenr");
        tfKundeBrukernavn.setId("tfkundenr");
        tfKundeBrukernavn.setMaxWidth(200);

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

        btnNyKunde = new Button("Ny Kunde");
        btnNyKunde.setId("btNyKunde");
        btnNyKunde.setMaxWidth(200);
        try {
            btnNyKunde.setOnAction(e -> kontroll.regVindu());
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        btnKundeLogginn = new Button("Logg inn");
        btnKundeLogginn.setId("btnlogginn");
        btnKundeLogginn.setMaxWidth(200);
        try {
            btnKundeLogginn.setOnAction(e -> {
                if (kontroll.sjekkPassordKunde(tfKundeBrukernavn.getText(), pfKundePassord.getText())) {
                    primaryStage.close();
                    kontroll.kundeSide(primaryStage);
                    kontroll.setInnloggetBruker(tfKundeBrukernavn.getText());

                } else if (!logginnInfo.isVisible()) {
                    ttpShake.play();
                    ttbShake.play();
                    logginnInfo.setText("Feil kundenr/passord");
                    logginnInfo.setVisible(true);
                    tfKundeBrukernavn.setId("error1");
                    pfKundePassord.setId("error2");
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(KundeSide.class.getName()).log(Level.SEVERE, null, ex);
        }

        vBoxKunde.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    if (kontroll.sjekkPassordKunde(tfKundeBrukernavn.getText(), pfKundePassord.getText())) {
                        primaryStage.close();
                        kontroll.kundeSide(primaryStage);
                        kontroll.setInnloggetBruker(tfKundeBrukernavn.getText());

                    } else if (!logginnInfo.isVisible()) {
                        ttpShake.play();
                        ttbShake.play();
                        logginnInfo.setText("Feil kundenr/passord");
                        logginnInfo.setVisible(true);
                        tfKundeBrukernavn.setId("error1");
                        pfKundePassord.setId("error2");
                    }
                }
            }
        });


        gridKunde.add(tfKundeBrukernavn, 0, 0, 2, 1);
        gridKunde.add(pfKundePassord, 0, 1, 2, 1);
        gridKunde.add(btnKundeLogginn, 0, 2);
        gridKunde.add(btnNyKunde, 1, 2);
        gridKunde.add(logginnInfo, 0, 3, 2, 1);

        vBoxKunde.getChildren().addAll(gridKtext, gridKunde);
        return vBoxKunde;
    }

    private Pane konsulentFane() {

        vBoxKonsulent = new VBox();
        vBoxKonsulent.setAlignment(Pos.CENTER);
        vBoxKonsulent.setSpacing(20);
        vBoxKonsulent.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left

        gridKonstext = new GridPane();
        gridKonstext.setAlignment(Pos.CENTER);

        infoKonsulent = new Label();
        infoKonsulent.setText("Logg inn for å fortsette...");
        infoKonsulent.setId("logginn_info");

        gridKonstext.add(infoKonsulent, 0, 0);

        gridKonsulent = new GridPane();
        gridKonsulent.setAlignment(Pos.CENTER);
        gridKonsulent.setHgap(20);
        gridKonsulent.setVgap(10);

        tfKonsulentBrukernavn = new TextField();
        tfKonsulentBrukernavn.setPromptText("brukernavn");
        tfKonsulentBrukernavn.setId("tfbrukernavn");
        tfKonsulentBrukernavn.setMaxWidth(250);

        pfKonsulentPassord = new PasswordField();
        pfKonsulentPassord.setPromptText("passord");
        pfKonsulentPassord.setId("pfbrukernavn");
        pfKonsulentPassord.setMaxWidth(250);

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

        btnKonsulentLogginn = new Button("Logg inn");
        btnKonsulentLogginn.setId("btnlogginn");
        btnKonsulentLogginn.setMaxWidth(200);
        btnKonsulentLogginn.setOnAction(e -> {
            if (kontroll.sjekkPassordKonsulent(tfKonsulentBrukernavn.getText(), pfKonsulentPassord.getText())) {
                primaryStage.close();
                kontroll.konsulentSide(primaryStage);
                kontroll.setInnloggetBruker(tfKonsulentBrukernavn.getText());
            } else if (!logginnInfo.isVisible()) {
                ttpShake.play();
                ttbShake.play();
                logginnInfo.setText("Feil brukernavn/passord");
                logginnInfo.setVisible(true);
                tfKonsulentBrukernavn.setId("error1");
                pfKonsulentPassord.setId("error2");
            }
        });

        btnNyKonsulent = new Button("Ny Konsulent");
        btnNyKonsulent.setId("btNyKonsulent");
        btnNyKonsulent.setMaxWidth(200);
        try {
            btnNyKonsulent.setOnAction(e -> kontroll.regKonsulent());
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        vBoxKonsulent.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    if (kontroll.sjekkPassordKonsulent(tfKonsulentBrukernavn.getText(), pfKonsulentPassord.getText())) {
                        primaryStage.close();
                        kontroll.konsulentSide(primaryStage);
                        kontroll.setInnloggetBruker(tfKonsulentBrukernavn.getText());
                    } else if (!logginnInfo.isVisible()) {
                        ttpShake.play();
                        ttbShake.play();
                        logginnInfo.setText("Feil brukernavn/passord");
                        logginnInfo.setVisible(true);
                        tfKonsulentBrukernavn.setId("error1");
                        pfKonsulentPassord.setId("error2");
                    }
                }
            }
        });

        gridKonsulent.add(tfKonsulentBrukernavn, 0, 0, 2, 1);
        gridKonsulent.add(pfKonsulentPassord, 0, 1, 2, 1);
        gridKonsulent.add(btnKonsulentLogginn, 0, 2);
        gridKonsulent.add(btnNyKonsulent, 1, 2);
        gridKonsulent.add(logginnInfo, 0, 3, 2, 1);

        vBoxKonsulent.getChildren().addAll(gridKonstext, gridKonsulent);
        return vBoxKonsulent;
    }

    public Button getKnappKonsulentLogginn() {
        return btnKonsulentLogginn;
    }

    public Button getKnappKundeLogginn() {
        return btnKundeLogginn;
    }

    public Button getKnappNyKonsulent() {
        return btnNyKonsulent;
    }

    public String getKunde() {
        return tfKundeBrukernavn.getText();
    }

    public String getPassordKunde() {
        return pfKundePassord.getText();
    }

    public String getKunsulent() {
        return tfKonsulentBrukernavn.getText();
    }

    public String getKunsulentPassord() {
        return pfKonsulentPassord.getText();
    }

}//End of class

//kontroll.getInnloggetBruker().getFornavn()
