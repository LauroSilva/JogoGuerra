/***********************************************************************************
  ***********************************************************************************
  *** Autor: Lauro Zua da Silva            
  *** Numero: 9209               
  *** Data: 15-Agosto-2012             
  *** Data da Ultima Actualizacao: 15-Agosto-2012          
  *** Descricao:            
  *** File: CandidatoAlterarPanel
  ***                     
  ***********************************************************************************
  ***********************************************************************************/

package sourceGui;

import java.io.*;
import javax.swing.*;

public class Configuracao{
  public static int velocidade;
  public static int pos;
  public static int modeGame;
  public String[][] imgTheme;
  
  
  public Configuracao()
  {
    imgTheme = new String[3][3];
    
    imgTheme[0][0] = "img_principal.png";
    imgTheme[0][1] = "fundoBlack.png";
    imgTheme[0][2] = "fundoBlack.png";
    
    imgTheme[1][0] = "imgPrimcipal1.png";
    imgTheme[1][1] = "imgJogoEdit.png";
    imgTheme[1][2] = "opac.png";

  }
  
  public static void guardarTheme(int pos){
    try{
      FileOutputStream fos = new FileOutputStream("Theme.dat");
      ObjectOutputStream aos = new ObjectOutputStream(fos);
      aos.writeObject(pos);
      aos.flush();
      aos.close();
      
    }
    catch(IOException io){
      JOptionPane.showMessageDialog(null," Nao foi possivel Guardar o ficheiro RegistroGerais");
    }
  }
  
  
  public static void carregarTheme(){
    int posicao = 0;
    try{
      FileInputStream fis = new FileInputStream("Theme.dat");
      ObjectInputStream ois= new ObjectInputStream(fis);
      posicao = (Integer) ois.readObject();  
    }
    catch(IOException io){
      posicao = 0;
      //JOptionPane.showMessageDialog(null," Nao foi possivel Carregar o ficheiro RegistroGerais");
    }
    catch(ClassNotFoundException cnfe){
      JOptionPane.showMessageDialog(null,"ERRO RegistroGerais");
    }
    pos =  posicao;
  }
  
  //===================================================================
  
    public static void guardarVeloc(int veloc){
    try{
      FileOutputStream fos1 = new FileOutputStream("Velocidade.dat");
      ObjectOutputStream aos1 = new ObjectOutputStream(fos1);
      aos1.writeObject(veloc);
      aos1.flush();
      aos1.close();
      
    }
    catch(IOException io){
      JOptionPane.showMessageDialog(null," Nao foi possivel Guardar o ficheiro RegistroGerais");
    }
  }
  
    
  public static void carregarVeloc(){
    int veloc = 0;
    try{
      FileInputStream fis1 = new FileInputStream("Velocidade.dat");
      ObjectInputStream ois1 = new ObjectInputStream(fis1);
      veloc = (Integer) ois1.readObject();
    }
    catch(IOException io){
      veloc = 0;
      //JOptionPane.showMessageDialog(null," Nao foi possivel Carregar o ficheiro RegistroGerais");
    }
    catch(ClassNotFoundException cnfe){
      JOptionPane.showMessageDialog(null,"ERRO RegistroGerais");
    }
    velocidade = veloc;
  }
  
  //======================================================================================
  
  public static void guardarModo(int modo){
    try{
      FileOutputStream fos1 = new FileOutputStream("ModoGame.dat");
      ObjectOutputStream aos1 = new ObjectOutputStream(fos1);
      aos1.writeObject(modo);
      aos1.flush();
      aos1.close();
      
    }
    catch(IOException io){
      JOptionPane.showMessageDialog(null," Nao foi possivel Guardar o ficheiro ModoGame");
    }
  }
  
  public static void carregarModo(){
    int modo = 0;
    try{
      FileInputStream fis1 = new FileInputStream("ModoGame.dat");
      ObjectInputStream ois1 = new ObjectInputStream(fis1);
      modo = (Integer) ois1.readObject();
    }
    catch(IOException io){
      modo = 0;
      //JOptionPane.showMessageDialog(null," Nao foi possivel Carregar o ficheiro RegistroGerais");
    }
    catch(ClassNotFoundException cnfe){
      JOptionPane.showMessageDialog(null,"ERRO RegistroGerais");
    }
    modeGame = modo;
  }
  
  
}