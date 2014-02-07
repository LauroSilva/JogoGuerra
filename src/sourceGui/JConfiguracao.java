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

import javax.swing.event.*;

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

public class JConfiguracao extends JDialog {

  
  public static int batalhas=0;
  public static String sj1="";
  public static String sj2="";
  
  private Border line;
  private JPanel panelPrincipal;
  private JLabel jlbTitulo;
  private JButton jbtDemo,jbtAplicar,jbtSair;
  private JPanel panel1,panel2,panel3;
  private JLabel jlbDescVeloc,jlbDescTheme,jlbAuto;
  private JTextField jtfCaixa;
  private JSlider cDeslizante;
  private JComboBox jcbTheme;
  private JRadioButton jrbActivar,jrbDesativar;
  private ButtonGroup radioGroup;
  
  
  public static int valor;
  
  private JDialog frame;
  private JanelaPrincipal jPrincipal;
  
  public JConfiguracao(Frame frames, boolean nl,int posWith,int posHeight)
  {
    super(frames,nl);
    frame = this;
    
    instancia();
    //resetButton();
    
    /* Tratar Eventos */
    TrataEventos eventos  = new  TrataEventos();
    jbtAplicar.addActionListener(eventos);
    jbtDemo.addActionListener(eventos);
    jbtSair.addActionListener(eventos);
    
    criarGui(posWith,posHeight);
  }
  
  
  
  public void instancia()
  {
    line = BorderFactory.createTitledBorder("");
    panelPrincipal = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    // panelPrincipal = new JPanel();
    panel1 = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    panel2 = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    panel3 = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    
    jlbDescVeloc = new JLabel("Veloc. Redemencionamento Cartas:");
    jlbDescTheme = new JLabel("Theme:"); 
    
    jtfCaixa = new JTextField();
    cDeslizante = new JSlider(JSlider.HORIZONTAL);
    
    jlbTitulo = new JLabel("Configuracoes");
    jcbTheme = new JComboBox();
    
    jlbAuto = new JLabel("Activar Modo Automatico:");
    
    radioGroup = new ButtonGroup();
    jrbActivar = new JRadioButton("Activar"); 
    jrbDesativar = new JRadioButton("Desativar");
    radioGroup.add(jrbActivar);
    radioGroup.add(jrbDesativar);
    statusModeGame();
    
    
    //  jcbTheme.addItem("Escolha o Tema:");
    jcbTheme.addItem("Padrao");
    jcbTheme.addItem("Classic");
    jcbTheme.setSelectedIndex(ControloGui.config.pos);
    
    
    jbtDemo = new JButton("Demo");
    jbtAplicar = new JButton("Aplicar",new ImageIcon(this.getClass().getResource("../img/button_ok.png")));
    
    jbtSair =  new JButton(new ImageIcon(this.getClass().getResource("../img/fechar_edited.png")));
    jbtSair.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        jbtSair.setIcon(new ImageIcon(this.getClass().getResource("../img/fechar.png")));
      }
      public void  mouseExited(MouseEvent e){
        jbtSair.setIcon(new ImageIcon(this.getClass().getResource("../img/fechar_edited.png")));
      }
    });
    
    cDeslizante.addChangeListener(
      new ChangeListener(){
      public void stateChanged(ChangeEvent e) {
        JSlider comp = (JSlider) e.getSource();
        if(!comp.getValueIsAdjusting())
          valor = comp.getValue();
        jtfCaixa.setText((new Integer(valor)).toString());

      }
  
    }
                                  
    );
    
  }
  
  
  public void criarGui(int posWith,int posHeight)
  {
    setLayout(null);
    panelPrincipal.setLayout(null);
    panel1.setLayout(null);
    panel2.setLayout(null);
    panel3.setLayout(null);
    panelPrincipal.setOpaque(true);
    panelPrincipal.setBounds(0,0,400,350);
    
    Font font = new Font("Footlight MT Light",0,20 );
    Font font1 = new Font("Footlight MT Light",0,16 );
    
    jbtSair.setBounds(320,2,30,30);  jbtSair.setContentAreaFilled(false);
    
    jlbTitulo.setBounds(100,10,180,25);  jlbTitulo.setFont(font);  jlbTitulo.setForeground(new Color(255,255,255));
    
    jlbDescVeloc.setBounds(25,15,280,25); jlbDescVeloc.setForeground(new Color(255,255,255));  jlbDescVeloc.setFont(font1);
    
    // jlbAuto.setEnabled(false);  // jrbActivar.setEnabled(false);  jrbDesativar.setEnabled(false);
    jlbAuto.setBounds(10,10,180,10); jlbAuto.setForeground(new Color(255,255,255));  jlbAuto.setFont(font1);
    jrbActivar.setBounds(100,35,80,18); jrbActivar.setForeground(new Color(255,255,255));  jrbActivar.setFont(font1);
    jrbDesativar.setBounds(200,35,120,18); jrbDesativar.setForeground(new Color(255,255,255));  jrbDesativar.setFont(font1);
    
    cDeslizante.setBounds(30,45,280,50); cDeslizante.setFont(font);  cDeslizante.setForeground(new Color(255,255,255));
    
    cDeslizante.setMinimum(10); 
    cDeslizante.setMaximum(100);
    cDeslizante.setValue(ControloGui.config.velocidade);
    
    
    cDeslizante.setMajorTickSpacing(10);
    cDeslizante.setMinorTickSpacing(10);
    
    cDeslizante.setPaintTicks(true);
    cDeslizante.setPaintLabels(true);
    cDeslizante.setSnapToTicks(true);
    
    jbtDemo.setBounds(190,100,80,30);
    
    jlbDescTheme.setBounds(20,8,100,30); jlbDescTheme.setForeground(new Color(255,255,255));  jlbDescTheme.setFont(font1);
    jcbTheme.setBounds(80,14,120,30); jcbTheme.setForeground(new Color(255,255,255));
    
    panel1.setBounds(10,40,320,140); panel1.setBorder(line); panel1.setOpaque(true);
    panel2.setBounds(10,240,320,60);  panel2.setBorder(line); panel1.setOpaque(true); 
    panel3.setBounds(10,180,320,60);  panel3.setBorder(line); panel3.setOpaque(true); 
    
    jbtAplicar.setBounds(200,310,110,30);
    
    
    panelPrincipal.add(jbtSair);
    panelPrincipal.add(jlbTitulo);
    
    panel1.add(jlbDescVeloc);      // panelPrincipal.add(jtfNomeJ1);
    panel1.add(cDeslizante);     //   panelPrincipal.add(jtfNomeJ2);
    panel1.add(jbtDemo);
    
    
    panel2.add(jlbDescTheme); 
    panel2.add(jcbTheme);
    
    panel3.add(jlbAuto);
    panel3.add(jrbActivar);
    panel3.add(jrbDesativar);

    
    panelPrincipal.add(jbtAplicar);
    
    /// panelPrincipal.add(jbtContinuarCont);
    
    panelPrincipal.add(panel1);
    panelPrincipal.add(panel2);
    panelPrincipal.add(panel3);
    
    add(panelPrincipal);
    
    setSize(350,350);
    setUndecorated(true);
//    AWTUtilities.setWindowOpacity(this, 0.90F);  
    setLocation(new Point(posWith,posHeight)); //    setLocation(new Point(700,250));
    //setLocationRelativeTo(null);
    
    setVisible(true);
  }
  
  /* Tratra Eventos */
  public class TrataEventos implements ActionListener
  {
    public void actionPerformed(ActionEvent ev)
    {
      if(ev.getSource()==jbtDemo )
      {
        // JOptionPane.showMessageDialog(null,valor);
        opacity(frame,0.45F);
        new JDemo(null, true,700,200);
        opacity(frame,0.90F);
      }
      if(ev.getSource()==jbtAplicar )
      {
        ControloGui.guiJanelPrincipal.dispose();
        ControloGui.config.guardarTheme(jcbTheme.getSelectedIndex() );
        ControloGui.config.guardarVeloc(valor);
        ControloGui.config.guardarModo(getModeGame() );
        
        ControloGui.config.carregarTheme();
        ControloGui.config.carregarVeloc();
        ControloGui.config.carregarModo();
        
        ControloGui.guiJanelPrincipal = new JanelaPrincipal();
        fechar();
      }
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
  
  
  public void opacity(JDialog frame,Float opacityF)
  {
//    AWTUtilities.setWindowOpacity(frame,opacityF); 
  }
  
  public int getModeGame()
  {
    if(jrbActivar.isSelected() )
      return 1;
    else return 0;
  }
  
  public void statusModeGame()
  {
    ControloGui.config.carregarModo();
    if(ControloGui.config.modeGame==1)
      jrbActivar.setSelected(true);
    else jrbDesativar.setSelected(true);
  }
  
  public static void main(String[] args) {
    try 
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
    new JConfiguracao(null, true,0,0);
    //new JanelaPrincipal();
  }
  
  
}