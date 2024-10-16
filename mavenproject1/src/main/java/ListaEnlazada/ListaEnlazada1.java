package ListaEnlazada;

public class ListaEnlazada1 {

    private Nodo cabeza;
    private int cantidadTareas;

    public ListaEnlazada1() {
        this.cabeza = null;
        this.cantidadTareas = 0;
    }

    // Agregar tarea al final de la lista
    public void agregarTarea(String nombre, int prioridad) {
        Tarea nuevaTarea = new Tarea(nombre, prioridad);
        Nodo nuevoNodo = new Nodo(nuevaTarea);

        if (cabeza == null) {
            cabeza = nuevoNodo; // Si la lista está vacía, el nuevo nodo se convierte en la cabeza
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente; // Recorremos hasta el último nodo
            }
            temp.siguiente = nuevoNodo; // Insertamos el nuevo nodo al final de la lista
        }
        cantidadTareas++;
    }

    // Insertar tarea en una posición específica
    public void insertarTareaEnPosicion(String nombre, int prioridad, int posicion) {
        if (posicion < 0 || posicion > cantidadTareas) {
            System.out.println("Posición inválida");
            return;
        }

        Tarea nuevaTarea = new Tarea(nombre, prioridad);
        Nodo nuevoNodo = new Nodo(nuevaTarea);

        if (posicion == 0) {
            // Insertar al inicio
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                temp = temp.siguiente;
            }
            nuevoNodo.siguiente = temp.siguiente;
            temp.siguiente = nuevoNodo;
        }
        cantidadTareas++;
    }

    // Eliminar tarea por nombre
    public String eliminar(String nombre) {
        if (cabeza == null) {
            return "Lista vacía";
        }

        if (cabeza.tarea.getNombre().equals(nombre)) {
            cabeza = cabeza.siguiente;
            cantidadTareas--;
            return "Tarea eliminada";
        }

        Nodo temp = cabeza;
        while (temp.siguiente != null && !temp.siguiente.tarea.getNombre().equals(nombre)) {
            temp = temp.siguiente;
        }

        if (temp.siguiente == null) {
            return "Tarea no encontrada";
        }

        temp.siguiente = temp.siguiente.siguiente;
        cantidadTareas--;
        return "Tarea eliminada";
    }

    // Mostrar todas las tareas
    public String imprimirTareas() {
        if (cabeza == null) {
            return "Lista vacía";
        }

        StringBuilder sb = new StringBuilder();
        Nodo temp = cabeza;
        while (temp != null) {
            sb.append(temp.tarea.toString()).append("\n");
            temp = temp.siguiente;
        }
        return sb.toString();
    }

    // Buscar tareas por prioridad
    public String buscarPorPrioridad(int prioridad) {
        if (cabeza == null) {
            return "Lista vacía";
        }

        StringBuilder resultado = new StringBuilder();
        Nodo temp = cabeza;
        while (temp != null) {
            if (temp.tarea.getPrioridad() == prioridad) {
                resultado.append(temp.tarea.toString()).append("\n");
            }
            temp = temp.siguiente;
        }
        if (resultado.length() == 0) {
            return "No se encontraron tareas con esa prioridad";
        }
        return resultado.toString();
    }

    // Borrar la lista
    public void borrarLista() {
        cabeza = null;
        cantidadTareas = 0;
    }

    public int getCantidadTareas() {
        return cantidadTareas;
    }
}

