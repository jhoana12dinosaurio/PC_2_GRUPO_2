/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author jhoan
 */
public class ListaEnlazada {
        private NodoTareas cabeza;
 // Método para agregar una tarea al final de la lista
    public void agregarTarea(String tarea, int prioridad) {
        NodoTareas nuevoNodo = new NodoTareas(tarea, prioridad);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoTareas actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        System.out.println("Tarea '" + tarea + "' con prioridad " + prioridad + " agregada.");
    }
}
