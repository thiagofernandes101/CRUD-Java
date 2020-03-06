/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comuns.crud.ec6.vos.conteudo;

import br.com.comuns.ec6.crud.basis.Entidade;

/**
 *
 * @author gabriell
 */
public class Produto extends Entidade
{

    private String nome;
    private String descrição;
    private double preco;

    /**
     * @return the nome
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDescrição()
    {
        return descrição;
    }

    public void setDescrição(String descrição)
    {
        this.descrição = descrição;
    }

    public double getPreco()
    {
        return preco;
    }

    public void setPreco(double preco)
    {
        this.preco = preco;
    }

}
