package GUI;

import Kontroller.Kontroller;
import javafx.geometry.HPos;
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
public class KundesideBåt {

    public static Pane båtFane(Kontroller kontroll) {

        //Group root = new Group();
        BorderPane borderPane = new BorderPane();
        HBox vb = new HBox();
        vb.setPadding(new Insets(25, 25, 0, 25));
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);

        Label overskrift = new Label();
        overskrift.setText("Her registrerer du båtforsikring");
        overskrift.setId("overskrift");
        vb.getChildren().addAll(overskrift);

        borderPane.setTop(vb); //TOP


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BOTTOM_CENTER);
        grid.setHgap(10);

        grid.setVgap(10);
        grid.setPadding(new Insets(100));

        grid.setPrefHeight(50);
        grid.setPrefWidth(800);


        //Person

        Label lbPerson = new Label();
        lbPerson.setText("Bileier innformasjon");
        lbPerson.setAlignment(Pos.CENTER);

        TextField tfFornavn = new TextField();
        tfFornavn.setPromptText("Fornavn");
        tfFornavn.setMinWidth(200);

        TextField tfEtternavn = new TextField();
        tfEtternavn.setPromptText("Etternavn");
        tfEtternavn.setMinWidth(200);

        TextField tfPersonnr = new TextField();
        tfPersonnr.setPromptText("PersonNr");
        tfPersonnr.setMinWidth(200);

        TextField tfAdresse = new TextField();
        tfAdresse.setPromptText("Adresse");
        tfAdresse.setMinWidth(200);

        TextField tfPostnr = new TextField();
        tfPostnr.setPromptText("PostNr");
        tfPostnr.setMinWidth(200);

        TextField tfTelefon = new TextField();
        tfTelefon.setPromptText("Telefon");
        tfTelefon.setMinWidth(200);


        //Båt

        Label lbBåt = new Label();
        lbBåt.setText("Båt innformasjon");
        lbBåt.setAlignment(Pos.CENTER);

        TextField tfRegnr = new TextField();
        tfRegnr.setPromptText("Reg.Nr");
        tfRegnr.setMinWidth(200);

        TextField tfÅrsmodell = new TextField();
        tfÅrsmodell.setPromptText("Årsmodell");
        tfÅrsmodell.setMinWidth(200);

        TextField tfBåtmodell = new TextField();
        tfBåtmodell.setPromptText("Båtmodell eks (Ibiza 22");
        tfBåtmodell.setMinWidth(200);

        TextField tfAntfor = new TextField();
        tfAntfor.setPromptText("Antall fot");
        tfAntfor.setMinWidth(200);

        TextField tfMotormerke = new TextField();
        tfMotormerke.setPromptText("Motormerke");
        tfMotormerke.setMinWidth(200);

        ToggleGroup båtType = new ToggleGroup();

        RadioButton rbtSeilbåt = new RadioButton("Seilbåt");
        rbtSeilbåt.setToggleGroup(båtType);
        rbtSeilbåt.setSelected(true);
        rbtSeilbåt.setOnAction(e -> {
            System.out.println("Du har valgt Seilbåt! =D");
        });

        RadioButton rbtYacht = new RadioButton("Yacht");
        rbtYacht.setToggleGroup(båtType);
        rbtYacht.setSelected(true);
        rbtYacht.setOnAction(e -> {
            System.out.println("Du har valgt en Yacht! WoHo!");
        });

        RadioButton rbtSnekke = new RadioButton("Snekke");
        rbtSnekke.setToggleGroup(båtType);
        rbtSnekke.setSelected(true);
        rbtSnekke.setOnAction(e -> {
            System.out.println("Du har valgt en gammel lekker snekke =)");
        });

        RadioButton rbtDaycruiser = new RadioButton("Daycruiser");
        rbtDaycruiser.setToggleGroup(båtType);
        rbtDaycruiser.setSelected(true);
        rbtDaycruiser.setOnAction(e -> {
            System.out.println("Du har valgt en Daycruiser =D");
        });

        RadioButton rbtCabincruiser = new RadioButton("Cabincruiser");
        rbtCabincruiser.setToggleGroup(båtType);
        rbtCabincruiser.setSelected(true);
        rbtCabincruiser.setOnAction(e -> {
            System.out.println("Du har valgt en Cabincruiser RichBitch!");
        });

        RadioButton rbtAndre = new RadioButton("Andre");
        rbtAndre.setToggleGroup(båtType);
        rbtAndre.setSelected(true);
        rbtAndre.setOnAction(e -> {
            System.out.println("Du har valgt en annen type båt en det vi har listet, dette går bra =D");
        });

        ComboBox<String> cbBonus = new ComboBox<>();
        cbBonus.setEditable(false);
        cbBonus.setMinWidth(200);
        cbBonus.getItems().addAll(
                "Bonus: -20%",
                "Bonus: -10%",
                "Bonus: 0%",
                "Bonus: 10%",
                "Bonus: 20%",
                "Bonus: 30%",
                "Bonus: 40%",
                "Bonus: 50%",
                "Bonus: 60%",
                "Bonus: 70%",
                "Bonus: 75%"
        );
        cbBonus.setValue("Velg Bonus:");

        ComboBox<String> cbEgenandel = new ComboBox<>();
        cbEgenandel.setEditable(false);
        cbEgenandel.setMinWidth(200);
        cbEgenandel.getItems().addAll(
                "Egenandel:  4 000,-",
                "Egenandel:  6 000,-",
                "Egenandel: 10 000,-"
        );
        cbEgenandel.setValue("Velg Egenandel:");

        //Registrer knapp & Label

        Label regLabel = new Label();
        regLabel.setText("");
        regLabel.setId("regLabel");
        regLabel.setAlignment(Pos.CENTER);

        Button btnSjekkpris = new Button();
        btnSjekkpris.setText("Sjekk Pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMinWidth(200);
        btnSjekkpris.setOnAction(e -> {
            regLabel.setText("Prisen er: " + "getPris()");
        });

        Button btnRegBilforsikring = new Button();
        btnRegBilforsikring.setText("Registrer Bilforsikring");
        btnRegBilforsikring.setId("btnRegBilforsikring");
        btnRegBilforsikring.setMinWidth(200);
        btnRegBilforsikring.setOnAction(e -> {
            regLabel.setText("Bilforsikring Registrert!");
        });

        grid.add(lbBåt, 0, 0);
        grid.add(lbPerson, 2, 0);

        grid.add(tfRegnr, 0, 1);
        grid.add(tfFornavn, 2, 1);

        grid.add(tfÅrsmodell, 0, 2);
        grid.add(tfEtternavn, 2, 2);

        grid.add(tfBåtmodell, 0, 3);
        grid.add(tfPersonnr, 2, 3);

        grid.add(tfAntfor, 0, 4);
        grid.add(tfTelefon, 2, 4);

        grid.add(tfMotormerke, 0, 5);
        grid.add(tfAdresse, 2, 5);

        grid.add(cbEgenandel, 0, 6);
        grid.add(tfPostnr, 2, 6);

        grid.add(cbBonus, 0, 7);

        grid.add(rbtCabincruiser, 1, 1);
        grid.add(rbtDaycruiser, 1, 2);
        grid.add(rbtSeilbåt, 1, 3);
        grid.add(rbtSnekke, 1, 4);
        grid.add(rbtYacht, 1, 5);
        grid.add(rbtAndre, 1, 6);


        grid.add(btnSjekkpris, 1, 13);
        grid.add(btnRegBilforsikring, 1, 14);

        grid.add(regLabel, 1, 15);




        borderPane.setCenter(grid); // CENTER

        return borderPane;
    }
}