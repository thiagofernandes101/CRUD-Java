/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.basis;

import br.com.comuns.ec6.crud.basis.Entidade;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabriell
 * @param <E>
 */
public abstract class DAO<E extends Entidade>
{

    protected Class<E> entityClass;

    public DAO(Class<E> entityClass)
    {
        this.entityClass = entityClass;
    }
    
    public abstract void Incluir(Entidade entidade);
    
    public abstract void Atualizar(Entidade entidade);
    
    public abstract void Deletar(int id);
    
    public abstract List<Entidade> ObterTodos();
    
    public abstract Entidade ObterEntidadePorId(int id);

    public abstract ArrayList<E> lista() throws SQLException;

    protected E getInstanceOfE()
    {
        try
        {
            return entityClass.newInstance();
        }
        catch (IllegalAccessException | InstantiationException e)
        {
            // Oops, no default constructor
            throw new RuntimeException(e);
        }
    }
}
