/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author 082170029
 */
public interface IRepositorio<TEntity> {
    void Incluir(String atributosInserir, String caminhoArquivo);
    
    TEntity ObterPorId(int id, String caminhoArquivo);
    
    List<String> ObterTodos(String caminhoArquivo);
    
    void Atualizar(String atributosAtualizar, String caminhoArquivo);
    
    void Remover(long id, String caminhoArquivo);
}
