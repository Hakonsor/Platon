package GUI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.*;

import static javafx.geometry.Pos.TOP_CENTER;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideInfo {

    public static Pane infoFane() {
        //Group root = new Group();
        BorderPane borderPane = new BorderPane();
        HBox vb = new HBox();
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

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(0, 25, 25, 25));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPrefHeight(50);
        grid.setPrefWidth(800);

        ComboBox<String> forsikringComboBox = new ComboBox<String>();
        forsikringComboBox.setEditable(false);
        forsikringComboBox.getItems().addAll("Båtforsikring", "Reiseforsikring", "Bilforsikring", "Boligforsikring", "Fri.Boligforsikring");
        forsikringComboBox.setValue("Velg Forsikring:");

        ObservableList<String> navn = FXCollections.observableArrayList();
        ObservableList<String> data = FXCollections.observableArrayList();

        ListView<String> listView = new ListView<String>(data);
        listView.setPrefSize(300, 600);
        listView.setEditable(false);

        navn.addAll("Honda CRV", "Ferrari Enzo", "VW Golf");
        data.addAll("Dobbel klikk for å velge:");

        listView.setItems(navn);
        listView.setCellFactory(ComboBoxListCell.forListView(navn));

        TextArea textArea = new TextArea();
        textArea.setPrefSize(400, 600);

        grid.add(forsikringComboBox, 0, 0);
        grid.add(listView, 0, 1);
        grid.add(textArea, 2, 1);

        borderPane.setCenter(grid);

        return borderPane;
    }
}
