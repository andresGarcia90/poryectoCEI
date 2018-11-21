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
public abstract class Variable {
    protected String nombre;
    protected Tipo tipoVar;
    protected int linea;
    protected int columna;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipoVar() {
        return tipoVar;
    }

    public void setTipoVar(Tipo tipoVar) {
        this.tipoVar = tipoVar;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
        
    public abstract void controlDeclaraciones() throws Exception;
    
}
