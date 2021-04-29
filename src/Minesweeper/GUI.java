package Minesweeper;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

public class GUI extends javax.swing.JFrame {

    private MinesweeperBoard board;
    
    public GUI() {
        initComponents();
        setSize(600, 600);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plButtons = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minesweeper");

        plButtons.setLayout(new java.awt.GridLayout(3, 3));
        getContentPane().add(plButtons, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem3.setText("Speichern");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSave(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Laden");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLoad(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem1.setText("Beenden");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem2.setText("Größe ändern");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSizeChange(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onSizeChange(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSizeChange
        int rows = 10, columns = 10;
        board = new MinesweeperBoard(rows, columns, 0.07f);
        board.printBoard();
        
        plButtons.removeAll();
        plButtons.setLayout(new GridLayout(rows, columns));
        
        for(int r = 1; r <= rows; r++) {
            for(int c = 1; c <= columns; c++) {
                JToggleButton toggleButton = new JToggleButton();
                toggleButton.setText(r + " " + c);
                toggleButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int x = Integer.parseInt(toggleButton.getText().split(" ")[0]);
                        int y = Integer.parseInt(toggleButton.getText().split(" ")[1]);
                        System.out.println(x + " " + y);
                    }
                });
                plButtons.add(toggleButton);
            }
        }
        board.setButtons(plButtons.getComponents());
        
        plButtons.revalidate();
        plButtons.repaint();
    }//GEN-LAST:event_onSizeChange

    private void onSave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSave
        JFileChooser fc = new JFileChooser();
        if(fc.showSaveDialog(this) == APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                board.save(file);
            } catch(FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, ex, "Fehler", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_onSave

    private void onLoad(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLoad
        // TODO add your handling code here:
    }//GEN-LAST:event_onLoad

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel plButtons;
    // End of variables declaration//GEN-END:variables
}
