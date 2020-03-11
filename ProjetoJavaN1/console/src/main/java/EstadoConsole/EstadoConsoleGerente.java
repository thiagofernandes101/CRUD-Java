/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadoConsole;

import Validation.FuncionarioValidation;
import java.util.Scanner;

/**
 *
 * @author thiag
 */
public class EstadoConsoleGerente extends MaquinaEstadoConsole
{

    @Override
    public boolean ExecutarMaquinaEstado()
    {
        return ApresentacaoGerente();
    }
    
    private static boolean ApresentacaoGerente()
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
        
        switch(opcao)
        {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                sair = true;
                break;
        }
        
        return sair;
    }
    
    private static void MenuGerente()
    {
        System.out.println("Escolha a opcao desejada:");
        System.out.println("1 - Cadastrar funcionario");
        System.out.println("2 - Cadastrar produto");
        System.out.println("3 - Cadastrar pedido");
        System.out.println("4 - Cadastrar clientes");
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
