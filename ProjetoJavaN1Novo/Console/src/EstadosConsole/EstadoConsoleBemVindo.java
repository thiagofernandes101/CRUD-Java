/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadosConsole;

import Crud.ProgramaPrincipal;
import EnumEstadosConsole.EnumEstadoConsole;
import java.util.Scanner;

/**
 *
 * @author 082170029
 */
public class EstadoConsoleBemVindo extends MaquinaEstadoConsole {

    @Override
    public boolean ExecutarMaquinaEstado() {
        return ApresentacaoBemVindo();
    }
    
    private static boolean ApresentacaoBemVindo()
    {
        int opcaoMenu;
        boolean sair = false;

        Scanner scanner = new Scanner(System.in);
        
        System.out.flush();
        System.out.println("Bem vindo!\n");

        do
        {
            MenuBemVindo();
            opcaoMenu = scanner.nextInt();

            if (opcaoMenu != 0 && opcaoMenu != 1)
            {
                System.out.flush();
                System.out.println("Por favor, digite uma opção válida\n");
            }
        }
        while (opcaoMenu != 0 && opcaoMenu != 1);

        switch (opcaoMenu)
        {
            case 0:
                sair = true;
                break;
            case 1:
                ProgramaPrincipal.maquinaEstadoConsole = EnumEstadoConsole.Login.getMaquinaEstadoConsole();
                break;
        }
        
        return sair;
    }

    private static void MenuBemVindo()
    {
        System.out.println("Indique a opção desejada");
        System.out.println("1-Logar");
        System.out.println("0-Sair");
    }
    
}
