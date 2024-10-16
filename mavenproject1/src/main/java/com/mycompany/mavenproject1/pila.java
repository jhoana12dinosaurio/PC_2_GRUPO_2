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
class pila {
    private ArrayList<NodoTareas> pila; 

    // Constructor
    public pila() {
        this.pila = new ArrayList<>();
    }
  public void apilarPorPrioridad(ListaEnlazada lista) {
        ArrayList<NodoTareas> tareas = new ArrayList<>();
        NodoTareas actual = lista.obtenerCabeza();

        // extraigo de lista y almaceno en pila :v
        while (actual != null) {
            tareas.add(actual);
            actual = actual.siguiente;
        }

        // Ordenar el ArrayList por prioridad de mayor a menor :v
        Collections.sort(tareas, new Comparator<NodoTareas>() {
            public int compare(NodoTareas tarea1, NodoTareas tarea2) {
                return tarea2.prioridad - tarea1.prioridad; // Orden descendente
            }
        });
  // elementos al revez
        for (NodoTareas tarea : tareas) {
            pila.add(tarea); // En lugar de usar push, simplemente añadimos a la lista
        }
        System.out.println("Tareas apiladas según prioridad.");
    }
                public void mostrarPila() {
        if (pila.isEmpty()) {
            System.out.println("La pila está vacía.");
            return;
        }
        System.out.println("Pila de Tareas por Prioridad:");
        for (int i = pila.size() - 1; i >= 0; i--) { // Mostrar desde el último elemento (simulando LIFO)
            NodoTareas tarea = pila.get(i);
            System.out.println("Tarea: " + tarea.tarea + ", Prioridad: " + tarea.prioridad);
        }
    }
}
            
