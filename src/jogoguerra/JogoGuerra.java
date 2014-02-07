/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jogoguerra;
import javax.swing.UIManager;
import rede.JanelaServidor;
import sourceGui.*;
/**
 *
 * @author Again
 */
public class JogoGuerra {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) {
    try
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    //..new ControloGui();
    //..ControloGui.config.carregarTheme();
    //..ControloGui.config.carregarVeloc();
    //..ControloGui.guiJanelPrincipal = new JanelaPrincipal();
    new JanelaServidor().setVisible(true);
    
  }
}
