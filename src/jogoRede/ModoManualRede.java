package jogoRede;

import java.awt.event.*;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;


import rede.Servidor;
import sourceModelo.Jogo;

public class ModoManualRede extends JanelaJogoRede {
  
  private Songs sons = new Songs();
  
  private int x,x1,sx,sx1;
  private int y,y1,sy,sy1;
  private boolean block=false;
  
  public InternalRunnableTimeRunGame gameRun;
  
  public ModoManualRede(Jogo jogo,String nome,String ip,int porta)
  {
    super(jogo,nome,ip,porta);
    this.gameRun = new InternalRunnableTimeRunGame();
      
    comecarJogoGui();
    // this.gameRun.start();
    
    if(jogoLocal.idPlayer == 1){
        jlbJ1[25].addMouseMotionListener(new Controler());  
        jlbJ1[25].addMouseListener(new MListener());  
        jlbJ1[25].addMouseListener(new EventMouseL());
        jlbJ1[25].addMouseListener( new MouseAdapter(){
          public void  mouseEntered(MouseEvent e) {}
          public void  mouseExited(MouseEvent e){}
        });
    }
    
    if(jogoLocal.idPlayer == 2){
        jlbJ2[25].addMouseMotionListener(new Controler1());  
        jlbJ2[25].addMouseListener(new MListener1());  
        jlbJ2[25].addMouseListener(new EventMouseL());
        jlbJ2[25].addMouseListener( new MouseAdapter() {  
          public void  mouseEntered(MouseEvent e) {}
          public void  mouseExited(MouseEvent e){}
        });
    }
    
  }
  
  
  
    public class InternalRunnableTimeRunGame extends Thread{
    public InternalRunnableTimeRunGame()
    { }
    public void run() {
      while(true){
        jogarGuiRun();
      }
    }
  }
    
    
    public void jogarGuiRun()
    {
        int cont = 0;
        
      if(cont < jogoLocal.numBatalha){
          
        if( (jJogar1 > 0) && (jJogar2 > 0) ){
          try { Thread.sleep (800);} catch (InterruptedException ex) {}
          numPartida.setText("Partidas Efec.: "+numPart++);
          JanelaJogoRede.jogoLocal.jogarGui();
          limparMesa1();
          verifEnpateGui();
          jJogar1 = 0;
          jJogar2 = 0;
          cont++;
        }
      }
      
      else JOptionPane.showMessageDialog(null,"Fim do Jogo!!!");
    }
    
    
    public static void resetEstatistica()
    {
      estNovo = false;
      estReiniciar = false;
      estContinuar = false;
      estSairJogo = false;
  }
    
  
  
  
  private class Controler extends MouseMotionAdapter {  
    
    @Override
    public void mouseDragged(MouseEvent e) {

      if (e.getX() - x == 0 || e.getX() - x == 0) {  
        x = e.getX();  
      }
      if (e.getY() - y == 0 || e.getY() - y == 0) {  
        y = e.getY();  
      }
      jlbJ1[25].setLocation(jlbJ1[25].getX() + (e.getX() - x), jlbJ1[25].getY() + (e.getY() - y));
    }
    
  }
  
  private class MListener extends MouseAdapter {  
    @Override
    public void mousePressed(MouseEvent e) {
      x = e.getX();  
      y = e.getY();     
    }
  }
  
  private class Controler1 extends MouseMotionAdapter {  
    
    @Override
    public void mouseDragged(MouseEvent e) {
 
      if (e.getX() - x1 == 0 || e.getX() - x1 == 0) {  
        x1 = e.getX();  
      }
      if (e.getY() - y1 == 0 || e.getY() - y1 == 0) {  
        y1 = e.getY();  
      }
      jlbJ2[25].setLocation(jlbJ2[25].getX() + (e.getX() - x1),  jlbJ2[25].getY() + (e.getY() - y1));
    }
  }
  
  private class MListener1 extends MouseAdapter {  
    @Override
    public void mousePressed(MouseEvent e) {
      x1 = e.getX();  
      y1 = e.getY();     
    }
  }
  
  
  public void verifPos()
  {
    if((jlbJ1[25].getX()>=jlbMesaJogo.getX() && jlbJ1[25].getX()<= jlbMesaJogo.getX()+200) && (jlbJ1[25].getY()>= jlbMesaJogo.getY() && jlbJ1[25].getY()<=jlbMesaJogo.getY()+100) ){
          if(jogoLocal.idPlayer==1){
             escritor.println("Joguei"+jogoLocal.idPlayer);
             // JOptionPane.showMessageDialog(null,"Jogador 1 deu Duplo click");
             escritor.flush();
          }
        jJogar1++;
    }
    else{
      jlbJ1[25].setLocation(40, 350);
       jJogar1=0;
       sons.jogar(); 
    }
  }
  
  public void verifPos1()
  {
    if( (jlbJ2[25].getX()>=jlbMesaJogo.getX() && jlbJ2[25].getX()<= jlbMesaJogo.getX()+200) && (jlbJ2[25].getY()>= jlbMesaJogo.getY() && jlbJ2[25].getY()<=jlbMesaJogo.getY()+100) ){
        if(jogoLocal.idPlayer==2){
             escritor.println("Joguei"+jogoLocal.idPlayer);
              // JOptionPane.showMessageDialog(null,"Jogador 2 deu Duplo click");
             escritor.flush();
        }
        jJogar2++;
    }
    else {
      jlbJ2[25].setLocation(636, 350);
       jJogar2=0;;
       sons.jogar(); 
    }
  }
 
  
  public void verifTable()
  {
    if(contJogada==2){
      // .. JOptionPane.showMessageDialog(null,"Ja se pode Jogar!!: ");
      contJogada=0;   
    }
  }
  
  public class EventMouseL implements MouseListener{
    public   void mouseClicked(MouseEvent e){
      if ((e.getClickCount() == 2) &&  (e.getSource()==jlbJ1[25] )  /*(e.getButton() == MouseEvent.BUTTON1)*/) {  
       // JOptionPane.showMessageDialog(null," Duplo Click! ");
          if(jogoLocal.idPlayer==1){
             escritor.println("Joguei"+jogoLocal.idPlayer);
             // JOptionPane.showMessageDialog(null,"Jogador 1 deu Duplo click");
             escritor.flush();
          }
        jJogar1++;
        jlbJ1[25].setBounds(320,180,106,163);
      }
      if ((e.getClickCount() == 2) &&  (e.getSource()==jlbJ2[25] )  /*(e.getButton() == MouseEvent.BUTTON1)*/) {  
        //JOptionPane.showMessageDialog(null," Duplo Click1! ");
          if(jogoLocal.idPlayer==2){
             escritor.println("Joguei"+jogoLocal.idPlayer);
              // JOptionPane.showMessageDialog(null,"Jogador 2 deu Duplo click");
             escritor.flush();
          }
        jJogar2++;
        jlbJ2[25].setBounds(380,200,106,163);
      }
    }
    public void mouseEntered(MouseEvent e){
      // JOptionPane.showMessageDialog(null," Ola! ");
    }
    public void mouseExited(MouseEvent e){
      //JOptionPane.showMessageDialog(null," Ola! ");
    }
    public void mousePressed(MouseEvent e){
      
    }
    public void mouseReleased(MouseEvent e){
      //JOptionPane.showMessageDialog(null," Ola! ");
      if(e.getSource() == jlbJ1[25]){
        verifPos();
      }
      if(e.getSource() == jlbJ2[25] ){
        verifPos1();
      }
      // verifTable();
    }  
  }
  
  
  
  
  
  
  
}