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
public class TipoArregloChar extends TipoArreglo {

    public TipoArregloChar(Token tok) {
        linea = tok.getLineNumber();
        columna = tok.getColumNumber();
        nombre = "arregloChar";

    }

    @Override
    public boolean esCompatible(TipoBase t) throws Exception {
        if(t.getNombre().equals(this.nombre) || t.getNombre().equals("null")) {
			return true;
		}
		return false;
    }
    
    @Override
    public boolean check() {
        return true;
    }

}
