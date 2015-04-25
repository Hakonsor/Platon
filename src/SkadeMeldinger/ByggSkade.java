/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

/**
 *klassen gjelder forsikring på både bolig og fritidsbolig
 * @author Therese
 */
public class ByggSkade extends SkadeMelding {
    
    ByggSkade(){
        
    }
    public ByggSkade(String skadeBeskrivelse , int utbetal){
        super( skadeBeskrivelse , utbetal);
    }
    
}
