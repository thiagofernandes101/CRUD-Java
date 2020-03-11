/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Interfaces.IRepositorio;
import Enums.EntidadesDisponiveis;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiag
 */
public abstract class RepositorioArquivo<TEntity> implements IRepositorio<TEntity>
{

    @Override
    public void Incluir(String atributoInserir, String caminhoArquivo)
    {
        PrintWriter escrever = null;
        try
        {
            escrever = new PrintWriter(new BufferedWriter(new FileWriter(caminhoArquivo, true)));
        }
        catch (IOException ex)
        {
            Logger.getLogger(RepositorioArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        escrever.println(atributoInserir);
        escrever.flush();
    }

    @Override
    public TEntity ObterPorId(int id, String caminhoArquivo)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TEntity> ObterTodos(String caminhoArquivo)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Atualizar(String atributosAtualizar, String caminhoArquivo)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Remover(int id, String caminhoArquivo)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
