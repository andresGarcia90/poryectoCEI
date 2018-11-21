/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantico;

import java.util.ArrayList;

/**
 *
 * @author andi
 */
public class DecVars extends Sentencia {

    private ArrayList<Variable> variables;
    private Tipo tipo;

    public DecVars(ArrayList<Variable> variables, Tipo tipo) {
        this.variables = variables;
        this.tipo = tipo;
    }

    @Override
    public void check() throws Exception {

        Unidad m = analizadorsintactico.AnalizadorSintactico.getTs().getUnidadActual();
        for (Variable v : variables) {
            m.agregarVariable(v);
            v.controlDeclaraciones();
        }

        /*
        if(analizadorsintactico.AnalizadorSintactico.getTs().getUnidadActual() instanceof Metodo){
            Metodo n = (Metodo) analizadorsintactico.AnalizadorSintactico.getTs().getUnidadActual();
            for(Variable v : variables){
                m.agregarVariable(v);
                v.controlDeclaraciones();
            }
            //TODO: AGREGAR LAS VARIABLES AL BLOQUE ACTUAL.. o no ;) 
        }
         */
    }

}
