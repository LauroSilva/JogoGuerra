/***********************************************************************************
  ***********************************************************************************
  *** Autor: Lauro Zua da Silva            
  *** Numero: 9209               
  *** Data: 15-Agosto-2012             
  *** Data da Ultima Actualizacao: 15-Agosto-2012          
  *** Descricao:            
  *** File: CandidatoAlterarPanel
  ***                     
  ***********************************************************************************
  ***********************************************************************************/

package sourceGuiControlo;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Restringe a digitacao de apenas numeros em um componentes de texto como o JTextField
 * Uso: setDocument(new OnlyNumberField());
 * @author Eduardo Costa - www.dimensaotech.com
 *
 */

public class ApenasNumero extends PlainDocument
{
  private int maxlength; 
  
  public ApenasNumero(){}
  
  
  public ApenasNumero(int maxlength)
  {
    super();
    this.maxlength = maxlength;
  }
  
  public void insertString(int offs, String str, AttributeSet a)
  {
    try
    {
      Integer.parseInt(str);
    } catch (NumberFormatException ex)
    {
      str = "";
    }
    try
    {
      boolean fixedLengh = (!((getLength() + str.length()) > maxlength));
      if (maxlength == 0 || fixedLengh)
        super.insertString(offs, str, a);
    } catch (BadLocationException e)
    {
      e.printStackTrace();
    }
  }
  
}


