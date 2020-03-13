/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import VO.Acesso.Usuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 082170029
 */
public class AcessoDAO {
    public String ObterAcessoFuncionario(Usuario usuario) throws FileNotFoundException, IOException
    {
        BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\thiag\\Documents\\Termomecanica\\EC6\\ProfessorGabrielLaraBatista\\CRUD-Java\\ProjetoJavaN1\\dao\\src\\main\\java\\ArquivoBancoDados\\Funcionario.txt"));
        if (arquivo != null)
        {
            //Scanner scanner = new Scanner(arquivo);
            String linha;
            while ((linha = arquivo.readLine()) != null)
            {
                String login = linha.split(";")[3];
                String senha = linha.split(";")[4];
                
                if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha()))
                {
                    return linha.split(";")[2];
                }
            }
        }

        return "Usuario nao encontrado";
    }
}
