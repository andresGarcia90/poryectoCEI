/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantico;

import Token.Token;
import java.util.HashMap;

/**
 *
 * @author andi
 */
public class Ctor extends Unidad {

    private boolean predefinido;

    public Ctor(Token token) {
        nombre = token.getLexema();
        linea = token.getLineNumber();
        columna = token.getColumNumber();
        params = new HashMap<String, Parametro>();
        vars = new HashMap<String, Variable>();
        predefinido = true;
    }

    public boolean isPredefinido() {
        return predefinido;
    }

    public void setPredefinido(boolean predefinido) {
        this.predefinido = predefinido;
    }

    public boolean estaVar(String nombreVar) {
        return vars.containsKey(nombreVar);
    }

    @Override
    public void controlDeclaraciones() throws Exception {

        for (Parametro p : params.values()) {
            p.controlDeclaraciones();
          //  vars.put(p.getNombre(), p);
        }

    }

    
    public void chequearSentencias() throws Exception {
        if (cuerpo != null) {
            cuerpo.check();
        }

    }

}
