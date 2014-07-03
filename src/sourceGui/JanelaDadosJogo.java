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

public class JanelaDadosJogo extends JDialog {
  
  public static int batalhas=0;
  public static String sj1="";
  public static String sj2="";
  
  private Border line;
  private JPanel panelPrincipal;
  private JLabel jlbTitulo,jlbNomeJ1,jlbNomeJ2,jlbNumBatalha;
  private JTextField jtfNomeJ1,jtfNomeJ2,jtfNumBatalha;
  private JButton jbtContinuar,jbtSair,jbtContinuarNew,jbtSairNew,jbtContinuarCont;
  
  
  public JanelaDadosJogo(Frame frame, boolean nl,int posWith,int posHeight)
  {
    super(frame,nl);
    instancia();
    resetButton();
    jbtContinuar.setVisible(true); jbtContinuar.setEnabled(true);
    jbtSair.setVisible(true); jbtSair.setEnabled(true);
    
    /* Tratar Eventos */
    TrataEventos eventos  = new  TrataEventos();
    jbtContinuar.addActionListener(eventos);
    jbtSair.addActionListener(eventos);
    
    criarGui(posWith,posHeight);
  }
  
  public JanelaDadosJogo(Frame frame, boolean nl,int posWith,int posHeight,String st)
  {
    super(frame,nl);
    instancia();
    resetButton();
    jbtContinuarNew.setVisible(true); jbtContinuarNew.setEnabled(true);
    jbtSairNew.setVisible(true); jbtSairNew.setEnabled(true);
    
    /* Tratar Eventos */
    TrataEventos eventos  = new  TrataEventos();
    jbtContinuarNew.addActionListener(eventos);
    jbtSairNew.addActionListener(eventos);
    
    criarGui(posWith,posHeight);
  } 
  
  
  /* Continuar */
  public JanelaDadosJogo(Frame frame, boolean nl,int posWith,int posHeight,boolean bool)
  {
    super(frame,nl);
    instancia();
    
    reporButton(false);
    reporContinue(false);
    
    /* Tratar Eventos */
    TrataEventos eventos  = new  TrataEventos();
    jbtContinuarCont.addActionListener(eventos);
    jbtSairNew.addActionListener(eventos);
    
    criarGui(posWith,posHeight);
  }
  
  
  
  public void instancia()
  {
    line = BorderFactory.createTitledBorder("");
    panelPrincipal = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    
    
    jlbTitulo = new JLabel(" Dados para o Jogo ");
    
    jlbNomeJ1 = new JLabel("Nome Jogador1:");
    jlbNomeJ2 = new JLabel("Nome Jogador2: ");
    jlbNumBatalha = new JLabel("Numero de Batalha");
    
    jtfNomeJ1 = new JTextField(); 
    jtfNomeJ2 = new JTextField();
    jtfNumBatalha = new JTextField();
    jtfNumBatalha.setDocument(new ApenasNumero());
    
    jbtContinuar = new JButton("Jogar");
    jbtSair = new JButton("Sair");
    
    jbtContinuarNew = new JButton("Jogar");
    jbtSairNew = new JButton("Sair");
    
    jbtContinuarCont = new JButton("JogarCont");
    
  }
  
  
  public void criarGui(int posWith,int posHeight)
  {
    setLayout(null);
    panelPrincipal.setLayout(null);
    panelPrincipal.setOpaque(false);
    panelPrincipal.setBounds(0,0,400,300);
    
    Font font = new Font("Footlight MT Light",0,18 );
    Font font1 = new Font("Footlight MT Light",0,16 );
    
    jlbNomeJ1.setFont(font1);
    jtfNomeJ1.setFont(font1);
    jlbNomeJ2.setFont(font1);
    jtfNomeJ2.setFont(font1);
    jlbNumBatalha.setFont(font1);
    jtfNumBatalha.setFont(font1);
    
    jlbTitulo.setBounds(80,15,180,25);  jlbTitulo.setFont(font);  jlbTitulo.setForeground(new Color(113,114,118));
    jlbNomeJ1.setBounds(20,65,120,25); jtfNomeJ1.setBounds(155,65,120,25);  jlbNomeJ1.setForeground(new Color(255,255,255));
    jlbNomeJ2.setBounds(20,105,120,25); jtfNomeJ2.setBounds(155,105,120,25);  jlbNomeJ2.setForeground(new Color(255,255,255));
    jlbNumBatalha.setBounds(50,145,1000,25); jtfNumBatalha.setBounds(200,145,80,25);  jlbNumBatalha.setForeground(new Color(255,255,255));
    
    jbtContinuar.setBounds(50,195,100,25);
    jbtSair.setBounds(150,195,80,25);
    
    jbtContinuarNew.setBounds(50,195,100,25);
    jbtSairNew.setBounds(150,195,80,25);
    
    jbtContinuarCont.setBounds(50,195,100,25);
    
    
    panelPrincipal.add(jlbTitulo);
    panelPrincipal.add(jlbNomeJ1);       panelPrincipal.add(jtfNomeJ1);
    panelPrincipal.add(jlbNomeJ2);       panelPrincipal.add(jtfNomeJ2);
    panelPrincipal.add(jlbNumBatalha);   panelPrincipal.add(jtfNumBatalha);
    
    panelPrincipal.add(jbtContinuar);
    panelPrincipal.add(jbtSair);
    
    panelPrincipal.add(jbtContinuarNew);
    panelPrincipal.add(jbtSairNew);
    
    panelPrincipal.add(jbtContinuarCont);
    
    
    add(panelPrincipal);
    
    setSize(350,300);
    setUndecorated(true);
    AWTUtilities.setWindowOpacity(this, 0.85F);  
    setLocation(new Point(posWith,posHeight)); //    setLocation(new Point(700,250));
    setVisible(true);
  }
  
  /* Tratra Eventos */
  public class TrataEventos implements ActionListener
  {
    public void actionPerformed(ActionEvent ev)
    {
      ControloGui.config.carregarModo();
      
      if(ev.getSource()==jbtContinuar )
      {
        if(validarDados() ){
          JanelaJogo.jogo.jogador1.setNome(jtfNomeJ1.getText());
          JanelaJogo.jogo.jogador2.setNome(jtfNomeJ2.getText());
          // ControloGui.guiJanelaJogo = new ModoAutomatico();
          ControloGui.chooseModePlayer.dispose();
          if(ControloGui.config.modeGame == 1)
          {
            ControloGui.guiJanelaJogo = new ModoAutomatico();
          }
          else{
            ControloGui.guiJanelaJogo = new ModoManual();
          }
          
          // ModoAutomatico
          // ArrastarSoltar
          // guiJogoManual
          // ControloGui.guiJogoManual = new ModoAutomatico();
          
          
          ControloGui.guiJanelPrincipal.dispose();
          dispose();
        }
        else JOptionPane.showMessageDialog(null,"Erro numero de batlaha invalido!");
      }
      
      if(ev.getSource()==jbtSair )
      {
        dispose();
      }
      
      if(ev.getSource()==jbtContinuarNew){
        if(validarDados() ){
          JanelaJogo.jogo.jogador1.setNome(jtfNomeJ1.getText());
          JanelaJogo.jogo.jogador2.setNome(jtfNomeJ2.getText());
          //if(!JanelaJogo.execut){
          dispose();
          //}
          // ControloGui.guiJanelaJogo.estNovo = true;
        }
        else JOptionPane.showMessageDialog(null,"Erro numero de batlaha invalido!");
      }
      
      if(ev.getSource()==jbtContinuarCont){
        if(validarDados() ){
          //  if(!JanelaJogo.execut){
          dispose();
          // }
          // ControloGui.guiJanelaJogo.estNovo = true;
        }
        else JOptionPane.showMessageDialog(null,"Erro numero de batlaha invalido!");
      }
      
      if(ev.getSource()==jbtSairNew){
        ControloGui.guiJanelPrincipal = new JanelaPrincipal();
        //ControloGui.guiJanelaJogo.gameRun.stop();
        ControloGui.guiJanelaJogo.dispose();
        dispose();
      }
      
    }
  }
  
  
  
  public boolean  validarDados(){
    try{
      int numero = Integer.parseInt(jtfNumBatalha.getText());
    }catch (Exception ex) {
      return false;
    }
    if( Integer.parseInt(jtfNumBatalha.getText() ) > 0 ){
      batalhas = batalhas = Integer.parseInt( jtfNumBatalha.getText() );
      sj1=jtfNomeJ1.getText();
      sj2=jtfNomeJ2.getText();
      return true;
    }
    return false;
  }
  
  public void reporButton(boolean bol)
  {  
    jbtContinuar.setVisible(bol); jbtContinuar.setEnabled(bol);
    jbtSair.setVisible(bol); jbtSair.setEnabled(bol); 
    
    jbtContinuarNew.setVisible(bol); jbtContinuarNew.setEnabled(bol);
    
    jbtSairNew.setVisible(!bol); jbtSairNew.setEnabled(!bol);
    
    jbtContinuarCont.setVisible(!bol); jbtContinuarCont.setEnabled(!bol);
  }
  
  
  public void resetButton()
  {
    jbtContinuar.setVisible(false); jbtContinuar.setEnabled(false);
    jbtSair.setVisible(false); jbtSair.setEnabled(false); 
    jbtContinuarNew.setVisible(false); jbtContinuarNew.setEnabled(false);
    jbtSairNew.setVisible(false); jbtSairNew.setEnabled(false);
    jbtContinuarCont.setVisible(false); jbtContinuarCont.setEnabled(false);
  }
  
  public void visiblelityAll(boolean verif)
  {
    jlbNomeJ1.setVisible(verif);
    jtfNomeJ1.setVisible(verif);
    jlbNomeJ2.setVisible(verif);
    jtfNomeJ2.setVisible(verif);
    jlbNumBatalha.setVisible(verif);
    jtfNumBatalha.setVisible(verif);
    resetButton();
  }
  
  public void reporContinue(boolean bool)
  {
    jtfNomeJ1.setEditable(bool);
    jtfNomeJ2.setEditable(bool);
    jlbNomeJ1.setEnabled(bool);
    jlbNomeJ2.setEnabled(bool);
    
    jtfNomeJ1.setVisible(bool);
    jtfNomeJ2.setVisible(bool);
    jlbNomeJ1.setVisible(bool);
    jlbNomeJ2.setVisible(bool);
    
  }
  
  
  
  public static void main(String[] args) {
    try 
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    new JanelaDadosJogo(null, true,0,0,"");
  }
  
  
}