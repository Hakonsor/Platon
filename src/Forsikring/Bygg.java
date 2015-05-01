/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forsikring;

import java.io.Serializable;

/**
 *
 * @author Therese
 */
abstract class Bygg extends Forsikringer implements Serializable{
    protected double kvadrat;
    protected String adresse;
    protected String boligType;
    protected String byggeår;
    protected String materiale;
    protected String standard;
    protected double byggSum;
    protected double innboSum;
    
    public Bygg(boolean ok,double kvadrat, String adresse, String boligType, String byggeÅr,
                  String materiale, String standard, double byggSum, double innboSum){
        
    this.kvadrat = kvadrat;
    this.adresse = adresse;
    this.boligType = boligType;
    this.byggeår= byggeÅr;
    this.materiale= materiale;
    this.standard= standard;
    this.byggSum = byggSum;
    this.innboSum = innboSum;
        
    }
}
