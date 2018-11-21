/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantico;

import Token.Token;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author andi
 */
public class TablaSimbolos {

    private Clase claseActual;
    private Unidad unidadActual;
    private Bloque bloqueActual;
    boolean mainDeclarado = false;

    private static Map<String, Clase> clases;

    public TablaSimbolos() {
        clases = new HashMap<String, Clase>();
        agregarObject();
        try {
            agregarSystem();
        } catch (Exception ex) {
           // System.out.println("Error Semantico: No se pudo crear la clase System");
        }
    }

    private void agregarObject() {
        Clase c = new Clase(new Token("idClase", "Object", 0, 0));
        clases.put("Object", c);
        c.setActualizado(true);
        c.setVisitado(true);
    }

    private void agregarSystem() throws Exception {
        Clase c = new Clase(new Token("idClase", "System", 0, 0));
        c.setHereda("Object");
        c.agregarConstructor(new Token("idClase", "System", 0, 0));
        clases.put("System", c);
        
        Metodo m = new Metodo(new Token("idMetVar", "read", 0, 0), "static", new Int(0, 0));
        c.agregarMetodo(m);

        m = new Metodo(new Token("idMetVar", "printB", 0, 0), "static", new Void2());
        m.agregarParametro(new Token("", "b", 0, 0), new Bool(0, 0));
        c.agregarMetodo(m);

        m = new Metodo(new Token("idMetVar", "printC", 0, 0), "static", new Void2());
        m.agregarParametro(new Token("", "c", 0, 0), new Char(0, 0));
        c.agregarMetodo(m);

        m = new Metodo(new Token("idMetVar", "printI", 0, 0), "static", new Void2());
        m.agregarParametro(new Token("", "i", 0, 0), new Int(0, 0));
        c.agregarMetodo(m);

        m = new Metodo(new Token("idMetVar", "printS", 0, 0), "static", new Void2());
        m.agregarParametro(new Token("", "s", 0, 0), new TipoString(0, 0));
        c.agregarMetodo(m);

        m = new Metodo(new Token("idMetVar", "println", 0, 0), "static", new Void2());
        c.agregarMetodo(m);

        m = new Metodo(new Token("idMetVar", "printBln", 0, 0), "static", new Void2());
        m.agregarParametro(new Token("", "b", 0, 0), new Bool(0, 0));
        c.agregarMetodo(m);

        m = new Metodo(new Token("idMetVar", "printCln", 0, 0), "static", new Void2());
        m.agregarParametro(new Token("", "c", 0, 0), new Char(0, 0));
        c.agregarMetodo(m);

        m = new Metodo(new Token("idMetVar", "printIln", 0, 0), "static", new Void2());
        m.agregarParametro(new Token("", "i", 0, 0), new Int(0, 0));
        c.agregarMetodo(m);

        m = new Metodo(new Token("idMetVar", "printSln", 0, 0), "static", new Void2());
        m.agregarParametro(new Token("", "s", 0, 0), new TipoString(0, 0));
        c.agregarMetodo(m);

    }

    public boolean estaClase(String clase) {
        return clases.containsKey(clase);
    }

    public void agregarClase(Clase c) {
        //if(!clases.containsKey(c.getNombre()))
        clases.put(c.getNombre(), c);
        claseActual = c;
    }

    public Clase getClaseActual() {
        return claseActual;
    }

    public void setClaseActual(Clase claseActual) {
        this.claseActual = claseActual;
    }

    public Unidad getUnidadActual() {
        return unidadActual;
    }

    public void setUnidadActual(Unidad unidadActual) {
        this.unidadActual = unidadActual;
    }

    public Clase getClase(String clase) {
        return clases.get(clase);
    }

    public boolean isMainDeclarado() {
        return mainDeclarado;
    }

    public void setMainDeclarado(boolean mainDeclarado) {
        this.mainDeclarado = mainDeclarado;
    }

    public Bloque getBloqueActual() {
        return bloqueActual;
    }

    public void setBloqueActual(Bloque bloqueActual) {
        this.bloqueActual = bloqueActual;
    }

    public void chequearDeclaraciones() throws Exception {
        for (Clase c : clases.values()) {
            if (!c.getNombre().equals("Object") && !c.getNombre().equals("System")) {
                c.chequearDeclaraciones();
            }
        }
        if (!isMainDeclarado()) {
            throw new Exception("Error Semantico: No hay ninguna clase con un main declarado");
        }
    }

    public void chequearSentencias() throws Exception {

        for (Clase c : clases.values()) {
            if (!c.getNombre().equals("Object") && !c.getNombre().equals("System")) {
                claseActual = c;
                c.chequearSentencias();
            }
        }
    }

}
