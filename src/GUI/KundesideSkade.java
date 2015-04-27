package GUI;

import Kontroller.Kontroller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
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

        TextArea taSkriv = new TextArea();
        taSkriv.setEditable(true);
        taSkriv.setPromptText("");
        taSkriv.setPrefSize(900, 300);

        Label lbSkadebeløp = new Label();
        lbSkadebeløp.setText("Samlet skadebeløp:");
        lbSkadebeløp.setId("lbSkadebeløp");

        TextField tfBeløp = new TextField();
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
        btnRapSkade.setOnAction(e -> {
            lbSkade.setText("Skademelding er sendt inn");
        });

        grid.add(forsikringComboBox, 0, 0);
        grid.add(lbInfo, 0, 1);
        grid.add(taSkriv, 0, 2);
        grid.add(lbSkadebeløp, 0, 3);
        grid.add(tfBeløp, 0, 4);
        grid.add(lbDato, 0, 5);
        grid.add(dpDato, 0, 6);
        grid.add(btnÅpnefil, 0, 7);
        grid.add(btnRapSkade, 0, 8);
        grid.add(lbSkade, 0, 9);

        borderPane.setCenter(grid); // CENTER

        return borderPane;
    }

}
