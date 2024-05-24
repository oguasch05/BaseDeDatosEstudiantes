package edu.upc.etsetb.poo.basededatos.dominio.tabla;

import edu.upc.etsetb.poo.basededatos.dominio.esquema.Esquema;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Clase que representa una fila de datos dentro de una {@link Tabla}. Cada fila
 * de datos es un conjunto de claves-valor, cuya clave representa el nombre de
 * una columna, y el valor será el contenido de esa columna para la fila dada
 *
 */
public class FilaDatos {

    /**
     * Mapa de parejas [nombre de clave, valor de la clave] para la fila de
     * datos
     */
    private Map<String, String> clavesValor;

    /**
     * Constructor sin argumentos que crea un nuevo mapa clavesValor vacío.
     */
    public FilaDatos() {
        clavesValor = new HashMap<>();
        //throw new UnsupportedOperationException("FilaDatos::FilaDatos() no implementado.");
    }

    /**
     * Añade un par [nombre declave,valor] al mapa de la fila de datos
     *
     * @param nombreClave Nombre de la nombreClave (columna de la {@link Tabla}
     * donde se añadirá)
     * @param valor Valor que tendrá la columna para la fila dada
     */
    public void put(String nombreClave, String valor) {
        clavesValor.put(nombreClave, valor);
        //throw new UnsupportedOperationException("FilaDatos::put(nombreClave,valor) no implementado.");
    }

    /**
     * Retorna el valor correspondiente a una nombreClave en la fila de datos si
     * existe una clave con ese nombre.
     *
     * @param nombreClave Nombre de la nombreClave (columna de la {@link Tabla}
     * para la fila en cuestión)
     * @return Valor de la columna para la fila dada si existe una clave con el
     * nombre igual al parámetro; devuelve null en caso contrario
     */
    public String get(String nombreClave) {
        return clavesValor.get(nombreClave);
        //throw new UnsupportedOperationException("FilaDatos::get(nombreClave) no implementado.");
    }

    /**
     * Comprueba si la fila es válida para dicho esquema. Una fila NO será
     * válida:
     * <ol>
     * <li><p>
     * Si el número de columnas de la fila NO COÍNCIDE con el número de campos
     * del esquema, O</p></li>
     * <li><p>
     * si el número de columnas de la fila COÍNCIDE con el número de campos del
     * esquema Y hay alguna clave en la fila cuyo nombre no está definido como
     * clave dentro del {@link Esquema} pasado como parámetro</p></li>
     * </ol>
     * Si la fila es válida para el esquema pasado como argumento, el método
     * acaba sin problemas (no devuelve nada). Si la fila NO es válida para el
     * esquema pasado como argumento, el método lanza una excepción
     * {@link ClaveInexistenteException}, creada pasándole a su constructor el
     * nombre de la clave en la que se ha detectado el problema.
     *
     * @param esquema El {@link Esquema} sobre el que validar la fila.
     * @throws ClaveInexistenteException si la fila de datos tiene alguna clave
     * cuyo nombre no existe en el esquema pasado por parámetro.
     */
    public void valida(Esquema esquema) throws ClaveInexistenteException, ValorClaveUnicaException {
        if (esquema.getNumCampos() != clavesValor.size()) {
            throw new ClaveInexistenteException("Size does not coincide");
        } else {
            Iterator<String> it = clavesValor.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                if (esquema.contieneClave(key) == false) {
                    throw new ClaveInexistenteException(key);
                }
            }
        }
        //throw new UnsupportedOperationException("FilaDatos::valida(esquema) no implementado.");
    }

    /**
     * Comprueba si este objeto FilaDatos es igual al objeto FilaDatos pasado
     * como argumento para que lo utilice el corrector: NO MODIFICAR.
     *
     * @param obj el otro objeto FilaDatos
     * @return true si este este objeto FilaDatos es igual al objeto FilaDatos,
     * pasado como argumento, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FilaDatos other = (FilaDatos) obj;
        return Objects.equals(this.clavesValor, other.clavesValor);
    }

    public String clavesTexto() {
        StringBuilder str = new StringBuilder();

        Iterator<String> it = clavesValor.keySet().iterator();
        while (it.hasNext()) {
            String clave = it.next();
            str.append(clave+"="+clavesValor.get(clave)+" ");
        }
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }

    /**
     * Devuelve un String con los datos del objeto FilaDatos para que lo use el
     * corrector; NO MODIFICAR
     *
     * @return String con los datos del objeto FilaDatos
     */
    @Override
    public String toString() {
        return "FilaDatos{" + "clavesValor=" + clavesValor + '}';
    }
}
