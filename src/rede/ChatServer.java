/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rede;

import java.awt.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Again
 */
public class ChatServer implements Runnable{
    
    ArrayList<PrintWriter> escritores = new ArrayList();
    public int cont=1;
//    public Jogo jogo;
    public String bigArgumento;
    
    public ChatServer(){
        
    }
    
    
    private void encaminharOTextoparaTodos(String texto){
        for(PrintWriter w: escritores){
            try{
                w.println(texto);
                w.flush();
            }
            catch(Exception ex){}
        }
    }
    
    
    
    private class EscutaCliente implements Runnable{
        Scanner leitor;
        public EscutaCliente(Socket socket){
            try{
                leitor = new Scanner(socket.getInputStream());
            }
            catch(Exception ex){}
        }
        
        public void run(){
            try{
                String texto;
                while( (texto = leitor.nextLine()) !=null ){
                    System.out.println("Recebeu: "+texto);
                        if(texto.equalsIgnoreCase("lauro")){
                            System.out.println("Porra nao escreve o nome do Admin");
                        }
                    encaminharOTextoparaTodos(texto);
                }
            }catch(Exception ex){
                
            }
        }
        
    }
    
     public void run()
     {
        ServerSocket server;
        
        try
        {
            server = new ServerSocket(5001);
            System.out.println("Servidor Criado!!!");
            
            while(true)
            {
                  Socket socket = server.accept();
                  System.out.println("Cliente: "+cont+" Conectado"); cont++;
                   
                new Thread(new EscutaCliente(socket)).start();
                PrintWriter p = new PrintWriter(socket.getOutputStream() );
                escritores.add(p);
            }
        }
        
        catch(Exception ex){}
     }
}
