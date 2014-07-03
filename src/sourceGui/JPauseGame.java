package sourceGui;

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


import com.sun.awt.AWTUtilities; 

public class JPauseGame extends JDialog {
 
  private Border line;
  private JPanel panelPrincipal;
  public static boolean sair = false;
  public static boolean continuar = false; 
  public static boolean reeniciar = false;
  public static boolean novo= false;
    
  
  
  //private JanelaPrincipalJogo.InternalRunnableTime main;
  private JanelaJogo.InternalRunnableTimeRunGame main;
  
  private JButton jbtContinuar,jbtReiniciar,jbtNovoJogo,jbtSair;
  
  
  public JPauseGame(Frame frame,boolean verif,JanelaJogo.InternalRunnableTimeRunGame internTime)
  {
    super(frame,verif);
    main = internTime;
    
    line = BorderFactory.createTitledBorder("");
    panelPrincipal = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    //  panelPrincipal = new JPanel();
     
    
    jbtContinuar = new JButton(new ImageIcon(this.getClass().getResource("../img/continuar.png")));
        jbtContinuar.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        //jbtFechar.setContentAreaFilled(true);
        jbtContinuar.setIcon(new ImageIcon(this.getClass().getResource("../img/continuarR1c.png")));
         // jbtFechar.setBackground(Color.BLACK);
      }
      public void  mouseExited(MouseEvent e){
        //jbtFechar.setContentAreaFilled(false);
        jbtContinuar.setIcon(new ImageIcon(this.getClass().getResource("../img/continuar.png")));
      }
    }); 
        
        
    jbtReiniciar = new JButton(new ImageIcon(this.getClass().getResource("../img/reiniciar1.png")));
        jbtReiniciar.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        //jbtFechar.setContentAreaFilled(true);
        jbtReiniciar.setIcon(new ImageIcon(this.getClass().getResource("../img/reiniciarR1.png")));
         // jbtFechar.setBackground(Color.BLACK);
      }
      public void  mouseExited(MouseEvent e){
        //jbtFechar.setContentAreaFilled(false);
        jbtReiniciar.setIcon(new ImageIcon(this.getClass().getResource("../img/reiniciar1.png")));
      }
    }); 
        
        
    jbtNovoJogo = new JButton(new ImageIcon(this.getClass().getResource("../img/novoJogo1.png")));
        jbtNovoJogo.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        //jbtFechar.setContentAreaFilled(true);
        jbtNovoJogo.setIcon(new ImageIcon(this.getClass().getResource("../img/novoJogoR1.png")));
         // jbtFechar.setBackground(Color.BLACK);
      }
      public void  mouseExited(MouseEvent e){
        //jbtFechar.setContentAreaFilled(false);
        jbtNovoJogo.setIcon(new ImageIcon(this.getClass().getResource("../img/novoJogo1.png")));
      }
    }); 
        
        
    jbtSair = new JButton(new ImageIcon(this.getClass().getResource("../img/sair1.png")));
        jbtSair.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        //jbtFechar.setContentAreaFilled(true);
        jbtSair.setIcon(new ImageIcon(this.getClass().getResource("../img/sairR1.png")));
         // jbtFechar.setBackground(Color.BLACK);
      }
      public void  mouseExited(MouseEvent e){
        //jbtFechar.setContentAreaFilled(false);
        jbtSair.setIcon( new ImageIcon(this.getClass().getResource("../img/sair1.png")));
      }
    }); 
        
        
    jbtSair.setContentAreaFilled(false);
    jbtReiniciar.setContentAreaFilled(false);
    jbtNovoJogo.setContentAreaFilled(false);
    jbtContinuar.setContentAreaFilled(false);
      
    /* Tratar Eventos */
    TrataEventos eventos  = new  TrataEventos();
    jbtContinuar.addActionListener(eventos);
    jbtSair.addActionListener(eventos);
    jbtNovoJogo.addActionListener(eventos);
    jbtReiniciar.addActionListener(eventos);
    
    //AWTUtilities.setWindowOpacity(this, 0.7F);
    
    criarGui();
  }
  
  
  public void criarGui()
  {
    //setDefaultLookAndFeelDecorated(true);
    setLayout(null);
    panelPrincipal.setLayout(null);
    panelPrincipal.setOpaque(false);
    panelPrincipal.setBounds(0,0,300,300);
      
    //jbtContinuar.setBounds(40,30,180,25);
    
    jbtContinuar.setBounds(30,50,220,60); //30
   // jbtReiniciar.setBounds(40,90,195,60);//90
    jbtNovoJogo.setBounds(40,120,195,60);//150
    jbtSair.setBounds(40,190,195,60);//210
    
    
    panelPrincipal.add(jbtContinuar);
    panelPrincipal.add(jbtReiniciar);
    panelPrincipal.add(jbtNovoJogo);
    panelPrincipal.add(jbtSair);
    
    add(panelPrincipal);
    
    //setBorder(line);
    
    setSize(300,300);
    setUndecorated(true);
    AWTUtilities.setWindowOpacity(this, 0.65F);  
    setLocationRelativeTo(null);
    setVisible(true);
    
  }
  
                                          
  
  /* Tratra Eventos */
  public class TrataEventos implements ActionListener
  {
    public void actionPerformed(ActionEvent ev)
    {
      if(ev.getSource()==jbtContinuar )
      {
        main.resume();
        inicBotton(false);
        dispose();
      }
      if(ev.getSource()==jbtNovoJogo )
      {
        main.resume();
        novo = true;
        dispose();
      }
      
      if(ev.getSource()==jbtSair )
      {   
        sair = true;
        dispose();
      }
    }
  }
  
  public static void inicBotton(boolean verif)
  {
    continuar = verif;
    reeniciar = verif;
    novo = verif;
    sair = verif;
  }
  
  public static void main(String[] args) {
    try 
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    new JPauseGame(null,false,null);
  }
  
}