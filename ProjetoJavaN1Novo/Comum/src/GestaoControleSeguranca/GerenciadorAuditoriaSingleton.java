/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoControleSeguranca;

import GestaoControleSeguranca.ThreadsRunnable.ThreadGestaoMensagensAuditoria;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiag
 */
public class GerenciadorAuditoriaSingleton {
    private ThreadGestaoMensagensAuditoria threadMensagensAuditoria;
    private Queue<String> filaMensagemAuditoria;
    private static GerenciadorAuditoriaSingleton instancia;

    private GerenciadorAuditoriaSingleton() {
        // File f = new File("MensagemSeguranca.txt");
        // String absoluta = f.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");
        
        this.filaMensagemAuditoria = new LinkedList<String>();
        threadMensagensAuditoria = new ThreadGestaoMensagensAuditoria();
    }

    public static synchronized GerenciadorAuditoriaSingleton getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorAuditoriaSingleton();
        }
        
        return instancia;
    }

    public void adicionaMensagemAuditoria(String mensagem) {
        filaMensagemAuditoria.add(mensagem);
    }
    
    public String obterMensagemAuditoria() {
        String mensagemAuditoria = filaMensagemAuditoria.peek();
        return mensagemAuditoria;
    }

    public String retiraMensagemAuditoria() {
        String retornoExclusaoMensagem = filaMensagemAuditoria.poll();
        return retornoExclusaoMensagem;
    }

    public void ativar() {
        threadMensagensAuditoria.start();
    }

    public void desativar() {
        while (threadMensagensAuditoria.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GerenciadorAuditoriaSingleton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
