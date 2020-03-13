/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import Repositorios.ClienteRepositorioArquivo;
import VO.Cliente.Cliente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 082170029
 */
public class ClienteValidation {

    public static String IncluirValidation(Cliente cliente) throws IOException {
        String atributosInserir = "";
        if (!cliente.getNome().trim().isEmpty() && !cliente.getCpf().trim().isEmpty()) {
            ClienteRepositorioArquivo clienteRepositorio = new ClienteRepositorioArquivo();
            Cliente retornoClienteValidacao = clienteRepositorio.ObterPorCPF(cliente.getCpf());

            if (retornoClienteValidacao == null) {
                BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\thiag\\Documents\\Termomecanica\\EC6\\ProfessorGabrielLaraBatista\\CRUD-Java\\ProjetoJavaN1\\dao\\src\\main\\java\\ArquivoBancoDados\\Cliente.txt"));

                if (arquivo != null) {
                    atributosInserir = cliente.getCpf() + ";" + cliente.getNome();
                } else {
                    atributosInserir = cliente.getCpf() + ";" + cliente.getNome();
                }

                clienteRepositorio.Incluir(atributosInserir, "C:\\Users\\thiag\\Documents\\Termomecanica\\EC6\\ProfessorGabrielLaraBatista\\CRUD-Java\\ProjetoJavaN1\\dao\\src\\main\\java\\ArquivoBancoDados\\Cliente.txt");

                arquivo.close();

                return "Cliente cadastrado com sucesso";
            }
        }

        return "Nao foi possivel cadastrar o cliente especificado";
    }
}
