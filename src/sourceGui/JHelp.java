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

public class JHelp extends JDialog {
  
  private int reset =1;
  public static int batalhas=0;
  public static String sj1="";
  public static String sj2="";
  
  private Border line;
  private JPanel panelPrincipal;
  private JLabel jlbTitulo;
  private JButton jbtObjectivo,jbtSair;
  private JButton jbt1,jbt2,jbt3,jbt4,jbt5,jbt6,jbt7;
  private JButton jbtSeguinte1,jbtSeguinte2,jbtSeguinte3,jbtSeguinte4,jbtSeguinte5;
  private JButton jbtAnterior1,jbtAnterior2,jbtAnterior3,jbtAnterior4,jbtAnterior5;
  
  private JPanel jPanel1,jPanel2,jPanel3,jPanel4,jPanel5;
  private Font fontGeral;
  
  /* Opcoes */
  public JHelp(Frame frame, boolean nl)
  {
    super(frame,nl);
    instancia();
    visiblidade(false);
    jPanel1.setVisible(true);
    
    eventosMouse();
    
    
    /* Tratar Eventos */
    TrataEventos eventos  = new  TrataEventos();
    jbtSair.addActionListener(eventos);
    jbtSeguinte1.addActionListener(eventos);
    jbtSeguinte2.addActionListener(eventos);
    jbtSeguinte3.addActionListener(eventos);
    jbtSeguinte4.addActionListener(eventos);
    jbtSeguinte5.addActionListener(eventos);
    
    jbtAnterior1.addActionListener(eventos);
    jbtAnterior2.addActionListener(eventos);
    jbtAnterior3.addActionListener(eventos);
    jbtAnterior4.addActionListener(eventos);
    jbtAnterior5.addActionListener(eventos);
    
    jbt1.addActionListener(eventos);
    jbt2.addActionListener(eventos);
    jbt3.addActionListener(eventos);
    jbt4.addActionListener(eventos);
    jbt5.addActionListener(eventos);
    
    criarGui();
  }
    
  
  
  public void instancia()
  {
    
    line = BorderFactory.createTitledBorder("");
    // panelPrincipal = new ImagemFundoModelo("fundoBlack.jpg");
    panelPrincipal = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][0]);
    
    jPanel1 = new ImagemFundoModelo("../img/help1.png");
    jPanel2 = new ImagemFundoModelo("../img/help2.png");
    jPanel3 = new ImagemFundoModelo("../img/help3.png");
    jPanel4 = new ImagemFundoModelo("../img/help4.png");
    jPanel5 = new ImagemFundoModelo("../img/help5.png");
    
    jbtSeguinte1 = new JButton(new ImageIcon(this.getClass().getResource("../img/seguinte.png"))); jbtSeguinte1.setContentAreaFilled(false);
    jbtSeguinte2 = new JButton(new ImageIcon(this.getClass().getResource("../img/seguinte.png"))); jbtSeguinte2.setContentAreaFilled(false);
    jbtSeguinte3 = new JButton(new ImageIcon(this.getClass().getResource("../img/seguinte.png"))); jbtSeguinte3.setContentAreaFilled(false);
    jbtSeguinte4 = new JButton(new ImageIcon(this.getClass().getResource("../img/seguinte.png"))); jbtSeguinte4.setContentAreaFilled(false);
    jbtSeguinte5 = new JButton(new ImageIcon(this.getClass().getResource("../img/seguinte.png"))); jbtSeguinte5.setContentAreaFilled(false);
    
    jbtAnterior1 = new JButton(new ImageIcon(this.getClass().getResource("../img/anterior.png"))); jbtAnterior1.setContentAreaFilled(false);
    jbtAnterior2 = new JButton(new ImageIcon(this.getClass().getResource("../img/anterior.png"))); jbtAnterior2.setContentAreaFilled(false);
    jbtAnterior3 = new JButton(new ImageIcon(this.getClass().getResource("../img/anterior.png"))); jbtAnterior3.setContentAreaFilled(false);
    jbtAnterior4 = new JButton(new ImageIcon(this.getClass().getResource("../img/anterior.png"))); jbtAnterior4.setContentAreaFilled(false);
    jbtAnterior5 = new JButton(new ImageIcon(this.getClass().getResource("../img/anterior.png"))); jbtAnterior5.setContentAreaFilled(false);
    
    
    jbtSair =  new JButton("Sair");
    jbtObjectivo = new JButton("Objectivo");
    
    jbt1 = new JButton("1");  jbt1.setForeground(new Color(242,246,255));
    jbt2 = new JButton("2"); jbt2.setForeground(new Color(242,246,255));
    jbt3 = new JButton("3"); jbt3.setForeground(new Color(242,246,255));
    jbt4 = new JButton("4"); jbt4.setForeground(new Color(242,246,255));
    jbt5 = new JButton("5"); jbt5.setForeground(new Color(242,246,255));
    jbt6 = new JButton("6"); jbt6.setForeground(new Color(242,246,255));
    jbt7 = new JButton("7"); jbt7.setForeground(new Color(242,246,255));
    
    
    jPanel1.setBounds(30,32,635,380);
    jPanel1.setBorder(line);
    jPanel1.setLayout(null);
    
    jPanel2.setBounds(30,32,635,380);
    jPanel2.setBorder(line);
    jPanel2.setLayout(null);
    
    jPanel3.setBounds(30,32,635,380);
    jPanel3.setBorder(line);
    jPanel3.setLayout(null);
    
    jPanel4.setBounds(30,32,635,380);
    jPanel4.setBorder(line);
    jPanel4.setLayout(null);
    
    jPanel5.setBounds(30,32,635,380);
    jPanel5.setBorder(line);
    jPanel5.setLayout(null);
    
    
    jbtAnterior1.setBounds(8,190,50,50);
    jbtSeguinte1.setBounds(580,190,50,50);
    
    jbtAnterior2.setBounds(8,190,50,50);
    jbtSeguinte2.setBounds(580,190,50,50);
    
    jbtAnterior3.setBounds(8,190,50,50);
    jbtSeguinte3.setBounds(580,190,50,50);
    
    jbtAnterior4.setBounds(8,190,50,50);
    jbtSeguinte4.setBounds(580,190,50,50);
    
    jbtAnterior5.setBounds(8,190,50,50);
    jbtSeguinte5.setBounds(580,190,50,50);
    
    
    jbt1.setBounds(30,12,30,23);
    jbt1.setBorder(line);
    jbt1.setContentAreaFilled(true);
    jbt1.setBackground(new Color(79,71,71) );
    
    
    jbt2.setBounds(62,12,30,23);
    jbt2.setBorder(line);
    jbt2.setContentAreaFilled(false);
    
    jbt3.setBounds(92,12,30,23);
    jbt3.setBorder(line);
    jbt3.setContentAreaFilled(false);
    
    jbt4.setBounds(122,12,30,23);
    jbt4.setBorder(line);
    jbt4.setContentAreaFilled(false);
    
    jbt5.setBounds(152,12,30,23);
    jbt5.setBorder(line);
    jbt5.setContentAreaFilled(false);
    
    jbtSair.setBounds(600,420,60,30);
    jbtObjectivo.setBounds(30,420,100,30);
    
    
    panelPrincipal.add(jbt1);
    panelPrincipal.add(jbt2); 
    panelPrincipal.add(jbt3);
    panelPrincipal.add(jbt4);
    panelPrincipal.add(jbt5);
    
    panelPrincipal.add(jbtSair);
    //panelPrincipal.add(jbtObjectivo);
    
   jPanel1.add(jbtSeguinte1);
   jPanel1.add(jbtAnterior1);
   
   jPanel2.add(jbtSeguinte2);
   jPanel2.add(jbtAnterior2);
   
   jPanel3.add(jbtSeguinte3);
   jPanel3.add(jbtAnterior3);
   
   jPanel4.add(jbtSeguinte4);
   jPanel4.add(jbtAnterior4);
   
   jPanel5.add(jbtSeguinte5);
   jPanel5.add(jbtAnterior5);
   
   panelPrincipal.add(jPanel1); jPanel1.setVisible(true);
   panelPrincipal.add(jPanel2);
   panelPrincipal.add(jPanel3);
   panelPrincipal.add(jPanel4);
   panelPrincipal.add(jPanel5);
    

    
  }
  
  
  public void criarGui()
  {
    setLayout(null);
    panelPrincipal.setLayout(null);
    panelPrincipal.setOpaque(false);
    panelPrincipal.setBounds(0,0,700,460);
    
    Font font = new Font("Footlight MT Light",0,18 );
    
    // jbtSair.
    
  
    // panelPrincipal.add(jbtSair);
    
    add(panelPrincipal);
    
    setSize(700,460);
    setUndecorated(true);
    // AWTUtilities.setWindowOpacity(this, 0.45F);  
    // setLocation(new Point(posWith,posHeight));
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  public void visiblidade(boolean bool)
  {
    jPanel1.setVisible(bool);
    jPanel2.setVisible(bool);
    jPanel3.setVisible(bool);
    jPanel4.setVisible(bool);
    jPanel5.setVisible(bool);
  }
  
  /* Tratra Eventos */
  public class TrataEventos implements ActionListener
  {
    public void actionPerformed(ActionEvent ev){
      if(ev.getSource()==jbtSair){
        dispose();
      }
      
      if(ev.getSource()==jbtSeguinte1){
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
        btNavegation(false);
        jbt2.setContentAreaFilled(true);
        jbt2.setBackground(new Color(79,71,71) );
        reset = 2;
      }
      if(ev.getSource()==jbtSeguinte2){
        jPanel2.setVisible(false);
        jPanel3.setVisible(true);
        btNavegation(false);
        jbt3.setContentAreaFilled(true);
        jbt3.setBackground(new Color(79,71,71) );
         reset = 3;
      }
      if(ev.getSource()==jbtSeguinte3){
        jPanel3.setVisible(false);
        jPanel4.setVisible(true);
        btNavegation(false);
        jbt4.setContentAreaFilled(true);
        jbt4.setBackground(new Color(79,71,71) );
         reset = 4;
      }
      if(ev.getSource()==jbtSeguinte4){
        jPanel4.setVisible(false);
        jPanel5.setVisible(true);
        btNavegation(false);
        jbt5.setContentAreaFilled(true);
        jbt5.setBackground(new Color(79,71,71) );
        reset = 5;
      }
      if(ev.getSource()==jbtSeguinte5){
        jPanel5.setVisible(false);
        jPanel1.setVisible(true);
        btNavegation(false);
        jbt1.setContentAreaFilled(true);
        jbt1.setBackground(new Color(79,71,71) );
         reset = 1;
      }
      
      /* Anteriores */
      if(ev.getSource()==jbtAnterior1){
        jPanel1.setVisible(false);
        jPanel5.setVisible(true);
        btNavegation(false);
        jbt5.setContentAreaFilled(true);
        jbt5.setBackground(new Color(79,71,71) );
        reset = 5;
      }
      if(ev.getSource()==jbtAnterior2){
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
        btNavegation(false);
        jbt1.setContentAreaFilled(true);
        jbt1.setBackground(new Color(79,71,71) );
        reset = 1;
      }
      if(ev.getSource()==jbtAnterior3){
        jPanel3.setVisible(false);
        jPanel2.setVisible(true);
        btNavegation(false);
        jbt2.setContentAreaFilled(true);
        jbt2.setBackground(new Color(79,71,71) );
        reset = 2;
      }
      if(ev.getSource()==jbtAnterior4){
        jPanel4.setVisible(false);
        jPanel3.setVisible(true);
        btNavegation(false);
        jbt3.setContentAreaFilled(true);
        jbt3.setBackground(new Color(79,71,71) );
        reset = 3;
      }
      if(ev.getSource()==jbtAnterior5){
        jPanel5.setVisible(false);
        jPanel4.setVisible(true);
        btNavegation(false);
        jbt4.setContentAreaFilled(true);
        jbt4.setBackground(new Color(79,71,71) );
        reset = 4;
      }
      
      /* Bottoes */
      if(ev.getSource()==jbt1){
        visiblidade(false);
        jPanel1.setVisible(true);
        btNavegation(false);
        jbt1.setContentAreaFilled(true);
        jbt1.setBackground(new Color(79,71,71) );
        reset = 1;
      }
      if(ev.getSource()==jbt2){
        visiblidade(false);
        jPanel2.setVisible(true);
        btNavegation(false);
        jbt2.setContentAreaFilled(true);
        jbt2.setBackground(new Color(79,71,71) );
        reset = 2;
      }
      if(ev.getSource()==jbt3){
        visiblidade(false);
        jPanel3.setVisible(true);
        btNavegation(false);
        jbt3.setContentAreaFilled(true);
        jbt3.setBackground(new Color(79,71,71) );
        reset = 3;
      }
      if(ev.getSource()==jbt4){
        visiblidade(false);
        jPanel4.setVisible(true);
        btNavegation(false);
        jbt4.setContentAreaFilled(true);
        jbt4.setBackground(new Color(79,71,71) );
        reset = 4;
      }
      if(ev.getSource()==jbt5){
        visiblidade(false);
        jPanel5.setVisible(true);
        btNavegation(false);
        jbt5.setContentAreaFilled(true);
        jbt5.setBackground(new Color(79,71,71) );
        reset = 5;
      }
      
      
    }
  }
  
  
  public void eventosMouse()
  {
    jbtSeguinte1.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        jbtSeguinte1.setIcon(new ImageIcon(this.getClass().getResource("../img/S.png")));
      }
      public void  mouseExited(MouseEvent e){
        jbtSeguinte1.setIcon(new ImageIcon(this.getClass().getResource("../img/seguinte.png")));
      }
    });
    
    
    jbt1.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        jbt1.setContentAreaFilled(true);
        jbt1.setBackground(new Color(79,71,71) );
      }
      public void  mouseExited(MouseEvent e){
        jbt1.setContentAreaFilled(false);
        jbt1.setBackground(null);
        normal();
      }
    });
    jbt2.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        jbt2.setContentAreaFilled(true);
        jbt2.setBackground(new Color(79,71,71) );
      }
      public void  mouseExited(MouseEvent e){
        jbt2.setContentAreaFilled(false);
        jbt2.setBackground(null);
        normal();
      }
    });
    jbt3.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        jbt3.setContentAreaFilled(true);
        jbt3.setBackground(new Color(79,71,71) );
        
      }
      public void  mouseExited(MouseEvent e){
        jbt3.setContentAreaFilled(false);
        jbt3.setBackground(null);
        normal();
      }
    });
    jbt4.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        jbt4.setContentAreaFilled(true);
        jbt4.setBackground(new Color(79,71,71) );
      }
      public void  mouseExited(MouseEvent e){
        jbt4.setContentAreaFilled(false);
        jbt4.setBackground(null);
        normal();
      }
    });
    jbt5.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        jbt5.setContentAreaFilled(true);
        jbt5.setBackground(new Color(79,71,71) );
      }
      public void  mouseExited(MouseEvent e){
        jbt5.setContentAreaFilled(false);
        jbt5.setBackground(null);
        normal();
      }
    });
    
  }
  
  
  public void btNavegation(boolean bool)
  {
    jbt1.setContentAreaFilled(bool);
    jbt1.setBackground(null);
    
    jbt2.setContentAreaFilled(bool);
    jbt2.setBackground(null);
    
    jbt3.setContentAreaFilled(bool);
    jbt3.setBackground(null);
    
    jbt4.setContentAreaFilled(bool);
    jbt4.setBackground(null);
    
    jbt5.setContentAreaFilled(bool);
    jbt5.setBackground(null);
  }
  
  public void normal()
  {
    
    if(reset==1)
    {
      jbt1.setContentAreaFilled(true);
      jbt1.setBackground(new Color(79,71,71) );
    }
    if(reset==2)
    {
      jbt2.setContentAreaFilled(true);
      jbt2.setBackground(new Color(79,71,71) );
    }
    if(reset==3)
    {
      jbt3.setContentAreaFilled(true);
      jbt3.setBackground(new Color(79,71,71) );
    }
    if(reset==4)
    {
      jbt4.setContentAreaFilled(true);
      jbt4.setBackground(new Color(79,71,71) );
    }
    if(reset==5)
    {
      jbt5.setContentAreaFilled(true);
      jbt5.setBackground(new Color(79,71,71) );
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
    new JHelp(null,true);
  }
  
  
}