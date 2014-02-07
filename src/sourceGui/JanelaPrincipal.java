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


//import com.sun.awt.AWTUtilities; 

public class JanelaPrincipal extends JFrame {
 
  public static boolean flag= false; 
  private Border line;
  private JPanel panelPrincipal,panelBarraTitulo,panelMenu;
  private JButton jbtIniciarJogo,jbtAjuda,jbtSair,jbtConfig,jbtAbout; 
  private Font fontGeral;
  private JanelaPrincipal frame;
  
  public JanelaPrincipal()
  {
    frame = this;
    fontGeral = new Font("Ravie",0,18 );
    line = BorderFactory.createTitledBorder("");
    panelPrincipal = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][0]);
   // panelPrincipal = new JPanel();
    
    panelMenu = new JPanelPrincipal();
    //panelMenu = new JPanel();
    
    jbtIniciarJogo = new JButton("Iniciar o Jogo");  
    jbtIniciarJogo.setFont(fontGeral);
    jbtIniciarJogo.setForeground(new Color(242,246,255));
    
    jbtIniciarJogo.addMouseMotionListener(new MouseMotionAdapter(){  
      public void mouseMoved(MouseEvent e) {
        //jbtIniciarJogo.setBackground(Color.red);
        }
      public void  mouseDragged(MouseEvent e){
        //jbtIniciarJogo.setBackground(Color.red);
      }
      }); 
      jbtIniciarJogo.addMouseListener( new MouseAdapter() {  
        public void  mouseEntered(MouseEvent e) {
          jbtIniciarJogo.setContentAreaFilled(true);
          jbtIniciarJogo.setBackground(Color.black);
        }
        public void  mouseExited(MouseEvent e){
          jbtIniciarJogo.setContentAreaFilled(false);
          jbtIniciarJogo.setBackground(null);
        }
      }); 
      
      
      jbtAjuda = new JButton("Ajuda");
      jbtAjuda.setFont(fontGeral);
      jbtAjuda.setForeground(new Color(242,246,255));
      jbtAjuda.addMouseMotionListener(new MouseMotionAdapter(){  
        public void mouseMoved(MouseEvent e) {
          //jbtIniciarJogo.setBackground(Color.red);
        }
        public void  mouseDragged(MouseEvent e){
          //jbtIniciarJogo.setBackground(Color.red);
        }
      }); 
      jbtAjuda.addMouseListener( new MouseAdapter() {  
        public void  mouseEntered(MouseEvent e) {
          jbtAjuda.setContentAreaFilled(true);
          jbtAjuda.setBackground(Color.black);
        }
        public void  mouseExited(MouseEvent e){
          jbtAjuda.setContentAreaFilled(false);
          jbtAjuda.setBackground(null);
        }
      });
      
      
      jbtSair = new JButton("Sair");
      jbtSair.setFont(fontGeral);
      jbtSair.setForeground(new Color(242,246,255));
      
      jbtSair.addMouseMotionListener(new MouseMotionAdapter(){  
        public void mouseMoved(MouseEvent e) {
          //jbtIniciarJogo.setBackground(Color.red);
        }
        public void  mouseDragged(MouseEvent e){
          //jbtIniciarJogo.setBackground(Color.red);
        }
      });
      
      jbtSair.addMouseListener( new MouseAdapter() {  
        public void  mouseEntered(MouseEvent e) {
          jbtSair.setContentAreaFilled(true);
          jbtSair.setBackground(Color.black);
        }
        public void  mouseExited(MouseEvent e){
          jbtSair.setContentAreaFilled(false);
          jbtSair.setBackground(null);
        }
      });
      
      jbtConfig = new JButton(new ImageIcon(this.getClass().getResource("../img/imgConfiguracao_mini.png")));
      jbtConfig.addMouseListener( new MouseAdapter() {  
        public void  mouseEntered(MouseEvent e) {
          jbtConfig.setIcon(new ImageIcon(this.getClass().getResource("../img/imgConfiguracao.png")));
        }
        public void  mouseExited(MouseEvent e){
          jbtConfig.setIcon(new ImageIcon(this.getClass().getResource("../img/imgConfiguracao_mini.png")));
        }
      });
      
      jbtAbout = new JButton(new ImageIcon(this.getClass().getResource("../img/about_mini.png")));
      jbtAbout.setFont(fontGeral);
      jbtAbout.setForeground(new Color(242,246,255));
      jbtAbout.addMouseListener( new MouseAdapter() {  
        public void  mouseEntered(MouseEvent e) {
          jbtAbout.setIcon(new ImageIcon(this.getClass().getResource("../img/about.png")));
        }
        public void  mouseExited(MouseEvent e){
          jbtAbout.setIcon(new ImageIcon(this.getClass().getResource("../img/about_mini.png")));
        }
      });
     
      
      
      /* Tratar Eventos */
      TrataEventos eventos  = new  TrataEventos();
      jbtIniciarJogo.addActionListener(eventos);
      jbtAjuda.addActionListener(eventos);
      jbtSair.addActionListener(eventos);
      jbtConfig.addActionListener(eventos);
      jbtAbout.addActionListener(eventos);
      
      //AWTUtilities.setWindowOpacity(this, 0.7F);
      
      criarGui();
  }
  
  
  public void instancia()
  {
    
  }
  
  public void criarGui()
  {
    //setDefaultLookAndFeelDecorated(true);
    setLayout(null);
    panelPrincipal.setLayout(null);
    panelPrincipal.setOpaque(false);
    panelPrincipal.setBounds(0,0,800,560);
    
    panelMenu.setLayout(null);
    panelMenu.setBounds(20,200,350,150);
    
    jbtIniciarJogo.setBounds(10,5,200,25);
    jbtIniciarJogo.setContentAreaFilled(false);
        
    jbtAjuda.setBounds(55,35,100,25);
    jbtAjuda.setContentAreaFilled(false);
    
    jbtSair.setBounds(55,60,100,25);
    jbtSair.setContentAreaFilled(false);
      
    jbtConfig.setBounds(0,5,60,50);
    jbtConfig.setContentAreaFilled(false);
    
    jbtAbout.setBounds(0,500,80,50);
    jbtAbout.setContentAreaFilled(false);
    
    panelMenu.add(jbtIniciarJogo);
    panelMenu.add(jbtAjuda);
    panelMenu.add(jbtSair);
    panelPrincipal.add(jbtConfig);
    panelPrincipal.add(jbtAbout);
    
    panelPrincipal.add(panelMenu);
    
    add(panelPrincipal);
    
    //setBorder(line);
    
    setSize(800,560);
    setUndecorated(true);
    // AWTUtilities.setWindowOpacity(this, 0.95F);  
    setLocationRelativeTo(null);
    setVisible(true);
  }
                                          
  public void visiblidade(boolean visb)
  {
    jbtIniciarJogo.setVisible(visb);
    jbtAjuda.setVisible(visb);
    jbtSair.setVisible(visb);
  }
  
  /* Tratra Eventos */
  public class TrataEventos implements ActionListener
  {
    public void actionPerformed(ActionEvent ev)
    {
      if(ev.getSource()==jbtIniciarJogo )
      {
        visiblidade(false);
        ControloGui.guiJanelaDadosJogo = new JanelaDadosJogo(null,true,700,250);//700,250);
        visiblidade(true);
      }
      if(ev.getSource()==jbtAjuda )
      {
        new JHelp(null, true);
      }
      if(ev.getSource()==jbtSair )
      {
        System.exit(0);
      }
      
      if(ev.getSource()==jbtConfig )
      {
        visiblidade(false);
        ControloGui.guiConfiguracao = new JConfiguracao(null,true,300,250);
        visiblidade(true);
      }
      if(ev.getSource()==jbtAbout)
      {
        new JAbout(null,true); 
      }
      if(flag){
        dispose();
      }
    }
  }
  
  
}