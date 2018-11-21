/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author andi
 */
public class GenCode {

    public static String path;
    private static GenCode gc;
    private int labelNbr = 0;
    private PrintWriter printWriter;

    public GenCode() {
        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter(path)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static GenCode gen() {
        if (gc == null) {
            gc = new GenCode();
        }

        return gc;
    }

    public void nl() {
        printWriter.println();
    }

    public void comment(String c) {
        printWriter.println("# " + c);
    }

    public void write(String c) {
        printWriter.println(c);
    }

    public void close() {
        printWriter.close();
    }

    public String genLabel() {
        return "l" + labelNbr++;
    }

    public void inicioUnidad() {
        printWriter.println("LOADFP # Guardo enlace dinamico");
        printWriter.println("LOADSP # Inicializo FP");
        printWriter.println("STOREFP");
        printWriter.println();
    }

}
