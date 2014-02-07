/***********************************************************************************
  **********************************************************************************
  *** Autor: Lauro Zua da Silva
  *** Numero: 9209
  *** Data: 15-Agosto-2012
  *** Data da Ultima Actualizacao: 5-Novembro-2012
  *** Descricao:
  *** Fle: TipoLista
  ***
  ***********************************************************************************
  ***********************************************************************************/
package sourceModelo;

import java.io.Serializable;

public class TipoFila implements Serializable
{
  private NodoFila frente;
  private NodoFila fundo;
  private int numElemento;
  
  
  public TipoFila()
  {
    inicializar();
  }
  
  public void inicializar()
  {
    frente = null;
    fundo = null;
    numElemento = 0;
  }
  
  public void inserir(ElementoInterface elemento)
  {
    NodoFila novo = new NodoFila();
    novo.setElemento(elemento);
    novo.setProximo(null);
    novo.setEproximo(null);
    
    if(fundo==null)
    {
      fundo = novo;
      frente = novo;
      numElemento++;
    
    }
    else
    {
      fundo.setProximo(novo);
      novo.setEproximo(fundo);
      fundo = novo;
      numElemento++;
    }
    
  }
  
  public void remover()
  {
    if(vazia()!=0)
    {
      System.out.println("Erro Fila Vazia");
    }
    else
    {
      frente = frente.getProximo();
      numElemento--;
    }
  }
  
  public NodoFila retirar()
  {
    numElemento--;
    return frente;
  }
  
  
  public NodoFila removerElemento()
  {
    NodoFila nodoAux = null;
    
    nodoAux = frente;
    frente = frente.getProximo();
    numElemento--;
    return nodoAux;
  }
  
  
  public String mostrarTodos()
  {
    String todos="";
    NodoFila nodoFilaAux = this.frente;
    
    while(frente!= null)
    {
      todos = " "+todos+frente.getElemento().getObject()+"  ";
      frente = frente.getProximo();
    }
    this.frente = nodoFilaAux;
    return todos;
  }
  
  
  public int vazia()
  {
    if(frente == null && fundo == null)
      return 0;
    else return 0;
  }
  
  public void setFundo(NodoFila fundo)
  {
    this.fundo = fundo;
  }
  
  public void setFrente(NodoFila frente)
  {
    this.frente = frente;
  }
  
  public void setNumElemento(int numElemento)
  {
    this.numElemento = numElemento;
  }
  
  
  public NodoFila getFundo(){
    return this.fundo;
  }
  
  public NodoFila getFrente(){
    return this.frente;
  }
  
  public int getNumElemento()
  {
    return this.numElemento;
  }
  
}