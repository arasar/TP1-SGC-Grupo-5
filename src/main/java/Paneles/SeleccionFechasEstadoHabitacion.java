
package Paneles;

import static Gestores.GestorHabitaciones.getInstanceHabitaciones;
import Validaciones.FechasEstadoHabitaciones;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class SeleccionFechasEstadoHabitacion extends javax.swing.JDialog {
    private String titulo;
    
    public SeleccionFechasEstadoHabitacion(javax.swing.JFrame parent, boolean modal, String titulo) {
        initComponents();
        this.setTitle("Estado de Habitaciones");
        this.setLocationRelativeTo(null);
        this.titulo = titulo;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fechaHastaField = new com.toedter.calendar.JDateChooser();
        fechaDesdeField = new com.toedter.calendar.JDateChooser();
        siguienteBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Fecha desde *");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Seleccione las fechas");

        jLabel4.setText("Fecha hasta *");

        siguienteBtn.setText("Siguiente");
        siguienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(siguienteBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(fechaHastaField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(158, 158, 158)
                    .addComponent(fechaDesdeField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(314, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaHastaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBtn)
                    .addComponent(siguienteBtn))
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addComponent(fechaDesdeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(141, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteBtnActionPerformed
        //Se validan las fechas ingresadas
        Date fechaDesde = fechaDesdeField.getDate();
        Date fechaHasta = fechaHastaField.getDate();
        FechasEstadoHabitaciones fechasValidas = getInstanceHabitaciones().validarFechas(fechaDesde, fechaHasta);

        if(!fechasValidas.getValidos()){
            //Si no son validas, obtenemos los mensajes de error
            List<String> mensajesError = new ArrayList();

            String camposIncompletos = "Error en campo ?. Ingrese una fecha.";
            if(!fechasValidas.getFechaDesdeValido()){
                fechaDesdeField.setBorder(BorderFactory.createLineBorder(Color.RED));
                String error = camposIncompletos.replace("?", "FechaDesde");
                mensajesError.add(error);
            }
            else{
                fechaDesdeField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }

            if(!fechasValidas.getFechaHastaValido()){
                fechaHastaField.setBorder(BorderFactory.createLineBorder(Color.RED));
                String error = camposIncompletos.replace("?", "FechaHasta");
                mensajesError.add(error);
            }
            else{
                fechaHastaField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }

            if(!fechasValidas.getDesdeMenorAHasta()){
                fechaDesdeField.setBorder(BorderFactory.createLineBorder(Color.RED));
                fechaHastaField.setBorder(BorderFactory.createLineBorder(Color.RED));

                String error = "Fechas incorrectas. 'Fecha Hasta' debe ser mayor a 'Fecha Desde'.";
                mensajesError.add(error);
            }

            //Mostramos el mensaje de error
            String mensaje = "";
            for(String m : mensajesError){
                mensaje +="- "+ m + "\n";
            }
            JOptionPane.showMessageDialog(this, mensaje, "Error al completar los datos",JOptionPane.ERROR_MESSAGE);
        }
        else{
            this.dispose();
            new MostrarEstadoHabitaciones(null,true,fechaDesdeField.getDate(), fechaHastaField.getDate(), titulo, null).setVisible(true);
        }
    }//GEN-LAST:event_siguienteBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        Object[] opciones = {"SI","NO"};
        int confirmacion = JOptionPane.showOptionDialog(this, "¿Desea salir?","Mostrar Estado Habitaciones",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null,opciones,null);
        if(confirmacion == JOptionPane.OK_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_cancelarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private com.toedter.calendar.JDateChooser fechaDesdeField;
    private com.toedter.calendar.JDateChooser fechaHastaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton siguienteBtn;
    // End of variables declaration//GEN-END:variables
}
