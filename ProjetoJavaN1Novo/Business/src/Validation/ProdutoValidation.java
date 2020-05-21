/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import GestaoControleSeguranca.GerenciadorAuditoriaSingleton;
import static Global.GerarId.GerarIdArquivo;
import Repositorios.FuncionarioRepositorioArquivo;
import Repositorios.ProdutoRepositorioArquivo;
import VO.Conteudo.Produto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author 082170029
 */
public class ProdutoValidation {

    public static String IncluirValidation(Produto produto) throws IOException {
        String atributosInserir = "";
          File f = new File("Produto.txt");
        String absoluta = f.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");
        if (!produto.getNome().trim().isEmpty() && !produto.getDesricao().trim().isEmpty() && produto.getPreco() > 0) {
            ProdutoRepositorioArquivo produtoRepositorio = new ProdutoRepositorioArquivo();

            int id = GerarIdArquivo(absoluta);
            BufferedReader arquivo = new BufferedReader(new FileReader(absoluta));

            atributosInserir = id + ";" + produto.getNome() + ";" + produto.getDesricao() + ";" + produto.getPreco();
            produtoRepositorio.Incluir(atributosInserir, absoluta);

            arquivo.close();
            GerenciadorAuditoriaSingleton.getInstance().adicionaMensagemAuditoria("Produto cadastrado com sucesso");
            
            return "Produto cadastrado com sucesso";

        }
        GerenciadorAuditoriaSingleton.getInstance().adicionaMensagemAuditoria("Nao foi possivel cadastrar o produto especificado");
    
        return "Nao foi possivel cadastrar o produto especificado";
    }
    public static List<String> Visualizar(){
        String atributosInserir = "";
        File f = new File("Produto.txt");
        String absoluta = f.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");
        ProdutoRepositorioArquivo produtoRepositorio  = new ProdutoRepositorioArquivo();
        GerenciadorAuditoriaSingleton.getInstance().adicionaMensagemAuditoria("Produto vizualizado com sucesso");
        return produtoRepositorio.ObterTodos(absoluta);
    }
    public static void Excluir(int id){
        File f = new File("Produto.txt");
        String absoluta = f.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");
        ProdutoRepositorioArquivo produtoRepositorio  = new ProdutoRepositorioArquivo();
        GerenciadorAuditoriaSingleton.getInstance().adicionaMensagemAuditoria("Produto excluido com sucesso");
        produtoRepositorio.Remover(id, absoluta);

        
    }
}
