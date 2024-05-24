package edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda;

import edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos;

/**
 * Para valores que pueden convertirse a números (por ejemplo, mediante el
 * método {@link Double#parseDouble(String)}, esta clase los compara y comprueba
 * que el valor buscado en una fila dada es menor al {@link #valorAComprobar}
 * (cuyo valor numérico convertimos en {@link #valorNumericoAComprobar}
 */
public class CriterioMenorQue extends Criterio {

    /**
     * Conversión a número del atributo de la superclase
     * {@link Criterio#valorAComprobar}
     */
    private double valorNumericoAComprobar;

    /**
     * {@inheritDoc}
     */
    public CriterioMenorQue(String nombreClave, String valorAComprobar) {
        super(nombreClave, valorAComprobar);
        valorNumericoAComprobar = Double.parseDouble(valorAComprobar);
    }

    /**
     * <p>
     * Convierte a número el valor la propiedad de la {@link FilaDatos} cuyo
     * nombreClave es igual al atributo {@link #nombreClave} (usando el método
     * {@link Double#parseDouble(String)})</p>
     *
     * <p>
     * Luego lo compara con {@link #valorNumericoAComprobar} y devuelve 'true'
     * si es menor que este último</p>
     *
     * <p>
     * Si el valor de la propiedad {@link FilaDatos} cuyo nombreClave es igual
     * al atributo {@link #nombreClave} no se puede convertir a número (porque
     * tiene caracteres no numéricos y el método
     * {@link Double#parseDouble(String)} nos lanza una
     * {@link NumberFormatException}, no se compara nada y se devuelve
     * directamente 'false'.</p>
     *
     * @param f Fila sobre la cual comprobar si se cumple el criterio
     * @return true si el criterio se cumple. false en caso contrario
     */
    @Override
    public boolean esCumplido(FilaDatos f) {
        try {
            double clave = Double.parseDouble(f.get(nombreClave));
            boolean d = Double.compare(clave, valorNumericoAComprobar) < 0;
            return d;
        } catch (NumberFormatException e) {
            return false;
        }
        //throw new UnsupportedOperationException("CriterioMenorQue::esCumplido(f) no implementado.");
    }
}