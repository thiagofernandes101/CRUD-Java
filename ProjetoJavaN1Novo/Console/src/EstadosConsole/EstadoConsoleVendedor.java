/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstadosConsole;

import VO.Acesso.Funcionario;
import VO.Acesso.Usuario;
import VO.Cliente.Cliente;
import VO.Conteudo.Produto;
import Validation.ClienteValidation;
import Validation.FuncionarioValidation;
import Validation.ProdutoValidation;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 082170029
 */
public class EstadoConsoleVendedor extends MaquinaEstadoConsole {

   @Override
    public boolean ExecutarMaquinaEstado() {
        boolean retorno = false;

        try {
            retorno = ApresentacaoGerente();
        } catch (IOException ex) {
            Logger.getLogger(EstadoConsoleGerente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
    }

    private static boolean ApresentacaoGerente() throws IOException {
        String opcao;
        boolean sair = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("**** VENDEDOR ****");

        do {
            MenuGerente();
            opcao = scanner.nextLine();
        } while (ValidaOpcao(opcao));

        switch (opcao) {
            
            case "1":
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
            case "3":
                Cliente cliente = new Cliente();
                Scanner ler = new Scanner(System.in);
                System.out.print("Digite o nome do cliente:");
                cliente.setNome(ler.next());
                System.out.println("Digite o cpf do cliente:");
                cliente.setCpf(ler.next());

                ClienteValidation.IncluirValidation(cliente);
                break;
            case "5":
                sair = true;
                break;
            
            
            case "11":
                List<String> listaP = ProdutoValidation.Visualizar();
                for (int i = 0; i < listaP.size(); i++) {
                    System.out.println("------------------------------------");
                    System.out.printf("id: %s\n",listaP.get(i).split(";")[0]);                    
                    System.out.printf("Nome: %s\n",listaP.get(i).split(";")[1]);
                    System.out.printf("Descrição: %s\n",listaP.get(i).split(";")[2]);
                    System.out.printf("Preço: %s\n",listaP.get(i).split(";")[3]);
                    System.out.println("------------------------------------");
                   
                    
                }
                break;
            case "12":
                Scanner lerProduto = new Scanner(System.in);
                System.out.print("Digite o id do produto que deseja excluir:");
                ProdutoValidation.Excluir(Long.parseLong(lerProduto.next()));
                List<String> listaProduto = ProdutoValidation.Visualizar();
                for (int i = 0; i < listaProduto.size(); i++) {
                    System.out.println("------------------------------------");
                    System.out.printf("id: %s\n",listaProduto.get(i).split(";")[0]);                    
                    System.out.printf("Nome: %s\n",listaProduto.get(i).split(";")[1]);
                    System.out.printf("Descrição: %s\n",listaProduto.get(i).split(";")[2]);
                    System.out.printf("Preço: %s\n",listaProduto.get(i).split(";")[3]);
                    System.out.println("------------------------------------");
                   
                    
                }
                    break;
         
            case "31":
                List<String> listaC = ClienteValidation.Visualizar();
                for (int i = 0; i < listaC.size(); i++) {
                    System.out.println("------------------------------------");
                    System.out.printf("CPF: %s\n",listaC.get(i).split(";")[0]);                    
                    System.out.printf("Nome: %s\n",listaC.get(i).split(";")[1]);
                    System.out.println("------------------------------------");
                   
                    
                }
                break;
             case "32":
                Scanner lerCli = new Scanner(System.in);
                System.out.print("Digite o cpf do cliente que deseja excluir:");
                ClienteValidation.Excluir(Long.parseLong(lerCli.next()));
                List<String> listaCli = ClienteValidation.Visualizar();
                for (int i = 0; i < listaCli.size(); i++) {
                    System.out.println("------------------------------------");
                    System.out.printf("CPF: %s\n",listaCli.get(i).split(";")[0]);                    
                    System.out.printf("Nome: %s\n",listaCli.get(i).split(";")[1]);
                    System.out.println("------------------------------------");
                   
                    
                }
                    break;
            
        }

        return sair;
    }

    private static void MenuGerente() {
        System.out.println("Escolha a opcao desejada:");;
        System.out.println("1 - Cadastrar produto");
        System.out.println("11 - Visualizar produto");
        System.out.println("12 - Excluir produto");
        System.out.println("2 - Cadastrar pedido");
        System.out.println("21 - Visualizar pedido");
        System.out.println("22 - Excluir pedido");
        System.out.println("3 - Cadastrar clientes");
        System.out.println("31 - Visualizar clientes");
        System.out.println("32 - Excluir cliente"); 
        System.out.println("5 - Sair");
    }

    private static boolean ValidaOpcao(String opcao) {
        if (!"1".equals(opcao) && !"2".equals(opcao) && !"3".equals(opcao) && !"5".equals(opcao)  && !"31".equals(opcao) && !"32".equals(opcao) && !"21".equals(opcao) && !"22".equals(opcao) && !"11".equals(opcao) && !"12".equals(opcao)) {
            System.out.println("Por favor informe uma opcao valida");
            return true;
        }

        return false;
    }
    
}
