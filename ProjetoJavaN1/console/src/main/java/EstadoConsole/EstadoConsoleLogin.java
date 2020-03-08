/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoConsole;

import Login.Acesso;
import VO.Acesso.Usuario;
import java.util.Scanner;

/**
 *
 * @author thiag
 */
public class EstadoConsoleLogin extends MaquinaEstadoConsole
{

    @Override
    public boolean ExecutarMaquinaEstado()
    {
        return ApresentacaoLogin();
    }
    
    private static boolean ApresentacaoLogin()
    {
        boolean sair = false;
        boolean usuarioValido = true;
        
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();
        Acesso acessoCadastro = new Acesso();
        
        System.out.flush();
        System.out.println("**** Login ****\n");
        
        do
        {
            System.out.print("Digite seu usuario: ");
            String login = scanner.nextLine();
            
            System.out.print("Digite sua senha: ");
            String senha = scanner.nextLine();
            
            usuario.setLogin(login);
            usuario.setSenha(senha);
            
            acessoCadastro.ValidarUsuario(usuario);
            
            if (!usuarioValido)
            {
                
                System.out.flush();
                System.out.println("Usuário ou senha inválidos.\n");
            }
        }
        while (!usuarioValido);
        
        return sair;
    }
}
