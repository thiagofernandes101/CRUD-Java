/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import VO.Cliente.Cliente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author 082170029
 */
public class ClienteRepositorioArquivo extends RepositorioArquivo<Cliente> {
    public Cliente ObterPorCPF(String cpf ) throws FileNotFoundException, IOException{
          File f = new File("Cliente.txt");
        String absoluta = f.getAbsolutePath().replace("Console", "DAO\\src\\ArquivoBancoDados");
       BufferedReader arquivo = new BufferedReader(new FileReader(absoluta));
        if (arquivo != null)
        {
            //Scanner scanner = new Scanner(arquivo);
            String linha;
            Cliente cliente = new Cliente();
            while ((linha = arquivo.readLine()) != null)
            {
                String cpfArquivo = linha.split(";")[0];
                
                if (cpfArquivo.equals(cpf))
                {
                    cliente.setNome(linha.split(";")[1]);
                    cliente.setCpf(cpf);
                    return cliente;
                }
                
            }
        }
        return null;
    }
}
