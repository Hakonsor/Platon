package GUI;


import Kontroller.Kontroller;
import Person.Bruker;
import Person.Kunde;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import static javafx.geometry.Pos.TOP_CENTER;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 * Created by Magnus on 20.04.15.
 */

public class Registrer {
    
    private final String LoginBilde = "Bilder/add_user.png";
    
    private final Button btnRegKunde;
    private final Label nyKunde;
    private final TextField fornavn;
    private final TextField etternavn;
    private final TextField personnr;
    private final TextField telefon;
    private final TextField epost;
    private final TextField adresse;
    private final PasswordField velgpassord;
    private final PasswordField gjentapassord;
    private static Stage vindu;
  
    
    public Button getBtnRegKunde(){
    return btnRegKunde;
    }
    public Kunde getKunde(){
        if(velgpassord.getText().equals(gjentapassord.getText())){
            return new Kunde(fornavn.getText(), etternavn.getText(), adresse.getText(), personnr.getText(), telefon.getText(),  velgpassord.getText() );
        } else {
            System.out.println("Todo popommelding i register getbruker");
        //pop opp melding hvis ordene ikke er like
        }
    return null;
    
    }
    public Registrer(Stage vindu, Kontroller kontroll)  {
        this.vindu = vindu;

        GridPane grid = new GridPane();
        grid.setAlignment(TOP_CENTER);
        //grid.setGridLinesVisible(true);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(40));

        ImageView loginImg = new ImageView(new Image(LoginBilde));
        loginImg.setId("loginImg");
        loginImg.setPreserveRatio(true);
        loginImg.setFitWidth(100);
        GridPane.setHalignment(loginImg, HPos.CENTER);

        nyKunde = new Label();
        nyKunde.setText("Ny Kunde");
        nyKunde.setId("nykunde");
        GridPane.setHalignment(nyKunde, HPos.CENTER);

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

        personnr = new TextField();
        personnr.setPromptText("Personnr");
        personnr.setId("personnr");
        personnr.setMaxWidth(200);
        GridPane.setHalignment(personnr, HPos.CENTER);

        telefon = new TextField();
        telefon.setPromptText("Telefon");
        telefon.setId("telefon");
        telefon.setMaxWidth(200);
        GridPane.setHalignment(telefon, HPos.CENTER);

        epost = new TextField();
        epost.setPromptText("E-Post");
        epost.setId("epost");
        epost.setMaxWidth(200);
        GridPane.setHalignment(epost, HPos.CENTER);

        adresse = new TextField();
        adresse.setPromptText("Adresse");
        adresse.setId("adresse");
        adresse.setMaxWidth(200);
        GridPane.setHalignment(adresse, HPos.CENTER);

        velgpassord = new PasswordField();
        velgpassord.setPromptText("Velg Passord");
        velgpassord.setId("velgpassord");
        velgpassord.setMaxWidth(200);
        GridPane.setHalignment(velgpassord, HPos.CENTER);

        gjentapassord = new PasswordField();
        gjentapassord.setPromptText("Gjenta Passord");
        gjentapassord.setId("gjentapassord");
        gjentapassord.setMaxWidth(200);
        GridPane.setHalignment(gjentapassord, HPos.CENTER);

        btnRegKunde = new Button("Registrer Kunde");
        btnRegKunde.setId("btNyKunde");
        btnRegKunde.setMaxWidth(200);
        btnRegKunde.setOnAction(e -> {
            kontroll.registrerKunde(this.getKunde());
            vindu.close();
        });


        GridPane.setHalignment(btnRegKunde, HPos.CENTER);

        grid.add(loginImg, 0, 0);
        grid.add(nyKunde,0 ,1);
        grid.add(fornavn, 0, 2);
        grid.add(etternavn, 0, 3);
        grid.add(personnr, 0, 4);
        grid.add(telefon, 0, 5);
        grid.add(epost, 0, 6);
        grid.add(adresse, 0, 7);
        grid.add(velgpassord, 0, 8);
        grid.add(gjentapassord, 0, 9);
        grid.add(btnRegKunde, 0, 10);


        Scene scene = new Scene(grid, 300, 550);
        vindu.setTitle("Registrer");
        vindu.setScene(scene);
        scene.getStylesheets().add("CSS/registrer.css");
        vindu.show();
    }
/*
    public String getnyKunde(){
        
    return nyKunde;
    } 
    
    public String getFornavn(){
    return fornavn;
    } 
    
    public String getEtternavn(){
    return null;
    } 
    
    public String getPersonnr(){
    return null;
    } 
    
    public String getTelefon(){
    return null;
    } 
    
    public String getEpost(){
    return null;
    } 
    
    public String getAdresse(){
    return null;
    } 
    
    public String getVelgpassord(){
    return null;
    } 
    
    public String getGjentapassord(){
    return null;
    } 
      */


}//End of class
