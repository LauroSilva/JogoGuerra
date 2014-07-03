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

public class JDemo extends JDialog {
  
  private Border line;
  private JPanel panelPrincipal;
  private JLabel jlbTitulo;
  private JButton jbtSair;
  private JLabel[] jlbCartas;
  
  public InternalRunnableTimeRunGame run;
  
  private String[] cartas = new String[17];
  
  public JDemo(Frame frame, boolean nl,int posWith,int posHeight)
  {
    super(frame,nl);
    run = new InternalRunnableTimeRunGame();
    instancia();
    //resetButton();
    instanciarCartas();
    porPanel();
    
    run.start();
    /* Tratar Eventos */
    TrataEventos eventos  = new  TrataEventos();
    jbtSair.addActionListener(eventos);
    
    criarGui(posWith,posHeight);
  }
  
  
  
  public void instancia()
  {
    line = BorderFactory.createTitledBorder("");
    panelPrincipal = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    jlbTitulo = new JLabel("Demostracao da Velocidade");
 
    jbtSair =  new JButton(new ImageIcon(this.getClass().getResource("../img/fechar_edited.png")));
    jbtSair.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        jbtSair.setIcon(new ImageIcon(this.getClass().getResource("../img/fechar.png")));
      }
      public void  mouseExited(MouseEvent e){
        jbtSair.setIcon(new ImageIcon(this.getClass().getResource("../img/fechar_edited.png")));
      }
    });
    
   
    
  }
  
  
  public void criarGui(int posWith,int posHeight)
  {
    setLayout(null);
    panelPrincipal.setLayout(null);
    panelPrincipal.setOpaque(false);
    panelPrincipal.setBounds(0,0,400,400);
    
    Font font = new Font("Footlight MT Light",0,20 );
    Font font1 = new Font("Footlight MT Light",0,16 );
    
    jbtSair.setBounds(315,2,30,30);  jbtSair.setContentAreaFilled(false);
    
    jlbTitulo.setBounds(40,15,260,25);  jlbTitulo.setFont(font);  jlbTitulo.setForeground(new Color(255,255,255));
    
    getCartas();
      
    panelPrincipal.add(jlbTitulo);
    panelPrincipal.add(jbtSair);
    
    
    add(panelPrincipal);
    
    setSize(350,400);
    setUndecorated(true);
    AWTUtilities.setWindowOpacity(this, 0.90F);  
    setLocation(new Point(posWith,posHeight)); //    setLocation(new Point(700,250));
    //setLocationRelativeTo(null);
    setVisible(true);
    
  }
  
  /* Tratra Eventos */
  public class TrataEventos implements ActionListener
  {
    public void actionPerformed(ActionEvent ev)
    {
      if(ev.getSource()==jbtSair )
      {
        dispose();
      }
    }
  }
  
  public void fechar()
  {
    dispose();
  }
  
  public void instanciarCartas()
  {

    int nLinhas = 40;
    jlbCartas = new JLabel[17]; 
    int contCarta=0;
    for(int i=0;i<17;i++){
      jlbCartas[i] = new JLabel(new ImageIcon(this.getClass().getResource(getCartas()[contCarta] )));
      jlbCartas[i].setBounds(120,nLinhas,106,163);
      nLinhas = nLinhas+12;
      contCarta++;
    }
  }
  
  public void porPanel()
  {
    for(int i=16;i>0;i--){
      panelPrincipal.add(jlbCartas[i]);
    }
  }
  
  public void redemencionar()
  {
    String lastCarta="";
    
    //jlbCartas[16].setIcon(new ImageIcon(this.getClass().getResource("../img/white.png" )));
    try { Thread.sleep (50); } catch (InterruptedException ex) {}
    
    for(int j=16;j>0;j--)
    {
      lastCarta = cartas[16];
      
      jlbCartas[j].setIcon(new ImageIcon(this.getClass().getResource( cartas[j-1] )));
      cartas[j] = cartas[j-1];
      if(j==1){
        cartas[0] = lastCarta;
      }
        
      try { Thread.sleep (JConfiguracao.valor ); } catch (InterruptedException ex) {}
      //JOptionPane.showMessageDialog(null,"Ola!!"+j);
    }
  }
  
  public String[] getCartas()
  {
    cartas[0] = "../img/2Espada.png";
    cartas[1] = "../img/7Espada.png";
    cartas[2] = "../img/14PausPire.png";
    cartas[3] = "../img/13PausPire.png";
    cartas[4] = "../img/12Copas.png";
    cartas[5] = "../img/5Copas.png";
    cartas[6] = "../img/11Ouro.png";
    cartas[7] = "../img/9Ouro.png";
    cartas[8] = "../img/10Ouro.png";
    cartas[9] = "../img/8Copas.png";
    cartas[10] = "../img/2Espada.png";
    cartas[11] = "../img/7Espada.png";
    cartas[12] = "../img/14PausPire.png";
    cartas[13] = "../img/13PausPire.png";
    cartas[14] = "../img/12Copas.png";
    cartas[15] = "../img/5Copas.png";
    cartas[16] = "../img/11Ouro.png";
    
    return cartas;
  }  
  
  public class InternalRunnableTimeRunGame extends Thread{
    public InternalRunnableTimeRunGame()
    {}
    public void run() {
      try { Thread.sleep (500); } catch (InterruptedException ex) {}
      int i=0;
      while(true){
          redemencionar();
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
    new JDemo(null, true,700,230);
  }
  
  
}