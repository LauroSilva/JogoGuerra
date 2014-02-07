/***********************************************************************************
  **********************************************************************************
  *** Autor: Lauro Zua da Silva
  *** Numero: 9209
  *** Data: 15-Agosto-2012
  *** Data da Ultima Actualizacao: 5-Novembro-2012
  *** Descricao:
  *** Fle: Tipo
  ***
  ***********************************************************************************
  ***********************************************************************************/
package sourceModelo;

import java.io.Serializable;

public class TipoPilha implements Serializable
{
  private NodoPilha topoPilha;
  private int numElemento;
  
  public TipoPilha()
  {
    inicializar();
  }
  
  
  public void empilhar(ElementoInterface elemento)
  {
    NodoPilha novo = new NodoPilha();
    
    
    novo.setElemento(elemento);
    if(topoPilha == null)
    {
      novo.setProximo(null);
    }
    else
    {
      novo.setProximo(topoPilha);
    }
    topoPilha = novo;
  }
  
  
  public void desenpilhar()
  {
    if(vazia()!=0)
    {
      System.out.println("Erro Pilha Vazia");
    }
    else
    {
      topoPilha = topoPilha.getProximo();
    }
  }
  
    
  public void desenpilharTodo()
  {
    if(vazia()!=0)
    {
      System.out.println("Erro Pilha Vazia");
    }
    else
    {
      while(topoPilha!=null)
        topoPilha = topoPilha.getProximo();
    }
  }
  
  public NodoPilha desenpilharElemento()
  {
    NodoPilha nodoPilhaAux=null;
    nodoPilhaAux = topoPilha;
    topoPilha = topoPilha.getProximo();
      
    return nodoPilhaAux;
  }
    
  
  public void inicializar()
  {
    topoPilha = null;
    numElemento = 0;
  }
  
  public String mostrarTodos()
  {
    String todos="";
    NodoPilha nodoFilaAux = this.topoPilha;
    
    while(topoPilha!= null)
    {
      todos = " "+todos+topoPilha.getElemento().getObject()+"  ";
      topoPilha = topoPilha.getProximo();
    }
    this.topoPilha = nodoFilaAux;
    return todos;
  }
  
  public int vazia()
  {
    if(topoPilha==null)
      return 0;
    else return 0;
  }
  
  public NodoPilha getTopPilha()
  {
    return this.topoPilha;
  }
  
  public void setTopPilha(NodoPilha topoPilha)
  {
    this.topoPilha = topoPilha;
  }
  
  public void setNumElemento(int numElemento)
  {
    this.numElemento = numElemento;
  }
  
  public int getNumElemento()
  {
    return this.numElemento;
  }
  
}