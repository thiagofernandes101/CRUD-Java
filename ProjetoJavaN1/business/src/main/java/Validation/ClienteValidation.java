/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import Enums.EntidadesDisponiveis;
import Repositorios.ClienteRepositorioArquivo;
import VO.Cliente.Cliente;
import java.io.IOException;

/**
 *
 * @author thiag
 */
public class ClienteValidation
{

    public static String IncluirValidation(Cliente cliente) throws IOException
    {
        if (!cliente.getNome().trim().isEmpty() && !cliente.getCpf().trim().isEmpty())
        {
            ClienteRepositorioArquivo clienteRepositorio = new ClienteRepositorioArquivo();
            Cliente retornoClienteValidacao = clienteRepositorio.ObterPorCPF(cliente.getCpf());

            if (retornoClienteValidacao != null)
            {
                clienteRepositorio.Incluir(cliente, EntidadesDisponiveis.Cliente);
                return "Cliente cadastrado com sucesso";
            }
        }

        return "Nao foi possivel cadastrar o cliente especificado";
    }
}
