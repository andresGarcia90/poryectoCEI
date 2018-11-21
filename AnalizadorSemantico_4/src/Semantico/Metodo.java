/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantico;

import Token.Token;
import analizadorsintactico.*;
import java.util.HashMap;

/**
 *
 * @author andi
 */
public class Metodo extends Unidad {

    private String formaMetodo;
    private TipoBase retorno;
    private boolean checkeado;
    private boolean tieneReturn;

    public Metodo(Token token, String fm, TipoBase retorno) {
        nombre = token.getLexema();
        linea = token.getLineNumber();
        columna = token.getColumNumber();
        params = new HashMap<String, Parametro>();
        vars = new HashMap<String, Variable>();
        cuerpo = null;
        formaMetodo = fm;
        this.retorno = retorno;
        tieneReturn = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarParametro(Token token, Tipo tipo) throws Exception {
        if (!params.containsKey(token.getName())) {
            params.put(token.getLexema(), new Parametro(token.getLexema(),token.getLineNumber(), token.getColumNumber(), params.size()));
        } else {
            Unidad m = AnalizadorSintactico.getTs().getUnidadActual();
            throw new Exception("Error Semantico: Ya existe un parametro con ese nombre en : " + m.getLinea());
        }
    }

    public void agregarVariable(Variable v) throws Exception {
        if (!vars.containsKey(v.getNombre())) {
            vars.put(v.getNombre(), v);
        } else {
            throw new Exception("La variable " + v.getNombre() + " de la linea " + v.getLinea() + " ya fue creada en " + vars.get(v.getNombre()).getLinea());
        }
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
/*
    public void eliminarVar(String v) {
        vars.remove(v);
    }
*/
    public String getFormaMetodo() {
        return formaMetodo;
    }

    public void setFormaMetodo(String formaMetodo) {
        this.formaMetodo = formaMetodo;
    }

    public TipoBase getRetorno() {
        return retorno;
    }

    public void setRetorno(TipoBase retorno) {
        this.retorno = retorno;
    }

    public boolean isCheckeado() {
        return checkeado;
    }

    public void setCheckeado(boolean checkeado) {
        this.checkeado = checkeado;
    }

    public boolean getTieneReturn() {
        return tieneReturn;
    }

    public void setTieneReturn(boolean tieneReturn) {
        this.tieneReturn = tieneReturn;
    }
    
    

    public Parametro getParametro(int nro) {
        for (Parametro p : params.values()) {
            if (p.getPosicion() == nro) {
                return p;
            }
        }
        return null;
    }

    public Parametro getParametro(String s) {
        return params.get(s);
    }

    @Override
    public void controlDeclaraciones() throws Exception {
        if (!retorno.check()) {
            throw new Exception("Error Semantico: Tipo invalido en el metodo " + nombre);
        }
        for (Parametro p : params.values()) {
            p.controlDeclaraciones();
            vars.put(p.getNombre(), p);

        }
    }

 
    public void chequearSentencias() throws Exception{
        if(analizadorsintactico.AnalizadorSintactico.getTs().getClaseActual().getNombre().equals(this.declaradoEn.getNombre())){
            if(cuerpo != null){
                cuerpo.check();
            }
        }
    }
}
