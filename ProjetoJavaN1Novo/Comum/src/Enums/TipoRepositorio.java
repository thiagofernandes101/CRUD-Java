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
public enum TipoRepositorio
{
    Texto("texto"),
    MySql("mySql");
    
    private String _descricao;
    
    TipoRepositorio(String descricao)
    {
        this._descricao = descricao;
    }
    
    public String getDescricao()
    {
        return this._descricao;
    }
}
