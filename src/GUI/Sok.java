package GUI;

import Kontroller.Kontroller;
import Person.Konsulent;
import Person.Kunde;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.geometry.Pos.TOP_CENTER;

/**
 * Created by Magnus on 28.04.15.
 */
public class Sok {

    private final String sokBilde = "Bilder/sok.png";
    private final TextField fornavn;
    private final TextField etternavn;
    private final TextField kundeNr;
    private final Button btnsøk;
    private final Button btnvelg;
    private final Button btnlukk;
    private static Stage vindu;

    public Sok(Stage vindu, Kontroller kontroll)  {

        this.vindu = vindu;

        ImageView img = new ImageView(new Image(sokBilde));
        img.setId("loginImg");
        img.setPreserveRatio(true);
        img.setFitWidth(100);
        GridPane.setHalignment(img, HPos.CENTER);

        GridPane grid = new GridPane();
        grid.setAlignment(TOP_CENTER);
        //grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        fornavn = new TextField();
        fornavn.setPromptText("Fornavn");
        fornavn.setId("fornavn");
        fornavn.setMaxWidth(200);
        GridPane.setHalignment(fornavn, HPos.CENTER);

        etternavn = new TextField();
        etternavn.setPromptText("Etternavn");
        etternavn.setId("etternavn");
        etternavn.setMaxWidth(200);
        GridPane.setHalignment(etternavn, HPos.CENTER);

        kundeNr = new TextField();
        kundeNr.setPromptText("Kundenr");
        kundeNr.setId("kundenr");
        kundeNr.setMaxWidth(200);
        GridPane.setHalignment(kundeNr, HPos.CENTER);

        ObservableList<String> data = FXCollections.observableArrayList();
        ListView<String> listView = new ListView<>(data);
        listView.setPrefSize(300, 200);
        listView.setEditable(false);
        //data.addAll("Honda CRV", "Ferrari Enzo", "VW Golf");
        data.addAll("Dobbel klikk for å velge:");
        listView.setItems(data);
        listView.setCellFactory(ComboBoxListCell.forListView(data));


        btnvelg = new Button("Velg");
        btnvelg.setId("btnvelg");
        btnvelg.setMinWidth(100);
        btnvelg.setOnAction(e -> {
            System.out.println("Du har valgt en kunde!");
        });

        btnsøk = new Button("Søk");
        btnsøk.setId("btnsøk");
        btnsøk.setMinWidth(100);
        btnsøk.setOnAction(e -> {
            System.out.println("Du søker");
        });

        btnlukk = new Button("Lukk");
        btnlukk.setId("btnlukk");
        btnlukk.setMinWidth(100);
        btnlukk.setOnAction(e -> vindu.close());

        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(btnlukk, btnvelg, btnsøk);


        grid.add(img, 0, 0);
        grid.add(fornavn, 0, 1);
        grid.add(etternavn, 0, 2);
        grid.add(kundeNr, 0, 3);
        grid.add(listView, 0, 4);
        grid.add(hb, 0, 6);

        VBox vb = new VBox();
        vb.setSpacing(25);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(img, grid);

        Scene scene = new Scene(vb, 450, 580);
        vindu.setTitle("Søk");
        vindu.setScene(scene);
        scene.getStylesheets().add("CSS/registrer.css");
        vindu.show();
    }




}//End of class
