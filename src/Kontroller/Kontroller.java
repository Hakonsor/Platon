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
import Person.Konsulent;
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
import java.util.Locale;
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
    private Bruker innloggetKonsulent = null;
    private SkadeMeldingRegister skademeldingregister = new SkadeMeldingRegister();
    private ForsikringsRegister forsikringsregister = new ForsikringsRegister();
    private RegKonsulent regKonsulent;
    private Sok sok;
    private KonsulentSide nyKunsulentSide;
    private KundeSide nyside;
    private Registrer regVindu;
    private infoMelding infoSkjerm;

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
        regKonsulent = new RegKonsulent(new Stage(), this);
    }

    public void infoSkjerm() {
        infoSkjerm = new infoMelding(new Stage(), this);
    }

    public void sok() {
        sok = new Sok(new Stage(), this);
    }

    // legger skade i skademeldingskøen. slik at den kan bli behandlet av konsulenten.
    public void addSkade(SkadeMelding skade) {
        skademeldingregister.leggIKø(skade);
    }

    public ArrayList<SkadeMelding> getSkadeMelding(Forsikringer f) {
        return skademeldingregister.getSkadeMelding(f.getClass(), innLoggetBruker);
    }

    public void konsulentSide(Stage primaryStage) {
        nyKunsulentSide = new KonsulentSide(primaryStage, this);
    }

    public void kundeSide(Stage primaryStage) {
        nyside = new KundeSide(primaryStage, this);
    }

    public void regVindu() {
        regVindu = new Registrer(new Stage(), this);
    }

    // setter reiseforsikringen i registeret
    public void setReiseForsikring(Forsikringer forsikring) {
        try {
            Kunde kunde = (Kunde) innLoggetBruker;
            forsikringsregister.settInn(kunde, forsikring);
        } catch (ClassCastException cce) {
            System.out.println("Innlogget kunde er ikke av type kunde");
        }
    }

    //båt forsikring, oppretter båtforsikring og setter den inn i registeret
    public void setBåtForsikring(BatForsikring båt) {

        try {
            Kunde kunde = (Kunde) innLoggetBruker;
            forsikringsregister.settInn(kunde, båt);
        } catch (ClassCastException cce) {
            System.out.println("Innlogget kunde er ikke av type kunde");
        }
    }

    // bolig forsikring, metode som oppretter boligforsikringer og setter de inn i registeret.
    public void setBoligForsikring(boolean utLeie, double kvadrat, String adresse, String boligType, int byggeår,
            String materiale, String standard, double byggSum, double inboSum) {

        try {
            Kunde kunde = (Kunde) innLoggetBruker;
            System.out.println("innlogget bruker");
            forsikringsregister.settInn(kunde, new BoligForsikring(utLeie, kvadrat, adresse, boligType, byggeår, materiale, standard, byggSum, inboSum));
        } catch (ClassCastException cce) {

            System.out.println("Feil med bruker");
        }

    }

    //FritidsForsikring, metode som oppretter fritidsbolig forsikringer og setter de inn i registeret.
    public void setFritidsForsikring(boolean utLeie, double kvadrat, String adresse, String boligType, int byggeår,
            String materiale, String standard, double byggSum, double inboSum) {
        try {
            Kunde kunde = (Kunde) innLoggetBruker;
            System.out.println("innlogget bruker");
            forsikringsregister.settInn(kunde, new FritidsBolig(utLeie, kvadrat, adresse, boligType, byggeår, materiale, standard, byggSum, inboSum));
        } catch (ClassCastException cce) {
            System.out.println("Feil med bruker");
        }

    }
// Bilforsikring, oppretter bilforsikringsobjekter og setter de inn i registeret.

    public void setBilForsikring(BilForsikring bil, Person person) {
        Kunde kunde = null;
        try {
            kunde = (Kunde) innLoggetBruker;

            //  forsikringsregister.settInn(kunde,);
        } catch (ClassCastException cce) {
            System.out.println(" Innlogget kunde er ikke av type kunde");
        }

        if (kunde != null) {
            forsikringsregister.settInn(kunde, bil);
            if (person != null) {
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

    // metode som henter indexen på køen av skademeldinger til behandling.
    public int visSkadeIndex() {
        return skademeldingregister.visIndex();
    }

    // flytter skademeldingen til registeret når den er behandlet. 
    public void ferdigBehandlet(SkadeMelding skade) {
        skademeldingregister.flyttTilRegister(skade);
    }

    //Bruker
    public void setInnloggetBruker(String nøkkel) {

        Bruker bruker = brukerRegister.getBruker(nøkkel);
        if (bruker instanceof Kunde) {
            innLoggetBruker = brukerRegister.getKunde(nøkkel);
        } else if (bruker instanceof Konsulent) {
            innloggetKonsulent = brukerRegister.getKonsulent(nøkkel);
        }

    }

    public Bruker getInnloggetBruker() {
        return innLoggetBruker;
    }

    public Bruker getInnloggetKonsulent() {
        return innloggetKonsulent;
    }

    public Bruker finnBruker(String Bruker) {
        return brukerRegister.getBruker(Bruker);
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
            Forsikringer.setStaticPolisenr(innfil.readInt());
            SkadeMelding.setStaticSkadeNr(innfil.readInt());
            Kunde.setStaticKundeNr(innfil.readInt());
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
            utfil.writeInt(Forsikringer.getStaticPolisenr());
            utfil.writeInt(SkadeMelding.getStaticSkadeNr());
            utfil.writeInt(Kunde.getStaticKundeNr());

        } catch (NotSerializableException nse) {
            System.out.println("Objektet er ikke serialisert!");
        } catch (FileNotFoundException ioe) {
            System.out.println("Finner ikke fil");
        } catch (IOException ioe) {
            System.out.println("Problem med utskrift til fil." + ioe.toString());
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
        if (k == null) {
            return null;
        }
        List a = forsikringsregister.finnForsikring(k, i);

        if (a == null || a.isEmpty()) {
            return null;
        }
        String infoliste = "";
        ArrayList<String> liste = new ArrayList<>();
        Iterator<? extends Forsikringer> iterator = a.iterator();

        if (i == 0) {
            while (iterator.hasNext()) {
                Forsikringer f = iterator.next();
                if (f.getAktiv()) {
                    liste.add(Integer.toString(f.getPoliseNr()));
                }
            }
        } else if (a.get(0) instanceof BilForsikring) {
            while (iterator.hasNext()) {
                BilForsikring b = (BilForsikring) iterator.next();
                if (b.getAktiv()) {
                    infoliste = b.getPoliseNr() + " Regnr: " + b.getRegNr();
                    liste.add(infoliste);
                }
            }
            return liste;
        } else if (a.get(0) instanceof BatForsikring) {
            while (iterator.hasNext()) {
                BatForsikring b = (BatForsikring) iterator.next();
                if (b.getAktiv()) {
                    liste.add(Integer.toString(b.getPoliseNr()) + " Regnr: " + b.getRegNr());
                }
            }
        } else if (a.get(0) instanceof BoligForsikring) {
            while (iterator.hasNext()) {
                BoligForsikring b = (BoligForsikring) iterator.next();
                if (b.getAktiv()) {
                    liste.add(Integer.toString(b.getPoliseNr()) + " Adresse: " + b.getAdresse());
                }
            }
        } else if (a.get(0) instanceof FritidsBolig) {
            while (iterator.hasNext()) {
                FritidsBolig b = (FritidsBolig) iterator.next();
                if (b.getAktiv()) {
                    liste.add(Integer.toString(b.getPoliseNr()) + " Adresse: " + b.getAdresse());
                }
            }
        } else if (a.get(0) instanceof ReiseForsikring) {
            while (iterator.hasNext()) {
                ReiseForsikring b = (ReiseForsikring) iterator.next();
                if (b.getAktiv()) {
                    liste.add(Integer.toString(b.getPoliseNr()) + " " + b.getType());
                }
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

    public void slettForsikring(int polisnr) {
        forsikringsregister.fjernForsikring(polisnr);
    }

//Statistikk konsulentsiden___________________________________________________________________
// metodene finner inntekter for et år
    public double finnInntekterReiseFors(int aar) {
        return forsikringsregister.finnInntekterReiseFors(aar);
    }

    // finner Inntekter boligforsikring
    public double finnInntekterBoligForsikring(int aar) {
        return forsikringsregister.finnInntekterReiseFors(aar);
    }
//  finner inntekter fritidsbolig

    public double finnInntekterFritidsBolig(int aar) {
        return forsikringsregister.finnInntekterFritidsBolig(aar);
    }
// finner inntekter båt

    public double finnInntekterBåt(int aar) {
        return forsikringsregister.finnInntekterBåt(aar);
    }
// finner inntekter bil

    public double finnInntekterBil(int aar) {
        return forsikringsregister.finnInntekterBil(aar);
    }
// finner den totale inntekten for alle forsikringer

    public double finnInntekterAlleForsikringer(int aar) {
        return forsikringsregister.finnInntekterAlleFors(aar);
    }
//____________slutt inntekt per år____________________________________

    //Utgifter per år____________________________________________________
    // finner utgifter på bilforsikringer
    public double finnUtgiftBil(int år) {
        return skademeldingregister.finnUtgiftBil(år);
    }

    // finner utgifter på båt.
    public double finnUtgiftBåt(int år) {
        return skademeldingregister.finnUtgiftBåt(år);
    }

    //finner utgifter på bolig
    public double finnUtgiftBolig(int år) {
        return skademeldingregister.finnUtgiftBolig(år);
    }

    //finner utgifter på fritidsbolig
    public double finnUtgiftFritid(int år) {
        return skademeldingregister.finnUtgiftFritid(år);
    }

    // finner utgifter på reise
    public double finnUtgiftReise(int år) {
        return skademeldingregister.finnUtgiftReise(år);
    }

    // finner totale utgifter for et gitt år
    public double finnUtgiftTotal(int år) {
        return skademeldingregister.finnUtgiftTotal(år);
    }

    public boolean sjekkPassordKunde(String bruker, String passord) {
        Bruker sjekkBruker = finnBruker(bruker);
        if (sjekkBruker == null || sjekkBruker instanceof Konsulent) {
            return false;
        }
        return sjekkBruker.sjekkPassord(passord);
    }

    public boolean sjekkPassordKonsulent(String bruker, String passord) {
        Bruker sjekkBruker = finnBruker(bruker);
        if (sjekkBruker == null || sjekkBruker instanceof Kunde) {
            return false;
        }
        System.out.println("konsulentS");
        return sjekkBruker.sjekkPassord(passord);
    }

    public void opptaterListeKonsulent() {
        nyKunsulentSide.opptatterListeKunde();
    }

    public List<SkadeMelding> gotGodkjentListe(int år) {
        return skademeldingregister.finnGodkjentListe(år);
    }

    public String getsisteKunde() {
        return brukerRegister.getSisteBruker();
    }

}// end of class kontroller

