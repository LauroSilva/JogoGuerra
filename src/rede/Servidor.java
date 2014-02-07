/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rede;

import sourceModelo.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import sourceGui.Songs;

/**
 *
 * @author Again
 */
public class Servidor extends javax.swing.JFrame {

    ArrayList<PrintWriter> escritores = new ArrayList();
    ArrayList<PrintWriter> clienteJogo = new ArrayList();
    
    public int contClienteJogo = 0;
    private int numJogada = 0;
    
    PrintWriter clienteJogo1;
    PrintWriter clienteJogo2;
    
    public int cont = 1;
    public int contIdPlayer = 1;
    public String bigArgumento;
    public ServerSocket server;
    
    //================================================
    // public static Baralho baralho = new Baralho();
    public static Jogo jogo;
    public static Songs sons = new Songs();
    //================================================
    
    public Servidor() {
        jogo = new Jogo();
        jogo.novoJogo();
        
        // JOptionPane.showMessageDialog(null,""+jogo.baralho.getCarta()[0].getPicture() );
        initComponents();
        setLocationRelativeTo(null);
        new Thread(new CriarServerThread()).start(); 
        new Thread(new ChatServer()).start();
       // new Thread(new CriaServerChat() ).start();
        
    }
    
    
    private void encaminharOTextoparaTodos(String texto){
        for(PrintWriter w: escritores){
            try{
                w.println(texto);
                w.flush();
            }
            catch(Exception ex){}
        }
    }
    
    public void encaminharCliente1(String texto){
             
        try{
            clienteJogo.get(0).println(texto);
            clienteJogo.get(0).flush();
        }
        catch(Exception ex){}
    }

    public void encaminharCliente2(String texto){
        try{
            clienteJogo.get(1).println(texto);
            clienteJogo.get(1).flush();
        }
        catch(Exception ex){}   
    }
    
      
    
    public class CriarServerThread implements Runnable{
        public CriarServerThread(){
        }
        
        public void run(){
            
             ObjectInputStream input;
             ObjectOutputStream output; 

            try{
                server = new ServerSocket(5000);
                System.out.println("Servidor Criado!!!");
                jtfEstado.setText("√ Ligado");
                jtfPorta.setText(""+server.getLocalPort());
                jtfIp.setText(""+InetAddress.getLocalHost().getHostAddress() );

                while(true){
                      Socket socket = server.accept(); 
                      try{
                         output = new ObjectOutputStream(socket.getOutputStream() );
                         jogo.idPlayer = contIdPlayer; contIdPlayer++;
                         DefinicaoJogo();
                         output.writeObject(jogo);
                         output.flush();
                         //output.close();
                      }catch(Exception ex){
                           System.out.println("Deu pau....");
                      }
                      finally{ }
                      //==================================================
                      System.out.println("Cliente: "+cont+" Conectado"); cont++;
                      
                      PrintWriter escritor = new PrintWriter(socket.getOutputStream() );
                       escritor.println("Ola");
                       escritor.flush();
                      
                    new Thread(new EscutaCliente(socket)).start();
                    PrintWriter p = new PrintWriter(socket.getOutputStream() );
                    escritores.add(p);
                    clienteJogo.add(contClienteJogo,p);
                    contClienteJogo = contClienteJogo+1;
                  }
            }catch(Exception ex){

            }
     
        }
    }
    
    
    
    
    private class EscutaCliente implements Runnable{
        Scanner leitor;
        
        public EscutaCliente(Socket socket){
            try{
                leitor = new Scanner(socket.getInputStream());
            }
            catch(Exception ex){}
        }
     public void run(){
         try{
              String texto;
              while( (texto = leitor.nextLine()) !=null ){
                  System.out.println("Recebeu: "+texto);
                   if(texto.equalsIgnoreCase("Joguei1")){
                       //JOptionPane.showMessageDialog(null,"Estou a por minha jogada: Player1");
                       encaminharCliente2("Joguei1");
                       numJogada++;
                       texto="";
                   }
                   if(texto.equalsIgnoreCase("Joguei2")){
                       // JOptionPane.showMessageDialog(null,"Estou a por minha jogada: Player2");
                       encaminharCliente1("Joguei2");
                       numJogada++;
                       texto="";
                   }
                   if(numJogada==2){
                       numJogada =0;
                       encaminharCliente1("limpar");
                       encaminharCliente2("limpar");
                       jogo.jogarGui();
                   }
                   encaminharOTextoparaTodos(texto);
                   
                }
            }catch(Exception ex){
                
            }
        }
    }
    
    
    public void DefinicaoJogo(){
        jogo.numBatalha = 26;
    }
    
    
    // public class EscutaClienteChat implements Runnable ...
    
    public void receberJogadaCliente(){
        
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfIp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfPorta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfEstado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfNumeroPlayer = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Servidor ....");

        jtfIp.setEditable(false);
        jtfIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfIpActionPerformed(evt);
            }
        });

        jLabel2.setText("Ip:");

        jLabel3.setText("Porta:");

        jtfPorta.setEditable(false);
        jtfPorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPortaActionPerformed(evt);
            }
        });

        jLabel4.setText("Estado: ");

        jtfEstado.setEditable(false);
        jtfEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEstadoActionPerformed(evt);
            }
        });

        jLabel5.setText("Numero Player: ");

        jtfNumeroPlayer.setEditable(false);

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jtfIp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 157, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(39, 39, 39)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jtfPorta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 28, Short.MAX_VALUE)
                        .add(jButton1))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(58, 58, 58)
                                .add(jLabel1))
                            .add(layout.createSequentialGroup()
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel5)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jtfNumeroPlayer))
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel4)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jtfEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 101, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(jLabel1)
                .add(24, 24, 24)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jtfEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jtfNumeroPlayer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 141, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jtfIp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(jtfPorta, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfIpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfIpActionPerformed

    private void jtfPortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPortaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPortaActionPerformed

    private void jtfEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEstadoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jtfEstado;
    private javax.swing.JTextField jtfIp;
    private javax.swing.JTextField jtfNumeroPlayer;
    private javax.swing.JTextField jtfPorta;
    // End of variables declaration//GEN-END:variables
}
