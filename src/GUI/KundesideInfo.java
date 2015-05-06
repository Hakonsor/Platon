package GUI;

import Forsikring.Forsikringer;
import Kontroller.ComboBoxConverter;
import Kontroller.Kontroller;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideInfo implements ComboBoxConverter {

    ObservableList<String> navn = FXCollections.observableArrayList();
    ObservableList<String> data = FXCollections.observableArrayList();
    
    Kontroller kontroller;
    ComboBox<String> forsikringComboBox;
    VBox vb;
    GridPane grid;
    
    Label lbhei;
    Label lbnavn;
    Label lbkundenr;
    Label lbepost;

    Button btnSlett;
    Button btnUtbetalinger;
    Button btnStatus;
    
    HBox hbKnapper;
    HBox hbFelter;
    
    ListView<String> listView;
    TextArea textArea;

    public Pane infoFane(Kontroller kontroller) {
        this.kontroller = kontroller;
        BorderPane borderPane = new BorderPane();
        borderPane.setId("borderpane");

        vb = new VBox();
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);

        grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 40, 10));//top/right/bottom/left
        grid.setVgap(5);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setGridLinesVisible(false);

        lbhei = new Label();
        lbhei.setId("hei");
        lbhei.setText("Hei");
        lbhei.setAlignment(Pos.CENTER_RIGHT);

        lbnavn = new Label();
        lbnavn.setId("navn");
        lbnavn.setText("Navn Navnesen");
        lbnavn.setAlignment(Pos.CENTER_LEFT);

        lbkundenr = new Label();
        lbkundenr.setId("kundenr");

        lbkundenr.setText("kundenr: " + "1");
        lbkundenr.setAlignment(Pos.CENTER);

        lbepost = new Label();
        lbepost.setId("epost");
        lbepost.setText("fornavn.etternavn@mail.com");
        lbepost.setAlignment(Pos.CENTER);

        grid.add(lbhei, 0, 0);
        grid.add(lbnavn, 1, 0);
        grid.add(lbepost, 1, 1);
        grid.add(lbkundenr, 1, 2);

        hbKnapper = new HBox();
        hbKnapper.setSpacing(90);
        hbKnapper.setAlignment(Pos.CENTER);

        forsikringComboBox = new ComboBox<>();
        forsikringComboBox.setEditable(false);
        forsikringComboBox.getItems().addAll("Alle", "Båtforsikring", "Reiseforsikring", "Bilforsikring", "Boligforsikring", "Fri.Boligforsikring");
        forsikringComboBox.setValue("Velg Forsikring:");
        forsikringComboBox.setOnAction(e -> {settListe();});
         
        btnSlett = new Button();
        btnSlett.setText("Slett");
        btnSlett.setId("slett");
        btnSlett.setMaxWidth(200);
        btnSlett.setOnAction(e -> { slettForsikring(); });

        btnUtbetalinger = new Button();
        btnUtbetalinger.setText("Utbetalinger");
        btnUtbetalinger.setId("utbetalinger");
        btnUtbetalinger.setMaxWidth(200);

        btnStatus = new Button();
        btnStatus.setText("Status");
        btnStatus.setId("status");
        btnStatus.setMaxWidth(200);

        hbKnapper.getChildren().addAll(forsikringComboBox, btnSlett, btnUtbetalinger, btnStatus);

        hbFelter = new HBox();
        hbFelter.setSpacing(10);
        hbFelter.setAlignment(Pos.CENTER);

        listView = new ListView<>(data);
        listView.setPrefSize(300, 300);
        listView.setId("listview");
        listView.setEditable(false);

        data.addAll("Dobbel klikk for å velge:");

        listView.setItems(navn);
        listView.setCellFactory(ComboBoxListCell.forListView(navn));
        listView.getSelectionModel().selectedItemProperty().addListener(e -> {skrivTilArea(); });
        
        textArea = new TextArea();
        textArea.setPrefSize(300, 300);
        textArea.setId("textarea");
        textArea.setEditable(false);

        hbFelter.getChildren().addAll(listView, textArea);
        vb.getChildren().addAll(grid, hbKnapper, hbFelter);
        
        borderPane.setCenter(vb);
        borderPane.getStylesheets().add("CSS/kundeInfo.css");
        
        return borderPane;
    }
    
    
    public void skrivTilArea(){
            String polisnr = listView.getSelectionModel().getSelectedItem();
            if (polisnr != null) {
                polisnr = polisnr.substring(0, 6);
                Forsikringer s = kontroller.getForsikring(Integer.parseInt(polisnr.replaceAll("[^0-9]", "0")));
                if (s != null) {
                    textArea.setText(s.toString());
                }
            }
    }

    public void settListe() {
        ArrayList<String> forsikringliste = kontroller.
                getInfoForsikringListe(forsikringComboBox.getItems().
                        indexOf(forsikringComboBox.getValue()));
        System.out.println(forsikringliste);
        if (forsikringliste == null) {
            navn.clear();
            navn.add("Ingen " + forsikringComboBox.getValue() + "er registrert");
        } else {
            navn.setAll(forsikringliste);
        }
    }

    public void slettForsikring() {
        String polisNr = listView.getSelectionModel().getSelectedItem();
        if (polisNr != null && polisNr.matches("[0-9]{6}.*")) {
            polisNr = polisNr.substring(0, 6);
        } else {
            return;
        }
        kontroller.slettForsikring(Integer.parseInt(polisNr));
        settListe();
    }

}
