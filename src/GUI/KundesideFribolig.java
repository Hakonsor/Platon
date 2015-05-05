package GUI;

import Forsikring.FritidsBolig;
import Kontroller.Kontroller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import Kontroller.Postregister;
import java.text.DecimalFormat;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideFribolig {

    String leie;

    public Pane friboligFane(Kontroller kontroller) {

        BorderPane borderPane = new BorderPane();
        HBox vb = new HBox();
        vb.setPadding(new Insets(25, 25, 25, 25));
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);

        Label overskrift = new Label();
        overskrift.setText("Her registrerer du fritidsboligforsikring");
        overskrift.setId("overskrift");
        vb.getChildren().addAll(overskrift);

        borderPane.setTop(vb); //TOP

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        grid.setPrefHeight(50);
        grid.setPrefWidth(800);

        //FritidsBolig
        Label lbBolig = new Label();
        lbBolig.setText("Informasjon om din fritidsbolig");
        lbBolig.setAlignment(Pos.CENTER);

        TextField tfAdresse = new TextField();
        tfAdresse.setPromptText("Adresse");
        tfAdresse.setId("promtfix");
        tfAdresse.setMinWidth(200);

        TextField tfByggeår = new TextField();
        tfByggeår.setPromptText("Byggeår");
        tfByggeår.setId("promtfix");
        tfByggeår.setMinWidth(200);

        TextField tfKvadrat = new TextField();
        tfKvadrat.setPromptText("Kvadratmeter");
        tfKvadrat.setId("promtfix");
        tfKvadrat.setMinWidth(200);

        TextField tfByggSum = new TextField();
        tfByggSum.setPromptText("Bolig verdi");
        tfByggSum.setId("promtfix");
        tfByggSum.setMinWidth(200);

        TextField tfInnboSum = new TextField();
        tfInnboSum.setPromptText("Innbo verdi");
        tfInnboSum.setId("promtfix");
        tfInnboSum.setMinWidth(200);

        TextField tfPostnr = new TextField();
        tfPostnr.setPromptText("PostNr");
        tfPostnr.setId("promtfix");
        tfPostnr.setMinWidth(200);

        TextField postSted = new TextField();
        postSted.setPromptText("PostSted");
        postSted.setId("promtfix");
        postSted.setEditable(false);
        postSted.setMinWidth(200);


        ComboBox<String> cbBoligtype = new ComboBox<>();
        cbBoligtype.setEditable(false);
        cbBoligtype.setMinWidth(200);
        cbBoligtype.getItems().addAll(
                "Enebolig",
                "Tomannsbolig",
                "Leilighet",
                "Rekkehus"
        );
        cbBoligtype.setValue("Velg Boligtype:");

        ComboBox<String> cbStandard = new ComboBox<>();
        cbStandard.setEditable(false);
        cbStandard.setMinWidth(200);
        cbStandard.getItems().addAll(
                "Dårlig",
                "Gjennomsnittlig",
                "Over gjennomsnitt",
                "Svært Høy"
        );
        cbStandard.setValue("Velg Standard:");

        ComboBox<String> cbMatriale = new ComboBox<>();
        cbMatriale.setEditable(false);
        cbMatriale.setMinWidth(200);
        cbMatriale.getItems().addAll(
                "Mur",
                "Tre",
                "Betong",
                "Leca",
                "Laft"
        );
        cbMatriale.setValue("Velg Byggmatriale:");

        CheckBox cbleie = new CheckBox("Merk om du har utleiemulighet");
        cbleie.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (cbleie.isSelected() == true) {
                leie = "Ja";
                System.out.println("Ja");
            } else {
                leie = "Nei";
                System.out.println("Nei");
            }
        });

        //Registrer knapp & Label
        Label regLabel = new Label();
        regLabel.setText("");
        regLabel.setId("regLabel");
        regLabel.setAlignment(Pos.CENTER);

        Button btnSjekkpris = new Button();
        btnSjekkpris.setText("Sjekk Pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMinWidth(200);
       
        Button btnRegFriboligforsikring = new Button();
        btnRegFriboligforsikring.setText("Registrer Fritidsboligforsikring");
        btnRegFriboligforsikring.setId("btnRegFriboligforsikring");
        btnRegFriboligforsikring.setMinWidth(200);

        tfPostnr.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Postregister register = new Postregister();
                String poststed = register.getPoststed(tfPostnr.getText());
                if (poststed == null) {
                    poststed = "Finnes ikke!";
                }
                if (tfPostnr.getText().equals("")) {
                    postSted.setText("");
                    postSted.setPromptText("PostSted");
                } else
                    postSted.setText(poststed);
            }
        });

        grid.add(lbBolig, 0, 0);
        grid.add(tfAdresse, 0, 1);
        grid.add(tfPostnr, 0, 2);
        grid.add(postSted, 0, 3);
        grid.add(tfByggeår, 0, 4);
        grid.add(tfKvadrat, 0, 5);
        grid.add(tfByggSum, 0, 6);
        grid.add(tfInnboSum, 0, 7);
        grid.add(cbBoligtype, 0, 8);
        grid.add(cbStandard, 0, 9);
        grid.add(cbMatriale, 0, 10);
        grid.add(cbleie, 0, 11);
        grid.add(btnSjekkpris, 0, 12);
        grid.add(btnRegFriboligforsikring, 0, 13);
        grid.add(regLabel, 0, 14);

        borderPane.setCenter(grid); // CENTER


        borderPane.setCenter(grid); // CENTER
        
        // oppretter en forsikring som kan settes inn i registeret dersom de trykker kjøp rett
        // etter at de har sjekket prisen, hvis ikke forsvinner objektet.
        btnSjekkpris.setOnAction(e -> {
            String form = "0.00";
            DecimalFormat tall = new DecimalFormat(form);
            String postNr = tfPostnr.getText();
            String adresse = tfAdresse.getText();
            String standard = cbStandard.getValue();
            String materiale = cbMatriale.getValue();
            String boligType = cbBoligtype.getValue();
            int byggeÅr = 0;
            double kvadrat = 0;
            double byggSum = 0;
            double innboSum= 0;
        try {
            kvadrat = Double.parseDouble(tfKvadrat.getText());
            byggSum = Double.parseDouble(tfByggSum.getText());
            innboSum = Double.parseDouble(tfInnboSum.getText());
            byggeÅr = Integer.parseInt(tfByggeår.getText());
        } catch (NumberFormatException nfe) {
            System.out.println("Feil tallformat.");
        }
         FritidsBolig f = new FritidsBolig(false,
         kvadrat,adresse, boligType,byggeÅr,
         materiale, standard, byggSum,innboSum);
        regLabel.setText("Årlig premie: " + tall.format(f.getPremie()) + " kr");
        });
        
        // oppretter og setter fritidsboligforsikring inn i registeret
        btnRegFriboligforsikring.setOnAction(e -> {
            String postNr = tfPostnr.getText();
            String adresse = tfAdresse.getText();
            String standard = cbStandard.getValue();
            String materiale = cbMatriale.getValue();
            String boligType = cbBoligtype.getValue();
            int byggeÅr = 0;
            double kvadrat = 0;
            double byggSum = 0;
            double innboSum= 0;
        try {
            kvadrat = Double.parseDouble(tfKvadrat.getText());
            byggSum = Double.parseDouble(tfByggSum.getText());
            innboSum = Double.parseDouble(tfInnboSum.getText());
            byggeÅr = Integer.parseInt(tfByggeår.getText());
        } catch (NumberFormatException nfe) {
            System.out.println("Feil tallformat.");
        }

        kontroller.setFritidsForsikring(kvadrat, adresse, "hei", byggeÅr, "tre", "dårlig", byggSum, innboSum);
        regLabel.setText("Boligforsikring registrert!");

        });


        borderPane.getStylesheets().add("CSS/kundefritidsbolig.css");
        return borderPane;
    }
}
