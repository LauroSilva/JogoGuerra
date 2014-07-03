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

public class JAbout extends JDialog{
  private JPanel principal;
  private JLabel jlbAbout;
  private JButton jbtFechar;
  
  public JAbout(Frame frame,boolean n){
    super(frame,n);
    
    jlbAbout = new JLabel(new ImageIcon(this.getClass().getResource("../img/logo_1.png")));
    principal = new ImagemFundoModelo(ControloGui.config.imgTheme[ControloGui.config.pos][2]);
    
    jbtFechar = new JButton(new ImageIcon(this.getClass().getResource("../img/fechar_edited.png")));
    jbtFechar.setContentAreaFilled(false);
    
    jbtFechar.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent ev){
        if(ev.getSource()==jbtFechar ){
          dispose();
        }
      }
    });
    
    jbtFechar.addMouseListener( new MouseAdapter() {  
      public void  mouseEntered(MouseEvent e) {
        //jbtFechar.setContentAreaFilled(true);
        jbtFechar.setIcon(new ImageIcon(this.getClass().getResource("../img/fechar.png")));
        // jbtFechar.setBackground(Color.BLACK);
      }
      public void  mouseExited(MouseEvent e){
        //jbtFechar.setContentAreaFilled(false);
        jbtFechar.setIcon(new ImageIcon(this.getClass().getResource("../img/fechar_edited.png")));
      }
    });
    
    criarGui();
  }
  
  public void criarGui(){
    
    principal.setLayout(null);
    jlbAbout.setBounds(0,0,257,276);
    jbtFechar.setBounds(220,4,30,30);
    
    principal.add(jlbAbout);
    principal.add(jbtFechar);
    
    add(principal);
    
    setSize(257,276);
    setUndecorated(true);
    AWTUtilities.setWindowOpacity(this, 0.85F); 
    setLocationRelativeTo(null);    
// setLocation(new Point(posWith,posHeight)); //    setLocation(new Point(700,250));$
    setVisible(true);
  }
  
  
  
}