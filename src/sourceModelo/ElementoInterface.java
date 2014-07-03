/***********************************************************************************
  **********************************************************************************
  *** Autor: Lauro Zua da Silva
  *** Numero: 9209
  *** Data: 15-Agosto-2012
  *** Data da Ultima Actualizacao: 5-Novembro-2012
  *** Descricao:
  *** Fle: ElementoInterface
  ***
  ***********************************************************************************
  ***********************************************************************************/
package sourceModelo;

import java.io.Serializable;

public interface ElementoInterface extends Serializable
{
  /* ------------------------------------------------------
   * Recebe: nao recebe Parametro
   * Objectivo: Obter a chave da classe que  o implementa
   * Devolve: inteiro chave
   * Autor: Lauro Zua da Silva
   -------------------------------------------------------*/
  public int chave();
  
  /* ------------------------------------------------------
   * Recebe: nao recebe Parametro
   * Objectivo: Obter o nome da classe que  o implementa
   * Devolve: String
   * Autor: Lauro Zua da Silva
   -------------------------------------------------------*/
  public String getObject();
  
}