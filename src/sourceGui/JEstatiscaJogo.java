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


import com.sun.awt.AWTUtilities; 


public class JEstatiscaJogo extends JDialog {
  
  private Border line;
  private JPanel panelPrincipal;
  
  private JPanel panel1,panel2,panel3,panel4,panel5,panel6;
  private JLabel jlbJogador1,jlbJogador2,jlbJ1Result,jlbJ2Result,jlbX;
  
  private JLabel jlbP2_Descr,jlbP2_1,jlbP2_2;
  private JLabel jlbP3_Descr,jlbP3_1,jlbP3_2;
  private JLabel jlbP4_Descr,jlbP4_1,jlbP4_2;
  private JLabel jlbP5_Descr,jlbP5_1,jlbP5_2;
  private JLabel jlbP6_Descr,jlbP6_1,jlbP6_2;
  
  
  private JLabel jlbTitulo,jlbNomeJ1,jlbNomeJ2,jlbNumBatalha;
  private JTextField jtfNomeJ1,jtfNomeJ2,jtfNumBatalha;
  private JButton jbtContinuar,jbtNovoJogo,jbtSair,jbtSairJogo;
  
  
  private String str1,str2;
  private JTextArea jlbDesc1,jlbDesc2;
  
  
 
  
  public JEstatiscaJogo(Frame frame, boolean nl,Jogo jogo,int posWith,int posHeight)
  {
    super(frame,nl);
    

    line = BorderFactory.createTitledBorder("");
    
    instancia();
    setEstatistica();
    
    /* Tratar Eventos */
    TrataEventos eventos  = new  TrataEventos();
    jbtSair.addActionListener(eventos);
    jbtContinuar.addActionListener(eventos);
    jbtNovoJogo.addActionListener(eventos);
      
    criarGui1(posWith,posHeight);
  }
  
  public JEstatiscaJogo(Frame frame, boolean nl,Jogo jogo,int posWith,int posHeight,int n)
  {
    super(frame,nl);
    
    line = BorderFactory.createTitledBorder("");
    
    instancia();
    
    /* Tratar Eventos */
    TrataEventos eventos  = new  TrataEventos();
    jbtSair.addActionListener(eventos);
    jbtContinuar.addActionListener(eventos);
    //jbtReiniciar.addActionListener(eventos);
    jbtNovoJogo.addActionListener(eventos);
      
    criarGui1(posWith,posHeight);
  }
  
  
  
  public void instancia()
  {
    
    //panelPrincipal = new JPanel();
    panelPrincipal = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);

    
    jlbTitulo = new JLabel("Estatistica do Jogo");
    
    panel1 = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    jlbJogador1 = new JLabel("Jogador1"); jlbJogador1.setForeground(new Color(255,255,255));
    jlbJogador2 = new JLabel("Jogador2"); jlbJogador2.setForeground(new Color(255,255,255));
    jlbJ1Result = new JLabel("2"); jlbJ1Result.setForeground(new Color(255,250,240 )); jlbJ1Result.setHorizontalAlignment(JLabel.RIGHT); 
    jlbJ2Result = new JLabel("0"); jlbJ2Result.setForeground(new Color(255,250,240 ));
    jlbX = new JLabel("X"); jlbX.setForeground(new Color(255,255,255));
    
    panel2 = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    jlbP2_Descr = new JLabel("Batalhas Perdidas"); jlbP2_Descr.setForeground(new Color(255,255,255)); jlbP2_Descr.setHorizontalAlignment(JLabel.CENTER); 
    jlbP2_1 = new JLabel("xxxx"); jlbP2_1.setForeground(new Color(255,255,255));
    jlbP2_2= new JLabel("xxxx"); jlbP2_2.setForeground(new Color(255,255,255));
    
    panel3 = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    jlbP3_Descr = new JLabel("Batalhas Vencidas"); jlbP3_Descr.setForeground(new Color(255,255,255)); jlbP3_Descr.setHorizontalAlignment(JLabel.CENTER); 
    jlbP3_1= new JLabel("xxxx"); jlbP3_1.setForeground(new Color(255,255,255));
    jlbP3_2= new JLabel("xxxx"); jlbP3_2.setForeground(new Color(255,255,255));
    
    panel4 = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    jlbP4_Descr = new JLabel("Quantidade de Querras"); jlbP4_Descr.setForeground(new Color(255,255,255)); jlbP4_Descr.setHorizontalAlignment(JLabel.CENTER);
    jlbP4_1= new JLabel("xxxx"); jlbP4_1.setForeground(new Color(255,255,255));
    jlbP4_2= new JLabel("xxxx"); jlbP4_2.setForeground(new Color(255,255,255));
    
    panel5 = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    jlbP5_Descr = new JLabel("Guerras Ganhas"); jlbP5_Descr.setForeground(new Color(255,255,255)); jlbP5_Descr.setHorizontalAlignment(JLabel.CENTER);
    jlbP5_1= new JLabel("xxxx"); jlbP5_1.setForeground(new Color(255,255,255));
    jlbP5_2= new JLabel("xxxx"); jlbP5_2.setForeground(new Color(255,255,255));
    
    panel6 = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    jlbP6_Descr = new JLabel("Guerras Perdidas"); jlbP6_Descr.setForeground(new Color(255,255,255)); jlbP6_Descr.setHorizontalAlignment(JLabel.CENTER);
    jlbP6_1= new JLabel("xxxx"); jlbP6_1.setForeground(new Color(255,255,255));
    jlbP6_2= new JLabel("xxxx"); jlbP6_2.setForeground(new Color(255,255,255));
      
    
    jbtContinuar = new JButton("Continua");
    jbtNovoJogo = new JButton("Novo Jogo");
    //jbtReiniciar = new JButton("Reiniciar");
    jbtSair = new JButton("Sair do Jogo");
  }
  
  public void criarGui1(int posWith,int posHeight)
  {
    setLayout(null);
    panelPrincipal.setLayout(null);
    panel1.setLayout(null);
    panel2.setLayout(null);
    panel3.setLayout(null);
    panel4.setLayout(null);
    panel5.setLayout(null);
    panel6.setLayout(null);
    
    // panelPrincipal.setOpaque(false);
    panelPrincipal.setBounds(0,0,4500,350);
    
    Font font = new Font("Bradley Hand ITC",5,28 );
    // Font font1 = new Font("Footlight MT Light",0,16 );
    
    jlbTitulo.setBounds(140,15,280,25);  jlbTitulo.setFont(font);  
    jlbTitulo.setForeground(new Color(113,114,118));
     
      panel1.setBounds(20,45,400,40); panel1.setBorder(line);
      jlbJogador1.setBounds(10,8,100,25); jlbJogador1.setBorder(line);
      jlbJ1Result.setBounds(120,8,50,25); jlbJ1Result.setBorder(line);
      jlbX.setBounds(170,8,35,25); jlbX.setBorder(line);
      jlbJ2Result.setBounds(200,8,50,25); jlbJ2Result.setBorder(line);
      jlbJogador2.setBounds(260,8,100,25); jlbJogador2.setBorder(line);
      
      panel2.setBounds(20,90,400,40); panel2.setBorder(line);
      jlbP2_1.setBounds(50,8,50,25); jlbP2_1.setBorder(line);
      jlbP2_Descr.setBounds(100,8,180,25); jlbP2_Descr.setBorder(line);
      jlbP2_2.setBounds(280,8,50,25); jlbP2_2.setBorder(line);
      
      panel3.setBounds(20,135,400,40); panel3.setBorder(line);
      jlbP3_1.setBounds(50,8,50,25); jlbP3_1.setBorder(line);
      jlbP3_Descr.setBounds(100,8,180,25); jlbP3_Descr.setBorder(line);
      jlbP3_2.setBounds(280,8,50,25); jlbP3_2.setBorder(line);
      
      panel4.setBounds(20,180,400,40); panel4.setBorder(line);
      jlbP4_1.setBounds(50,8,50,25); jlbP4_1.setBorder(line);
      jlbP4_Descr.setBounds(100,8,180,25); jlbP4_Descr.setBorder(line);
      jlbP4_2.setBounds(280,8,50,25); jlbP4_2.setBorder(line);
      
      panel5.setBounds(20,225,400,40); panel5.setBorder(line);
      jlbP5_1.setBounds(50,8,50,25); jlbP5_1.setBorder(line);
      jlbP5_Descr.setBounds(100,8,180,25); jlbP5_Descr.setBorder(line);
      jlbP5_2.setBounds(280,8,50,25); jlbP5_2.setBorder(line);
      
      panel6.setBounds(20,270,400,40); panel6.setBorder(line);
      jlbP6_1.setBounds(50,8,50,25); jlbP6_1.setBorder(line);
      jlbP6_Descr.setBounds(100,8,180,25); jlbP6_Descr.setBorder(line);
      jlbP6_2.setBounds(280,8,50,25); jlbP6_2.setBorder(line);
      

          
    jbtContinuar.setBounds(50,312,100,25);
    jbtNovoJogo.setBounds(170,312,100,25);
    //jbtReiniciar.setBounds(220,312,100,25);
    jbtSair.setBounds(290,312,100,25);
    
    
    
    panelPrincipal.add(jlbTitulo); 
    
    panel1.add(jlbJogador1);
    panel1.add(jlbJ1Result);
    panel1.add(jlbX);
    panel1.add(jlbJ2Result);
    panel1.add(jlbJogador2);
    
    panel2.add(jlbP2_1);
    panel2.add(jlbP2_Descr);
    panel2.add(jlbP2_2);
    
    panel3.add(jlbP3_1);
    panel3.add(jlbP3_Descr);
    panel3.add(jlbP3_2);
    
    panel4.add(jlbP4_1);
    panel4.add(jlbP4_Descr);
    panel4.add(jlbP4_2);
    
    
    panel5.add(jlbP5_1);
    panel5.add(jlbP5_Descr);
    panel5.add(jlbP5_2);
    
    panel6.add(jlbP6_1);
    panel6.add(jlbP6_Descr);
    panel6.add(jlbP6_2);
        
    panelPrincipal.add(panel1);
    panelPrincipal.add(panel2);
    panelPrincipal.add(panel3);
    panelPrincipal.add(panel4);
    panelPrincipal.add(panel5);
    panelPrincipal.add(panel6);
    
    panelPrincipal.add(jbtContinuar);
    panelPrincipal.add(jbtNovoJogo);
    //panelPrincipal.add(jbtReiniciar);
    panelPrincipal.add(jbtSair);
   
    
    add(panelPrincipal);
    
      
    setSize(440,350);
    setUndecorated(true);
    //AWTUtilities.setWindowOpacity(this, 0.65F);   
    
    setLocation(new Point(posWith,posHeight)); //setLocationRelativeTo(null);
    setVisible(true);
    }
  
  /* Tratra Eventos */
  public class TrataEventos implements ActionListener
  {
    public void actionPerformed(ActionEvent ev)
    {
      if(ev.getSource()==jbtContinuar )
      {
        JanelaJogo.contBool = true;
        dispose();
      }
      if(ev.getSource()==jbtSair )
      {
        JanelaJogo.exitBool =true;
        dispose();
      }
      if(ev.getSource()==jbtNovoJogo )
      {
        JanelaJogo.novoJogoBool = true;
        dispose();
      }
    }
  }
  
  
  public void setEstatistica()
  {
    JanelaJogo.jogo.resultadoFinal();
    
    jlbJogador1.setText(""+JanelaJogo.jogo.jogador1.getNome());
    jlbJogador2.setText(""+JanelaJogo.jogo.jogador2.getNome());
    
    jlbJ1Result.setText(""+JanelaJogo.jogo.jogador1.getPontos() );
    jlbJ2Result.setText(""+JanelaJogo.jogo.jogador2.getPontos() );
    
    jlbP2_1.setText(""+JanelaJogo.jogo.jogador1.estatisticaJogo.numPartPerdidas); jlbP2_2.setText(""+JanelaJogo.jogo.jogador2.estatisticaJogo.numPartPerdidas);
    jlbP3_1.setText(""+JanelaJogo.jogo.jogador1.estatisticaJogo.numPartidasVencidas); jlbP3_2.setText(""+JanelaJogo.jogo.jogador2.estatisticaJogo.numPartidasVencidas);
    jlbP4_1.setText(""+( (JanelaJogo.jogo.jogador1.estatisticaJogo.numGuerrasVenciadas)+(JanelaJogo.jogo.jogador1.estatisticaJogo.numGuerrasPerdidas))); jlbP4_2.setText(""+((JanelaJogo.jogo.jogador1.estatisticaJogo.numGuerrasVenciadas)+(JanelaJogo.jogo.jogador1.estatisticaJogo.numGuerrasPerdidas)));
    jlbP5_1.setText(""+JanelaJogo.jogo.jogador1.estatisticaJogo.numGuerrasVenciadas); jlbP5_2.setText(""+JanelaJogo.jogo.jogador2.estatisticaJogo.numGuerrasVenciadas);
    jlbP6_1.setText(""+JanelaJogo.jogo.jogador1.estatisticaJogo.numGuerrasPerdidas); jlbP6_2.setText(""+JanelaJogo.jogo.jogador2.estatisticaJogo.numGuerrasPerdidas);
    
  }
  
  
  public static void main(String[] args) {
    try 
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    new JEstatiscaJogo(null,true,JanelaJogo.jogo,0,0);
  }
  
}