package GUI;

import Forsikring.FritidsBolig;
import Kontroller.Kontroller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import static javafx.geometry.Pos.TOP_CENTER;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideFribolig {

    public static Pane friboligFane(Kontroller kontroller) {
        //Group root = new Group();
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

        //Bolig
        Label lbBolig = new Label();
        lbBolig.setText("Bolig innformasjon");
        lbBolig.setAlignment(Pos.CENTER);

        TextField tfPostnr = new TextField();
        tfPostnr.setPromptText("Postnummer");
        tfPostnr.setMinWidth(200);

        TextField tfAdresse = new TextField();
        tfAdresse.setPromptText("Adresse");
        tfAdresse.setMinWidth(200);

        TextField tfByggeår = new TextField();
        tfByggeår.setPromptText("Byggår");
        tfByggeår.setMinWidth(200);

        TextField tfKvadrat = new TextField();
        tfKvadrat.setPromptText("Kvadratmeter");
        tfKvadrat.setMinWidth(200);

        TextField tfByggSum = new TextField();
        tfByggSum.setPromptText("Bolig verdi");
        tfByggSum.setMinWidth(200);

        TextField tfInnboSum = new TextField();
        tfInnboSum.setPromptText("Innbo verdi");
        tfInnboSum.setMinWidth(200);

        ComboBox<String> cbEgenandel = new ComboBox<>();
        cbEgenandel.setEditable(false);
        cbEgenandel.setMinWidth(200);
        cbEgenandel.getItems().addAll(
                "Egenandel: 10 000,-",
                "Egenandel: 15 000,-",
                "Egenandel: 20 000,-"
        );
        cbEgenandel.setValue("Velg Egenandel:");

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

        ComboBox<String> cbMateriale = new ComboBox<>();
        cbMateriale.setEditable(false);
        cbMateriale.setMinWidth(200);
        cbMateriale.getItems().addAll(
                "Mur",
                "Tre",
                "Betong",
                "Leca",
                "Laft"
        );
        cbMateriale.setValue("Velg Byggmatriale:");

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
       

        grid.add(lbBolig, 0, 0);

        grid.add(tfPostnr, 0, 1);

        grid.add(tfAdresse, 0, 2);

        grid.add(tfByggeår, 0, 3);

        grid.add(tfKvadrat, 0, 4);

        grid.add(tfByggSum, 0, 5);

        grid.add(tfInnboSum, 0, 6);

        grid.add(cbEgenandel, 0, 7);
        grid.add(cbBoligtype, 0, 8);
        grid.add(cbStandard, 0, 9);
        grid.add(cbMateriale, 0, 10);

        grid.add(btnSjekkpris, 1, 13);
        grid.add(btnRegFriboligforsikring, 1, 14);

        grid.add(regLabel, 1, 15);

        borderPane.setCenter(grid); // CENTER
        
        // oppretter en forsikring som kan settes inn i registeret dersom de trykker kjøp rett
        // etter at de har sjekket prisen, hvis ikke forsvinner objektet.
        btnSjekkpris.setOnAction(e -> {
            String postNr = tfPostnr.getText();
            String adresse = tfAdresse.getText();
            String standard = cbStandard.getValue();
            String materiale = cbMateriale.getValue();
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
            regLabel.setText("Årlig premie: " + f.getPremie());
        });
        
        // oppretter og setter fritidsboligforsikring inn i registeret
        btnRegFriboligforsikring.setOnAction(e -> {
            String postNr = tfPostnr.getText();
            String adresse = tfAdresse.getText();
            String standard = cbStandard.getValue();
            String materiale = cbMateriale.getValue();
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
        

        kontroller.setFritidsForsikring(kvadrat, adresse, boligType, byggeÅr,materiale, standard, byggSum, innboSum);
        regLabel.setText("Boligforsikring registrert!");

    }
    );
    return borderPane ;
}
}
