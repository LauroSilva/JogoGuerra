/***********************************************************************************
  **********************************************************************************
  *** Autor: Lauro Zua da Silva
  *** Numero: 9209
  *** Data: 15-Agosto-2012
  *** Data da Ultima Actualizacao: 5-Novembro-2012
  *** Descricao:
  *** Fle: NodoPilha
  ***
  ***********************************************************************************
  ***********************************************************************************/
package sourceModelo;

import java.io.Serializable;

public class NodoPilha implements Serializable
{
  
  private ElementoInterface elemento;
  private NodoPilha proximo;
  
  
  public NodoPilha()
  {
    elemento = null;
    proximo = null;
  }

 
 public void setElemento(ElementoInterface elemento) {
  this.elemento = elemento; 
 }

 public void setProximo(NodoPilha proximo) {
  this.proximo = proximo; 
 }

 public ElementoInterface getElemento() {
  return (this.elemento); 
 }

 public NodoPilha getProximo() {
  return (this.proximo); 
 }
  
} 