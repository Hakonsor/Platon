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
import javafx.event.EventHandler;
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
    private String skade;

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
        listView.setOnMouseClicked(e -> {
            System.out.println("visElement()");
        });
        listView.getSelectionModel().selectedItemProperty().addListener(e -> {
            System.out.println("Her skal det stå en kode");
        });

        hb.getChildren().addAll(listView, skriveOmråde);

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

        Label lbSkadebeløp = new Label();
        lbSkadebeløp.setText("Samlet skadebeløp:");
        lbSkadebeløp.setId("lbSkadebeløp");

        tfBeløp.setMaxWidth(200);
        tfBeløp.setAlignment(Pos.CENTER_RIGHT);
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

        grid.add(rbtBrann, 2, 1);
        grid.add(rbtVann, 2, 2);
        grid.add(rbtRør, 2, 3);

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
                System.err.println("Selected date: " + date);
                dato =Calendar.getInstance();
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
            if (listView.getSelectionModel().getSelectedItem() != null) {
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
            Forsikringer fors = kontroll.getForsikring(Integer.parseInt(listView.getSelectionModel().getSelectedItem()));
            try {
                if (fors instanceof BilForsikring) {
                    BilForsikring f = (BilForsikring)fors;
                    BilSkadeMelding bil =new BilSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()),dato); 
                    kontroll.addSkade(bil, f);
                    bil.setUtbetaling(f.utbetal(200000, Integer.parseInt(tfBeløp.getText())));
                    skriveOmråde.setText(bil.melding());
                } else if (fors instanceof BatForsikring) {
                    BatForsikring f = (BatForsikring) fors;
                    BatSkadeMelding bat =new BatSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()),dato);
                    kontroll.addSkade(bat, f);
                    bat.setUtbetaling(Integer.parseInt(tfBeløp.getText()));
                } else if (fors instanceof BoligForsikring) {
                    BoligForsikring f = (BoligForsikring)fors;
                    BoligSkadeMelding bolig = new BoligSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()),dato);
                    kontroll.addSkade(bolig,f);
                    f.utbetaling(Integer.parseInt(tfBeløp.getText()), 2015);// 2015 er året skaden inntraff 
                    skriveOmråde.setText(bolig.melding());
                } else if (fors instanceof FritidsBolig) {
                    FritidsBolig f = (FritidsBolig)fors;
                    FritidsBoligMelding fri = new FritidsBoligMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()),dato);
                    kontroll.addSkade(fri,f);
                    skriveOmråde.setText(fri.melding());
                    f.utbetaling(Integer.parseInt(tfBeløp.getText()), 2015);
                } else if (fors instanceof ReiseForsikring) {
                    ReiseForsikring f = (ReiseForsikring) fors;
                    ReiseSkadeMelding reise =new ReiseSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText()),dato);
                    kontroll.addSkade(reise, f);
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
