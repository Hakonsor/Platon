package GUI;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import static javafx.geometry.Pos.CENTER;
import static javafx.geometry.Pos.TOP_CENTER;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

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
        vb.setAlignment(CENTER);

        Label overskrift = new Label();
        overskrift.setText("Her registrerer du bilforsikring");
        overskrift.setId("overskrift");
        vb.getChildren().addAll(overskrift);

        borderPane.setTop(vb);


        GridPane grid = new GridPane();
        grid.setAlignment(TOP_CENTER);
        grid.setHgap(10);

        grid.setVgap(10);
        grid.setPadding(new Insets(100));

        Label lb = new Label();
        lb.setText("Her kommer det Informasjon");
        GridPane.setHalignment(lb, HPos.CENTER);

        grid.setPrefHeight(50);
        grid.setPrefWidth(800);
        grid.setAlignment(TOP_CENTER);


        TextField tfRegnr = new TextField();
        tfRegnr.setPromptText("Reg.Nr");
        tfRegnr.setMinWidth(200);

        TextField tfÅrsmodell = new TextField();
        tfÅrsmodell.setPromptText("Årsmodell");
        tfÅrsmodell.setMinWidth(200);

        TextField tfBiltype = new TextField();
        tfBiltype.setPromptText("Biltype eks (BMW 3-serie)");
        tfBiltype.setMinWidth(200);

        TextField tfKmstand = new TextField();
        tfKmstand.setPromptText("Km-stand");
        tfKmstand.setMinWidth(200);

        Label regLabel = new Label();
        regLabel.setText("");
        regLabel.setId("regLabel");
        regLabel.setMinWidth(300);

        ComboBox<String> cbKjørelengde = new ComboBox<String>();
        cbKjørelengde.setEditable(false);
        cbKjørelengde.setMinWidth(200);
        cbKjørelengde.getItems().addAll(
                "Kjørelengde: 8 000 km",
                "Kjørelengde: 15 000 km",
                "Kjørelengde: 20 000 km",
                "Kjørelengde: 30 000 km",
                "Kjørelengde: Ubegrenset"
        );
        cbKjørelengde.setValue("Velg Kjørelengde:");

        ComboBox<String> cbBonus = new ComboBox<String>();
        cbBonus.setEditable(false);
        cbBonus.setMinWidth(200);
        cbBonus.getItems().addAll(
                "Bonus: -20%",
                "Bonus: -10%",
                "Bonus: 0%",
                "Bonus: 10%",
                "Bonus: 20%",
                "Bonus: 30%",
                "Bonus: 40%",
                "Bonus: 50%",
                "Bonus: 60%",
                "Bonus: 70%",
                "Bonus: 75%",
                "Bonus: 75% + 1år",
                "Bonus: 75% + 2år",
                "Bonus: 75% + 3år",
                "Bonus: 75% + 4år",
                "Bonus: 75% + 5år"
        );
        cbBonus.setValue("Velg Bonus:");

        ComboBox<String> cbEgenandel = new ComboBox<String>();
        cbEgenandel.setEditable(false);
        cbEgenandel.setMinWidth(200);
        cbEgenandel.getItems().addAll(
                "Egenandel:  5 000,-",
                "Egenandel:  7 000,-",
                "Egenandel: 10 000,-",
                "Egenandel: 15 000,-"
        );
        cbEgenandel.setValue("Velg Egenandel:");

        Button btnRegBilforsikring = new Button();
        btnRegBilforsikring.setText("Registrer Bilforsikring");
        btnRegBilforsikring.setId("btnRegBilforsikring");
        btnRegBilforsikring.setMinWidth(200);
        btnRegBilforsikring.setOnAction(e -> {
            System.out.println("Venter på en KODE!!! :D");
            regLabel.setText("Bilforsikring Registrert!");
        });

        grid.add(tfRegnr, 0, 0); grid.add(cbKjørelengde, 1, 0);
        grid.add(tfÅrsmodell, 0, 1); grid.add(cbBonus, 1, 1);
        grid.add(tfBiltype, 0, 2); grid.add(cbEgenandel, 1, 2);
        grid.add(tfKmstand, 0, 3); grid.add(btnRegBilforsikring, 1, 3);
        grid.add(regLabel, 0, 4);




        grid.add(lb, 0, 0);

        return grid;
    }
}
