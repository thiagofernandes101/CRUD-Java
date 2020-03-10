/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoConsole;

import CRUD.ProgramaPrincipal;
import EnumEstadoConsole.EnumEstadoConsole;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 082170029
 */
public class EstadoConsoleLogin extends MaquinaEstadoConsole
{

    @Override
    public boolean ExecutarMaquinaEstado()
    {
        boolean retorno = false;
        try
        {
            retorno = ApresentacaoLogin();
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(EstadoConsoleLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(EstadoConsoleLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
    }
    
    private static boolean ApresentacaoLogin() throws FileNotFoundException, IOException
    {
        boolean sair = false;
        String retornoCargoFuncionario;

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

            retornoCargoFuncionario = acessoCadastro.ValidarUsuario(usuario);
        }
        while (retornoCargoFuncionario.isEmpty() || retornoCargoFuncionario == "Usuario nao encontrado");

        if (retornoCargoFuncionario.isEmpty() || retornoCargoFuncionario == "Usuario nao encontrado")
        {

            System.out.flush();
            System.out.println("Usuário ou senha inválidos.\n");
        }
        else
        {
            switch (retornoCargoFuncionario.toLowerCase())
            {
                case "gerente":
                    ProgramaPrincipal.maquinaEstadoConsole = EnumEstadoConsole.Gerente.getMaquinaEstadoConsole();
                    break;

                case "vendedor":
                    ProgramaPrincipal.maquinaEstadoConsole = EnumEstadoConsole.Vendedor.getMaquinaEstadoConsole();
                    break;
            }
        }

        return sair;
    }
}
