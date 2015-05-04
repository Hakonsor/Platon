package GUI;

import Kontroller.Kontroller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Created by Magnus on 21.04.15.
 */


public class KundeSide {

    private Kontroller kontroll;

    public KundeSide(Stage primaryStage, Kontroller k){
        this.kontroll = k;

        Group root = new Group();
        Scene scene = new Scene(root, 1024, 768);

        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Fil");

        MenuItem left = new MenuItem("Logg ut");
        menu.getItems().addAll(left);
        left.setOnAction(e -> {
            primaryStage.close();
            kontroll.loginVindu(primaryStage);
        });

        menuBar.getMenus().addAll(menu);

        BorderPane borderPane = new BorderPane();

        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setTop(menuBar);

        TabPane tabPane = new TabPane();

        //Info
        Tab tabInfo = new Tab();
        tabInfo.setText("Min side");
        tabInfo.setClosable(false);
        KundesideInfo info = new KundesideInfo();
        tabInfo.setOnSelectionChanged(e -> {
        tabInfo.setContent(info.infoFane(kontroll));
        });
        //Båtforsikring
        Tab tabBåt = new Tab();
        tabBåt.setText("Båtforsikring");
        tabBåt.setClosable(false);
        KundesideBåt båt = new KundesideBåt();
        tabBåt.setOnSelectionChanged(e -> {
        tabBåt.setContent(båt.båtFane(kontroll));
        });
        
       

        //Reiseforsikring
        Tab tabReise = new Tab();
        tabReise.setText("Reiseforsikring");
        tabReise.setClosable(false);
        KundesideReise reise = new KundesideReise();
        tabReise.setOnSelectionChanged(e -> {
        tabReise.setContent(reise.reiseFane(kontroll));
        });

        //Bilforsikring
        Tab tabBil = new Tab();
        tabBil.setText("Bilforsikring");
        tabBil.setClosable(false);
        KundesideBil bil = new KundesideBil();
        tabBil.setOnSelectionChanged(e -> {
        tabBil.setContent(bil.bilFane(kontroll));
        });

        //Boligforsikring
        Tab tabBolig = new Tab();
        tabBolig.setText("Boligforsikring");
        tabBolig.setClosable(false);
        KundesideBolig bolig = new KundesideBolig();
        tabBolig.setOnSelectionChanged(e -> {
        tabBolig.setContent(bolig.boligFane(kontroll));
        });

        //Fri.Boligforsikring
        Tab tabFriBolig = new Tab();
        tabFriBolig.setText("Fritidsboligforsikring");
        tabFriBolig.setClosable(false);
        KundesideFribolig fribolig = new KundesideFribolig();
        tabFriBolig.setOnSelectionChanged(e -> {
        tabFriBolig.setContent(KundesideFribolig.friboligFane(kontroll));
        });
        //SkadeMelding
        Tab tabSkade = new Tab();
        tabSkade.setText("Skademelding");
        tabSkade.setClosable(false);
        KundesideSkade skade = new KundesideSkade();
        tabSkade.setOnSelectionChanged(e -> {
        tabSkade.setContent(skade.skadeFane(kontroll));
        });
        


        tabPane.getTabs().addAll(tabInfo, tabBåt, tabReise, tabBil, tabBolig, tabFriBolig, tabSkade);

        borderPane.setCenter(tabPane);

        root.getChildren().add(borderPane);

        primaryStage.setTitle("Kundeside");
        primaryStage.setScene(scene);
        scene.getStylesheets().add("CSS/kundeside.css");
        primaryStage.show();
    }



}//End of class
