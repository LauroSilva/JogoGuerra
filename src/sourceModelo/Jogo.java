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


public class Jogo implements Serializable
{
  public Jogador jogador1;
  public Jogador jogador2;
  public TipoPilha mesaJogo;
  public Baralho baralho;
  public int numBatalha;
  private boolean enpate;
  public int idPlayer;
  
  public Baralho baralhoCopy;
  
  
  public Jogo()
  {
    jogador1 = new Jogador();
    jogador2 = new Jogador();
    numBatalha = 0;
    enpate = false;
    mesaJogo = new TipoPilha();
  }
  

  public void distribuirCartas()
  {
    for(int i=0;i<baralho.getCarta().length;i++)
    {
      if(i<=25){
        jogador1.getCartas().inserir(baralho.getCarta()[i]);
      }
      else jogador2.getCartas().inserir(baralho.getCarta()[i]);
    }
  }
  
  
  public String getCartaJogador1()
  {
    return ((Carta) jogador1.getCartas().getFrente().getElemento() ).getPicture();
  }
  
  
  public String getCartaJogador2()
  {
    return ((Carta) jogador2.getCartas().getFrente().getElemento() ).getPicture();
  }
  
  public String getCartaMesaJ1(){
    return ((Carta) mesaJogo.getTopPilha().getElemento() ).getPicture();
  }
  
  public String getCartaMesaJ2(){
    return ((Carta) mesaJogo.getTopPilha().getProximo().getElemento() ).getPicture();
  }
  
  
  
  public void jogarGui()
  {
    /*
    System.out.println("Jogador 1:"+jogador1.getCartas().mostrarTodos()  );
    System.out.println("Jogador 2:"+jogador2.getCartas().mostrarTodos()  );
    
    System.out.print("MESA:  ");
    System.out.println(mesaJogo.mostrarTodos());
    System.out.println("\n\n");
    */
    mesaJogo.empilhar(jogador1.jogar().getElemento() );
    mesaJogo.empilhar(jogador2.jogar().getElemento() );
    
    if(mesaJogo.getTopPilha().getElemento().chave() < mesaJogo.getTopPilha().getProximo().getElemento().chave() )
    {
      if(enpate)
      {
        jogador1.estatisticaJogo.numGuerrasVenciadas++;
        jogador2.estatisticaJogo.numGuerrasPerdidas++;
      }
      while(mesaJogo.getTopPilha()!=null){
        jogador1.getCartas().inserir(mesaJogo.desenpilharElemento().getElemento() );
      }
      jogador1.estatisticaJogo.numPartidasVencidas++;
      jogador2.estatisticaJogo.numPartPerdidas++;
      enpate = false;
    }
    else if(mesaJogo.getTopPilha().getElemento().chave() > mesaJogo.getTopPilha().getProximo().getElemento().chave()){
      if(enpate)
      {
        jogador2.estatisticaJogo.numGuerrasVenciadas++;
        jogador1.estatisticaJogo.numGuerrasPerdidas++;
      }
      while(mesaJogo.getTopPilha()!= null){
        jogador2.getCartas().inserir(mesaJogo.desenpilharElemento().getElemento() );
      }
      jogador2.estatisticaJogo.numPartidasVencidas++;
      jogador1.estatisticaJogo.numPartPerdidas++;
      enpate = false;
    }
    else if( mesaJogo.getTopPilha().getElemento().chave() == mesaJogo.getTopPilha().getProximo().getElemento().chave() ){
      // System.out.println("--------------------------------------------------------------");
      enpate = true;
    }
    numBatalha--;
  }

  
  public void jogarGui(TipoPilha mesa)
  {
    /*
    System.out.println("Jogador 1:"+jogador1.getCartas().mostrarTodos()  );
    System.out.println("Jogador 2:"+jogador2.getCartas().mostrarTodos()  );
    
    System.out.print("MESA:  ");
    System.out.println(mesaJogo.mostrarTodos());
    System.out.println("\n\n");
    */
    mesaJogo.empilhar(jogador1.jogar().getElemento() );
    mesaJogo.empilhar(jogador2.jogar().getElemento() );
    
    if(mesaJogo.getTopPilha().getElemento().chave() < mesaJogo.getTopPilha().getProximo().getElemento().chave() )
    {
      if(enpate)
      {
        jogador1.estatisticaJogo.numGuerrasVenciadas++;
        jogador2.estatisticaJogo.numGuerrasPerdidas++;
      }
      while(mesaJogo.getTopPilha()!=null){
        jogador1.getCartas().inserir(mesaJogo.desenpilharElemento().getElemento() );
      }
      jogador1.estatisticaJogo.numPartidasVencidas++;
      jogador2.estatisticaJogo.numPartPerdidas++;
      enpate = false;
    }
    else if(mesaJogo.getTopPilha().getElemento().chave() > mesaJogo.getTopPilha().getProximo().getElemento().chave()){
      if(enpate)
      {
        jogador2.estatisticaJogo.numGuerrasVenciadas++;
        jogador1.estatisticaJogo.numGuerrasPerdidas++;
      }
      while(mesaJogo.getTopPilha()!= null){
        jogador2.getCartas().inserir(mesaJogo.desenpilharElemento().getElemento() );
      }
      jogador2.estatisticaJogo.numPartidasVencidas++;
      jogador1.estatisticaJogo.numPartPerdidas++;
      enpate = false;
    }
    else if( mesaJogo.getTopPilha().getElemento().chave() == mesaJogo.getTopPilha().getProximo().getElemento().chave() ){
      // System.out.println("--------------------------------------------------------------");
      enpate = true;
    }
    numBatalha--;
  }
  
  public boolean verifEnpate()
  {
    if( this.enpate )
      return true;
    return false;
  }
  
  public void resultadoFinal()
  {
    if( jogador1.estatisticaJogo.numPartidasVencidas > jogador2.estatisticaJogo.numPartidasVencidas ){
      jogador1.estatisticaJogo.numJogosVencidos++;
      jogador1.setPontos(jogador1.getPontos()+1);
    }
    else if(jogador1.estatisticaJogo.numPartidasVencidas < jogador2.estatisticaJogo.numPartidasVencidas) 
    {
      jogador2.estatisticaJogo.numJogosVencidos++;
      jogador2.setPontos(jogador2.getPontos()+1);
    }
    
  }
  
  
  public void prepararJogo()
  {
    jogador1.inicializar();
    jogador2.inicializar();
    numBatalha = 0;
    enpate = false;
    mesaJogo = new TipoPilha();
  }
  
  public void comecarJogo()
  {
    baralho = new Baralho();
    baralho.baralhar();
    baralhoCopy = new Baralho();
    baralhoCopy = baralho;
    distribuirCartas();
  }
  
  public void reiniciarJogo()
  {
    baralho = baralhoCopy;
    //prepararJogo();
    numBatalha = 0;
    enpate = false;
    mesaJogo = new TipoPilha();
    distribuirCartas();
  }
  
  public void continuar()
  {
    baralho = new Baralho();
    baralho.baralhar();
    baralhoCopy = baralho;
    jogador1.getCartas().inicializar();
    jogador2.getCartas().inicializar();
    
    jogador1.estatisticaJogo.inicializar();
    jogador2.estatisticaJogo.inicializar();
    distribuirCartas();
  }
  
  public void novoJogo()
  {
    baralho = new Baralho();
    baralho.baralhar();
    baralhoCopy = baralho;
    prepararJogo();
    distribuirCartas();
  }
  
}