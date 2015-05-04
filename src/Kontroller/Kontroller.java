/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroller;

import Forsikring.BatForsikring;
import Forsikring.BilForsikring;
import Forsikring.BoligForsikring;
import Forsikring.Forsikringer;
import Forsikring.ForsikringsRegister;
import Forsikring.FritidsBolig;
import Forsikring.ReiseForsikring;
import GUI.KonsulentSide;
import GUI.KundeSide;
import GUI.Login;
import GUI.Registrer;
import GUI.*;
import Person.Bruker;
import Person.BrukerRegister;
import Person.Kunde;
import Person.Person;
import SkadeMeldinger.SkadeMelding;
import SkadeMeldinger.SkadeMeldingRegister;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/*
 *
 * @author hakon_000
 */
public class Kontroller implements EventHandler<ActionEvent> {

    private BrukerRegister brukerRegister = new BrukerRegister();
    private Bruker innLoggetBruker = null;
    private SkadeMeldingRegister skademeldingregister = new SkadeMeldingRegister();
    private ForsikringsRegister forsikringsregister = new ForsikringsRegister();

    public Kontroller(Stage primaryStage) throws Exception {
        primaryStage.getIcons().add(new Image("http://www.tryg.no/media/icon-login_148x120_78-5042.png"));
    }

    //GUI
    public void loginVindu(Stage primaryStage) {
        innLoggetBruker = null;
        try {
            Login login = new Login(primaryStage, this);
        } catch (java.lang.Exception jle) {
            System.out.println("Klarte ikke å åpne logginn vindu!");
        }
    }

    public void regKonsulent() {
        RegKonsulent regKonsulent = new RegKonsulent(new Stage(), this);
    }

    public void sok() {
        Sok sok = new Sok(new Stage(), this);
    }

    // legger skade i skademeldingskøen. slik at den kan bli behandlet av konsulenten.
    public void addSkade(SkadeMelding skade) {
        skademeldingregister.leggIKø(skade);
    }

    public ArrayList<SkadeMelding> getSkadeMelding(Forsikringer f) {
        return skademeldingregister.getSkadeMelding(f.getClass(), innLoggetBruker);
    }

    public void konsulentSide(Stage primaryStage) {
        KonsulentSide nySide = new KonsulentSide(primaryStage, this);
    }

    public void kundeSide(Stage primaryStage) {
        KundeSide nyside = new KundeSide(primaryStage, this);
    }

    public void regVindu() {
        Registrer regVindu = new Registrer(new Stage(), this);
    }

    //Forsikring
    public void setForsikring(Forsikringer forsikring) {
        forsikringsregister.settInn((Kunde) innLoggetBruker, forsikring);
    }

    //båt forsikring
    public void setBåtForsikring(double bonus, double egenandel,
            String regNr, String arsmodell, String modell, String tffot, String motor, int ytelse, String type, Person person) {
        int fot = 0;
        if (person == null) {
            person = innLoggetBruker;
        }

        try {
            fot = Integer.parseInt(tffot);
        } catch (NumberFormatException nfe) {
            System.out.println("Kun heltall er lov!");
            return;
        }
        try {
            Kunde kunde = (Kunde) innLoggetBruker;
            forsikringsregister.settInn(kunde, new BatForsikring(bonus, egenandel, motor, fot, ytelse, regNr, type, modell, arsmodell, person));
        } catch (ClassCastException cce) {
            System.out.println("Innlogget kunde er ikke av type kunde");
        }
    }

    // bolig forsikring
    public void setBoligForsikring(double kvadrat, String adresse, String boligType, int byggeår,
            String materiale, String standard, double byggSum, double inboSum) {
        try {
            Kunde kunde = (Kunde) innLoggetBruker;
            System.out.println("innlogget bruker");
            forsikringsregister.settInn(kunde, new BoligForsikring(kvadrat, adresse, boligType, byggeår, materiale, standard, byggSum, inboSum));
        } catch (ClassCastException cce) {
            System.out.println("Feil med bruker");
        }

    }

    //Forsikring
    public void setFritidsForsikring(double kvadrat, String adresse, String boligType, int byggeår,
            String materiale, String standard, double byggSum, double inboSum) {
        try {
            Kunde kunde = (Kunde) innLoggetBruker;
            System.out.println("innlogget bruker");
            forsikringsregister.settInn(kunde, new FritidsBolig(false, kvadrat, adresse, boligType, byggeår, materiale, standard, byggSum, inboSum));
        } catch (ClassCastException cce) {
            System.out.println("Feil med bruker");
        }

    }

    public void setBilForsikring(BilForsikring bil, Person person) {
            Kunde kunde = null;
            try {
                kunde = (Kunde) innLoggetBruker;
                    
              //  forsikringsregister.settInn(kunde,);

            } catch (ClassCastException cce) {
                System.out.println(" Innlogget kunde er ikke av type kunde");
            }
            
            if (kunde!= null){
                forsikringsregister.settInn(kunde, bil);
                if(person!= null){
                    bil.setPerson(person);
                }
        }
        
    }

    //SkadeMeldingBehandling skadeKonsulent-------------------------------------------
    // henter den første skademeldingen i behandlingskøen
    public SkadeMelding getFørste() {
        return skademeldingregister.getFørste();
    }

    // henter Skademeldingen med gitt index
    public SkadeMelding visNesteIKø() {
        return skademeldingregister.visNesteIKø();
    }

    // henter den forrige skademeldingen
    public SkadeMelding visForrigeIKø() {
        return skademeldingregister.visForrigeIKø();
    }

    public int visSkadeIndex() {
        return skademeldingregister.visIndex();
    }

    // flytter skademeldingen til registeret når den er behandlet. 
    public void ferdigBehandlet(SkadeMelding skade) {
        skademeldingregister.flyttTilRegister(skade);
    }

    //Bruker
    public void setInnloggetBruker(String nokkel) {
        innLoggetBruker = brukerRegister.getKunde(nokkel);
    }

    public Bruker getInnloggetBruker() {
        return innLoggetBruker;
    }

    public Bruker finnBruker(String Bruker) {
        return brukerRegister.getBruker(Bruker);
    }

    public boolean sjekkPassord(String bruker, String passord) {
        Bruker sjekkBruker = finnBruker(bruker);
        if (sjekkBruker == null) {
            return false;
        }
        return sjekkBruker.sjekkPassord(passord);
    }

    //Kunde
    public void registrerBruker(Bruker b) {
        brukerRegister.registrerBruker(b);
    }

    //Filskriving
    public void lesFil() {
        try (ObjectInputStream innfil = new ObjectInputStream(
                new FileInputStream("src/Fil/forsikring.data"))) {
            brukerRegister = (BrukerRegister) innfil.readObject();
            skademeldingregister = (SkadeMeldingRegister) innfil.readObject();
            forsikringsregister = (ForsikringsRegister) innfil.readObject();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Opprette nye registere");
            brukerRegister = new BrukerRegister();
            skademeldingregister = new SkadeMeldingRegister();
            forsikringsregister = new ForsikringsRegister();

        } catch (FileNotFoundException fne) {
            System.out.println("Finner ikke datafil. Oppretter ny fil.\n");
            brukerRegister = new BrukerRegister();
            skademeldingregister = new SkadeMeldingRegister();
            forsikringsregister = new ForsikringsRegister();

        } catch (IOException ioe) {
            System.out.println("Innlesingsfeil. Oppretter ny fil.\n");
            brukerRegister = new BrukerRegister();
            skademeldingregister = new SkadeMeldingRegister();
            forsikringsregister = new ForsikringsRegister();

        }
    }

    public void skrivTilFil() {
        try (ObjectOutputStream utfil = new ObjectOutputStream(
                new FileOutputStream("src/Fil/forsikring.data"))) {
            utfil.writeObject(brukerRegister);
            utfil.writeObject(skademeldingregister);
            utfil.writeObject(forsikringsregister);

        } catch (NotSerializableException nse) {
            System.out.println("Objektet er ikke serialisert!");
        } catch (IOException ioe) {
            System.out.println("Problem med utskrift til fil.");
        }
    }

    @Override
    public void handle(ActionEvent event) {
        // Vi tar i bruk lambda uttrykk istedenfor istedenfor
        // Metodene blir kjøre direkte med <knapp>.setOnAction( e -> regVindu())
    }

    //infosiden
    // Finner alle forsikringene til en gitt kunde, legger i liste, returnerer null hvis kunden ikke har noen forsikring.
    public ArrayList<Forsikringer> finnForsikringListe(int i) {
        Kunde k = (Kunde) innLoggetBruker;
        List a = forsikringsregister.finnForsikring(k, i);
        if (a == null) {
            return null;
        }
        return new ArrayList<>(a);
    }

    // Henter opp en forklaring(liste) på hvilke forsikringer kunden har.
    public ArrayList<String> getInfoForsikringListe(int i) {
        Kunde k = (Kunde) innLoggetBruker;
        List a = forsikringsregister.finnForsikring(k, i);
        if (a == null || a.isEmpty()) {
            return null;
        }

        ArrayList<String> liste = new ArrayList<>();
        Iterator<? extends Forsikringer> iterator = a.iterator();

        if (a.get(0) instanceof BilForsikring) {
            while (iterator.hasNext()) {
                liste.add(Integer.toString(iterator.next().getPoliseNr()));
                //iterator.next().getRegNr()
            }
            return liste;
        } else if (a.get(0) instanceof BatForsikring) {
            while (iterator.hasNext()) {
                liste.add(Integer.toString(iterator.next().getPoliseNr()));
            }
        } else if (a.get(0) instanceof BoligForsikring) {
            while (iterator.hasNext()) {
                liste.add(Integer.toString(iterator.next().getPoliseNr()));
            }
        } else if (a.get(0) instanceof FritidsBolig) {
            while (iterator.hasNext()) {
                liste.add(Integer.toString(iterator.next().getPoliseNr()));
            }
        } else if (a.get(0) instanceof ReiseForsikring) {
            while (iterator.hasNext()) {
                liste.add(Integer.toString(iterator.next().getPoliseNr()));
            }

        }
        return liste;
    }

    // Finner forsikringer basert på poliseNr
    public Forsikringer getForsikring(int parseInt) {
        return forsikringsregister.finnForsPolise(parseInt);
    }

    public List<Kunde> søkeResultater(String fornavn, String etternavn, String kundeNr) {
        return brukerRegister.søkeResultater(fornavn, etternavn, kundeNr);
    }

    public Kunde getKunde(String id) {
        return brukerRegister.getKunde(id);
    }
}
