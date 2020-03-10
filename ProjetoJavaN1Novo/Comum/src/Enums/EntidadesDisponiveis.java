/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author 082170029
 */
public enum EntidadesDisponiveis
{
    Gerente("gerente"),
    Vendedor("vendedor"),
    Pedido("pedido"),
    Produto("produto");
    
    private String _descricao;
    
    EntidadesDisponiveis(String descricao)
    {
        this._descricao = descricao;
    }
    
    public String getDescricao()
    {
        return _descricao;
    }
}
