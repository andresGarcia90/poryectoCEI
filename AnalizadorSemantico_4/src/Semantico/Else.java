/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantico;

import Token.Token;

/**
 *
 * @author andi
 */
public class Else extends If{
    
    private Sentencia sen2;
    
    public Else(Token tok, NodoExp exp, Sentencia sen, Sentencia sen2) {
        super(tok, exp, sen);
        this.sen2 = sen2;
    }

    public Sentencia getSen2() {
        return sen2;
    }

    public void setSen2(Sentencia sen2) {
        this.sen2 = sen2;
    }
    
    
     public void check() throws Exception {
         
        if(!exp.check().getNombre().equals("boolean")){
            throw new Exception("El tipo de la expresion dentro del if en la linea "+ linea+ " no es de tipo boolean");
        }
        sen.check();
        sen2.check();
    }
            
    
    
}
