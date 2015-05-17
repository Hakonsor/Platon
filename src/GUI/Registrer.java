package GUI;

import Kontroller.Kontroller;
import Person.Bruker;
import Kontroller.Postregister;
import Person.Kunde;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import static javafx.geometry.Pos.TOP_CENTER;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Magnus on 20.04.15.
 */
public class Registrer {

    private final String LoginBilde = "Bilder/add_user.png";
    private Kontroller kontroll;

    private final Button btnRegKunde;
    private final Label nyKunde;
    private final Label info;
    private final TextField fornavn;
    private final TextField etternavn;
    private final TextField personnr;
    private final TextField telefon;
    private final TextField epost;
    private final TextField adresse;
    private final TextField postnr;
    private final Label poststed;
    private final PasswordField velgpassord;
    private final PasswordField gjentapassord;
    private static Stage vindu;
    public Scene scene;

    public Registrer(Stage vindu, Kontroller kontroll) {
        this.vindu = vindu;
        this.kontroll = kontroll;

        GridPane grid = new GridPane();
        grid.setAlignment(TOP_CENTER);
        //grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        ImageView loginImg = new ImageView(new Image(LoginBilde));
        loginImg.setId("loginImg");
        loginImg.setPreserveRatio(true);
        loginImg.setFitWidth(100);
        GridPane.setHalignment(loginImg, HPos.CENTER);

        nyKunde = new Label();
        nyKunde.setText("Ny Kunde");
        nyKunde.setId("nykunde");
        GridPane.setHalignment(nyKunde, HPos.CENTER);

        fornavn = new TextField();
        fornavn.setPromptText("Fornavn");
        fornavn.setId("promtfix");
        fornavn.setMaxWidth(200);
        GridPane.setHalignment(fornavn, HPos.CENTER);
        fornavn.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            String regex = "[äÄöÖüÜëËÆØÅæøåA-Za-z]+";
            String Fornavn = fornavn.getText();

            if (Fornavn.matches(regex)) {
                fornavn.setId("valid");
            } else {
                fornavn.setId("error");
            }
            if (Fornavn.length() == 0) {
                fornavn.setId("promtfix");
            }
        });

        etternavn = new TextField();
        etternavn.setPromptText("Etternavn");
        etternavn.setId("promtfix");
        etternavn.setMaxWidth(200);
        GridPane.setHalignment(etternavn, HPos.CENTER);
        etternavn.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            String regex = "[äÄöÖüÜëËÆØÅæøåA-Za-z]+";
            String Etternavn = etternavn.getText();

            if (Etternavn.matches(regex)) {
                etternavn.setId("valid");
            } else {
                etternavn.setId("error");
            }
            if (Etternavn.length() == 0) {
                etternavn.setId("promtfix");
            }
        });

        personnr = new TextField();
        personnr.setPromptText("Personnr");
        personnr.setId("promtfix");
        personnr.setMaxWidth(200);
        GridPane.setHalignment(personnr, HPos.CENTER);
        personnr.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            String regex = "[0-9]+";
            String Personnr = personnr.getText();

            if (!Personnr.matches(regex) || Personnr.length() > 11 || Personnr.length() < 11) {
                personnr.setId("error");
            } else {
                personnr.setId("valid");
            }
            if (Personnr.length() == 0) {
                personnr.setId("promtfix");
            }
        });

        telefon = new TextField();
        telefon.setPromptText("Telefon");
        telefon.setId("promtfix");
        telefon.setMaxWidth(200);
        GridPane.setHalignment(telefon, HPos.CENTER);
        telefon.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            String regex = "[0-9]+";
            String Telefon = telefon.getText();

            if (!Telefon.matches(regex) || Telefon.length() > 8 || Telefon.length() < 8) {
                telefon.setId("error");
            } else {
                telefon.setId("valid");
            }
            if (Telefon.length() == 0) {
                telefon.setId("promtfix");
            }
        });

        epost = new TextField();
        epost.setPromptText("E-Post");
        epost.setId("promtfix");
        epost.setMaxWidth(200);
        GridPane.setHalignment(epost, HPos.CENTER);
        epost.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            String regex = "^[A-Za-z0-9.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
            String Epost = epost.getText();

            if (Epost.matches(regex)) {
                epost.setId("valid");
            } else {
                epost.setId("error");
            }
            if (Epost.length() == 0) {
                epost.setId("promtfix");
            }
        });

        adresse = new TextField();
        adresse.setPromptText("Adresse");
        adresse.setId("promtfix");
        adresse.setMaxWidth(200);
        GridPane.setHalignment(adresse, HPos.CENTER);
        adresse.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[äÄöÖüÜëËÆØÅæøåA-Za-z0-9 _]+";
                String Adresse = adresse.getText();

                if (Adresse.matches(regex)) {
                    adresse.setId("valid");
                } else {
                    adresse.setId("error");
                }
                if (Adresse.length() == 0) {
                    adresse.setId("promtfix");
                }
            }
        });

        postnr = new TextField();
        postnr.setPromptText("Postnr:");
        postnr.setId("promtfix");
        postnr.setMaxWidth(200);
        GridPane.setHalignment(postnr, HPos.CENTER);

        poststed = new Label();
        poststed.setText("");
        poststed.setId("poststed");
        GridPane.setHalignment(poststed, HPos.CENTER);
        postnr.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            String regex = "[0-9]+";
            String Postnr = postnr.getText();

            Postregister register = new Postregister();
            String Poststed = register.getPoststed(postnr.getText());
            if (!Postnr.matches(regex) || Postnr.length() > 4 || Postnr.length() < 4) {
                postnr.setId("error");
            }
            if (Poststed != null) {
                postnr.setId("valid");
            }
            if (Postnr.length() == 0) {
                postnr.setId("promtfix");
            }

            if (Poststed == null) {
                poststed.setText("Finnes ikke!");
            }
            if (postnr.getText().length() == 0) {
                poststed.setText("");
            } else {
                poststed.setText(Poststed);
            }
        });

        velgpassord = new PasswordField();
        velgpassord.setPromptText("Velg Passord");
        velgpassord.setId("promtfix");
        velgpassord.setMaxWidth(200);
        GridPane.setHalignment(velgpassord, HPos.CENTER);

        gjentapassord = new PasswordField();
        gjentapassord.setPromptText("Gjenta Passord");
        gjentapassord.setId("promtfix");
        gjentapassord.setMaxWidth(200);
        GridPane.setHalignment(gjentapassord, HPos.CENTER);
        gjentapassord.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String Velgpassord = velgpassord.getText();
                String Gjentapassord = gjentapassord.getText();
                if (!velgpassord.getText().equals(gjentapassord.getText())) {
                    // velgpassord.setId();
                    gjentapassord.setId("error");
                }
                if (velgpassord.getText().equals(gjentapassord.getText())) {
                    velgpassord.setId("valid");
                    gjentapassord.setId("valid");
                }
                if (Velgpassord.length() == 0) {
                    velgpassord.setId("promtfix");
                }
                if (Gjentapassord.length() == 0) {
                    gjentapassord.setId("promtfix");
                    velgpassord.setId("promtfix");
                }
            }
        });

        info = new Label();
        info.setText("");
        info.setId("info");
        info.setVisible(false);
        GridPane.setHalignment(info, HPos.CENTER);

        btnRegKunde = new Button("Registrer Kunde");
        btnRegKunde.setId("btNyKunde");
        btnRegKunde.setMaxWidth(200);
        btnRegKunde.setOnAction(e -> {
            regKunde();
        });

        GridPane.setHalignment(btnRegKunde, HPos.CENTER);

        grid.add(loginImg, 0, 0);
        grid.add(nyKunde, 0, 1);
        grid.add(fornavn, 0, 2);
        grid.add(etternavn, 0, 3);
        grid.add(personnr, 0, 4);
        grid.add(telefon, 0, 5);
        grid.add(epost, 0, 6);
        grid.add(adresse, 0, 7);
        grid.add(postnr, 0, 8);
        grid.add(poststed, 0, 9);
        grid.add(velgpassord, 0, 10);
        grid.add(gjentapassord, 0, 11);
        grid.add(btnRegKunde, 0, 14);
        grid.add(info, 0, 15);

        scene = new Scene(grid, 300, 650);
        vindu.setTitle("Registrer");
        vindu.setScene(scene);
        scene.getStylesheets().add("CSS/nykunde.css");
        vindu.show();
    }

    public Button getBtnRegKunde() {
        return btnRegKunde;
    }

    public Kunde getKunde() {
        if (velgpassord.getText().equals(gjentapassord.getText())) {
            return new Kunde(fornavn.getText(), etternavn.getText(), personnr.getText(), telefon.getText(), epost.getText(), adresse.getText(), postnr.getText(), velgpassord.getText());
        } else {
            velgpassord.setId("error");
            gjentapassord.setId("error");
            //pop opp melding hvis ordene ikke er like
        }
        return null;
    }

    public void regKunde() {
        if (fornavn.getId().equals("valid")
                && etternavn.getId().equals("valid")
                && personnr.getId().equals("valid")
                && telefon.getId().equals("valid")
                && epost.getId().equals("valid")
                && adresse.getId().equals("valid")
                && postnr.getId().equals("valid")
                && velgpassord.getId().equals("valid")
                && gjentapassord.getId().equals("valid")) {
            List<Kunde> list = kontroll.søkeResultater(fornavn.getText(),etternavn.getText() , "0");
            for (Kunde k : list) {
                if (k.getFornavn().equals(fornavn.getText()) && (k.getEtternavn().equals(etternavn.getText()))) {
                    info.setText("Denne brukeren eksisterer allerede");
                    info.setVisible(true);
                    return;
                }
            }
            kontroll.registrerBruker(this.getKunde());
            vindu.close();
            kontroll.infoSkjerm();
        } else {
            info.setText("Sjekk feil i feltene ovenfor");
            info.setVisible(true);
        }
    }


    /*
     public String getnyKunde(){
        
     return nyKunde;
     } 
    
     public String getFornavn(){
     return fornavn;
     } 
    
     public String getEtternavn(){
     return null;
     } 
    
     public String getPersonnr(){
     return null;
     } 
    
     public String getTelefon(){
     return null;
     } 
    
     public String getEpost(){
     return null;
     } 
    
     public String getAdresse(){
     return null;
     } 
    
     public String getVelgpassord(){
     return null;
     } 
    
     public String getGjentapassord(){
     return null;
     } 
     */
}//End of class
