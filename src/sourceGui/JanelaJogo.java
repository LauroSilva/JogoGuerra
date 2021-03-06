package sourceGui;

import sourceModelo.*;
import sourceGuiControlo.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.Border;
import javax.swing.BorderFactory; 

import com.sun.awt.AWTUtilities; 


public class JanelaJogo extends JFrame{
  protected int jJogar1 = 0;
  protected int jJogar2 = 0;
  
  public static boolean execut,estNovo,estReiniciar,estContinuar,estSairJogo;
  public static boolean jogarBool,novoJogoBool,runBool,rstartBool,contBool,exitBool,restart,run;
  
  protected int inicio = 0;
  protected int batalhas = 1;
  protected int ultmimoCartaJ1,numCartas,ultmimoCartaJ2;
  protected int numPart =1;
  
  protected int numMaxPart =0;
  protected int contJogada=0;
  
  public Baralho baralho = new Baralho();
  public static Jogo jogo = new Jogo();
  public Songs sons = new Songs();

  
  public InternalRunnableTimeRunGame gameRun;// = new InternalRunnableTimeRunGame();
  
  
  private JButton jbtPause;
  protected JLabel jlbCartaJogador1,jlbCartaJogador2,jlbMesaJogo;
  private JLabel jlbCartaJ1,jlbCartaJ2;
  private JPanel panelPrincipal,panelMenu;
  private Border line;
  private Icon imgJ1,imgJ2;
  private JButton jbtFechar,jbtMinimizar;
  protected JLabel[] jlbJ1,jlbJ2;
  
  protected JLabel jlbGuerra,numMaxPartida,numPartida;
  private JLabel lg1,lg2;
  private JLabel jlbdc1,jlbdc2;
  
  
  public JanelaJogo()
  {
    gameRun = new InternalRunnableTimeRunGame();
  
    
    run = true;
    execut = false;
    jogarBool = false;
    novoJogoBool = false;
    rstartBool = false;
    runBool = false;
    restart = false;
        
    exitBool = false;
    contBool = false;
    
    estNovo = false;
    estReiniciar = false;
    estContinuar = false;
    estSairJogo = false;
    
    line = BorderFactory.createTitledBorder("");
    
    Font font = new Font("Footlight MT Light",0,16 );
    
    jlbMesaJogo = new JLabel(); jlbMesaJogo.setBorder(line);
    
    jlbGuerra = new JLabel("______________________GUERRA_____________________"); jlbGuerra.setFont(font); jlbGuerra.setForeground(new Color(255,255,255));
    jlbGuerra.setVisible(false);
    
    numMaxPartida = new JLabel("Maximo de Partida: "+JanelaDadosJogo.batalhas); numMaxPartida.setFont(font); numMaxPartida.setForeground(new Color(250,10,10));
    numPartida = new JLabel("Partidas Efec.: "+numPart); numPartida.setFont(font); numPartida.setForeground(new Color(255,255,255));
    
    jlbdc1 = new JLabel("<-- "+JanelaDadosJogo.sj1);     jlbdc1.setFont(font); jlbdc1.setForeground(new Color(255,255,255));
    jlbdc2 = new JLabel(""+JanelaDadosJogo.sj2+" -->");     jlbdc2.setFont(font); jlbdc2.setForeground(new Color(255,255,255));
    
    
    panelPrincipal = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][1]);
   
   
    panelMenu= new JPanel();
    
    
    jbtPause  = new JButton(new ImageIcon(this.getClass().getResource("../img/pause3.png")));
    jbtPause.setContentAreaFilled(false);
    
    
    jbtFechar = new JButton(new ImageIcon(this.getClass().getResource("../img/fechar_edited.png")));
    jbtFechar.addMouseMotionListener(new MouseMotionAdapter(){  
      public void mouseMoved(MouseEvent e) {
      }
      public void  mouseDragged(MouseEvent e){
      }
    });
    
    jbtFechar.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        jbtFechar.setIcon(new ImageIcon(this.getClass().getResource("../img/fechar.png")));
      }
      public void  mouseExited(MouseEvent e){
        jbtFechar.setIcon(new ImageIcon(this.getClass().getResource("../img/fechar_edited.png")));
      }
    });
    
    
    jbtMinimizar = new JButton(new ImageIcon(this.getClass().getResource("../img/minimizar_edited.png")));
    jbtMinimizar.addMouseMotionListener(new MouseMotionAdapter(){  
      public void mouseMoved(MouseEvent e) {
      }
      public void  mouseDragged(MouseEvent e){
      }
    });
    
    jbtMinimizar.addMouseListener( new MouseAdapter() {
      public void  mouseEntered(MouseEvent e) {
        jbtMinimizar.setIcon(new ImageIcon(this.getClass().getResource("../img/minimizar.png")));
      }
      public void  mouseExited(MouseEvent e){
        jbtMinimizar.setIcon(new ImageIcon(this.getClass().getResource("../img/minimizar_edited.png")));
      }
      public void mouseClicked(MouseEvent e){
      }
    });
      
    jbtFechar.setContentAreaFilled(false);
    jbtMinimizar.setContentAreaFilled(false);
    
    imgJ1 = new ImageIcon(this.getClass().getResource("../img/white.png"));
    imgJ2 = new ImageIcon(this.getClass().getResource("../img/white.png"));
    
    jlbCartaJogador1 = new JLabel(imgJ1);
    jlbCartaJogador2 = new JLabel(imgJ2);
    
    lg1 = new JLabel( new ImageIcon(this.getClass().getResource("../img/white.png")));
    lg2 = new JLabel( new ImageIcon(this.getClass().getResource("../img/white.png")));
    
    jlbCartaJ1 = new JLabel( new ImageIcon(this.getClass().getResource("../img/white.png")));  
    jlbCartaJ2 = new JLabel( new ImageIcon(this.getClass().getResource("../img/white.png")));

    
    panelPrincipal.setLayout(null);
    panelPrincipal.setBorder(line);
    instanciarCartasJogadoresPorPanel();
    
    jbtMinimizar.setBounds(720,4,30,30);
    jbtFechar.setBounds(750,4,30,30);
    jbtPause.setBounds(350,444,100,100);
    
    
    jlbCartaJogador1.setBounds(200,80,356,355);  
    jlbCartaJogador2.setBounds(250,120,356,355);
    
    numMaxPartida.setBounds(300,20,180,20);
    jlbGuerra.setBounds(200,60,500,20);
    
    numPartida.setBounds(340,350,220,100);
    
    
    lg1.setBounds(170,70,106,163);
    lg1.setLayout(null);
    
    lg2.setBounds(510,70,106,163);
    lg2.setLayout(null);
    
    jlbCartaJ1.setBounds(320,180,106,163);
    jlbCartaJ2.setBounds(380,200,106,163);
    
    
    jlbdc1.setBounds(170,500,150,50);
    jlbdc2.setBounds(540,500,150,50);
    
    jlbMesaJogo.setBounds(270,160,250,230);
    
    
    panelPrincipal.add(jlbCartaJogador2);
    panelPrincipal.add(jlbCartaJogador1);
    
    panelPrincipal.add(jbtMinimizar);
    panelPrincipal.add(jbtFechar); 
    
    panelPrincipal.add(jbtPause);
    
    panelPrincipal.add(jlbGuerra);
    panelPrincipal.add(numMaxPartida);
    
    panelPrincipal.add(lg1);//
    panelPrincipal.add(lg2);//
    panelPrincipal.add(jlbMesaJogo);
    panelPrincipal.add(jlbCartaJ1);  
    panelPrincipal.add(jlbCartaJ2);  
    
    panelPrincipal.add(jlbdc1);
    panelPrincipal.add(jlbdc2);
    
    panelPrincipal.add(numPartida);
    panelPrincipal.add(numPartida);
    
    ultmimoCartaJ1=25;
    numCartas=25;
    ultmimoCartaJ2=25;
    
    
    /* Tratar Eventos */
    TrataEventos eventos  = new  TrataEventos();
    jbtFechar.addActionListener(eventos);
    jbtMinimizar.addActionListener(eventos);
    jbtPause.addActionListener(eventos);
    
    
    instanciarCartasJogadoresPorPanel();
    porPanelCartas();
    criarGui();
    
    /*  Elementos Adicional  */
     comecarJogoGui();
     gameRun.start();
    
  }
  
  public void criarGui()
  {
    setLayout(null);
    panelPrincipal.setBounds(0,0,800,560);
    add(panelPrincipal);
    
    setSize(800,560);
    setUndecorated(true);
    AWTUtilities.setWindowOpacity(this, 0.95F);  
    setLocationRelativeTo(null);
    setVisible(true);
    
  }
  
  
  /* Tratra Eventos */
  public class TrataEventos implements ActionListener
  {
    public void actionPerformed(ActionEvent ev)
    {
      if(ev.getSource()==jbtFechar )
      {
        System.exit(0);
      }
      if(ev.getSource()==jbtMinimizar )
      {
        setExtendedState(JFrame.ICONIFIED);
      }
      if(ev.getSource()==jbtPause){
        gameRun.suspend();
        ControloGui.guiPause = new JPauseGame(null,true,gameRun);
      }
      if(JPauseGame.novo){
        novoJogoBool = true;
      }
      if(JPauseGame.sair)
      {
        ControloGui.guiJanelPrincipal = new JanelaPrincipal();
        ControloGui.guiJanelaJogo.dispose();
        run = false;
        exitBool = false;
      }
      JPauseGame.inicBotton(false);
    }
    
  }
  
  public void instanciarCartasJogadoresPorPanel()
  {
    int nLinhas = 10;
    jlbJ1 = new JLabel[52]; 
    jlbJ2 = new JLabel[52];
    
    for(int i=0;i<26;i++){
      jlbJ1[i] = new JLabel(new ImageIcon(this.getClass().getResource("../img/white.png")));    
      jlbJ2[i] = new JLabel(new ImageIcon(this.getClass().getResource("../img/white.png")));    
      nLinhas = nLinhas+12;
    }

  }
  
  public void porPanelCartas(){
    for(int j=25;j>=0;j--)
    {
      panelPrincipal.add(jlbJ2[j]);
      // try { Thread.sleep (100); } catch (InterruptedException ex) {}
      panelPrincipal.add(jlbJ1[j]);
    }
  }
  
  
  public void limparMesa()
  {
    jlbCartaJogador1.setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")));
    jlbCartaJogador2.setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")));
  }
  
  public void jogarJogador1()
  {
    jlbJ1[ultmimoCartaJ1].setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")) );
    jlbCartaJogador1.setIcon( new ImageIcon(this.getClass().getResource( jogo.getCartaJogador1() )));
  }
  
  public void jogarJogador2(){
    jlbJ2[ultmimoCartaJ2].setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")) );
    jlbCartaJogador2.setIcon( new ImageIcon(this.getClass().getResource( jogo.getCartaJogador2() )));
    
  }
  
  public void verifEnpateGui()
  {
    if(jogo.verifEnpate() ){
      jlbGuerra.setVisible(true);
      lg1.setIcon( new ImageIcon(this.getClass().getResource( jogo.getCartaMesaJ1()  )));
      lg2.setIcon( new ImageIcon(this.getClass().getResource( jogo.getCartaMesaJ2()  )));
    }
    else{
      jlbGuerra.setVisible(false);
      lg1.setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")) );
      lg2.setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")) );
    }
  }
  
  public void redemencionePanelJ1(){
    int limite=0;
    NodoFila frenteAuxJ1 = jogo.jogador1.getCartas().getFrente();
    
    if(jogo.jogador1.getCartas().getNumElemento()<=26)
    {
      limite = jogo.jogador1.getCartas().getNumElemento();
      for(int j=25;j>=0;j--)
      { 
        if(limite==0){
          jlbJ1[j].setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")));
        }else{
          jlbJ1[j].setIcon(new ImageIcon(this.getClass().getResource( ((Carta) frenteAuxJ1.getElemento()).getPicture())));
          frenteAuxJ1 = frenteAuxJ1.getProximo();
          limite--;
          try { Thread.sleep (ControloGui.config.velocidade); } catch (InterruptedException ex) {}
        }
      }
    }
    else{
      for(int j=25;j>=0;j--)
      { 
        jlbJ1[j].setIcon(new ImageIcon(this.getClass().getResource( ((Carta) frenteAuxJ1.getElemento()).getPicture())));
        frenteAuxJ1 = frenteAuxJ1.getProximo();
         try { Thread.sleep (ControloGui.config.velocidade); } catch (InterruptedException ex) {}
      }
    }
  }
  
  public void redemencionePanelJ2(){
    int limite=0;
    NodoFila frenteAuxJ2 = jogo.jogador2.getCartas().getFrente();
    if(jogo.jogador2.getCartas().getNumElemento()<26)
    {
      limite = jogo.jogador2.getCartas().getNumElemento();
      for(int j=25;j>=0;j--)
      { 
        if(limite==0){
          jlbJ2[j].setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")));
        }else{
     
          jlbJ2[j].setIcon(new ImageIcon(this.getClass().getResource( ((Carta) frenteAuxJ2.getElemento()).getPicture())));
          frenteAuxJ2 = frenteAuxJ2.getProximo();
          limite--;
          try { Thread.sleep (ControloGui.config.velocidade); } catch (InterruptedException ex) {}
        }
      }
    }
    else{
      for(int j=25;j>=0;j--)
      { 
   
        jlbJ2[j].setIcon(new ImageIcon(this.getClass().getResource( ((Carta) frenteAuxJ2.getElemento()).getPicture())));
        frenteAuxJ2 = frenteAuxJ2.getProximo();
        try { Thread.sleep (ControloGui.config.velocidade); } catch (InterruptedException ex) {}
      }
    }
  
    
  }
  
  
  public void limparTudo()
  {
    int i=0;
    numPart = 0;
    limparMesa1();
    numPartida.setText("Partidas Efec.: "+numPart++);
    for(int j=25;j>=0;j--,i++)
    {
      jlbJ1[j].setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")));
      jlbJ2[i].setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")) );
      try { Thread.sleep (25); } catch (InterruptedException ex) {}
    }
  }
  
  
  public void distribuirJogoGui()
  {
    int nLinhas = 50;
    
    NodoFila frenteAuxJ1 = jogo.jogador1.getCartas().getFundo();
    NodoFila frenteAuxJ2 = jogo.jogador2.getCartas().getFundo();
    
    for(int i=0;i<26;i++){
      jlbJ1[i].setIcon( new ImageIcon(this.getClass().getResource( ((Carta) frenteAuxJ1.getElemento()).getPicture() )));
      jlbJ2[i].setIcon( new ImageIcon(this.getClass().getResource( ((Carta) frenteAuxJ2.getElemento()).getPicture() )));
      
      jlbJ1[i].setBounds(40,nLinhas,90,140);
      jlbJ2[i].setBounds(636,nLinhas,90,140);
      nLinhas = nLinhas+12;
      frenteAuxJ1 = frenteAuxJ1.getEproximo();
      frenteAuxJ2 = frenteAuxJ2.getEproximo();
    }
  }
  
  
  public void comecarJogoGui()
  {
    jogo.novoJogo();
    distribuirJogoGui();

  }
  
  public void reiniciarJogoGui()
  {
    batalhas = 1;
    limparTudo();
    jogo.reiniciarJogo();
    redemencionePanelJ1();
    redemencionePanelJ2();
  }
  
  public void novoJogoGui()
  {
    batalhas = 1;
    limparTudo();
    jogo.novoJogo();
    jogo.jogador1.estatisticaJogo.inicializar();
    jogo.jogador2.estatisticaJogo.inicializar();
    
    receberDadosJogo();
    
    redemencionePanelJ1();
    redemencionePanelJ2();
  }
  
  public void continuarJogoGui()
  {
    batalhas = 1;
    limparTudo();
    jogo.continuar();
    numMaxPartida.setText("Maximo de Partida: "+JanelaDadosJogo.batalhas);
    redemencionePanelJ1();
    redemencionePanelJ2();
  }
  
  
  public void receberDadosJogo()
  {
    numMaxPartida.setText("Maximo de Partida: "+JanelaDadosJogo.batalhas);
    jlbdc1.setText("<-- "+JanelaDadosJogo.sj1);
    jlbdc2.setText(""+JanelaDadosJogo.sj2+" -->");
    
    jogo.jogador1.setNome(JanelaDadosJogo.sj1);
    jogo.jogador2.setNome(JanelaDadosJogo.sj2);
  }
  
  
  //* *********************************************************************************************** 8*/
  
  
  public class InternalRunnableTimeRunGame extends Thread{
    public InternalRunnableTimeRunGame()
    {}
    public void run() {
      try { Thread.sleep (1000); } catch (InterruptedException ex) {}
      while(run){
        
        jogarGuiRun();
        if(novoJogoBool)
        {
          ControloGui.guiJanelaDadosJogo = new JanelaDadosJogo(null,true,500,250,"Novo Jogo Pause");
          novoJogoGui();
          novoJogoBool = false;
        }
        if(contBool){
          ControloGui.guiJanelaDadosJogo = new JanelaDadosJogo(null,true,500,250,false);
          continuarJogoGui();
          contBool = false;
        }
        if(exitBool){
          ControloGui.guiJanelPrincipal = new JanelaPrincipal();
          ControloGui.guiJanelaJogo.dispose();
          run = false;
          exitBool = false;
        }
      }
    }
  }
  public void jogarGuiRun()
  {}
  
  public void limparMesa1()
  {          
    jlbJ1[25].setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")));
    jlbJ2[25].setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")));
    
    lg1.setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")));
    lg2.setIcon( new ImageIcon(this.getClass().getResource("../img/white.png")));
    
    jlbJ1[25].setLocation(40, 350);
    jlbJ2[25].setLocation(636, 350);
    redemencionePanelJ1();
    redemencionePanelJ2();
  }
  
  
  public static void resetEstatistica()
  {
    estNovo = false;
    estReiniciar = false;
    estContinuar = false;
    estSairJogo = false;
  }
  
}