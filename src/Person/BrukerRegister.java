/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Håkon
 */
    public class BrukerRegister implements Serializable{


    private Map<String, Bruker> register = new HashMap<>();
    
    public BrukerRegister(){
        
    }
    public List<Kunde> søkeResultater(String fornavn, String etternavn, String kundernr) {
        List<Kunde> liste = new ArrayList<>();
        Kunde kunde;
        if (register.containsKey(kundernr)) {
            liste.add((Kunde) register.get(kundernr));
            return liste;
        }
        for (Map.Entry<String, Bruker> e : register.entrySet()) {
            if (e.getValue() instanceof Kunde) {
                kunde = (Kunde) e.getValue();
                if (kunde.getFornavn().equals(fornavn)) {
                    liste.add(kunde);
                } else if (kunde.getEtternavn().equals(etternavn)) {
                    liste.add(kunde);
                }
            }
        }
        return liste;
    }
    

    public Kunde getKunde(String id) {
        return (Kunde) register.get(id);
    }
    public Bruker getBruker(String nøkkel) {
        return register.get(nøkkel);
    }
    public void registrerBruker( Bruker b) {
        register.put(b.getNøkkel(), b);
    }

    public boolean inneholderBruker(String kundenr) {
       return register.containsKey(kundenr);
    }
    
    
    
    
}
