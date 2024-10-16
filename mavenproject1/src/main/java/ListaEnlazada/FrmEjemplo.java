package ListaEnlazada;


import java.util.Stack;
import javax.swing.JOptionPane;


public class FrmEjemplo extends javax.swing.JFrame {

     ListaEnlazada lista = new ListaEnlazada();

        
    public FrmEjemplo() {
        initComponents();
        lista = new ListaEnlazada();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtSalida = new javax.swing.JTextArea();
        btnGenerar = new javax.swing.JButton();
        btnMostrar = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnMostarPila = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtSalida.setColumns(20);
        txtSalida.setRows(5);
        jScrollPane1.setViewportView(txtSalida);

        btnGenerar.setText("Agregar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar Tarea");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnMostarPila.setText("Mostras Pila");
        btnMostarPila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostarPilaActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGenerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsertar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMostarPila)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGenerar)
                    .addComponent(btnMostrar)
                    .addComponent(btnInsertar)
                    .addComponent(btnEliminar)
                    .addComponent(btnMostarPila)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
    String nombreTarea = JOptionPane.showInputDialog("Ingrese el nombre de la tarea:");
    String prioridadStr = JOptionPane.showInputDialog("Ingrese la prioridad (número entero):");
    
    try {
        int prioridad = Integer.parseInt(prioridadStr);
        lista.agregarTarea(nombreTarea, prioridad); // Agregar tarea con prioridad
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido para la prioridad.");
    }
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
     String tarea = JOptionPane.showInputDialog(null, "Ingresa el nombre de la tarea:");
    String posicionStr = JOptionPane.showInputDialog(null, "Posición a insertar (0 para inicio):");
    int posicion = Integer.parseInt(posicionStr);  // Convertir la posición a entero
    lista.insertarTareaEnPosicion(tarea, posicion);  // Insertar tarea en la posición específica
    txtSalida.setText("Tarea '" + tarea + "' insertada en la posición " + posicion + ".");
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        txtSalida.setText(lista.imprimirTareas());
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String tareaEliminar = JOptionPane.showInputDialog(null, "Ingrese el nombre de la tarea a eliminar:");
    txtSalida.setText(lista.eliminar(tareaEliminar)); 
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMostarPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostarPilaActionPerformed
        Stack<String> pilaOrdenada = new Stack<>();

    // Ordenar las tareas en la lista por prioridad
    lista.ordenarPorPrioridad();  // Ordenar la lista por prioridad
    while (!lista.isEmpty()) {
        String tarea = lista.eliminarPrimera();  // Eliminar la tarea de la lista
        pilaOrdenada.push(tarea);  // Agregar la tarea a la pila
    }

    // Mostrar la pila
    StringBuilder sb = new StringBuilder();
    while (!pilaOrdenada.isEmpty()) {
        sb.append(pilaOrdenada.pop()).append("\n");  // Mostrar la pila en orden
    }
    txtSalida.setText(sb.toString());
    }//GEN-LAST:event_btnMostarPilaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    String prioridadStr = JOptionPane.showInputDialog(null, "Ingrese la prioridad de la tarea a buscar:");
    
    try {
        // Convertir la prioridad ingresada en número
        int prioridadBuscar = Integer.parseInt(prioridadStr);
        
        // Llamar al método en la lista para buscar tareas con esa prioridad
        String resultado = lista.buscarPorPrioridad(prioridadBuscar);
        
        // Mostrar el resultado en el área de texto
        if (resultado != null && !resultado.isEmpty()) {
            txtSalida.setText("Tareas encontradas con prioridad " + prioridadBuscar + ":\n" + resultado);
        } else {
            txtSalida.setText("No se encontraron tareas con la prioridad " + prioridadBuscar + ".");
        }
    } catch (NumberFormatException e) {
        // Manejo de errores en caso de que la prioridad ingresada no sea un número válido
        JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido para la prioridad.");
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    
    
    public void eliminar(){
         String ingresado = JOptionPane.showInputDialog(null, "Nombre a eliminar:");
         txtSalida.setText(lista.eliminar(ingresado));
    }
    public String buscarPorPrioridad(int prioridad) {
    StringBuilder resultado = new StringBuilder();
    
    // Iterar sobre la lista de tareas
    for (int i = 0; i < cantidadTareas; i++) {
        if (tareas[i].getPrioridad() == prioridad) {
            resultado.append("Tarea: ").append(tareas[i].getNombre())
                     .append(" - Prioridad: ").append(tareas[i].getPrioridad()).append("\n");
        }
    }
    
    return resultado.length() > 0 ? resultado.toString() : null;  // Si no se encontraron tareas, retornar null
}

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEjemplo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEjemplo().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnMostarPila;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtSalida;
    // End of variables declaration//GEN-END:variables
}
