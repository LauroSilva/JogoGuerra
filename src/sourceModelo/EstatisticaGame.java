
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


public class EstatisticaGame implements Serializable
{
  public int numJogosVencidos;
  public int numJogosPerdidos;
  public int numPartPerdidas;
  public int numPartidasVencidas;
  public int numGuerrasPerdidas;
  public int numGuerrasVenciadas;
  public int numpontosAdquiridos;
  public int numPontosPerdidos;
  
  
  public EstatisticaGame()
  {
    inicializar();
  }
  
  public void inicializar()
  {
    numPartPerdidas=0;
    numPartidasVencidas=0;
    
    numGuerrasPerdidas=0;
    numGuerrasVenciadas=0;
    
    numpontosAdquiridos=0;
    numPontosPerdidos=0;
    
    numJogosVencidos = 0;
    numJogosPerdidos =0;
  }
  
}