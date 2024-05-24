/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.basededatos.dominio.tabla;

import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioIgual;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.Esquema;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author oscar.guasch.ruiz
 */
public class myTablaTest {

    public static void main(String[] args) {
        Esquema esq = new Esquema();
        FilaDatos f = new FilaDatos();
        f.put("clave2", "0");
        f.put("clave", "valosr");
        FilaDatos f2 = new FilaDatos();
        f.put("clave2", "0");
        f.put("clave", "valor");
        Tabla tabla = new Tabla("tabla", esq);
        try {
            tabla.anyade(f);
            tabla.anyade(f2);
        } catch (ValorClaveUnicaException e) {
            System.out.println("ClaveUnica");
        } catch (ClaveInexistenteException e) {
            System.out.println("NoExisteClave");

        }
    }
}
