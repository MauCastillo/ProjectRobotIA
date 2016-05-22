/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import Logica.Bloque;
import Logica.Coordenada;
import Archivo.Leer;
import Logica.Amplitud;
import Logica.Profundida;
import java.awt.GridLayout;
import Recursos.IcoRecurso;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Mauro
 */
public class UsuarioVisual extends javax.swing.JFrame {

    /**
     * Creates new form UsuarioVisual
     */
    Leer lectura = new Leer();
    Bloque[][] matriz;
    Coordenada inicia = new Coordenada();
    Bloque init = new Bloque();
    public UsuarioVisual() {
        initComponents();
        //Funcines para el Inicio del Mapa
        this.matriz = lectura.ReadFile();
        this.inicia = lectura.inicio;
        init = lectura.init;
        this.creacionBotones(matriz);
        this.repaint();
        this.setSize(450, 491);
        //setResizable(false);
    }

    //Diseñada para generar los iconos
    private ImageIcon IconoMapa(Bloque bloque) {
        ImageIcon imagen = new ImageIcon();
        //Poner condicionales para elementos graficos
        if (bloque.getContenido() == 1) {
            imagen = IcoRecurso.ICON_MURO;
        }
        if (bloque.getContenido() == 2) {
            imagen = IcoRecurso.ICON_ROBOT;
        }
        if (bloque.getContenido() == 3) {
            imagen = IcoRecurso.ICON_TRAJE;
        }
        if (bloque.getContenido() == 4) {
            imagen = IcoRecurso.ICON_RAYOAZUL;
        }
        if (bloque.getContenido() == 5) {
            imagen = IcoRecurso.ICON_RAYOROJO;
        }
        if (bloque.getContenido() == 6) {
            imagen = IcoRecurso.ICON_BATERIA;
        }
        return imagen;
    }

    /*Funcion diseñada para llenar el JPmapa de Botones*/
    public void creacionBotones(Bloque[][] matriz) {

        this.setSize(450, 492);
        jPmapa.removeAll();
        int filas = 10;
        int columnas = 10;
        jPmapa.setLayout(new GridLayout(10, 10));
        JLabel bMatriz[][] = new JLabel[10][10];
        //*
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                bMatriz[i][j] = new JLabel();
                bMatriz[i][j].setIcon(IconoMapa(matriz[j][i]));
                bMatriz[i][j].setBounds(10, 10, 10, 10);

                jPmapa.add(bMatriz[i][j]);
                //*
            }
        }
        this.setSize(450, 493);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jBbuscar = new javax.swing.JButton();
        jCseleccion = new javax.swing.JComboBox<String>();
        jPBanner = new javax.swing.JPanel();
        jLIcoTitle = new javax.swing.JLabel();
        jPmapa = new javax.swing.JPanel();
        jLTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jBbuscar.setBackground(new java.awt.Color(255, 255, 255));
        jBbuscar.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jBbuscar.setText("Buscar");
        jBbuscar.setContentAreaFilled(false);
        jBbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbuscarActionPerformed(evt);
            }
        });

        jCseleccion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Profundida", "Ampitud", "Costo Uniforme", "Avare ", "A*" }));
        jCseleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCseleccionActionPerformed(evt);
            }
        });

        jPBanner.setBackground(new java.awt.Color(204, 204, 255));

        jLIcoTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/img Logo.png"))); // NOI18N

        jPmapa.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPmapaLayout = new javax.swing.GroupLayout(jPmapa);
        jPmapa.setLayout(jPmapaLayout);
        jPmapaLayout.setHorizontalGroup(
            jPmapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPmapaLayout.setVerticalGroup(
            jPmapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 316, Short.MAX_VALUE)
        );

        jLTitle.setFont(new java.awt.Font("Candara", 1, 24)); // NOI18N
        jLTitle.setForeground(new java.awt.Color(0, 0, 153));
        jLTitle.setText("Univalle Smart Robot");

        javax.swing.GroupLayout jPBannerLayout = new javax.swing.GroupLayout(jPBanner);
        jPBanner.setLayout(jPBannerLayout);
        jPBannerLayout.setHorizontalGroup(
            jPBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBannerLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLIcoTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLTitle)
                .addContainerGap(151, Short.MAX_VALUE))
            .addGroup(jPBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPmapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPBannerLayout.setVerticalGroup(
            jPBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBannerLayout.createSequentialGroup()
                .addGroup(jPBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPBannerLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLTitle)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBannerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLIcoTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPmapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Candara", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Seleccione tipo de busqueda:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCseleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                        .addComponent(jBbuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCseleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCseleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCseleccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCseleccionActionPerformed

    private void jBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbuscarActionPerformed
        int algoritmo = 0;
        if (jCseleccion.getSelectedIndex() == 0) {
            Profundida amplitud = new Profundida(matriz, init);
            amplitud.BusquedaProfundida();

        }
        if (jCseleccion.getSelectedIndex() == 1) {
            //Amplitud
            Amplitud amplitud = new Amplitud(matriz, init);
            amplitud.BusquedaAmplitud();
        }
        if (jCseleccion.getSelectedIndex() == 1) {
            //Costo Uniforme
        }
        if (jCseleccion.getSelectedIndex() == 1) {
            //Avara
        }
        if (jCseleccion.getSelectedIndex() == 1) {
            //A*
        }

    }//GEN-LAST:event_jBbuscarActionPerformed

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
            java.util.logging.Logger.getLogger(UsuarioVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioVisual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioVisual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbuscar;
    private javax.swing.JComboBox<String> jCseleccion;
    private javax.swing.JLabel jLIcoTitle;
    private javax.swing.JLabel jLTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPBanner;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPmapa;
    // End of variables declaration//GEN-END:variables

}
