/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Enums.EntidadesDisponiveis;
import java.util.List;

/**
 *
 * @author thiag
 */
public interface IRepositorio<TEntity> 
{
    void Incluir(TEntity entidade, EntidadesDisponiveis tipoEntidade);
    
    TEntity ObterPorId(int id, EntidadesDisponiveis tipoEntidade);
    
    List<TEntity> ObterTodos(EntidadesDisponiveis tipoEntidade);
    
    void Atualizar(TEntity entidade, EntidadesDisponiveis tipoEntidade);
    
    void Remover(int id, EntidadesDisponiveis tipoEntidade);
}
