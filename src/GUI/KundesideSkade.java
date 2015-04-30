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
import java.util.ArrayList;
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
 */
public class KundesideSkade {

    public static Pane skadeFane(Kontroller kontroll) {

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
        
        Label  lbFeilFormat = new Label();
        lbFeilFormat.setVisible( false );
        
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
            Forsikringer fors = kontroll.getForsikring(Integer.parseInt(listView.getSelectionModel().getSelectedItem()));
            if (fors != null) {
                skriveOmråde.setEditable(true);
            } else {
                skriveOmråde.setEditable(false);
            }

        });
        btnRapSkade.setOnAction((ActionEvent e) -> {
            Forsikringer fors = kontroll.getForsikring(Integer.parseInt(listView.getSelectionModel().getSelectedItem()));
            try {
                if (fors instanceof BilForsikring) {
                    kontroll.addSkade(new BilSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText())));
                } else if (fors instanceof BatForsikring) {
                    kontroll.addSkade(new BatSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText())));
                } else if (fors instanceof BoligForsikring) {
                    kontroll.addSkade(new BoligSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText())));
                } else if (fors instanceof FritidsBolig) {
                    kontroll.addSkade(new FritidsBoligMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText())));
                } else if (fors instanceof ReiseForsikring) {
                    kontroll.addSkade(new ReiseSkadeMelding(skriveOmråde.getText(), Integer.parseInt(tfBeløp.getText())));
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
