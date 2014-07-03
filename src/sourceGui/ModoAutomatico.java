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


public class ModoAutomatico extends JanelaJogo{
  
  public InternalRunnableTimeRunGame gameRun;
    
  public ModoAutomatico()
  {     
    this.gameRun = new InternalRunnableTimeRunGame();
      
    numPartida.setText("Partidas Efec.: "+numPart); 
    batalhas = 0;
    comecarJogoGui();
    this.gameRun.start();
  }
  
  
  public void jogarGuiRun(){
    if(JanelaDadosJogo.batalhas > batalhas){
      numPartida.setText("Partidas Efec.: "+numPart++);
      jogarJogador1();
      
      try { Thread.sleep (800); } catch (InterruptedException ex) {}
      jogarJogador2();
      try { Thread.sleep (800); } catch (InterruptedException ex) {}
      
      limparMesa();
      jogo.jogarGui();
      verifEnpateGui();
      
      redemencionePanelJ2();
      redemencionePanelJ1();
      try { Thread.sleep (500); } catch (InterruptedException ex) {}
      batalhas++;
    }
    else{
      ControloGui.guiEstatisicaJogo = new JEstatiscaJogo(null,true,jogo,460,163);
      
      if(estNovo){
        ControloGui.guiJanelaDadosJogo = new JanelaDadosJogo(null,true,500,250,"Estatistica");
        novoJogoGui();
        novoJogoBool = false;
        jogarBool = true;
      }
      if(estContinuar){
        ControloGui.guiJanelaDadosJogo = new JanelaDadosJogo(null,true,500,250,false);
        continuarJogoGui();
        estContinuar = false;
        jogarBool = true;
      }
      if(estSairJogo){
        ControloGui.guiJanelPrincipal = new JanelaPrincipal();
        ControloGui.guiJanelaJogo.dispose();
        gameRun.stop();
      }
      
      resetEstatistica();
      // batalhas = 0;
    }
    
  }
  
  
  public class InternalRunnableTimeRunGame extends Thread{
    public InternalRunnableTimeRunGame()
    {}
    @Override
    public void run() {
      int runInt = 0;
      try { Thread.sleep (1000); } catch (InterruptedException ex) {}
      while(true){
        /* Jogar */
        if(jogarBool){
          jogarGuiRun();
        }
        if(novoJogoBool)
        {
          ControloGui.guiJanelaDadosJogo = new JanelaDadosJogo(null,true,500,250,"Novo Jogo Pause");
          novoJogoGui();
          novoJogoBool = false;
          jogarBool = true;
        }
      }
    }
  }
  
  
  public static void resetEstatistica()
  {
    estNovo = false;
    estReiniciar = false;
    estContinuar = false;
    estSairJogo = false;
  }
  
  
  
}