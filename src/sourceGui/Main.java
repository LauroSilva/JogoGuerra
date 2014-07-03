package sourceGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;
import javax.swing.BorderFactory; 
import java.awt.event.MouseListener;

import java.applet.*;
import java.io.*;
import java.net.*;


public class Main{
  public static void main(String[] args) {
    try
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    }
    catch (Exception ex){
      ex.printStackTrace();
    }
    
    // "C:\\WINDOWS\\Media\\notify.wav"
    new Songs().entrada();
   // new Songs().jogar();
    
    new ControloGui();
    ControloGui.config.carregarTheme();
    ControloGui.config.carregarVeloc();
    ControloGui.guiJanelPrincipal = new JanelaPrincipal();
  }
}
