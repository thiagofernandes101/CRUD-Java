/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import VO.Acesso.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author 082170029
 */
public class Acesso {
    public boolean ValidarLoginESenha(Usuario usuario)
    {
        boolean loginESenhaValido = false;

        if (usuario != null)
        {
            if (!usuario.getLogin().isEmpty() && !usuario.getSenha().isEmpty())
            {
                loginESenhaValido = true;
            }
        }

        return loginESenhaValido;
    }

    public String ValidarUsuario(Usuario usuario) throws FileNotFoundException, IOException
    {
        String retornoCargoUsuario = "";
        
        if (ValidarLoginESenha(usuario))
        {
            AcessoDAO acessoDAO = new AcessoDAO();
            retornoCargoUsuario = acessoDAO.ObterAcessoFuncionario(usuario);
        }
        
        return retornoCargoUsuario;
    }
}
