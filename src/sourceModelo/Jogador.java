/*
Autor: Lauro Ailva
*/


package sourceModelo;

import java.io.Serializable;

public class Jogador implements Serializable
{
  public EstatisticaGame estatisticaJogo;
  private String nome;
  private TipoFila cartas;
  private int pontos;
  
  
  public Jogador()
  {
    inicializar();
  }
  
  public void inicializar()
  {
    // nome = null;
    cartas= new TipoFila();
    pontos = 0;
    estatisticaJogo = new EstatisticaGame();
  }
  
  public void setNome(String nome) {
    this.nome = nome; 
  }

  public void setCartas(TipoFila cartas) {
    this.cartas = cartas; 
  }
  
  public void setPontos(int pontos) {
    this.pontos = pontos; 
  }
  
  public String getNome() {
    return (this.nome); 
  }
  
  public TipoFila getCartas() {
    return (this.cartas); 
  }
  
  public int getPontos() {
    return (this.pontos); 
  }
  
  public NodoFila jogar()
  {
    return cartas.removerElemento();
    
  }
  
  public NodoFila getElementoAJogar(){
      return cartas.getFrente();
  }
  
  public String argumento(){
      return ""+this.nome+"?"+cartas+"?"+this.pontos;
  }
  
  
}
