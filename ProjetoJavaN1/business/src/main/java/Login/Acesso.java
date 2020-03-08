/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import VO.Acesso.Usuario;

/**
 *
 * @author thiag
 */
public class Acesso
{

    public boolean ValidarLoginESenha(Usuario usuario)
    {
        boolean loginESenhaValido = true;

        if (usuario != null)
        {
            if (!usuario.getLogin().isBlank() && !usuario.getSenha().isBlank())
            {
                loginESenhaValido = false;
            }
        }

        return loginESenhaValido;
    }

    public String ValidarUsuario(Usuario usuario)
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
