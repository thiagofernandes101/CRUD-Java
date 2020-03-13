/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO.Acesso;

import VO.Padrao.PadraoVO;

/**
 *
 * @author 082170029
 */
public class Funcionario extends PadraoVO {

    private String _nome;
    private String _cargo;
    private Usuario _usuario;

    public String getNome() {
        return _nome;
    }

    public void setNome(String _nome) {
        this._nome = _nome;
    }

    public String getCargo() {
        return _cargo;
    }

    public void setCargo(String _cargo) {
        this._cargo = _cargo;
    }

    public Usuario getUsuario() {
        return _usuario;
    }

    public void setUsuario(Usuario usuario) {
        this._usuario = usuario;
    }
}
