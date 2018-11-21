/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantico;

import Token.Token;
import analizadorsintactico.AnalizadorSintactico;

/**
 *
 * @author andi
 */
class IdIzquierdo {

    private Token id;
    private IdIzqEncadenado enc;

    public IdIzquierdo(Token id, IdIzqEncadenado enc) {
        this.id = id;
        this.enc = enc;
    }

    public Token getId() {
        return id;
    }

    public void setId(Token id) {
        this.id = id;
    }

    public IdIzqEncadenado getEnc() {
        return enc;
    }

    public void setEnc(IdIzqEncadenado enc) {
        this.enc = enc;
    }

    public TipoBase check() throws Exception {
        Clase c = AnalizadorSintactico.getTs().getClaseActual();
        Unidad m = AnalizadorSintactico.getTs().getUnidadActual();
        String nombreVar = id.getLexema();
        Variable v;
        TipoBase aux;

        //En caso de que sea variable de instancia del metodo
        if (m.getVars().containsKey(nombreVar)) {
            v = m.getVars().get(nombreVar);
            aux = new TipoClase(id.getLineNumber(), id.getColumNumber(), id.getLexema());
        } else {
            //En caso de que sea variable de clase.
            if (c.getVariables().containsKey(nombreVar)) {
                v = c.getVariables().get(nombreVar);
                aux = new TipoClase(id.getLineNumber(), id.getColumNumber(), id.getLexema());
            } else {
                throw new Exception("La variable del lado izquierdo, no pertenece al metodo " + m.getNombre() + "o a la clase " + c.getNombre() + " en la linea " + id.getLineNumber());
            }
        }
        
        if(enc!= null){
            return enc.check(aux);
        }
        
        return v.getTipoVar();
    }
}
