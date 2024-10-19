package io.github.znemux.chrono;

import com.formdev.flatlaf.FlatDarkLaf;
import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI extends javax.swing.JFrame {

    public GUI() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listFrame = new javax.swing.JFrame();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        nameField = new javax.swing.JTextField();
        listButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();

        listFrame.setTitle(IOUtils.APP_NAME + " list");
        listFrame.setLocation(new java.awt.Point(0, 0));
        listFrame.setResizable(false);
        listFrame.setSize(new java.awt.Dimension(480, 320));

        table.setModel(new io.github.znemux.chrono.ChronoTableModel());
        scrollPane.setViewportView(table);

        javax.swing.GroupLayout listFrameLayout = new javax.swing.GroupLayout(listFrame.getContentPane());
        listFrame.getContentPane().setLayout(listFrameLayout);
        listFrameLayout.setHorizontalGroup(
            listFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        listFrameLayout.setVerticalGroup(
            listFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameField.setText("Task");
        if (Main.CHRONO.existsSave())
        nameField.setText(Main.CHRONO.getName());

        listButton.setText("View list");
        listButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listButtonActionPerformed(evt);
            }
        });

        startButton.setText(START_TEXT);
        if (Main.CHRONO.existsSave())
        startButton.setText(STOP_TEXT);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(listButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        switch (startButton.getText()) {
            case START_TEXT -> {
                try {
                    startButton.setText(STOP_TEXT);
                    Main.start(nameField.getText());
                } catch (IOException ex) {
                    GuiUtils.showExceptionMessage(this, ex);
                    startButton.setText(STOP_TEXT);
                }
            }
            case STOP_TEXT -> {
                try {
                    Main.stop();
                    startButton.setText(START_TEXT);
                } catch (IOException ex) {
                    GuiUtils.showExceptionMessage(this, ex);
                    startButton.setText(STOP_TEXT);
                }
            }
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void listButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listButtonActionPerformed
        listFrame.setLocationRelativeTo(this);
        listFrame.setVisible(true);
    }//GEN-LAST:event_listButtonActionPerformed
    
    public static void main() {
        /* Set the FlatDarkLaf look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
             ex.printStackTrace();
        }
        /* Create and display the form */
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            GUI gui = new GUI();
            gui.setTitle(IOUtils.APP_NAME);
            gui.setLocationRelativeTo(null);
            gui.setVisible(true);
        });
    }
    
    public static final String START_TEXT = "Start";
    public static final String STOP_TEXT = "Stop";

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton listButton;
    private javax.swing.JFrame listFrame;
    private javax.swing.JTextField nameField;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton startButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
