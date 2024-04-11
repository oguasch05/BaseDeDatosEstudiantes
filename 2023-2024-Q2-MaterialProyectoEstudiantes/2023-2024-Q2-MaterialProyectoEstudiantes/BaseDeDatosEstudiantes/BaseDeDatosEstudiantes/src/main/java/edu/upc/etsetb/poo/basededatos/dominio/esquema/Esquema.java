package edu.upc.etsetb.poo.basededatos.dominio.esquema;

import java.util.*;

/**
 * Un Esquema indica la estructura de una
 * {@link edu.upc.etsetb.poo.basededatos.dominio.tabla.Tabla}, es decir, qué
 * claves tiene ésta.
 */
public class Esquema {

    /**
     * {@link Map} cuya clave es el nombre de la {@link Clave} y cuyo valor es
     * el objeto {@link Clave} en cuestión.
     */
    private Map<String, Clave> campos;

    /**
     * Instancia un nuevo esquema vacío (sin claves)
     */
    public Esquema() {
        this.campos = new HashMap<>();
        //throw new UnsupportedOperationException("Esquema::Esquema() no implementado.");
    }

    /**
     * Añade una clave al esquema
     *
     * <p>
     * <b>Cambios con respecto a v1:</b></p>
     * <ul>
     * <li><b>Lanza {@link ClaveYaExisteException} en caso de que ya exista una
     * clave con ese nombre en el esquema</b></li>
     * </ul>
     *
     * @param clave clave a añadir al esquema
     * @throws ClaveYaExisteException en caso de que ya exista una clave con ese
     * nombre en el esquema
     *
     */
    public void addClave(Clave clave) throws ClaveYaExisteException {
        if (campos.containsKey(clave.getNombre())) {
            throw new ClaveYaExisteException(clave.getNombre());
        }
        campos.put(clave.getNombre(), clave);
        //throw new UnsupportedOperationException("Esquema::addClave(clave) no implementado.");
    }

    /**
     * Retorna <code>true</code> si el esquema contiene una clave cuyo nombre
     * coincide con el argumento <code>nombre</code>
     *
     * @param nombre nombre de la clave a buscar
     * @return <code>true</code> si el esquema contiene una clave cuyo nombre
     * coincide con el argumento <code>nombre</code>. <code>false</code> en caso
     * contrario
     */
    public boolean contieneClave(String nombre) {
        return campos.containsKey(nombre);
        //throw new UnsupportedOperationException("Esquema::contieneClave(nombre) no implementado.");
    }

    /**
     * Genera y retorna un nuevo iterador a las {@link Clave}s del esquema
     *
     * @return nuevo iterador a las {@link Clave}s del esquema
     */
    public Iterator<Clave> iterator() {
        return campos.values().iterator();
        //throw new UnsupportedOperationException("Esquema::iterator() no implementado.");
    }

    /**
     * Devuelve el número de campos del esquema
     *
     * @return
     */
    public int getNumCampos() {
        return campos.size();
        //throw new UnsupportedOperationException("Esquema::getNumCampos() no implementado.");
    }
}
