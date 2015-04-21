package GUI;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;


/**
 * Created by Magnus on 21.04.15.
 */


public class KundeSide {

    static Stage vindu = new Stage();
    KundesideInfo info;
    public static void Display() {

        Group root = new Group();
        Scene scene = new Scene(root, 800, 640);

        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Fil");

        MenuItem left = new MenuItem("Logg ut");
        menu.getItems().addAll(left);
        left.setOnAction(e -> {
            vindu.hide();
        });


        menuBar.getMenus().add(menu);

        BorderPane borderPane = new BorderPane();

        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setTop(menuBar);

        TabPane tabPane = new TabPane();

        //Info
        Tab tabInfo = new Tab();
        tabInfo.setText("Informasjon");
        tabInfo.setClosable(false);
        KundesideInfo info = new KundesideInfo();
        tabInfo.setContent(info.infoFane());

        //Båtforsikring
        Tab tabBåt = new Tab();
        tabBåt.setText("Båtforsikring");
        tabBåt.setClosable(false);
        KundesideBåt båt = new KundesideBåt();
        tabBåt.setContent(båt.båtFane());

        //Reiseforsikring
        Tab tabReise = new Tab();
        tabReise.setText("Reiseforsikring");
        tabReise.setClosable(false);
        KundesideReise reise = new KundesideReise();
        tabReise.setContent(reise.reiseFane());

        //Bilforsikring
        Tab tabBil = new Tab();
        tabBil.setText("Bilforsikring");
        tabBil.setClosable(false);
        KundesideBil bil = new KundesideBil();
        tabBil.setContent(bil.bilFane());

        //Boligforsikring
        Tab tabBolig = new Tab();
        tabBolig.setText("Boligforsikring");
        tabBolig.setClosable(false);
        KundesideBolig bolig = new KundesideBolig();
        tabBolig.setContent(bolig.boligFane());

        //Fri.Boligforsikring
        Tab tabFriBolig = new Tab();
        tabFriBolig.setText("Fritids-boligforsikring");
        tabFriBolig.setClosable(false);
        KundesideFribolig fribolig = new KundesideFribolig();
        tabFriBolig.setContent(fribolig.friboligFane());


        tabPane.getTabs().addAll(tabInfo, tabBåt, tabReise, tabBil, tabBolig, tabFriBolig);

        borderPane.setCenter(tabPane);

        root.getChildren().add(borderPane);

        vindu.setTitle("Kundeside");
        vindu.setScene(scene);
        scene.getStylesheets().add("CSS/kundeside.css");
        vindu.show();
    }


}//End of class