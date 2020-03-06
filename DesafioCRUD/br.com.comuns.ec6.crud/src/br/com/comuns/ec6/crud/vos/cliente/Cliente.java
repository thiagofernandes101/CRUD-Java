/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comuns.ec6.crud.vos.cliente;

/**
 *
 * @author 082170029
 */
public class Cliente
{
    private String nome;
    private String telefone;
    private int cpf;

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public int getCpf()
    {
        return cpf;
    }

    public void setCpf(int cpf)
    {
        this.cpf = cpf;
    }
    
}
