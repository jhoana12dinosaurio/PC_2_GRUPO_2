/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author jhoan
 */
public class pila {
    private ArrayList<NodoTareas> pila; 

    // Constructor
    public pila() {
        this.pila = new ArrayList<>();
    }
 public void apilarPorPrioridad(ListaEnlazada lista) {
        ArrayList<NodoTareas> tareas = new ArrayList<>();
        NodoTareas actual = lista.obtenerCabeza();

        // Extraigo de lista y almaceno en ArrayList
        while (actual != null) {
            tareas.add(actual);
            actual = actual.siguiente;
        }

        // Ordenar el ArrayList por prioridad de mayor a menor
        Collections.sort(tareas, new Comparator<NodoTareas>() {
            public int compare(NodoTareas tarea1, NodoTareas tarea2) {
                return tarea2.prioridad - tarea1.prioridad; // Orden descendente
            }
        });

        // Añadir las tareas en orden al ArrayList de la pila
        for (NodoTareas tarea : tareas) {
            pila.add(tarea); // Añadir a la lista, ordenada por prioridad
        }
        System.out.println("Tareas apiladas según prioridad.");
    }
       // Método para mostrar la pila de tareas
    public void mostrarPila() {
        if (pila.isEmpty()) {
            System.out.println("La pila está vacía.");
            return;
        }
        System.out.println("Pila de Tareas por Prioridad:");
        for (int i = pila.size() - 1; i >= 0; i--) { 
            NodoTareas tarea = pila.get(i);
            System.out.println("Tarea: " + tarea.tarea + ", Prioridad: " + tarea.prioridad);
        }
    }
        public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        lista.agregarTarea("Comprar cebolla", 2);
        lista.agregarTarea("Cocinar chaufa", 1);
        lista.agregarTarea("Terminar proyecto", 3);
        lista.agregarTarea("paneton para el profesor heber", 5);


        lista.mostrarTareas();

        pila pila = new pila();
        pila.apilarPorPrioridad(lista);
        pila.mostrarPila();
    
} 

}
   