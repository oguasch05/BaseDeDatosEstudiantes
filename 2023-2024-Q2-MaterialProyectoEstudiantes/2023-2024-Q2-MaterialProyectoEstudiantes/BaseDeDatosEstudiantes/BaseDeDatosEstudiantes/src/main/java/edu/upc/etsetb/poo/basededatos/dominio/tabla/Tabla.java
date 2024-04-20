package edu.upc.etsetb.poo.basededatos.dominio.tabla;

import edu.upc.etsetb.poo.basededatos.casosdeuso.ComparadorFilas;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.Criterio;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.Clave;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.Esquema;
import java.util.*;

/**
 * Una tabla guarda, siguiendo un {@link Esquema} que indica qué columnas tiene
 * dicha tabla, una sucesión de {@link FilaDatos} con los datos almacenados en
 * la base de datos.
 *
 * <p>
 * Cambios respecto a v1:</p>
 * <ul>
 * <li>Algunos métodos tiran excepciones (mirar javadocs)</li>
 * <li>Método "ordena"</li>
 * </ul>
 */
public class Tabla {

    /**
     * Nombre de la tabla
     */
    private String nombre;
    /**
     * Esquema que indica la estructura de la tabla, es decir, qué columnas
     * tiene y si los valores de estas columnas deben ser únicos o no
     */
    private Esquema esquema;

    /**
     * Los datos en cuestión. Cada {@link FilaDatos} indica una entrada en la
     * tabla.
     */
    private List<FilaDatos> filas;

    /**
     * Constructor sin argumentos para el corrector: ¡NO TOCAR!
     */
    public Tabla() {

    }

    /**
     * Intancia una tabla, dado un nombre y un esquema
     *
     * @param nombre nombre de la tabla
     * @param esquema {@link #esquema} de la tabla
     */
    public Tabla(String nombre, Esquema esquema) {
        this.nombre = nombre;
        this.esquema = esquema;
        filas = new LinkedList<>();
        //throw new UnsupportedOperationException("Tabla::Tabla(nombre,esquema) no implementado.");
    }

    /**
     * Añade una fila de datos a la tabla. Devuelve una excepción si no se ha
     * podido insertar, es decir, si ha sucedido uno de estos casos:
     * <ul>
     * <li>La clave única ha sido violada: se ha insertado un dato en una
     * columna marcada como {@link Clave#isUnica()}, y ya existía en la tabla
     * una fila con ese mismo valor</li>
     * <li>El esquema no coincide: la {@link FilaDatos} contiene columnas cuya
     * clave no está definida en el {@link Esquema} de la tabla.</li>
     * </ul>
     *
     * @param datos Fila de datos a insertar
     * @throws ValorClaveUnicaException Si se ha violado la clave única
     * @throws ClaveInexistenteException Si en la fila se define una clave no
     * existente en el esquema
     */
    public void anyade(FilaDatos datos) throws ValorClaveUnicaException, ClaveInexistenteException {

        datos.valida(esquema);
        Iterator<Clave> claves = esquema.iterator();
        while (claves.hasNext()) {
            Clave clave = claves.next();
            String valorAComprobar = datos.get(clave.getNombre());
            if (clave.isUnica()) {
                Iterator<FilaDatos> it1 = filas.iterator();
                while (it1.hasNext()) {
                    FilaDatos next = it1.next();
                    String valor = next.get(clave.getNombre());
                    if(valor!=null&&valor.equals(valorAComprobar)){
                        throw new ValorClaveUnicaException(clave.getNombre(), next.get(clave.getNombre()));
                    }
                }
            }

        }
        filas.add(datos);
        //throw new UnsupportedOperationException("Tabla::anyade(datos) no implementado.");
    }

    /**
     * Devuelve una lista con todas las {@link FilaDatos} de la tabla. Debe ser
     * UNA COPIA de la lista {@link #filas}, no la lista original.
     *
     * @return Devuelve una lista con todas las {@link FilaDatos} de la tabla.
     */
    public List<FilaDatos> buscaTodo() {
        List<FilaDatos> filascopy = filas;
        return filascopy;
        //throw new UnsupportedOperationException("Tabla::buscaTodo() no implementado.");
    }

    /**
     * <p>
     * Devuelve una lista con todas las {@link FilaDatos} de la tabla que
     * cumplen el criterio pasado por parámetro.</p>
     *
     * <p>
     * Si el criterio es <code>null</code>, deberá devolver el mismo resultado
     * que el método {@link #buscaTodo()}</p>
     *
     * @param criterio Criterio que deben cumplir las filas devueltas.
     * @return una lista con todas las {@link FilaDatos} de la tabla que cumplen
     * el criterio pasado por parámetro.
     */
    public List<FilaDatos> busca(Criterio criterio) {
        List<FilaDatos> lista = filas;
        Iterator<FilaDatos> it = lista.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (criterio.esCumplido(it.next())) {
                lista.remove(i);
            }
            i++;
        }
        return lista;
        //throw new UnsupportedOperationException("Tabla::busca(criterio) no implementado.");
    }

    /**
     * <p>
     * Elimina todas las {@link FilaDatos} de la tabla que cumplen el criterio
     * pasado por parámetro.</p>
     *
     * <p>
     * Si el criterio es <code>null</code>, no eliminará nada y devuelve una
     * lista vacía.</p>
     *
     * @param criterio Criterio que deben cumplir las filas eliminadas.
     *
     * @return una lista con todas las {@link FilaDatos} eliminadas de la tabla
     * o una lista vacía si no ha eliminado ninguna.
     */
    public List<FilaDatos> elimina(Criterio criterio) {
        List<FilaDatos> lista = filas;
        Iterator<FilaDatos> it = lista.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!criterio.esCumplido(it.next())) {
                lista.remove(i);
            }
            i++;
        }
        return lista;
        //throw new UnsupportedOperationException("Tabla::elimina(criterio) no implementado.");
    }

    /**
     * Retorna el esquema de la tabla
     *
     * @return el esquema de la tabla
     */
    public Esquema getEsquema() {
        return esquema;
        //throw new UnsupportedOperationException("Tabla::getEsquema() no implementado.");
    }

    /**
     * Retorna una lista con los nombres de las claves de la tabla tal y como
     * aparecen en su esquema
     *
     * @return Una lista con los nombres de las claves de la tabla
     */
    public List<String> getCabeceras() {
        Iterator<Clave> it = esquema.iterator();
        List<String> cabeceras = new LinkedList<>();
        while (it.hasNext()) {
            cabeceras.add(it.next().getNombre());
        }
        return cabeceras;
        //throw new UnsupportedOperationException("Tabla::getCabeceras() no implementado.");
    }

    /**
     * <p>
     * Ordena la lista de filas según una columna dada, en orden ascendente o
     * descendente</p>
     * <p>
     * Para ordenar la lista, podéis usar el método estático
     * {@link Collections#sort(List, Comparator)}, y como instancia de
     * {@link Comparator} a pasarle, debéis usar la clase
     * {@link ComparadorFilas}</p>
     *
     * @param columnaAOrdenar La columna por la cual se debe ordenar la tabla
     * @param ascendente Si se debe ordenar en ascendente o descendente.
     */
    public void ordena(String columnaAOrdenar, boolean ascendente) {
        Comparator<FilaDatos> comparador = new ComparadorFilas(columnaAOrdenar, ascendente);
        Collections.sort(filas, comparador);
        //throw new UnsupportedOperationException("Tabla::ordena(columnaAOrdenar,ascendente) no implementado.");
    }
}
