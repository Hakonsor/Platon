package GUI;

import Kontroller.Kontroller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Magnus on 27.04.15.
 */
public class KonsulentsideKunde {

    public static Pane kundeFane(Kontroller kontroller) {

        //Group root = new Group();
        BorderPane borderPane = new BorderPane();

        //TOP---------------------------------->
        HBox vb = new HBox();
        vb.setPadding(new Insets(25, 25, 50, 25)); //top/right/bottom/left
        vb.setSpacing(70);
        vb.setAlignment(Pos.CENTER);

        TextField tfKundenavn = new TextField();
        tfKundenavn.setText("Ola Normann");
        tfKundenavn.setId("Kundenavn");
        tfKundenavn.setMinWidth(300);
        tfKundenavn.setEditable(false);

        Button btnSøk = new Button();
        btnSøk.setText("Søk");
        btnSøk.setId("søk");
        btnSøk.setMinWidth(100);
        btnSøk.setOnAction(e -> {
            kontroller.sok();
        });

        /*
        kontroll.registrerBruker(this.getKunde());
            vindu.close();
         */

        Button btnRegKunde = new Button();
        btnRegKunde.setText("Reg. kunde");
        btnRegKunde.setId("regKunde");
        btnRegKunde.setMinWidth(150);
        btnRegKunde.setOnAction(e -> {
            kontroller.regVindu();
        });

        vb.getChildren().addAll(tfKundenavn, btnSøk, btnRegKunde);

        borderPane.setTop(vb);

        //LEFT-------------------------------------->
        GridPane gridLeft = new GridPane();
        gridLeft.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridLeft.setVgap(10);
        gridLeft.setHgap(10);
        //gridLeft.setPrefHeight(50);
        //gridLeft.setPrefWidth(500);
        gridLeft.setAlignment(Pos.TOP_CENTER);

        ObservableList<String> navn = FXCollections.observableArrayList();
        ObservableList<String> data = FXCollections.observableArrayList();

        ComboBox<String> forsikringComboBox = new ComboBox<>();
        forsikringComboBox.setEditable(false);
        forsikringComboBox.getItems().addAll(
                "Båtforsikring",
                "Reiseforsikring",
                "Bilforsikring",
                "Boligforsikring",
                "Fri.Boligforsikring"
        );
        forsikringComboBox.setValue("Velg Forsikring:");
        forsikringComboBox.setOnAction(e -> {

            ArrayList<String> forsikringliste = kontroller.
                    getInfoForsikringListe(forsikringComboBox.getItems().
                            indexOf(forsikringComboBox.getValue()));
            if (forsikringliste == null) {
                navn.clear();
                navn.add("Ingen " + forsikringComboBox.getValue() + "er registrert");
            } else {
                navn.setAll(forsikringliste);
            }
        });

        ListView<String> listView = new ListView<>(data);
        listView.setPrefSize(300, 400);
        listView.setEditable(false);

        //navn.addAll("Honda CRV", "Ferrari Enzo", "VW Golf");
        data.addAll("Dobbel klikk for å velge:");

        listView.setItems(navn);
        listView.setCellFactory(ComboBoxListCell.forListView(navn));

        gridLeft.add(forsikringComboBox, 0, 0);
        gridLeft.add(listView, 0, 1);

        borderPane.setLeft(gridLeft);

        //RIGHT --------------------------------------------------------->>
        //Bil
        GridPane gridBil = new GridPane();
        gridBil.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridBil.setVgap(10);
        gridBil.setHgap(10);
        //gridBil.setPrefHeight(50);
        //gridBil.setPrefWidth(500);
        gridBil.setAlignment(Pos.CENTER);

        TextField tfRegnr = new TextField();
        tfRegnr.setPromptText("Reg.Nr");
        tfRegnr.setMinWidth(200);

        TextField tfÅrsmodell = new TextField();
        tfÅrsmodell.setPromptText("Årsmodell");
        tfÅrsmodell.setMinWidth(200);

        TextField tfBiltype = new TextField();
        tfBiltype.setPromptText("Biltype eks (BMW 3-serie)");
        tfBiltype.setMinWidth(200);

        TextField tfKmstand = new TextField();
        tfKmstand.setPromptText("Km-stand");
        tfKmstand.setMinWidth(200);

        ComboBox<String> cbKjørelengde = new ComboBox<>();
        cbKjørelengde.setEditable(false);
        cbKjørelengde.setMinWidth(200);
        cbKjørelengde.getItems().addAll(
                "Kjørelengde:  5 000 km",
                "Kjørelengde: 10 000 km",
                "Kjørelengde: 20 000 km",
                "Kjørelengde: 30 000 km",
                "Kjørelengde: Ubegrenset"
        );
        cbKjørelengde.setValue("Velg Kjørelengde:");

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

        gridBil.add(tfRegnr, 0, 0);
        gridBil.add(tfKmstand, 0, 1);
        gridBil.add(tfÅrsmodell, 0, 2);
        gridBil.add(tfBiltype, 0, 3);
        gridBil.add(cbKjørelengde, 0, 4);
        gridBil.add(cbBonus, 0, 5);
        gridBil.add(cbEgenandel, 0, 6);

        borderPane.setRight(gridBil);

        //Buttons ---------------------------------->
        GridPane gridButtons = new GridPane();
        gridButtons.setPadding(new Insets(100, 0, 0, 0)); //top/right/bottom/left
        gridButtons.setVgap(10);
        gridButtons.setHgap(10);
        //gridButtons.setPrefHeight(50);
        //gridButtons.setPrefWidth(1000);
        gridButtons.setAlignment(Pos.CENTER);

        Button btnSlett = new Button();
        btnSlett.setText("Slett");
        btnSlett.setOnAction(e -> {
            System.out.println("Du trykket på SLETT!");
        });

        Button btnRegForsikring = new Button();
        btnRegForsikring.setText("Reg. Forsikring");
        btnRegForsikring.setOnAction(e -> {
            System.out.println("RegForsikrings");
        });

        gridButtons.add(btnSlett, 0, 0);
        gridButtons.add(btnRegForsikring, 1, 0);

        GridPane gridRight = new GridPane();
        gridLeft.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridRight.add(gridBil, 0, 0);
        gridRight.add(gridButtons, 0, 1);
        gridRight.setAlignment(Pos.BOTTOM_CENTER);

        borderPane.setRight(gridRight);
        borderPane.setPadding(new Insets(10, 200, 200, 100)); //top/right/bottom/left

        gridButtons.setGridLinesVisible(false);
        gridLeft.setGridLinesVisible(false);
        gridBil.setGridLinesVisible(false);

        return borderPane;
    }

}
