/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda;

import edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos;

/**
 *
 * @author oscar.guasch.ruiz
 */
public class CriterioTest {

    public static void main(String[] args) {
        FilaDatos f = new FilaDatos();
        f.put("clave2", "0");
        f.put("clavee", "valosr");
        CriterioIgual criterio = new CriterioIgual("clave", "valor");
        System.out.println(criterio.esCumplido(f));
    }
}
