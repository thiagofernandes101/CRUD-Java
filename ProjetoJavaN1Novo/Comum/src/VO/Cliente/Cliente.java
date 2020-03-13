/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO.Cliente;

/**
 *
 * @author 082170029
 */
public class Cliente {

    public String getNome() {
        return _nome;
    }

    public void setNome(String nome) {
        this._nome = nome;
    }

    public String getCpf() {
        return _cpf;
    }

    public void setCpf(String cpf) {
        this._cpf = cpf;
    }
    private String _nome;
    private String _cpf;
}
