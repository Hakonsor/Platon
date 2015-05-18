/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import java.io.Serializable;
import java.util.Calendar;

/**
 *Inneholder det som er unikt for boligskademelding, foreløpig
 * er deet bare en melding
 * @author Therese
 */
public class BoligSkadeMelding extends ByggSkade implements Serializable {

    

    public BoligSkadeMelding(String skadeBeskrivelse, int utbetal, Calendar skadeDato) {
        super(skadeBeskrivelse, utbetal, skadeDato);

    }
    
    // denne meldingen vises i vinduet for skadebehandleren
    public String melding(){
        String s;
        s = "Boligskademelding \nInnmeldt av\t :" +  super.getForsikring().getKunde().getFornavn() +" "+super.getForsikring().getKunde().getEtternavn()+"\n"
                + super.toString();
        
        return s;
    }

}
