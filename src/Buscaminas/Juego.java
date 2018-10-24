/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Buscaminas;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Juego extends javax.swing.JFrame {

    JLabel casilla[][] = new JLabel[10][10];
    JButton botonsito[][] = new JButton[10][10];
    Casilla miCasilla[][]=new Casilla[10][10];
    Random aleatorio=new Random();
    File miArchivo = new File("Mina.jpg");
    Font myFont = new Font("Tahoma",1,18);
    
    public Juego() {
        initComponents();
        crearCasilla();
        ponerMinas();
    }
    
    void crearCasilla(){
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                final int p=i;
                final int q=j;
                casilla[i][j]=new JLabel();
                casilla[i][j].setBounds(20*i+42,20*j+82,20,20);
                casilla[i][j].setBorder(BorderFactory.createLineBorder(Color.gray));
                add(casilla[i][j]);
                miCasilla[i][j]=new Casilla();
                botonsito[i][j]=new JButton();
                botonsito[i][j].setBounds(20*i+40,20*j+80,25,25);
                add(botonsito[i][j]);
                botonsito[i][j].setVisible(true);
                casilla[i][j].setVisible(false);
                botonsito[i][j].addActionListener((ActionEvent e) -> {
                    verificarMinas(p,q);
                });
            }
        }
    }
    void ponerMinas(){
        for(int m=0;m<15;m++){
            int a=aleatorio.nextInt(10);
            int b=aleatorio.nextInt(10);
            if(miCasilla[a][b].mina==false){
                miCasilla[a][b].mina=true;
                try {
                    BufferedImage miImagen = ImageIO.read(miArchivo);
                    ImageIcon miIcono = new ImageIcon(miImagen);
                    Image pequeño = miIcono.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                    ImageIcon otroIcono = new ImageIcon(pequeño);
                    casilla[a][b].setIcon(otroIcono);
                } catch (IOException ex) {
                    casilla[a][b].setText("*");
                }
            }else{
                m=m-1;
            }
        }
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(miCasilla[i][j].mina==false){
                    int cont=0;
                    for(int k=-1;k<2;k++)
                    {
                        for(int l=-1;l<2;l++)
                        {
                            try{
                                if(miCasilla[i+k][j+l].mina==true){
                                    cont++;
                                }
                            }
                            catch(Exception miExcepción){}
                    }
                    casilla[i][j].setText(String.valueOf(cont));
                    casilla[i][j].setHorizontalAlignment(JLabel.CENTER);
                    casilla[i][j].setVerticalAlignment(JLabel.CENTER);
                    casilla[i][j].setFont(myFont);
                    switch(cont){
                        case 1:{
                            casilla[i][j].setForeground(Color.blue);
                        }break;
                        case 2:{
                            casilla[i][j].setForeground(Color.green.darker());
                        }break;
                        case 3:{
                            casilla[i][j].setForeground(Color.red);
                        }break;
                        case 4:{
                            casilla[i][j].setForeground(Color.BLUE.darker());
                        }break;
                        case 5:{
                            casilla[i][j].setForeground(Color.RED.darker());
                        }break;
                        case 6:{
                            casilla[i][j].setForeground(Color.magenta);
                        }break;
                        case 7:{
                            casilla[i][j].setForeground(Color.black);
                        }break;
                        case 8:{
                            casilla[i][j].setForeground(Color.gray);
                        }break;
                    }
                }
            }
        }
    }
    }
    
    void verificarMinas(int a, int b){
        botonsito[a][b].setVisible(false);
        casilla[a][b].setVisible(true);
        if(miCasilla[a][b].mina==true){
            for(a=0;a<10;a++){
                for(b=0;b<10;b++){
                    if(miCasilla[a][b].mina==true){
                        botonsito[a][b].setVisible(false);
                        casilla[a][b].setVisible(true);
                    }
                }
            }
        }else{
            if("0".equals(casilla[a][b].getText())){
                casilla[a][b].setText("");
                casillasVacías(a,b);
            }
        }
    }
    
    void casillasVacías(int a, int b){
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                try{
                    botonsito[a+i][b+j].setVisible(true);
                    casilla[a+i][b+j].setVisible(true);
                    verificarMinas(a+i,b+j);
                }catch(Exception Excepción){}
            }
        }
    }
    
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(317, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(266, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        crearCasilla();
        ponerMinas();
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Juego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
