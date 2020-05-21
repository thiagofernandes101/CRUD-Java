/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoControleSeguranca.ThreadsRunnable;

import GestaoControleSeguranca.GerenciadorAuditoriaSingleton;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiag
 */
public class ThreadGestaoMensagensAuditoria extends Thread {

    @Override
    public void run() {
        String mensagemAuditoria = GerenciadorAuditoriaSingleton.getInstance().obterMensagemAuditoria();
        
        if (mensagemAuditoria != null) {
            enviarMensagemParaSistemaAuditoria(mensagemAuditoria);
            GerenciadorAuditoriaSingleton.getInstance().retiraMensagemAuditoria();
        }
    }

    private void enviarMensagemParaSistemaAuditoria(String mensagem) {
        File file = new File("MensagemSeguranca.txt");
        String absoluta = file.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");        
        PrintWriter escrever = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try {
            escrever = new PrintWriter(new BufferedWriter(new FileWriter(absoluta, true)));
        } catch (IOException ex) {
            Logger.getLogger(ThreadGestaoMensagensAuditoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        escrever.println(mensagem + "  " + dtf.format(now));
        escrever.flush();
        
    }
}
