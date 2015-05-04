package GUI;

import Forsikring.BatForsikring;
import Forsikring.BilForsikring;
import Forsikring.BoligForsikring;
import Forsikring.Forsikringer;
import Forsikring.FritidsBolig;
import Forsikring.ReiseForsikring;
import Kontroller.Kontroller;
import SkadeMeldinger.BatSkadeMelding;
import SkadeMeldinger.BilSkadeMelding;
import SkadeMeldinger.BoligSkadeMelding;
import SkadeMeldinger.FritidsBoligMelding;
import SkadeMeldinger.ReiseSkadeMelding;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Created by Magnus on 27.04.15.
 *
 * @author Therese
 *
 * public static Calendar DateToCalendar(Date date){ Calendar cal =
 * Calendar.getInstance(); cal.setTime(date); return cal; }
 */
public class KundesideSkade {

    private Calendar dato;
    private String skade = "BrannSkade";

    public Pane skadeFane(Kontroller kontroll) {

        //Group root = new Group();
        TextField tfBeløp = new TextField();
        BorderPane borderPane = new BorderPane();
        HBox vb = new HBox();
        vb.setPadding(new Insets(25, 25, 0, 25));
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);

        Label overskrift = new Label();
        overskrift.setText("Her oppretter du en Skademelding");
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

        //Skjema
        ComboBox<String> forsikringComboBox = new ComboBox<String>();
        forsikringComboBox.setEditable(false);
        forsikringComboBox.getItems().addAll(
                "Alle",
                "Båtforsikring",
                "Reiseforsikring",
                "Bilforsikring",
                "Boligforsikring",
                "Fri.Boligforsikring");
        forsikringComboBox.setValue("Velg Forsikring:");

        Label lbInfo = new Label();
        lbInfo.setText("Info om skaden:");
        lbInfo.setId("lbInfo");

        HBox hb = new HBox();
        hb.setSpacing(20);
        hb.setAlignment(Pos.CENTER);

        TextArea skriveOmråde = new TextArea();
        skriveOmråde.setEditable(true);
        skriveOmråde.setPromptText("Skriv innformasjon om skaden");
        skriveOmråde.setPrefSize(400, 400);

        ObservableList<String> data = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(data);
        listView.setPrefSize(300, 400);
        listView.setId("listview");
        listView.setEditable(false);

        data.addAll("Trykk på meg :)");

        listView.setItems(data);
        listView.setCellFactory(ComboBoxListCell.forListView(data));

        ToggleGroup skadeType = new ToggleGroup();
        RadioButton rbtVann = new RadioButton("Vannskade");
        rbtVann.setToggleGroup(skadeType);
        rbtVann.setSelected(true);
        rbtVann.setOnAction(e -> {
            skade = "VannSkade";
        });
        rbtVann.setVisible(false);

        RadioButton rbtRør = new RadioButton("Rørskade");
        rbtRør.setToggleGroup(skadeType);
        rbtRør.setSelected(true);
        rbtRør.setOnAction(e -> {
            skade = "RørSkade";
        });
        rbtRør.setVisible(false);

        RadioButton rbtBrann = new RadioButton("Brannskade");
        rbtBrann.setToggleGroup(skadeType);
        rbtBrann.setSelected(true);
        rbtBrann.setOnAction(e -> {
            skade = "BrannSkade";
        });
        rbtBrann.setVisible(false);


        GridPane radioGrid = new GridPane();
        radioGrid.add(rbtBrann, 0, 0);
        radioGrid.add(rbtRør, 0, 1);
        radioGrid.add(rbtVann,0, 2);
        radioGrid.setVgap(30);

        hb.getChildren().addAll(listView, skriveOmråde, radioGrid);


        Label lbSkadebeløp = new Label();
        lbSkadebeløp.setText("Samlet skadebeløp:");
        lbSkadebeløp.setId("lbSkadebeløp");

        tfBeløp.setMaxWidth(100);
        tfBeløp.setAlignment(Pos.CENTER_LEFT);
        tfBeløp.setPromptText("Beløp:");

        Label lbDato = new Label();
        lbDato.setText("Velg dato for hendelsen:");
        lbDato.setId("lbDato");

        DatePicker dpDato = new DatePicker();
        dpDato.setPromptText("Format eks. 12.02.2015");

        FileChooser fileChooser = new FileChooser();

        Button btnÅpnefil = new Button("Velg fil");
        btnÅpnefil.setMaxWidth(200);
        btnÅpnefil.setOnAction(e -> {
            fileChooser.showOpenMultipleDialog(new Stage());
        });

        Label lbSkade = new Label();
        lbSkade.setText("");
        lbSkade.setId("lbskade");

        Button btnRapSkade = new Button();
        btnRapSkade.setText("Raporter skade");
        btnRapSkade.setId("btnRapSkade");
        btnRapSkade.setMinWidth(200);

        Label lbFeilFormat = new Label();
        lbFeilFormat.setVisible(false);

        grid.add(forsikringComboBox, 0, 0);
        //grid.add(lbInfo, 0, 1);
        grid.add(hb, 0, 2);
        grid.add(lbSkadebeløp, 0, 3);
        grid.add(tfBeløp, 0, 4);

        grid.add(lbFeilFormat, 1, 4);
        grid.add(lbDato, 0, 5);
        grid.add(dpDato, 0, 6);
        grid.add(btnÅpnefil, 0, 7);
        grid.add(btnRapSkade, 0, 8);
        grid.add(lbSkade, 0, 9);

        borderPane.setCenter(grid); // CENTER

        // henter datoen og konverterer den til Calendar
        dpDato.setOnAction((ActionEvent e) -> {
            {
                LocalDate date = dpDato.getValue();
                Date dat = Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
                dato = Calendar.getInstance();
                dato.setTime(dat);
            }
        });

        forsikringComboBox.setOnAction(e -> {

            ArrayList<String> forsikringliste = kontroll.
                    getInfoForsikringListe(forsikringComboBox.getItems().
                            indexOf(forsikringComboBox.getValue()));
            if (forsikringliste == null) {
                data.clear();
                data.add("Ingen " + forsikringComboBox.getValue() + "er registrert");
            } else {
                data.setAll(forsikringliste);
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener((Observable e) -> {
            int poisnr = -1;
            if (listView.getSelectionModel().getSelectedItem() != null && listView.getSelectionModel().getSelectedItem().isEmpty()) {
                
                poisnr = Integer.parseInt(listView.getSelectionModel().getSelectedItem());
            }

            Forsikringer fors = kontroll.getForsikring(poisnr);
            if (fors != null) {
                skriveOmråde.setEditable(true);
                if (fors instanceof BoligForsikring || fors instanceof FritidsBolig) {
                    rbtVann.setVisible(true);
                    rbtBrann.setVisible(true);
                    rbtRør.setVisible(true);
                } else {
                    rbtVann.setVisible(false);
                    rbtBrann.setVisible(false);
                    rbtRør.setVisible(false);
                }
            } else {
                skriveOmråde.setEditable(false);
            }
        });
        btnRapSkade.setOnAction((ActionEvent e) -> {
            String polisNr = listView.getSelectionModel().getSelectedItem();
            
            Forsikringer fors = kontroll.getForsikring(Integer.parseInt(polisNr));
            try {
                if (fors instanceof BilForsikring) {

                    BilForsikring f = (BilForsikring) fors;
                    BilSkadeMelding bil = new BilSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    bil.setForsikring(f);
                    bil.setUtbetaling(f.utbetal(200000, Integer.parseInt(tfBeløp.getText())));
                    f.premieTilGodkjenning(f.premieEtterSkade(f.getPremie(), f.getBonus()));
                    f.nyBonusTilGodkjenning(f.bonusEtterSkade(f.getBonus()));
                    kontroll.addSkade(bil);
                    skriveOmråde.setText(bil.melding());

                } else if (fors instanceof BatForsikring) {

                    BatForsikring f = (BatForsikring) fors;
                    BatSkadeMelding bat = new BatSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    bat.setForsikring(f);
                    bat.setUtbetaling(Integer.parseInt(tfBeløp.getText()));
                    kontroll.addSkade(bat);
                    skriveOmråde.setText(bat.melding());

                } else if (fors instanceof BoligForsikring) {

                    BoligForsikring f = (BoligForsikring) fors;
                    BoligSkadeMelding bolig = new BoligSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    bolig.setForsikring(f);
                    int egenandel = f.egenandel(skade, false);
                    bolig.setUtbetaling(f.utbetaling(Integer.parseInt(tfBeløp.getText()), f.getForsikringsSum(), 2015, egenandel));
                    f.premieTilGodkjenning(f.nyPremie());
                    kontroll.addSkade(bolig);
                    skriveOmråde.setText(bolig.melding());

                } else if (fors instanceof FritidsBolig) {

                    FritidsBolig f = (FritidsBolig) fors;
                    FritidsBoligMelding fri = new FritidsBoligMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    fri.setForsikring(f);
                    int egenandel = f.egenandel(skade, false);
                    fri.setUtbetaling(f.utbetaling(Integer.parseInt(tfBeløp.getText()), f.getForsikringsSum(), 2015, egenandel));
                    f.premieTilGodkjenning(f.nyPremie());
                    kontroll.addSkade(fri);
                    skriveOmråde.setText(fri.melding());
                } else if (fors instanceof ReiseForsikring) {
                    ReiseForsikring f = (ReiseForsikring) fors;
                    ReiseSkadeMelding reise = new ReiseSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()), dato);
                    reise.setUtbetaling(Integer.parseInt(tfBeløp.getText()));
                    kontroll.addSkade(reise);
                    skriveOmråde.setText(reise.melding());
                }

            } catch (NumberFormatException nfe) {
                lbFeilFormat.setText("Kun hele tall.");
                lbFeilFormat.setVisible(true);
            }
            lbSkade.setText("Skademelding er sendt inn");
        });
        return borderPane;
    }
}
