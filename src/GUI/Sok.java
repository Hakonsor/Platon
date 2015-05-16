package GUI;

import Person.Personsammenlikner;
import Kontroller.Kontroller;
import Person.Kunde;
import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.geometry.Pos.TOP_CENTER;

/**
 * Created by Magnus on 28.04.15.
 */
public class Sok {

    private Kontroller kontroll;
    private ObservableList<String> data = FXCollections.observableArrayList();
    private final String sokBilde = "Bilder/sok2.png";
    private final TextField fornavn;
    private final TextField etternavn;
    private final TextField kundeNr;
    private ListView<String> listView;
    private final Button btnsøk;
    private final Button btnvelg;
    private final Button btnlukk;
    private static Stage vindu;
    private Label info;

    public Sok(Stage vindu, Kontroller kontroll) {

        this.vindu = vindu;
        this.kontroll = kontroll;

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
        fornavn.setId("promtfix");
        fornavn.setMaxWidth(200);
        GridPane.setHalignment(fornavn, HPos.CENTER);

        etternavn = new TextField();
        etternavn.setPromptText("Etternavn");
        etternavn.setId("promtfix");
        etternavn.setMaxWidth(200);
        GridPane.setHalignment(etternavn, HPos.CENTER);

        kundeNr = new TextField();
        kundeNr.setPromptText("Kundenr");
        kundeNr.setId("promtfix");
        kundeNr.setMaxWidth(200);
        GridPane.setHalignment(kundeNr, HPos.CENTER);

        listView = new ListView<>(data);
        listView.setPrefSize(300, 200);
        listView.setEditable(false);
        listView.setId("list");
        //data.addAll("Honda CRV", "Ferrari Enzo", "VW Golf");
        data.addAll("Søk og trykk på \"Velg\" knappen:");
        listView.setItems(data);
        listView.setCellFactory(ComboBoxListCell.forListView(data));

        btnvelg = new Button("Velg");
        btnvelg.setId("btnvelg");
        btnvelg.setMinWidth(100);
        btnvelg.setOnAction(e -> {
            velgKunde();
        });

        btnsøk = new Button("Søk");
        btnsøk.setId("btnsok");
        btnsøk.setMinWidth(100);
        btnsøk.setOnAction(e -> {
            søkeResultater();
        });

        btnlukk = new Button("Lukk");
        btnlukk.setId("btnlukk");
        btnlukk.setMinWidth(100);
        btnlukk.setOnAction(e -> vindu.close());

        info = new Label();
        info.setId("info");
        info.setText("");
        info.setVisible(false);
        info.setAlignment(Pos.CENTER);

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
        grid.add(info, 0, 7);

        VBox vb = new VBox();
        vb.setSpacing(15);
        vb.setAlignment(Pos.CENTER);
        vb.getChildren().addAll(img, grid);

        Scene scene = new Scene(vb, 450, 580);
        vindu.setTitle("Søk");
        vindu.setScene(scene);
        scene.getStylesheets().add("CSS/sok.css");

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    søkeResultater();
                }
            }
        });

        vindu.show();
    }

    private void søkeResultater() {
        data.clear();
        List<Kunde> list = kontroll.søkeResultater(fornavn.getText(), etternavn.getText(), kundeNr.getText());
        Collections.sort(list, new Personsammenlikner());
        Collections.reverse(list); 
        list.stream().forEach((i) -> {
            data.add(i.getFornavn() + " " + i.getEtternavn() + ", KundeNr: " + i.getNøkkel());
            
        });
        
    }

    private void velgKunde() {
        String kundenr = listView.getSelectionModel().getSelectedItem();
        Kunde k = null;
        info.setText("Du har ikke valgt kunde!");
        info.setVisible(true);
        if (kundenr != null && !kundenr.isEmpty()) {
            k = kontroll.getKunde(kundenr.replaceAll("\\D", ""));
        }

        if (k != null) {
            kontroll.setInnloggetBruker(k.getNøkkel());
            KonsulentsideKunde.lbKundenavn.setText("Valgt kunde: " + kontroll.getInnloggetBruker().getFornavn() + " " + kontroll.getInnloggetBruker().getEtternavn() + ", kundenr: " + kontroll.getInnloggetBruker().getNøkkel());
            kontroll.opptaterListeKonsulent();
            vindu.close();
        }

    }

}//End of class
