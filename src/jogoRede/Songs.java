package jogoRede;

import javax.swing.*;

import java.applet.*;
import java.io.*;
import java.net.*;


import javax.sound.sampled.*;

public class Songs{
  private Clip clip;    
  private AudioInputStream audioIn;   
  
  public Songs()
  {}
  
  
  public void distribuir()
  {
    try{
      AudioClip clip = Applet.newAudioClip(new File("C:\\Users\\Again\\Projectos Lauro_Lau_X_Chi\\Trabalho_2-0.5\\som\\distribuir.wav").toURL());
      //"C:\\Users\\Again\\Projectos Lauro_Lau_X_Chi\\Trabalho_2-0.5\\som\\embaralhar.wav"
      
      clip.play();  
    }catch ( MalformedURLException ex) {  
      ex.printStackTrace();  
    }
    
  }
  
  public void baralhar()
  {
    
  }
  
  
  
  // JOptionPane.showMessageDialog(null,new File("embaralhar.wav").toURL());
  
  
  
  public void jogar(){
    
    try{
      AudioClip clip = Applet.newAudioClip(new File("C:\\Users\\Again\\Projectos Lauro_Lau_X_Chi\\Trabalho_2-0.5\\som\\virar.wav").toURL());
      //"C:\\Users\\Again\\Projectos Lauro_Lau_X_Chi\\Trabalho_2-0.5\\som\\embaralhar.wav"
      
      clip.play();  
    }catch ( MalformedURLException ex) {  
      ex.printStackTrace();  
    }
    
  }
  
  
  
  
  public void entrada()
  {
    try{
      AudioClip clip = Applet.newAudioClip(new File("C:\\WINDOWS\\Media\\notify.wav").toURL());  
      clip.play();  
    }catch ( MalformedURLException ex) {  
      ex.printStackTrace();  
    }
  }
  
  
}