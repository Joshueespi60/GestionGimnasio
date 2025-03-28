/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package capadeinterfaz;

import capadeentidades.Membresia;
import capadenegocio.MembresiaNegocio;
import com.toedter.calendar.JDateChooser;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
/**
 *
 * @author Joshue
 */
public class GestionMembresias extends javax.swing.JFrame {
    
     private MembresiaNegocio membresiaNegocio = new MembresiaNegocio();
    /**
     * Creates new form GestionMembresias
     */
    public GestionMembresias() {
        initComponents();
        setLocationRelativeTo(null);
        cargarClientesEnTabla();
        
        cmbMembresia.setModel(new DefaultComboBoxModel<>(new String[] {"Mensual", "Trimestral", "Anual"}));
        
        btnRegistrar.addActionListener(evt -> registrarMembresia());
        btnCancelar.addActionListener(evt -> cancelarMembresia());
        btnVolver.addActionListener(evt -> volverAlMenuPrincipal());
    }
    private void cargarClientesEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblClientesMembresia.getModel();
        modelo.setRowCount(0);

        List<Membresia> lista = membresiaNegocio.obtenerClientesConMembresia();
        for (Membresia m : lista) {
            modelo.addRow(new Object[]{m.getIdCliente(), m.getNombre(), m.getApellido(), m.getTelefono(),
                                       m.getTipoMembresia(), m.getFechaInicio(), m.getFechaVencimiento()});
        }
    
}

private void registrarMembresia() {
    int fila = tblClientesMembresia.getSelectedRow(); // Cambié jScrollPane1 por tblClientesMembresia
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un cliente");
        return;
    }

    int idCliente = (int) tblClientesMembresia.getValueAt(fila, 0); // Cambié jScrollPane1 por tblClientesMembresia
    String tipo = cmbMembresia.getSelectedItem().toString();
    Date fechaInicio = dcFechaInicio.getDate();
    Date fechaVencimiento = dcFechaVencimiento.getDate();

    Membresia nueva = new Membresia(idCliente, tipo, fechaInicio, fechaVencimiento);
    if (membresiaNegocio.registrarMembresia(nueva)) {
        JOptionPane.showMessageDialog(this, "Membresía registrada");
        cargarClientesEnTabla();
    }
}

    private void cancelarMembresia() {
    int fila = tblClientesMembresia.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un cliente");
        return;
    }

    int idCliente = (int) tblClientesMembresia.getValueAt(fila, 0);
    if (membresiaNegocio.cancelarMembresia(idCliente)) {
        JOptionPane.showMessageDialog(this, "Membresía cancelada");
        cargarClientesEnTabla();
    }
    } 
    private void volverAlMenuPrincipal() {
    this.dispose(); // Cierra la ventana actual
    MenuPrincipal menu = new MenuPrincipal(); // Crea una nueva instancia del menú
    menu.setVisible(true); // Muestra la ventana del menú
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbMembresia = new javax.swing.JComboBox<>();
        dcFechaInicio = new com.toedter.calendar.JDateChooser();
        dcFechaVencimiento = new com.toedter.calendar.JDateChooser();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientesMembresia = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbMembresia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMembresia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMembresiaActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnRegistrar.setText("REGISTRAR");

        btnCancelar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnCancelar.setText("CANCELAR");

        btnVolver.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnVolver.setText("VOLVER");

        tblClientesMembresia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Teléfono", "Membresía", "Fecha Inicio", "Fecha Vencimiento"
            }
        ));
        jScrollPane1.setViewportView(tblClientesMembresia);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setText("MEMBRESIAS");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setText("FECHA INICIO");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setText("FECHA FIN");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel4.setText("MEMBRESIA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(jLabel4)
                        .addGap(183, 183, 183)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(cmbMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(500, 500, 500)
                        .addComponent(dcFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(dcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbMembresia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dcFechaVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMembresiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMembresiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMembresiaActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbMembresia;
    private com.toedter.calendar.JDateChooser dcFechaInicio;
    private com.toedter.calendar.JDateChooser dcFechaVencimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientesMembresia;
    // End of variables declaration//GEN-END:variables
}
