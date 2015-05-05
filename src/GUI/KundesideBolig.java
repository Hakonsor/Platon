package GUI;

import Forsikring.BoligForsikring;
import Kontroller.Kontroller;
import java.text.DecimalFormat;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import static javafx.geometry.Pos.TOP_CENTER;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideBolig {

    public static Pane boligFane(Kontroller kontroller) {
        //Group root = new Group();
        BorderPane borderPane = new BorderPane();
        HBox vb = new HBox();
        vb.setPadding(new Insets(25, 25, 25, 25));
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);

        Label overskrift = new Label();
        overskrift.setText("Boligforsikring\nSørg for å ha nødvendig økonomisk støtte dersom noe skulle skje med huset ditt.");
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
        lbBolig.setText("Informasjon om din bolig");
        lbBolig.setAlignment(Pos.CENTER);

        TextField tfPostnr = new TextField();
        tfPostnr.setPromptText("Postnummer");
        tfPostnr.setMinWidth(200);

        TextField tfAdresse = new TextField();
        tfAdresse.setPromptText("Adresse");
        tfAdresse.setMinWidth(200);

        TextField tfByggeår = new TextField();
        tfByggeår.setPromptText("Byggeår");
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
        cbStandard.setValue("Standard:");

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
        cbMateriale.setValue("Byggematriale:");

        //Registrer knapp & Label
        Label regLabel = new Label();
        regLabel.setText("");
        regLabel.setId("regLabel");
        regLabel.setAlignment(Pos.CENTER);

        Button btnSjekkpris = new Button();
        btnSjekkpris.setText("Beregn pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMinWidth(200);

        Button btnRegBoligforsikring = new Button();
        btnRegBoligforsikring.setText("Registrer Boligforsikring");
        btnRegBoligforsikring.setId("btnRegBoligforsikring");
        btnRegBoligforsikring.setMinWidth(200);

        grid.add(lbBolig, 0, 0);

        grid.add(tfPostnr, 0, 1);

        grid.add(tfAdresse, 0, 2);

        grid.add(tfByggeår, 0, 3);

        grid.add(tfKvadrat, 0, 4);

        grid.add(tfByggSum, 0, 5);

        grid.add(tfInnboSum, 0, 6);

        grid.add(cbBoligtype, 0, 7);
        grid.add(cbStandard, 0, 8);
        grid.add(cbMateriale, 0, 9);

        grid.add(btnSjekkpris, 1, 13);
        grid.add(btnRegBoligforsikring, 1, 14);

        grid.add(regLabel, 1, 15);

        borderPane.setCenter(grid); // CENTER
        
        //Oppretter en forsikring, slik at man kan sjekke pris. Objektet lagres ikke,
        //men hvis man trykker på kjøp rett etter vil det opprettes et nytt objekt som lagres
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
         BoligForsikring f = new BoligForsikring(kvadrat,adresse,boligType,byggeÅr,
                  materiale, standard, byggSum,innboSum);
           String form = "0.00";
            DecimalFormat tall = new DecimalFormat(form);
            regLabel.setText("Årlig premie: " + tall.format(f.getPremie()) + " kr" );
        });
        //registrerer boligforsikring og setter sen inn i forsikringsregisteret.
        btnRegBoligforsikring.setOnAction(e -> {
            String postNr = tfPostnr.getText();
            String adresse = tfAdresse.getText();
            String byggeÅr = tfByggeår.getText();
            String standard = cbStandard.getValue();
            String materiale = cbMateriale.getValue();
            String boligType = cbBoligtype.getValue();
            double kvadrat = 0;
            double byggSum = 0;
            double innboSum = 0;
            int byggeår = 0;

            try {
                kvadrat = Double.parseDouble(tfKvadrat.getText());
                byggSum = Double.parseDouble(tfByggSum.getText());
                innboSum = Double.parseDouble(tfInnboSum.getText());
                byggeår = Integer.parseInt(tfKvadrat.getText());
            } catch (NumberFormatException nfe) {
                System.out.println("Feil tallformat.");
            }

            kontroller.setBoligForsikring(kvadrat, adresse, boligType, byggeår, materiale, standard, byggSum, innboSum);
            regLabel.setText("Boligforsikring registrert!");

        });
        return borderPane;
    }
}
