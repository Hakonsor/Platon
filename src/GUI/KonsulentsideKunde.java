package GUI;

import Forsikring.BilForsikring;
import Kontroller.Kontroller;
import Kontroller.ComboBoxConverter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import Forsikring.Forsikringer;
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
public class KonsulentsideKunde implements ComboBoxConverter{

    public static TextField tfKundenavn = new TextField();

    String type;
    String leie;

    public Pane kundeFane(Kontroller kontroll) {

        //Group root = new Group();
        BorderPane borderPane = new BorderPane();

        //TOP---------------------------------->
        HBox vb = new HBox();
        vb.setPadding(new Insets(25, 25, 50, 25)); //top/right/bottom/left
        vb.setSpacing(70);
        vb.setAlignment(Pos.CENTER);

        tfKundenavn.setText("");
        tfKundenavn.setId("Kundenavn");
        tfKundenavn.setMinWidth(300);
        tfKundenavn.setEditable(false);

        Button btnSøk = new Button();
        btnSøk.setText("Søk");
        btnSøk.setId("søk");
        btnSøk.setMinWidth(100);
        btnSøk.setOnAction(e -> {
            kontroll.sok();
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
            kontroll.regVindu();
        });

        vb.getChildren().addAll(tfKundenavn, btnSøk, btnRegKunde);

        borderPane.setTop(vb);

        //LEFT-------------------------------------->
        GridPane gridLeft = new GridPane();
        gridLeft.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridLeft.setVgap(10);
        gridLeft.setHgap(10);
        gridLeft.setAlignment(Pos.TOP_CENTER);

        ObservableList<String> navn = FXCollections.observableArrayList();
        ObservableList<String> data = FXCollections.observableArrayList();

        ComboBox<String> forsikringComboBox = new ComboBox<>();
        forsikringComboBox.setEditable(false);
        forsikringComboBox.getItems().addAll(
                "Alle",
                "Båtforsikring",
                "Reiseforsikring",
                "Bilforsikring",
                "Boligforsikring",
                "Fri.Boligforsikring"
        );

        // Forskjellige forsikringer vises
        GridPane gridBil = new GridPane();
        gridBil.setVisible(false);

        GridPane gridReise = new GridPane();
        gridReise.setVisible(false);

        GridPane gridBåt = new GridPane();
        gridBåt.setVisible(false);

        GridPane gridBolig = new GridPane();
        gridBolig.setVisible(false);

        GridPane gridFriBolig = new GridPane();
        gridFriBolig.setVisible(false);

        GridPane gridAlle = new GridPane();
        gridAlle.setVisible(false);

        forsikringComboBox.setValue("Velg Forsikring:");
        forsikringComboBox.setOnAction(e -> {

            ArrayList<String> forsikringliste = kontroll.getInfoForsikringListe(forsikringComboBox.getItems().indexOf(forsikringComboBox.getValue()));
            if (forsikringComboBox.getValue().equals("Bilforsikring")) {
                gridBil.setVisible(true);
            } else gridBil.setVisible(false);

            if (forsikringComboBox.getValue().equals("Reiseforsikring")) {
                gridReise.setVisible(true);
            } else gridReise.setVisible(false);

            if (forsikringComboBox.getValue().equals("Båtforsikring")) {
                gridBåt.setVisible(true);
            } else gridBåt.setVisible(false);

            if (forsikringComboBox.getValue().equals("Boligforsikring")) {
                gridBolig.setVisible(true);
            } else gridBolig.setVisible(false);

            if (forsikringComboBox.getValue().equals("Fri.Boligforsikring")) {
                gridFriBolig.setVisible(true);
            } else gridFriBolig.setVisible(false);

            if (forsikringComboBox.getValue().equals("Alle")) {
                gridAlle.setVisible(true);
            } else gridAlle.setVisible(false);


            if (forsikringliste == null) {
                navn.clear();
                navn.add("Ingen " + forsikringComboBox.getValue() + "er registrert");
            }
            else {
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

        /*

        listView.setItems(navn);
        listView.setCellFactory(ComboBoxListCell.forListView(navn));

        TextArea textArea = new TextArea();
        //listView.setOnMouseClicked(e -> { visElemnt();   });
        listView.getSelectionModel().selectedItemProperty().addListener(e -> {

            Forsikringer s = kontroller.getForsikring(Integer.parseInt(listView.getSelectionModel().getSelectedItem()));
            if (s != null) {
                textArea.setText(s.toString());
            }

        });
         */


        gridLeft.add(forsikringComboBox, 0, 0);
        gridLeft.add(listView, 0, 1);

        borderPane.setLeft(gridLeft);

        //RIGHT --------------------------------------------------------->>

        //Bil
        gridBil.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridBil.setVgap(10);
        gridBil.setHgap(10);
        gridBil.setAlignment(Pos.CENTER);

        Label regLabelBil = new Label();
        regLabelBil.setText("");

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

        Button btnSjekkprisBil = new Button();
        btnSjekkprisBil.setText("Beregn Pris");
        btnSjekkprisBil.setId("btnSjekkpris");
        btnSjekkprisBil.setMinWidth(200);
        btnSjekkprisBil.setOnAction(e -> {
            regLabelBil.setText("Prisen er: " + "getPris()");
        });

        Button btnRegBilforsikring = new Button();
        btnRegBilforsikring.setText("Registrer Bilforsikring");
        btnRegBilforsikring.setId("btnRegBilforsikring");
        btnRegBilforsikring.setMinWidth(200);
        btnRegBilforsikring.setOnAction(e -> {
            double bonus = 0;
            double egenandel = 0;
            int kjøreLengde = 0;
            String regNo = tfRegnr.getText();
            String årsModell = tfÅrsmodell.getText();
            String bilType = tfBiltype.getText();
            int kmStand = 0;
            try {
                bonus = convertDou(cbBonus.getValue());
                egenandel = convertDou(cbEgenandel.getValue());
                kjøreLengde = convertInt(cbKjørelengde.getValue());
                kmStand = Integer.parseInt(tfKmstand.getText());

            } catch (NumberFormatException nfe) {
                System.out.println("Feil tallformat");
            }
            BilForsikring bil = new BilForsikring(bonus, egenandel, kjøreLengde, regNo, årsModell, bilType, kmStand);
            kontroll.setBilForsikring(bil, null);
            regLabelBil.setText("Bilforsikring Registrert!");
        });

        gridBil.add(tfRegnr, 0, 0);
        gridBil.add(tfKmstand, 0, 1);
        gridBil.add(tfÅrsmodell, 0, 2);
        gridBil.add(tfBiltype, 0, 3);
        gridBil.add(cbKjørelengde, 0, 4);
        gridBil.add(cbBonus, 0, 5);
        gridBil.add(cbEgenandel, 0, 6);
        gridBil.add(btnSjekkprisBil, 0, 7);
        gridBil.add(btnRegBilforsikring,0,8);
        gridBil.add(regLabelBil, 0, 9);


        //Reise

        Label lbInfo = new Label();
        lbInfo.setText("Velg reiseforsikringstype:");
        lbInfo.setId("lbInfo");
        lbInfo.setAlignment(Pos.CENTER_LEFT);

        Label lbPrint = new Label();
        lbPrint.setId("print");
        lbPrint.setText("");
        lbPrint.setAlignment(Pos.CENTER_LEFT);

        ToggleGroup reise = new ToggleGroup();

        RadioButton rbtnVerden = new RadioButton("Veden");
        rbtnVerden.setId("verden");
        rbtnVerden.setToggleGroup(reise);
        rbtnVerden.setSelected(true);
        rbtnVerden.setAlignment(Pos.CENTER_LEFT);
        rbtnVerden.setOnAction(e -> {
            type = "Verden";
        });

        RadioButton rbtnEuropa = new RadioButton("Europa");
        rbtnEuropa.setId("europa");
        rbtnEuropa.setToggleGroup(reise);
        rbtnEuropa.setSelected(true);
        rbtnEuropa.setOnAction(e -> {
            type = "Europa";
        });

        RadioButton rbtnNorden = new RadioButton("Norden");
        rbtnNorden.setId("norden");
        rbtnNorden.setToggleGroup(reise);
        rbtnNorden.setSelected(true);
        rbtnNorden.setOnAction(e -> {
            type = "Norden";
        });

        Button btnBeregn = new Button();
        btnBeregn.setText("Beregn pris");
        btnBeregn.setMinWidth(100);
        btnBeregn.setId("beregn");
        btnBeregn.setOnAction(e -> {
            lbPrint.setText("Prisen er: getPris()");
        });

        Button btnBestill = new Button();
        btnBestill.setText("Bestill");
        btnBestill.setMinWidth(100);
        btnBestill.setId("bestill");
        btnBestill.setOnAction(eBestill -> {
            lbPrint.setText("Reiseforsikring bestilt!");
        });

        gridReise.add(lbInfo, 0, 0);
        gridReise.add(rbtnVerden, 0, 1);
        gridReise.add(rbtnEuropa, 0, 2);
        gridReise.add(rbtnNorden, 0, 3);
        gridReise.add(btnBeregn, 0, 4);
        gridReise.add(btnBestill, 0, 5);
        gridReise.add(lbPrint,0,6);

        gridReise.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridReise.setVgap(20);
        gridReise.setHgap(10);
        gridReise.setAlignment(Pos.CENTER);
        gridReise.setGridLinesVisible(false);


        //Båt
        gridBåt.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridBåt.setVgap(10);
        gridBåt.setHgap(10);
        gridBåt.setAlignment(Pos.CENTER);


        Label lbbåt = new Label("Test tekst, du har vlagt Båt");
        gridBåt.add(lbbåt, 0, 0);

        //Båt
        TextField tfRegnrB = new TextField();
        tfRegnrB.setPromptText("Reg.Nr");
        tfRegnrB.setMinWidth(200);

        TextField tfÅrsmodellB = new TextField();
        tfÅrsmodellB.setPromptText("Årsmodell");
        tfÅrsmodellB.setMinWidth(200);

        TextField tfBåtmodell = new TextField();
        tfBåtmodell.setPromptText("Båtmodell eks (Ibiza 22");
        tfBåtmodell.setMinWidth(200);

        TextField tfAntfor = new TextField();
        tfAntfor.setPromptText("Antall fot");
        tfAntfor.setMinWidth(200);

        TextField tfMotormerke = new TextField();
        tfMotormerke.setPromptText("Motormerke");
        tfMotormerke.setMinWidth(200);

        TextField tfYtelse = new TextField();
        tfYtelse.setPromptText("Ytelse (hk)");
        tfYtelse.setMinWidth(200);

        ToggleGroup båtType = new ToggleGroup();

        RadioButton rbtSeilbåt = new RadioButton("Seilbåt");
        rbtSeilbåt.setToggleGroup(båtType);
        rbtSeilbåt.setSelected(true);
        rbtSeilbåt.setOnAction(e -> {
            type = "Seilbåt";
        });

        RadioButton rbtMotorbåt = new RadioButton("Motorbåt");
        rbtMotorbåt.setToggleGroup(båtType);
        rbtMotorbåt.setSelected(true);
        rbtMotorbåt.setOnAction(e -> {
            type = "Motorbåt";
        });



        ComboBox<String> cbBonusB = new ComboBox<>();
        cbBonusB.setEditable(false);
        cbBonusB.setMinWidth(200);
        cbBonusB.getItems().addAll(
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
        cbBonusB.setValue("Velg Bonus:");

        ComboBox<String> cbEgenandelB = new ComboBox<>();
        cbEgenandelB.setEditable(false);
        cbEgenandelB.setMinWidth(200);
        cbEgenandelB.getItems().addAll(
                "Egenandel:  4 000,-",
                "Egenandel:  6 000,-",
                "Egenandel: 10 000,-"
        );
        cbEgenandelB.setValue("Velg Egenandel:");

        //Registrer knapp & Label

        Label regLabelB = new Label();
        regLabelB.setText("");
        regLabelB.setId("regLabel");
        regLabelB.setAlignment(Pos.CENTER);


        Button btnSjekkprisB = new Button();
        btnSjekkprisB.setText("Sjekk Pris");
        btnSjekkprisB.setId("btnSjekkpris");
        btnSjekkprisB.setMinWidth(200);
        btnSjekkprisB.setOnAction(e -> {
            regLabelB.setText("Prisen er: " + "getPris()");
        });

        Button btnRegBåtforsikring = new Button();
        btnRegBåtforsikring.setText("Registrer Båtforsikring");
        btnRegBåtforsikring.setId("btnRegBåtforsikring");
        btnRegBåtforsikring.setMinWidth(200);
        btnRegBåtforsikring.setOnAction(e -> {
            regLabelB.setText("Båtforsikring Registrert!");

            int effekt = 0;

            try {
                effekt = Integer.parseInt(tfYtelse.getText());
            } catch (NumberFormatException nfe) {
                System.out.println("Dette er en feilmelding opprettet i KundesideBåt.java\n" +
                        "En feil ved parsing av motoreffekt fra string til tall har oppstått\n" + nfe.toString());
            }

            kontroll.setBåtForsikring(convertDou(cbBonus.getValue()), convertDou(cbEgenandel.getValue()), tfRegnr.getText(), tfÅrsmodell.getText(), tfBåtmodell.getText(), tfAntfor.getText(), tfMotormerke.getText(), effekt, type, null);
            regLabelB.setText("Bilforsikring Registrert!");
        });

        gridBåt.add(tfRegnrB, 0, 0);
        gridBåt.add(tfÅrsmodellB, 0, 1);
        gridBåt.add(tfBåtmodell, 0, 2);
        gridBåt.add(tfAntfor, 0, 3);
        gridBåt.add(tfMotormerke, 0, 4);
        gridBåt.add(tfYtelse, 0, 5);
        gridBåt.add(cbEgenandelB, 0, 6);
        gridBåt.add(cbBonusB, 0, 7);
        gridBåt.add(rbtMotorbåt, 0, 8);
        gridBåt.add(rbtSeilbåt, 0, 9);
        gridBåt.add(btnSjekkprisB, 0, 10);
        gridBåt.add(btnRegBåtforsikring, 0, 11);
        gridBåt.add(regLabelB, 0, 12);




        //Bolig
        gridBolig.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridBolig.setVgap(10);
        gridBolig.setHgap(10);
        gridBolig.setAlignment(Pos.CENTER);

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
        cbMatriale.setValue("Byggematriale:");

        CheckBox cbleie = new CheckBox("Merk om du har utleiemulighet");
        cbleie.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (cbleie.isSelected() == true) {
                    leie = "Ja";
                    System.out.println("Ja");
                } else {
                    leie = "Nei";
                    System.out.println("Nei");
                }
            }
        });

        //Registrer knapp & Label
        Label regLabelBo = new Label();
        regLabelBo.setText("");
        regLabelBo.setId("regLabel");
        regLabelBo.setAlignment(Pos.CENTER);

        Button btnSjekkpris = new Button();
        btnSjekkpris.setText("Beregn pris");
        btnSjekkpris.setId("btnSjekkpris");
        btnSjekkpris.setMinWidth(200);
        btnSjekkpris.setOnAction(e -> {
            regLabelBo.setText("Prisen er: " + "getPris()");
        });

        Button btnRegBoligforsikring = new Button();
        btnRegBoligforsikring.setText("Registrer Boligforsikring");
        btnRegBoligforsikring.setId("btnRegBoligforsikring");
        btnRegBoligforsikring.setMinWidth(200);
        btnRegBoligforsikring.setOnAction(eB -> {
            String postNr = tfPostnr.getText();
            String adresse = tfAdresse.getText();
            String byggeÅr = tfByggeår.getText();
            double kvadrat = 0;
            double byggSum = 0;
            double innboSum = 0;
            int byggeår = 0;
            String mertiale = cbMatriale.getValue();


            try {
                kvadrat = Double.parseDouble(tfKvadrat.getText());
                byggSum = Double.parseDouble(tfByggSum.getText());
                innboSum = Double.parseDouble(tfInnboSum.getText());
                byggeår = Integer.parseInt(tfKvadrat.getText());
            } catch (NumberFormatException nfe) {
                System.out.println("Feil tallformat.");
            }

            kontroll.setBoligForsikring(kvadrat, adresse, "hei", byggeår, "tre", "dårlig", byggSum, innboSum);
            regLabelBo.setText("Boligforsikring registrert!");
        });

        gridBolig.add(tfPostnr, 0, 0);
        gridBolig.add(tfAdresse, 0, 1);
        gridBolig.add(tfByggeår, 0, 2);
        gridBolig.add(tfKvadrat, 0, 3);
        gridBolig.add(tfByggSum,0,4);
        gridBolig.add(tfInnboSum,0,5);
        gridBolig.add(cbBoligtype,0,6);
        gridBolig.add(cbStandard,0,7);
        gridBolig.add(cbMatriale,0,8);
        gridBolig.add(cbleie, 0, 9);
        gridBolig.add(btnSjekkpris,0,10);
        gridBolig.add(btnRegBoligforsikring, 0, 11);
        gridBolig.add(regLabelBo, 0, 12);

        gridBolig.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridBolig.setVgap(10);
        gridBolig.setHgap(10);
        gridBolig.setAlignment(Pos.CENTER);



        //FritidsBolig
        gridFriBolig.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridFriBolig.setVgap(10);
        gridFriBolig.setHgap(10);
        gridFriBolig.setAlignment(Pos.CENTER);

        TextField tfPostnrF = new TextField();
        tfPostnrF.setPromptText("Postnummer");
        tfPostnrF.setMinWidth(200);

        TextField tfAdresseF = new TextField();
        tfAdresseF.setPromptText("Adresse");
        tfAdresseF.setMinWidth(200);

        TextField tfByggeårF = new TextField();
        tfByggeårF.setPromptText("Byggeår");
        tfByggeårF.setMinWidth(200);

        TextField tfKvadratF = new TextField();
        tfKvadratF.setPromptText("Kvadratmeter");
        tfKvadratF.setMinWidth(200);

        TextField tfByggSumF = new TextField();
        tfByggSumF.setPromptText("Bolig verdi");
        tfByggSumF.setMinWidth(200);

        TextField tfInnboSumF = new TextField();
        tfInnboSumF.setPromptText("Innbo verdi");
        tfInnboSumF.setMinWidth(200);

        ComboBox<String> cbBoligtypeF = new ComboBox<>();
        cbBoligtypeF.setEditable(false);
        cbBoligtypeF.setMinWidth(200);
        cbBoligtypeF.getItems().addAll(
                "Enebolig",
                "Tomannsbolig",
                "Leilighet",
                "Rekkehus"
        );
        cbBoligtypeF.setValue("Velg Boligtype:");

        ComboBox<String> cbStandardF = new ComboBox<>();
        cbStandardF.setEditable(false);
        cbStandardF.setMinWidth(200);
        cbStandardF.getItems().addAll(
                "Dårlig",
                "Gjennomsnittlig",
                "Over gjennomsnitt",
                "Svært Høy"
        );
        cbStandardF.setValue("Standard:");

        ComboBox<String> cbMatrialeF = new ComboBox<>();
        cbMatrialeF.setEditable(false);
        cbMatrialeF.setMinWidth(200);
        cbMatrialeF.getItems().addAll(
                "Mur",
                "Tre",
                "Betong",
                "Leca",
                "Laft"
        );
        cbMatrialeF.setValue("Byggematriale:");

        CheckBox cbleieF = new CheckBox("Merk om du har utleiemulighet");
        cbleieF.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (cbleieF.isSelected() == true) {
                    leie = "Ja";
                    System.out.println("Ja");
                }
                else {
                    leie = "Nei";
                    System.out.println("Nei");
                }
            }
        });

        //Registrer knapp & Label
        Label regLabelF = new Label();
        regLabelF.setText("");
        regLabelF.setId("regLabel");
        regLabelF.setAlignment(Pos.CENTER);

        Button btnSjekkprisF = new Button();
        btnSjekkprisF.setText("Beregn pris");
        btnSjekkprisF.setId("btnSjekkpris");
        btnSjekkprisF.setMinWidth(200);
        btnSjekkprisF.setOnAction(eF -> {
            regLabelF.setText("Prisen er: " + "getPris()");
        });

        Button btnRegBoligforsikringF = new Button();
        btnRegBoligforsikringF.setText("Registrer Boligforsikring");
        btnRegBoligforsikringF.setId("btnRegBoligforsikring");
        btnRegBoligforsikringF.setMinWidth(200);
        btnRegBoligforsikringF.setOnAction(eBF -> {
            String postNr = tfPostnr.getText();
            String adresse = tfAdresse.getText();
            String byggeÅr = tfByggeår.getText();
            double kvadrat = 0;
            double byggSum = 0;
            double innboSum = 0;
            int byggeår = 0;
            String mertiale = cbMatriale.getValue();


            try {
                kvadrat = Double.parseDouble(tfKvadrat.getText());
                byggSum = Double.parseDouble(tfByggSum.getText());
                innboSum = Double.parseDouble(tfInnboSum.getText());
                byggeår = Integer.parseInt(tfKvadrat.getText());
            } catch (NumberFormatException nfe) {
                System.out.println("Feil tallformat.");
            }

            kontroll.setFritidsForsikring(kvadrat, adresse, "hei", byggeår, "tre", "dårlig", byggSum, innboSum);
            regLabelF.setText("FritidsBoligforsikring registrert!");
        });

        gridFriBolig.add(tfPostnrF, 0, 0);
        gridFriBolig.add(tfAdresseF, 0, 1);
        gridFriBolig.add(tfByggeårF, 0, 2);
        gridFriBolig.add(tfKvadratF, 0, 3);
        gridFriBolig.add(tfByggSumF,0,4);
        gridFriBolig.add(tfInnboSumF,0,5);
        gridFriBolig.add(cbBoligtypeF,0,6);
        gridFriBolig.add(cbStandardF,0,7);
        gridFriBolig.add(cbMatrialeF,0,8);
        gridFriBolig.add(cbleieF, 0, 9);
        gridFriBolig.add(btnSjekkprisF,0,10);
        gridFriBolig.add(btnRegBoligforsikringF, 0, 11);
        gridFriBolig.add(regLabelF, 0, 12);

        gridFriBolig.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridFriBolig.setVgap(10);
        gridFriBolig.setHgap(10);
        gridFriBolig.setAlignment(Pos.CENTER);

        //Alle
        gridAlle.setPadding(new Insets(10, 0, 0, 0)); //top/right/bottom/left
        gridAlle.setVgap(10);
        gridAlle.setHgap(10);
        gridAlle.setAlignment(Pos.CENTER);

        TextArea taLes = new TextArea();
        taLes.setPrefSize(300, 400);
        taLes.setId("taLes");
        taLes.setEditable(false);

        listView.getSelectionModel().selectedItemProperty().addListener(eA -> {

            Forsikringer s = kontroll.getForsikring(Integer.parseInt(listView.getSelectionModel().getSelectedItem()));
            if (s != null) {
                taLes.setText(s.toString());
            }

        });


        Label lballe = new Label("Test tekst, du har vlagt Alle");
        gridAlle.add(lballe,0,0);
        gridAlle.add(taLes,0,1);


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
        btnSlett.setOnAction(eS -> {
            System.out.println("Du trykket på SLETT!");
        });

        Button btnRegForsikring = new Button();
        btnRegForsikring.setText("Reg. Forsikring");
        btnRegForsikring.setOnAction(e1 -> {
            System.out.println("RegForsikrings");
        });

        //gridButtons.add(btnSlett, 0, 0);
        //gridButtons.add(btnRegForsikring, 1, 0);

        GridPane gridRight = new GridPane();
        gridLeft.setPadding(new Insets(0, 0, 0, 0)); //top/right/bottom/left
        gridRight.add(gridBil, 0, 0);
        gridRight.add(gridBåt, 0, 0);
        gridRight.add(gridReise, 0, 0);
        gridRight.add(gridBolig, 0, 0);
        gridRight.add(gridFriBolig, 0, 0);
        gridRight.add(gridAlle, 0, 0);
        //gridRight.add(gridButtons, 0, 1);
        gridRight.setAlignment(Pos.CENTER);

        borderPane.setRight(gridRight);
        borderPane.setPadding(new Insets(10, 200, 200, 100)); //top/right/bottom/left

        gridButtons.setGridLinesVisible(false);
        gridLeft.setGridLinesVisible(false);
        gridBil.setGridLinesVisible(false);

        return borderPane;
    }

}
