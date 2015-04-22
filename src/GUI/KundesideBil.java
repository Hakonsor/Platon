package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import static javafx.geometry.Pos.TOP_CENTER;

/**
 * Created by Magnus on 21.04.15.
 */
public class KundesideBil {

    public static Pane bilFane() {
        //Group root = new Group();
        BorderPane borderPane = new BorderPane();
        HBox vb = new HBox();
        vb.setPadding(new Insets(25, 25, 25, 25));
        vb.setSpacing(100);
        vb.setAlignment(Pos.CENTER);

        Label overskrift = new Label();
        overskrift.setText("Her registrerer du bilforsikring");
        overskrift.setId("overskrift");
        vb.getChildren().addAll(overskrift);

        borderPane.setTop(vb);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(0, 25, 25, 25));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPrefHeight(50);
        grid.setPrefWidth(800);

        TextField tfRegnr = new TextField();
        tfRegnr.setPromptText("Reg.Nr");
        tfRegnr.setMaxWidth(200);


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

}//End of class

/*
<Tab text="Bilforsikring" fx:id="bil" closable="false">
                    <content>
                        <BorderPane>
                            <top>
                                <GridPane alignment="CENTER" hgap="10" vgap="10" prefHeight="20" prefWidth="30">
                                    <padding>
                                        <Insets top="25" right="25" bottom="25" left="25"/>
                                    </padding>

                                    <Label fx:id="blab22" text="Her kommer Bilforsikringene"/>

                                    <TextField fx:id="regnr" promptText="Reg.Nr" prefHeight="25.0" prefWidth="200.0"
                                               GridPane.columnIndex="0" GridPane.rowIndex="1"/>

                                    <TextField fx:id="modell" promptText="Årsmodell" prefHeight="25.0" prefWidth="200.0"
                                               GridPane.columnIndex="0" GridPane.rowIndex="2"/>

                                    <TextField fx:id="type" promptText="Biltype eks (BMW 3-serie)" prefHeight="25.0" prefWidth="200.0"
                                               GridPane.columnIndex="0" GridPane.rowIndex="3"/>

                                    <TextField fx:id="kmstand" promptText="Km-stand" prefHeight="25.0" prefWidth="200.0"
                                               GridPane.columnIndex="0" GridPane.rowIndex="4"/>

                                    <ComboBox fx:id="kjørelengde" editable="false" value="Velg Kjørelengde:" prefWidth="200.0" prefHeight="25.0"
                                              GridPane.columnIndex="1" GridPane.rowIndex="1" >
                                        <items>
                                            <FXCollections fx:factory="observableArrayList">
                                                <String fx:value="Kjørelengde: 5 000 km"/>
                                                <String fx:value="Kjørelengde: 8 000 km"/>
                                                <String fx:value="Kjørelengde: 10 000 km"/>
                                                <String fx:value="Kjørelengde: 15 000 km"/>
                                                <String fx:value="Kjørelengde: 20 000 km"/>
                                                <String fx:value="Kjørelengde: 25 000 km"/>
                                                <String fx:value="Kjørelengde: 30 000 km"/>
                                                <String fx:value="Kjørelengde: Ubegrenset"/>
                                            </FXCollections>
                                        </items>
                                    </ComboBox>


                                        <ComboBox fx:id="velgbonus" editable="false" value="Velg Bonus:" prefWidth="200.0" prefHeight="25.0"
                                                  GridPane.columnIndex="1" GridPane.rowIndex="2" >
                                            <items>
                                                <FXCollections fx:factory="observableArrayList">
                                                    <String fx:value="Bonus: -20%"/>
                                                    <String fx:value="Bonus: -10%"/>
                                                    <String fx:value="Bonus: 0%"/>
                                                    <String fx:value="Bonus: 10%"/>
                                                    <String fx:value="Bonus: 20%"/>
                                                    <String fx:value="Bonus: 30%"/>
                                                    <String fx:value="Bonus: 40%"/>
                                                    <String fx:value="Bonus: 50%"/>
                                                    <String fx:value="Bonus: 60%"/>
                                                    <String fx:value="Bonus: 70%"/>
                                                    <String fx:value="Bonus: 75%"/>
                                                    <String fx:value="Bonus: 75% +1år"/>
                                                    <String fx:value="Bonus: 75% +2år"/>
                                                    <String fx:value="Bonus: 75% +3år"/>
                                                    <String fx:value="Bonus: 75% +4år"/>
                                                    <String fx:value="Bonus: 75% +5år"/>
                                                </FXCollections>
                                            </items>
                                        </ComboBox>

                                    <ComboBox fx:id="egenandel" editable="false" value="Velg Egenandel:" prefWidth="200.0" prefHeight="100.0"
                                              GridPane.columnIndex="1" GridPane.rowIndex="3" >
                                        <items>
                                            <FXCollections fx:factory="observableArrayList">
                                                <String fx:value="Egenandel:  5 000,-"/>
                                                <String fx:value="Egenandel:  7 000,-"/>
                                                <String fx:value="Egenandel: 10 000,-"/>
                                                <String fx:value="Egenandel: 15 000,-"/>
                                            </FXCollections>
                                        </items>
                                    </ComboBox>

                                    <Button fx:id="reg_bilforsikring" text="Registrer Bilforsikring" prefWidth="200.0" prefHeight="25.0"
                                            GridPane.columnIndex="1" GridPane.rowIndex="4" GridPane.halignment="CENTER"/>

                                </GridPane>
                            </top>
                        </BorderPane>
                    </content>
                </Tab>

 */