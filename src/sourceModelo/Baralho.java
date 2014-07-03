/***********************************************************************************
  **********************************************************************************
  *** Autor: Lauro Zua da Silva
  *** Numero: 9209
  *** Data: 15-Agosto-2012
  *** Data da Ultima Actualizacao: 5-Novembro-2012
  *** Descricao:
  *** Fle: Baralho
  ***
  ***********************************************************************************
  ***********************************************************************************/
package sourceModelo;

import java.io.Serializable;
import java.util.*;

public class Baralho implements Serializable
{
  private Carta[] carta;
  
  private String[] naipes;
  private String[] simbolo;
  
  public Baralho()
  { 
    carta = new Carta[52];
    naipes = new String[4];
    inic();
    montarBaralho();
  }
  
  public void inic()
  {   
    
    for(int i=0;i<52;i++)
    {
      carta[i] = new Carta();
    }
    for(int i=0;i<4;i++){
      naipes[i] = new String();
    }
    
    naipes[0] ="Espada";/*Espada*/
    naipes[1] ="Copas";/*Copas*/
    naipes[2] ="PausPire";/*PausPire*/
    naipes[3] ="Ouro";/*Ouro*/
    
    String[] simbolo ={"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
    this.simbolo = simbolo;
  }
  
  public void montarBaralho()
  {
    int cont=2;
    int contCarta=0;
    int valorCarta =2;
    int contSimbolo =0;
    
    String n="";
      while(contCarta<52){
        for(int h=0;h<naipes.length;h++){
          carta[contCarta].setValor(valorCarta);
          carta[contCarta].setSimbolo(simbolo[contSimbolo]);
          carta[contCarta].setNaipe(naipes[h]);
          carta[contCarta].setPicture("../img/"+cont+naipes[h]+".png");
          contCarta++;
        }
        cont++;
        valorCarta++;
        contSimbolo++;
      }
      reMont();
  }
  
  public void reMont()
  {
    int valor = carta[48].getValor();
    
    carta[20].setValor(valor);
    carta[21].setValor(valor);
    carta[22].setValor(valor);
    carta[23].setValor(valor);
      
    carta[48].setValor(valor+2);
    carta[49].setValor(valor+2);
    carta[50].setValor(valor+2);
    carta[51].setValor(valor+2);
    //48
  }
  
  public void baralhar()
  {
    Carta cartaAux = new Carta();
    int cont=0;
    int posicao1 = 0;
    int posicao2 = 0;
    
    
    while(cont<=10000000)
    {
      posicao1 = new Random().nextInt(52);
      posicao2  = new Random().nextInt(52);
      
      cartaAux = carta[posicao1];
      carta[posicao1] = carta[posicao2];
      carta[posicao2] = cartaAux;
      cont++;
    }
  }
  
  public Carta[] getCarta()
  {
    return this.carta;
  }
  
 
  
}