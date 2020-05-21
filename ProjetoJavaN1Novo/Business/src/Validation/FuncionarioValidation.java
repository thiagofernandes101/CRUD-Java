/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import GestaoControleSeguranca.GerenciadorAuditoriaSingleton;
import static Global.GerarId.GerarIdArquivo;
import Repositorios.ClienteRepositorioArquivo;
import Repositorios.FuncionarioRepositorioArquivo;
import VO.Acesso.Funcionario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author 082170029
 */
public class FuncionarioValidation {

    public static String IncluirValidation(Funcionario funcionario) throws IOException {
        String atributosInserir = "";
        File f = new File("Funcionario.txt");
        String absoluta = f.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");
        if (!funcionario.getNome().trim().isEmpty() && !funcionario.getCargo().trim().isEmpty() && !funcionario.getUsuario().getLogin().trim().isEmpty() && !funcionario.getUsuario().getSenha().trim().isEmpty()) {
            FuncionarioRepositorioArquivo funcionarioRepositorio = new FuncionarioRepositorioArquivo();

            int id = GerarIdArquivo(absoluta);
            BufferedReader arquivo = new BufferedReader(new FileReader(absoluta));

            //if (id == 1) {
                atributosInserir = id + ";" + funcionario.getNome() + ";" + funcionario.getCargo() + ";" + funcionario.getUsuario().getLogin() + ";" + funcionario.getUsuario().getSenha();

            //} else {
              //  atributosInserir = id + ";" + funcionario.getNome() + ";" + funcionario.getCargo() + ";" + funcionario.getUsuario().getLogin() + ";" + funcionario.getUsuario().getSenha();

            //}

            funcionarioRepositorio.Incluir(atributosInserir, absoluta);

            arquivo.close();
GerenciadorAuditoriaSingleton.getInstance().adicionaMensagemAuditoria("Funcionario cadastrado com sucesso");
            return "Funcionario cadastrado com sucesso";

        }
GerenciadorAuditoriaSingleton.getInstance().adicionaMensagemAuditoria("Nao foi possivel cadastrar o funcionario especificado");
        return "Nao foi possivel cadastrar o funcionario especificado";
    }
    public static List<String> Visualizar(){
        String atributosInserir = "";
        File f = new File("Funcionario.txt");
        String absoluta = f.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");
        FuncionarioRepositorioArquivo funcionarioRepositorio  = new FuncionarioRepositorioArquivo();
        GerenciadorAuditoriaSingleton.getInstance().adicionaMensagemAuditoria("Funcionario visualizado com sucesso");
        return funcionarioRepositorio.ObterTodos(absoluta);
        
    }
    public static void Excluir(int id){
        File f = new File("Funcionario.txt");
        String absoluta = f.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");
        FuncionarioRepositorioArquivo funcionarioRepositorio  = new FuncionarioRepositorioArquivo();
        funcionarioRepositorio.Remover(id, absoluta);
        GerenciadorAuditoriaSingleton.getInstance().adicionaMensagemAuditoria("Funcionario excluido com sucesso");

        
    }
}
