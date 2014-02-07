/***********************************************************************************
  ************************************************************************************
  *** Autor: Lauro Zua da Silva       ****
  *** Numero: 9209        ****
  *** Data: 03-Janeiro-2012       ****
  *** Descricao:          ****
  ***            
  ***********************************************************************************/
package sourceGuiControlo;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.util.Calendar;
import java.text.DecimalFormat;


public class ImagemFundoModelo extends JPanel {
  private Image fundo;
  public ImagemFundoModelo(String imagem){
    String n="../img/";
    URL res = getClass().getResource(n+imagem);
    if (res == null) {  
      throw new IllegalArgumentException("resource not found: " + imagem);
    }
    fundo = Toolkit.getDefaultToolkit().createImage(res);  
  }
  
  @Override
  protected void paintComponent(Graphics g) {  
    super.paintComponent(g);  
    if (fundo != null) {  
      int w = fundo.getWidth(this);  
      int h = fundo.getHeight(this);  
      if (w > 0  &&  h > 0) {  
        for (int y = 0; y < getHeight(); y += h) {  
          for (int x = 0; x < getWidth(); x += w) {  
            g.drawImage(fundo, x, y, this);  
          }  
        }  
      }  
    }  
  }
  
}  
