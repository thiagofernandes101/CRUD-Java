/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Interfaces.IRepositorio;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 082170029
 */
public abstract class RepositorioArquivo<TEntity> implements IRepositorio<TEntity> {

    @Override
    public void Incluir(String atributosInserir, String caminhoArquivo) {
        PrintWriter escrever = null;
        try {
            escrever = new PrintWriter(new BufferedWriter(new FileWriter(caminhoArquivo, true)));
        } catch (IOException ex) {
            Logger.getLogger(RepositorioArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        escrever.println(atributosInserir);
        escrever.flush();
    }

    @Override
    public TEntity ObterPorId(int id, String caminhoArquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> ObterTodos(String caminhoArquivo) {
        BufferedReader arquivo;
        List<String> listaArquivo = new ArrayList<>();
        try {
            arquivo = new BufferedReader(new FileReader(caminhoArquivo));

            if (arquivo != null) {
                //Scanner scanner = new Scanner(arquivo);
                String linha;
                while ((linha = arquivo.readLine()) != null) {
                    listaArquivo.add(linha);
                }

                return listaArquivo;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RepositorioArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RepositorioArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public void Atualizar(String atributosAtualizar, String caminhoArquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Remover(int id, String caminhoArquivo) {
        List<String> lista = new ArrayList<String>();
        List<String> listaNova = new ArrayList<String>();
        lista = ObterTodos(caminhoArquivo);
        for (int i = 0; i < lista.size(); i++) {
            if(Integer.parseInt(lista.get(i).split(";")[0]) != id){
                listaNova.add(lista.get(i));
            }
            
        }
        File f = new File(caminhoArquivo);
        f.delete();
        try {
            FileOutputStream out = new FileOutputStream(caminhoArquivo);
            for (int i = 0; i < listaNova.size(); i++) {
                
               Incluir(listaNova.get(i), caminhoArquivo);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RepositorioArquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RepositorioArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

}
