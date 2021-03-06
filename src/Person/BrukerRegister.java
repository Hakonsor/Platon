/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Håkon
 */
public class BrukerRegister implements Serializable {

    private Map<String, Bruker> register;

    public BrukerRegister() {
        register = new HashMap<>();
    }

    public List<Kunde> søkeResultater(String fornavn, String etternavn, String kundernr) {
        List<Kunde> liste = new ArrayList<>();
        Kunde kunde;
        Bruker bruker = register.get(kundernr);
        if (bruker != null && bruker instanceof Kunde) {
            liste.add((Kunde) bruker);
            return liste;
        }
        for (Map.Entry<String, Bruker> e : register.entrySet()) {
            if (e.getValue() instanceof Kunde) {
                kunde = (Kunde) e.getValue();
                if (kunde.getFornavn().equals(fornavn)||kunde.getFornavn().equalsIgnoreCase(fornavn)) {
                    liste.add(kunde);
                } else if (kunde.getEtternavn().equals(etternavn) || (kunde.getEtternavn().equalsIgnoreCase(etternavn) )) {
                    liste.add(kunde);
                }
            }
        }
        return liste;
    }

    public Kunde getKunde(String id) {
        Bruker b = register.get(id);
        if (b instanceof Kunde) {
            return (Kunde) b;
        }
        return null;
    }


    public Bruker getBruker(String nøkkel) {
        return register.get(nøkkel);
    }

    public void registrerBruker(Bruker b) {
        register.put(b.getNøkkel(), b);
    }

    public boolean inneholderBruker(String kundenr) {
        return register.containsKey(kundenr);
    }

    public Bruker getKonsulent(String nøkkel) {
        return (Konsulent) register.get(nøkkel);
    }

    public String getSisteBruker() {
        Kunde k = (Kunde)register.get(Integer.toString(Kunde.getStaticKundeNr()));
        
        return k.toString();
    }

}
