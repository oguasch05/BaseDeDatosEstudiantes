package edu.upc.etsetb.poo.basededatos.dominio;

/**
 * Excepción genérica para errores de la base de datos
 */
public class BaseDatosException extends Exception {
    public BaseDatosException() {
    }

    public BaseDatosException(String message) {
        System.out.println(message);
    }
}
