package GUI;

import Kontroller.Kontroller;
import Person.Bruker;
import Person.Konsulent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import static javafx.geometry.Pos.TOP_CENTER;

/**
 * Created by Magnus on 28.04.15.
 */
public class RegKonsulent {

    private final String LoginBilde = "Bilder/add_user.png";
    private final Button btnRegKonsulent;
    private final Label nyKonsulent;
    private final Label info;
    private final TextField fornavn;
    private final TextField etternavn;
    private final TextField brukernavn;
    private final PasswordField velgpassord;
    private final PasswordField gjentapassord;
    private static Stage vindu;


    public Button getBtnRegKonsulent(){
        return btnRegKonsulent;
    }
    public Konsulent getKonsulent(){
        if(velgpassord.getText().equals(gjentapassord.getText())){
            return new Konsulent(brukernavn.getText(), velgpassord.getText(), fornavn.getText(), etternavn.getText());
        } else {
            System.out.println("feilpassord");
            //pop opp melding hvis ordene ikke er like
        }
        return null;
    }

    public RegKonsulent(Stage vindu, Kontroller kontroll)  {
        this.vindu = vindu;

        GridPane grid = new GridPane();
        grid.setAlignment(TOP_CENTER);
        //grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(40));

        ImageView loginImg = new ImageView(new Image(LoginBilde));
        loginImg.setId("loginImg");
        loginImg.setPreserveRatio(true);
        loginImg.setFitWidth(100);
        GridPane.setHalignment(loginImg, HPos.CENTER);

        nyKonsulent = new Label();
        nyKonsulent.setText("Ny Konsulent");
        nyKonsulent.setId("nykunde");
        GridPane.setHalignment(nyKonsulent, HPos.CENTER);

        fornavn = new TextField();
        fornavn.setPromptText("Fornavn");
        fornavn.setId("fornavn");
        fornavn.setMaxWidth(200);
        GridPane.setHalignment(fornavn, HPos.CENTER);
        fornavn.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
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
            }
        });

        etternavn = new TextField();
        etternavn.setPromptText("Etternavn");
        etternavn.setId("etternavn");
        etternavn.setMaxWidth(200);
        GridPane.setHalignment(etternavn, HPos.CENTER);
        etternavn.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
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
            }
        });

        brukernavn = new TextField();
        brukernavn.setPromptText("Velg Brukernavn");
        brukernavn.setId("brukernavn");
        brukernavn.setMaxWidth(200);
        GridPane.setHalignment(brukernavn, HPos.CENTER);
        brukernavn.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String regex = "[äÄöÖüÜëËÆØÅæøåA-Za-z]+";
                String Brukernavn = brukernavn.getText();

                if (Brukernavn.matches(regex)) {
                    brukernavn.setId("valid");
                } else {
                    brukernavn.setId("error");
                }
                if (Brukernavn.length() == 0) {
                    brukernavn.setId("promtfix");
                }
            }
        });

        velgpassord = new PasswordField();
        velgpassord.setPromptText("Velg Passord");
        velgpassord.setId("velgpassord");
        velgpassord.setMaxWidth(200);
        GridPane.setHalignment(velgpassord, HPos.CENTER);

        gjentapassord = new PasswordField();
        gjentapassord.setPromptText("Gjenta Passord");
        gjentapassord.setId("gjentapassord");
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

        btnRegKonsulent = new Button("Registrer Konsulent");
        btnRegKonsulent.setId("btNyKunde");
        btnRegKonsulent.setMaxWidth(200);
        btnRegKonsulent.setOnAction(e -> {
            if (fornavn.getId().equals("valid")
                    && etternavn.getId().equals("valid")
                    && brukernavn.getId().equals("valid")
                    && velgpassord.getId().equals("valid")
                    && gjentapassord.getId().equals("valid")
                    ) {
                kontroll.registrerBruker(this.getKonsulent());
                vindu.close();
            } else {
                info.setText("Sjekk feil i feltene ovenfor");
                info.setVisible(true);
            }
        });


        GridPane.setHalignment(btnRegKonsulent, HPos.CENTER);

        grid.add(loginImg, 0, 0);
        grid.add(nyKonsulent,0 ,1);
        grid.add(fornavn, 0, 2);
        grid.add(etternavn, 0, 3);
        grid.add(brukernavn,0, 4);
        grid.add(velgpassord, 0, 5);
        grid.add(gjentapassord, 0, 6);
        grid.add(btnRegKonsulent, 0, 8);
        grid.add(info, 0, 9);


        Scene scene = new Scene(grid, 300, 500);
        vindu.setTitle("Registrer");
        vindu.setScene(scene);
        scene.getStylesheets().add("CSS/nykunde.css");
        vindu.show();
    }

}
