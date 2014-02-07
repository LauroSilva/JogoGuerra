package sourceGui;

import sourceModelo.*;
import sourceGuiControlo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;
import javax.swing.BorderFactory; 
import java.awt.event.MouseListener;


import java.awt.FlowLayout;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
import javax.swing.JTextField;  
import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.Graphics2D;  
import java.awt.Rectangle;  
import java.awt.RenderingHints;


//import com.sun.awt.AWTUtilities; 

public class JEscolhaNovoJogo extends JDialog {
  
  public static int batalhas=0;
  public static String sj1="";
  public static String sj2="";
  
  private Border line;
  private JPanel panelPrincipal;
  private JLabel jlbTitulo;
  private JButton jbtMesmoJogo,jbtNovoJogo,jbtSair;
  
  
  /* Opcoes */
  public JEscolhaNovoJogo(Frame frame, boolean nl)
  {
    super(frame,nl);
    instancia();
    
    /* Tratar Eventos */
    TrataEventos eventos  = new  TrataEventos();
    jbtMesmoJogo.addActionListener(eventos);
    jbtNovoJogo.addActionListener(eventos);
    jbtSair.addActionListener(eventos);
    
    criarGui();
  }
    
  
  
  public void instancia()
  {
    line = BorderFactory.createTitledBorder("");
    // panelPrincipal = new ImagemFundoModelo("fundoBlack.jpg");
    panelPrincipal = new JPanel();
    
    jlbTitulo = new JLabel(" Dados para o Jogo ");
    
    jbtSair =  new JButton("Sair");
    jbtMesmoJogo = new JButton("Mesmo Jogadores");
    jbtNovoJogo = new JButton("Novo Jogo Jogadores");
    
  }
  
  
  public void criarGui()
  {
    setLayout(null);
    panelPrincipal.setLayout(null);
    panelPrincipal.setOpaque(false);
    panelPrincipal.setBounds(0,0,400,300);
    
    Font font = new Font("Footlight MT Light",0,18 );
    
    
    jlbTitulo.setBounds(80,15,180,25);  jlbTitulo.setFont(font);  jlbTitulo.setForeground(new Color(113,114,118));
    
    // jbtSair.
    jbtMesmoJogo.setBounds(30,195,140,25);
    jbtNovoJogo.setBounds(170,195,140,25);
    
    
    panelPrincipal.add(jlbTitulo);
  
    panelPrincipal.add(jbtMesmoJogo);
    panelPrincipal.add(jbtNovoJogo);
    // panelPrincipal.add(jbtSair);
    
    add(panelPrincipal);
    
    setSize(700,460);
    setUndecorated(true);
//    AWTUtilities.setWindowOpacity(this, 0.45F);  
    // setLocation(new Point(posWith,posHeight));
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  /* Tratra Eventos */
  public class TrataEventos implements ActionListener
  {
    public void actionPerformed(ActionEvent ev){
    
      if(ev.getSource()==jbtMesmoJogo){
        dispose();
        ControloGui.guiJanelaDadosJogo = new JanelaDadosJogo(null,true,500,250,false);
        
      }
      if(ev.getSource()==jbtNovoJogo){
        dispose();
        ControloGui.guiJanelaDadosJogo = new JanelaDadosJogo(null,true,500,250,"Novo Jogo Pause");
        
      }
      
    }
  }
  
  public static void main(String[] args) {
    try 
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    new JanelaPrincipal();
  }
  
  
}