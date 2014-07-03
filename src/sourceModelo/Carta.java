/***********************************************************************************
  **********************************************************************************
  *** Autor: Lauro Zua da Silva
  *** Numero: 9209
  *** Data: 15-Agosto-2012
  *** Data da Ultima Actualizacao: 05-Novembro-2012
  *** Descricao:
  *** Fle: Carta
  ***
  ***********************************************************************************
  ***********************************************************************************/
package sourceModelo;

public class Carta implements ElementoInterface
{
  private int valor;
  private String simbolo;
  private String naipe;
  
  private String picture;
  
  public Carta()
  {
    valor = 0;
    simbolo = null;
    naipe = null;
    picture = null;
  }
  
  
  public void setValor(int valor) {
    this.valor = valor; 
  }
  
  public void setSimbolo(String simbolo) {
    this.simbolo = simbolo; 
  }
  
  public void setNaipe(String naipe) {
    this.naipe = naipe; 
  }
  
  public void setPicture(String picture) {
    this.picture = picture; 
  }
  
  public int getValor() {
    return (this.valor); 
  }
  
  public String getSimbolo() {
    return (this.simbolo); 
  }
  
  public String getNaipe() {
    return (this.naipe); 
  }
  
  public String getPicture() {
    return (this.picture); 
  }
  
  //---------------------------------------------------------------
  public int chave(){
    return this.valor;
  }
  
  public String getObject()
  {
    return this.simbolo;
  }
  
}

