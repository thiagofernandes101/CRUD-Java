/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import GestaoControleSeguranca.GerenciadorAuditoriaSingleton;
import Repositorios.ClienteRepositorioArquivo;
import VO.Cliente.Cliente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author 082170029
 */
public class ClienteValidation {

    public static String IncluirValidation(Cliente cliente) throws IOException {
        String atributosInserir = "";
        File f = new File("Cliente.txt");
        String absoluta = f.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");
        if (!cliente.getNome().trim().isEmpty() && !cliente.getCpf().trim().isEmpty()) {
            ClienteRepositorioArquivo clienteRepositorio = new ClienteRepositorioArquivo();
            Cliente retornoClienteValidacao = clienteRepositorio.ObterPorCPF(cliente.getCpf());

            if (retornoClienteValidacao == null) {
                BufferedReader arquivo = new BufferedReader(new FileReader(absoluta));

                if (arquivo != null) {
                    atributosInserir = cliente.getCpf() + ";" + cliente.getNome();
                } else {
                    atributosInserir = cliente.getCpf() + ";" + cliente.getNome();
                }

                clienteRepositorio.Incluir(atributosInserir, absoluta);

                arquivo.close();
                GerenciadorAuditoriaSingleton.getInstance().adicionaMensagemAuditoria("Cliente cadastrado com sucesso");
                return "Cliente cadastrado com sucesso";
            }
        }
        GerenciadorAuditoriaSingleton.getInstance().adicionaMensagemAuditoria("Nao foi possivel cadastrar o cliente especificado");
        return "Nao foi possivel cadastrar o cliente especificado";
    }

    public static List<String> Visualizar() {
        String atributosInserir = "";
        File f = new File("Cliente.txt");
        String absoluta = f.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");
        ClienteRepositorioArquivo clienteRepositorio = new ClienteRepositorioArquivo();
        GerenciadorAuditoriaSingleton.getInstance().adicionaMensagemAuditoria("Cliente visualizado com sucesso");
        return clienteRepositorio.ObterTodos(absoluta);

    }

    public static void Excluir(long id) {
        File f = new File("Cliente.txt");
        String absoluta = f.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");
        ClienteRepositorioArquivo clienteRepositorio = new ClienteRepositorioArquivo();
        GerenciadorAuditoriaSingleton.getInstance().adicionaMensagemAuditoria("Cliente excluido com sucesso");
        clienteRepositorio.Remover(id, absoluta);

    }
}
