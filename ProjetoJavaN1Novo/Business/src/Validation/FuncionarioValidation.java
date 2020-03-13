/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import static Global.GerarId.GerarIdArquivo;
import Repositorios.FuncionarioRepositorioArquivo;
import VO.Acesso.Funcionario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 082170029
 */
public class FuncionarioValidation {

    public static String IncluirValidation(Funcionario funcionario) throws IOException {
        String atributosInserir = "";
        if (!funcionario.getNome().trim().isEmpty() && !funcionario.getCargo().trim().isEmpty() && !funcionario.getUsuario().getLogin().trim().isEmpty() && !funcionario.getUsuario().getSenha().trim().isEmpty()) {
            FuncionarioRepositorioArquivo funcionarioRepositorio = new FuncionarioRepositorioArquivo();

            int id = GerarIdArquivo("C:\\Users\\thiag\\Documents\\Termomecanica\\EC6\\ProfessorGabrielLaraBatista\\CRUD-Java\\ProjetoJavaN1\\dao\\src\\main\\java\\ArquivoBancoDados\\Funcionario.txt");
            BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\thiag\\Documents\\Termomecanica\\EC6\\ProfessorGabrielLaraBatista\\CRUD-Java\\ProjetoJavaN1\\dao\\src\\main\\java\\ArquivoBancoDados\\Funcionario.txt"));

            if (id == 1) {
                atributosInserir = "\n" + id + ";" + funcionario.getNome() + ";" + funcionario.getCargo() + ";" + funcionario.getUsuario().getLogin() + ";" + funcionario.getUsuario().getSenha();

            } else {
                atributosInserir = id + ";" + funcionario.getNome() + ";" + funcionario.getCargo() + ";" + funcionario.getUsuario().getLogin() + ";" + funcionario.getUsuario().getSenha();

            }

            funcionarioRepositorio.Incluir(atributosInserir, "C:\\Users\\thiag\\Documents\\Termomecanica\\EC6\\ProfessorGabrielLaraBatista\\CRUD-Java\\ProjetoJavaN1\\dao\\src\\main\\java\\ArquivoBancoDados\\Funcionario.txt");

            arquivo.close();

            return "Funcionario cadastrado com sucesso";

        }

        return "Nao foi possivel cadastrar o funcionario especificado";
    }
}
