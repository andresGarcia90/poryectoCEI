/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantico;

/**
 *
 * @author andi
 */
public class Char extends TipoPrimitivo {

    public Char(int l, int c) {
        linea = l;
        columna = c;
        nombre = "char";
    }

    
    @Override
    public boolean esCompatible(TipoBase t) throws Exception {
        if(t.getNombre().equals(this.nombre)) {
			return true;
		}
		return false;
    }

    @Override
    public boolean check() {
        return true;
    }
    
}
