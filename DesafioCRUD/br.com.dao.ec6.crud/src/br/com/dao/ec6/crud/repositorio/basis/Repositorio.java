/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.repositorio.basis;

import br.com.comuns.crud.ec6.enums.EntidadesDisponiveis;
import br.com.comuns.ec6.crud.basis.Entidade;
import java.util.List;

/**
 *
 * @author gabriell
 */
public abstract class Repositorio
{

    public abstract Entidade seleciona(int id, EntidadesDisponiveis tipoEntidade);

    public abstract Entidade localiza(String codigo, EntidadesDisponiveis tipoEntidade);

    public abstract void Incluir(Entidade entidade, EntidadesDisponiveis tipoEntidade);

    public abstract void Atualizar(Entidade entidade, EntidadesDisponiveis tipoEntidade);
    
    public abstract void Deletar(int id, EntidadesDisponiveis tipoEntidade);

    public abstract List<Entidade> ObterTodos(EntidadesDisponiveis tipoEntidade);
    
    public abstract Entidade ObterEntidadePorId(int id, EntidadesDisponiveis tipoEntidade);
}
