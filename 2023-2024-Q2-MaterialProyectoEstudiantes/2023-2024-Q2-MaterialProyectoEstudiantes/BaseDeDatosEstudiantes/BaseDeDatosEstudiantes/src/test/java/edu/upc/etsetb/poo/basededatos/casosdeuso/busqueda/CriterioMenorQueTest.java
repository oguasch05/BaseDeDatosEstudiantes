/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda;

import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.basededatos.dominio.tabla.*;
import edu.upc.etsetb.poo.corrector.TestAll;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class CriterioMenorQueTest extends SuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    public CriterioMenorQueTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        System.out.println("\nCorrigiendo clase CriterioMenorQue.");
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "CriterioMenorQue");
        nota.put("CriterioMenorQue", puntosTotales);
        puntosTotales = 0;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01_Constructor() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 1.0;
        int numTests = 6;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            this.printlnAlways("\n\tCriterioMenorQueTest::CriterioMenorQueTest(nombreClave,valorAComprobar). Valor: " + valorTotal);
            double individualPer = valorTotal / numTests;
            String nombreClave = "nombreClave-1";
            String valorAComprobar = "20";            
            CriterioMayorQue instance = new CriterioMayorQue(nombreClave, valorAComprobar);
            //Comprobar atributo 'nombreClave'
            this.checkAttributeAfterConstructor(instance, "nombreClave", nombreClave,
                    valorTotal, individualPer, individualPer, 1);
            //Comprobar atributo 'valorAComprobar'
            this.checkAttributeAfterConstructor(instance, "valorAComprobar", valorAComprobar,
                    valorTotal, individualPer, individualPer, 3);
            // Comprobar atributo 'valorNumericoAComprobar'
            this.checkAttributeAfterConstructor(instance, "valorNumericoAComprobar", 20.0,
                    valorTotal, individualPer, individualPer, 5);
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
    }

    @Test
    public void test02_esCumplido() {
        double valorTotal = 9.0;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        int numTests = 3;
        this.printlnAlways("\n\tCriterioMenorQueTest::esCumplido(filaDatos). Valor: " + valorTotal);
        try {
            FilaDatos fila = this.createFilaDatosValida();
            String nombreClave = "nombreClave-1";
            CriterioMayorQue instance = new CriterioMayorQue(nombreClave, "19.0");
            
            this.printlnAlways("\tTest 1: comprobación cuando la fila de datos tiene "
                    + "mapeado con la clave un valor menor que el valor a comprobar");
            error = this.sAssertTrue(instance.esCumplido(fila), 
                    valorTotal/numTests, "Error. La fila de datos tenía "
                            + "mapeado con la clave un valor mayor que el valor, "
                            + "a comprobar, pero el método ha devuelto false");
            this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 2: comprobación cuando la fila de datos tiene "
                    + "mapeado con la clave un valor mayor que el valor a comprobar");
            instance = new CriterioMayorQue(nombreClave, "21");
            error = this.sAssertFalse(instance.esCumplido(fila), 
                    valorTotal/numTests, "Error. La fila de datos tenía "
                            + "mapeado con la clave un valor menor que el valor a comprobar, "
                            + "pero el método ha devuelto true");
            this.toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 3: comprobación cuando la fila de datos tiene "
                    + "mapeado con la clave un valor igual al valor a comprobar");
            instance = new CriterioMayorQue(nombreClave, "20");
            error = this.sAssertFalse(instance.esCumplido(fila), 
                    valorTotal/numTests, "Error. La fila de datos tenía "
                            + "mapeado con la clave un valor igual al valor a comprobar, "
                            + "pero el método ha devuelto true");
            this.toThrow(error, toThrow);
            
         } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
    }


    private FilaDatos createFilaDatosValida() {
        FilaDatos fila = new FilaDatos();
        for (int i = 0; i < 5; i++) {
            fila.put("nombreClave-" + (i + 1), "" + (i + 20.0));
        }
        return fila;
    }

}
