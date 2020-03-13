/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import static Global.GerarId.GerarIdArquivo;
import Repositorios.ProdutoRepositorioArquivo;
import VO.Conteudo.Produto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 082170029
 */
public class ProdutoValidation {

    public static String IncluirValidation(Produto produto) throws IOException {
        String atributosInserir = "";
        if (!produto.getNome().trim().isEmpty() && !produto.getDesricao().trim().isEmpty() && produto.getPreco() > 0) {
            ProdutoRepositorioArquivo produtoRepositorio = new ProdutoRepositorioArquivo();

            int id = GerarIdArquivo("C:\\Users\\thiag\\Documents\\Termomecanica\\EC6\\ProfessorGabrielLaraBatista\\CRUD-Java\\ProjetoJavaN1\\dao\\src\\main\\java\\ArquivoBancoDados\\Produto.txt");
            BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\thiag\\Documents\\Termomecanica\\EC6\\ProfessorGabrielLaraBatista\\CRUD-Java\\ProjetoJavaN1\\dao\\src\\main\\java\\ArquivoBancoDados\\Produto.txt"));

            atributosInserir = id + ";" + produto.getNome() + ";" + produto.getDesricao() + ";" + produto.getPreco();

            produtoRepositorio.Incluir(atributosInserir, "C:\\Users\\thiag\\Documents\\Termomecanica\\EC6\\ProfessorGabrielLaraBatista\\CRUD-Java\\ProjetoJavaN1\\dao\\src\\main\\java\\ArquivoBancoDados\\Produto.txt");

            arquivo.close();

            return "Produto cadastrado com sucesso";

        }

        return "Nao foi possivel cadastrar o produto especificado";
    }
}
