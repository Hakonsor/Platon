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

    public static Pane infoFane(Kontroller kontroller) {
        //Group root = new Group();
        BorderPane borderPane = new BorderPane();
        borderPane.setId("haha");
        HBox vb = new HBox();
        vb.setId("border");
        vb.setPadding(new Insets(25, 25, 25, 25));
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);

        Button btnSlett = new Button();
        btnSlett.setText("Slett");
        btnSlett.setId("slett");
        btnSlett.setMaxWidth(200);


        Button btnUtbetalinger = new Button();
        btnUtbetalinger.setText("Utbetalinger");
        btnUtbetalinger.setId("utbetalinger");
        btnUtbetalinger.setMaxWidth(200);

        Button btnStatus = new Button();
        btnStatus.setText("Status");
        btnStatus.setId("status");
        btnStatus.setMaxWidth(200);
        vb.getChildren().addAll(btnSlett, btnUtbetalinger, btnStatus);

        borderPane.setTop(vb);

        //CENTER
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setVgap(50);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        ObservableList<String> navn = FXCollections.observableArrayList();
        ObservableList<String> data = FXCollections.observableArrayList();

        ComboBox<String> forsikringComboBox = new ComboBox<>();
        forsikringComboBox.setEditable(false);
        forsikringComboBox.getItems().addAll("Alle", "Båtforsikring", "Reiseforsikring", "Bilforsikring", "Boligforsikring", "Fri.Boligforsikring");
        forsikringComboBox.setValue("Velg Forsikring:");
        

        ListView<String> listView = new ListView<>(data);
        listView.setPrefSize(300, 400);
        listView.setId("listview");
        listView.setEditable(false);

        //navn.addAll("Honda CRV", "Ferrari Enzo", "VW Golf");
        data.addAll("Dobbel klikk for å velge:");

        listView.setItems(navn);
        listView.setCellFactory(ComboBoxListCell.forListView(navn));
        TextArea textArea = new TextArea();
        //listView.setOnMouseClicked(e -> { visElemnt();   });
        

        textArea.setPrefSize(300, 400);
        textArea.setId("textarea");
        textArea.setEditable(false);

        grid.add(forsikringComboBox, 0, 0);
        grid.add(listView, 0, 1);
        grid.add(textArea, 2, 1);

        borderPane.setCenter(grid);

        borderPane.getStylesheets().add("CSS/kundeInfo.css");
        
        btnSlett.setOnAction(e -> {
            String polisNr = listView.getSelectionModel().getSelectedItem();
            if (polisNr != null && polisNr.matches("[0-9]{6}.*")) {
                polisNr = polisNr.substring(0, 6);
            }else{
                return;
            }
            kontroller.slettForsikring(Integer.parseInt(polisNr));
        
        });
        
        listView.getSelectionModel().selectedItemProperty().addListener(e -> {

            String polisnr = listView.getSelectionModel().getSelectedItem();
            if (polisnr != null) {
                polisnr = polisnr.substring(0,6);
                Forsikringer s = kontroller.getForsikring(Integer.parseInt(polisnr.replaceAll("[^0-9]","0")));
                if (s != null) {
                    textArea.setText(s.toString());
                }
            }
        });
        
        forsikringComboBox.setOnAction(e -> {
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
        });
        
        return borderPane;
    }

}
