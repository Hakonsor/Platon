package forsikringstest;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.text.html.ListView;


public class Controller {
    private Pattern pattern;
    private Matcher matcher;
    private String tekststreng;
    private String regutrykk = "\\w";
    
   

    @FXML
    private Label output_kunde;

    @FXML
    private TextField kundenr;

    @FXML
    private PasswordField passwordField_kunde;

    @FXML
    private Label output_konsulent;

    @FXML
    private TextField brukernavn;

    @FXML
    private PasswordField passwordField_konsulent;
    
    @FXML
    private TextField fornavn, etternavn, personnr, telefon, epost, adresse;

    @FXML
    private void kunde_reg(ActionEvent event) throws Exception {
    
        /*tekststreng = fornavn.getText();
        pattern = Pattern.compile(regutrykk);
        matcher = pattern.matcher(tekststreng);*/
        System.out.println( (new Kunde(fornavn.getText(), etternavn.getText() , adresse.getText(), personnr.getText())).toString());
        
               
        
        
    
    }
    @FXML
    private void logginAction_kunde(ActionEvent event) throws Exception {
        if (kundenr.getText().equals("test") && passwordField_kunde.getText().equals("test")) {


            output_kunde.setText("Riktig!");
            kundenr.setText("");
            passwordField_kunde.setText("");

            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parent = FXMLLoader.load(getClass().getResource("KundeSide.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            //stage.setMaxWidth(350);
            //stage.setMaxHeight(500);
            stage.setScene(scene);
            stage.setTitle("Kundeside");
            stage.show();

        }
        else {
            output_kunde.setText("Kundenr eller Passord er feil!");
            kundenr.setText("");
            passwordField_kunde.setText("");
        }
    }

    @FXML
    private void logginAction_konsulent(ActionEvent event) throws Exception {
        if (brukernavn.getText().equals("test") && passwordField_konsulent.getText().equals("test")) {
            output_konsulent.setText("Riktig");
            brukernavn.setText("");
            passwordField_konsulent.setText("");
        }
        else {
            output_konsulent.setText("Brukernavn eller Passord er feil!");
            brukernavn.setText("");
            passwordField_konsulent.setText("");
        }
    }


    @FXML
    private void regKunde(ActionEvent event) throws Exception {
        //((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("RegistrerKunde.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        //stage.setMaxWidth(350);
        //stage.setMaxHeight(500);
        stage.setScene(scene);
        stage.setTitle("Registrer Kunde");
        stage.show();
    }

    @FXML
    private void regKonsulent(ActionEvent event) throws Exception {
        //((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("RegistrerKonsulent.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        //stage.setMaxWidth(350);
        //stage.setMaxHeight(500);
        stage.setScene(scene);
        stage.setTitle("Registrer Konsulent");
        stage.show();
    }

    @FXML
    private void loggut(ActionEvent event) throws Exception {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        //stage.setMaxWidth(350);
        //stage.setMaxHeight(500);
        stage.setScene(scene);
        stage.setTitle("Logg inn");
        stage.show();
    }



    @FXML
    private void konsulent_reg(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("BARETULL"));
    }

}
