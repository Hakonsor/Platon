/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkadeMeldinger;

import Forsikring.Forsikringer;

/**
 *
 * @author Therese
 */
public class PersonSkade extends SkadeMelding{
    
   public PersonSkade(String skadeBeskrivelse , int erstatt , Forsikringer forsikring){
   super(skadeBeskrivelse ,  erstatt , forsikring);
   
   }
    
}
