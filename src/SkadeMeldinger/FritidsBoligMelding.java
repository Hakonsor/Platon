/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import java.io.Serializable;

/**
 *
 * @author Therese
 */
public class FritidsBoligMelding extends ByggSkade implements Serializable {



    public FritidsBoligMelding(String skadeBeskrivelse, int utbetal) {
        super(skadeBeskrivelse, utbetal);
        
    }

}