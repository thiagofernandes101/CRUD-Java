/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comuns.crud.ec6.vos.acesso;

import br.com.comuns.ec6.crud.basis.Entidade;

/**
 *
 * @author 082170029
 */
public abstract class Funcionario extends Entidade
{
    
    private String nome;
    private String cargo;
    private Usuario acesso;

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCargo()
    {
        return cargo;
    }

    public void setCargo(String cargo)
    {
        this.cargo = cargo;
    }
    
    
    
}
