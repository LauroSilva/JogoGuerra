/***********************************************************************************
  **********************************************************************************
  *** Autor: Lauro Zua da Silva
  *** Numero: 9209
  *** Data: 15-Agosto-2012
  *** Data da Ultima Actualizacao: 5-Novembro-2012
  *** Descricao:
  *** Fle: NodoLista
  ***
  ***********************************************************************************
  ***********************************************************************************/
package sourceModelo;

import java.io.Serializable;

public class NodoFila implements Serializable
{
  
  private ElementoInterface elemento;
  private NodoFila proximo;
  private NodoFila eproximo;
  
  
  public  NodoFila()
  {
    elemento = null;
    proximo = null;
  }

 
 public void setElemento(ElementoInterface elemento) {
  this.elemento = elemento; 
 }

 public void setProximo(NodoFila proximo) {
  this.proximo = proximo; 
 }

 public void setEproximo(NodoFila eproximo)
 {
   this.eproximo = eproximo;
 }
 
 public ElementoInterface getElemento() {
  return (this.elemento); 
 }

 public NodoFila getProximo() {
  return (this.proximo); 
 }
  
 public NodoFila getEproximo()
 {
   return eproximo;
 }
 
} 

