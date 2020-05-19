/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoControleSeguranca;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author thiag
 */
public class GerenciadorAuditoriaSingleton {
    private FileWriter arquivo;
    private Queue<String> filaMensagemAuditoria;
    private static GerenciadorAuditoriaSingleton instancia;
    
    private GerenciadorAuditoriaSingleton() {
      
            File f = new File("MensagemSeguranca.txt");
            String absoluta = f.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");
           //  this.arquivo = new FileWriter("c:/teste.log");
            this.filaMensagemAuditoria = new LinkedList<String>();
        
    }
    
    public static synchronized GerenciadorAuditoriaSingleton getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorAuditoriaSingleton();
        }
        return instancia;
    }
    
    public void adicionaMensagemAuditoria(String mensagem) {
        // adicionar mensagens de envio na fila de mensagens
        // método add adiciona elementos na fila
    }
    
    public String retiraMensagemAuditoria() {
        // retirar as mensagens da fila confirme forem enviadas pelo métodos de envio da thread
        // método poll retira os elements da fila
        return "";
    }
    
    public void ativar() {
        // ativar a thread
    }
    
    public void desativar() {
        // desativar a thread
    }
}
