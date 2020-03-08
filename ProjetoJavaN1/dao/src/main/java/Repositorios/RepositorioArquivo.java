/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorios;

import Interfaces.IRepositorio;
import Enums.EntidadesDisponiveis;
import java.util.List;

/**
 *
 * @author thiag
 */
public class RepositorioArquivo<TEntity> implements IRepositorio<TEntity>
{

    @Override
    public void Incluir(TEntity entidade, EntidadesDisponiveis tipoEntidade)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TEntity ObterPorId(int id, EntidadesDisponiveis tipoEntidade)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TEntity> ObterTodos(EntidadesDisponiveis tipoEntidade)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Atualizar(TEntity entidade, EntidadesDisponiveis tipoEntidade)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Remover(int id, EntidadesDisponiveis tipoEntidade)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
