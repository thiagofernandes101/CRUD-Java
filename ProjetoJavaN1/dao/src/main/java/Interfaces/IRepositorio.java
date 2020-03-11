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
    void Incluir(String atributosInserir, String caminhoArquivo);
    
    TEntity ObterPorId(int id, String caminhoArquivo);
    
    List<TEntity> ObterTodos(String caminhoArquivo);
    
    void Atualizar(String atributosAtualizar, String caminhoArquivo);
    
    void Remover(int id, String caminhoArquivo);
}
