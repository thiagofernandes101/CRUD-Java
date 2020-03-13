/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoConsole;

import VO.Acesso.Funcionario;
import VO.Acesso.Usuario;
import VO.Cliente.Cliente;
import VO.Conteudo.Produto;
import Validation.ClienteValidation;
import Validation.FuncionarioValidation;
import Validation.ProdutoValidation;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiag
 */
public class EstadoConsoleGerente extends MaquinaEstadoConsole
{

    @Override
    public boolean ExecutarMaquinaEstado()
    {
        boolean retorno = false;

        try
        {
            retorno = ApresentacaoGerente();
        }
        catch (IOException ex)
        {
            Logger.getLogger(EstadoConsoleGerente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    private static boolean ApresentacaoGerente() throws IOException
    {
        int opcao;
        boolean sair = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("**** GERENTE ****");

        do
        {
            MenuGerente();
            opcao = scanner.nextInt();
        }
        while (ValidaOpcao(opcao));

        switch (opcao)
        {
            case 1:
                String login;
                String senha;
                Funcionario funcionario = new Funcionario();
                Scanner lerFunc = new Scanner(System.in);
                System.out.print("Digite o nome do funcionario:");
                funcionario.setNome(lerFunc.next());
                System.out.println("Digite o cargo do funcionario:");
                funcionario.setCargo(lerFunc.next());
                System.out.println("Digite o login do funcionario:");
                login = lerFunc.next();
                System.out.println("Digite a senha do funcionario:");
                senha = lerFunc.next();
                funcionario.setUsuario(new Usuario(login, senha));

                FuncionarioValidation.IncluirValidation(funcionario);
                break;
            case 2:
                Produto produto = new Produto();
                Scanner lerProd = new Scanner(System.in);
                System.out.print("Digite o nome do produto:");
                produto.setNome(lerProd.next());
                System.out.println("Digite a descrição do produto:");
                produto.setDesricao(lerProd.next());
                System.out.println("Digite o preço do produto:");
                produto.setPreco(lerProd.nextDouble());

                ProdutoValidation.IncluirValidation(produto);
                break;
            case 3:
                break;
            case 4:
                Cliente cliente = new Cliente();
                Scanner ler = new Scanner(System.in);
                System.out.print("Digite o nome do cliente:");
                cliente.setNome(ler.next());
                System.out.println("Digite o cpf do cliente:");
                cliente.setCpf(ler.next());

                ClienteValidation.IncluirValidation(cliente);
                break;
            case 5:
                sair = true;
                break;
            case 11:
                
                break;
            case 21:
                break;
            case 31:
                break;
            case 41:
                break;
        }

        return sair;
    }

    private static void MenuGerente()
    {
        System.out.println("Escolha a opcao desejada:");
        System.out.println("1 - Cadastrar funcionario");
        System.out.println("11 - Visualizar funcionario");
        System.out.println("2 - Cadastrar produto");
        System.out.println("21 - Visualizar funcionario");
        System.out.println("3 - Cadastrar pedido");
        System.out.println("31 - Visualizar funcionario");
        System.out.println("4 - Cadastrar clientes");
        System.out.println("41 - Visualizar funcionario");
        System.out.println("5 - Sair");
    }

    private static boolean ValidaOpcao(int opcao)
    {
        if (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5)
        {
            System.out.println("Por favor informe uma opcao valida");
            return true;
        }

        return false;
    }
}
