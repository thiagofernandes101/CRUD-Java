/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO.Conteudo;

import VO.Padrao.PadraoVO;

/**
 *
 * @author thiag
 */
public class Produto extends PadraoVO
{

    public String getNome()
    {
        return _nome;
    }

    public void setNome(String _nome)
    {
        this._nome = _nome;
    }

    public String getDesricao()
    {
        return _desricao;
    }

    public void setDesricao(String _desricao)
    {
        this._desricao = _desricao;
    }

    public double getPreco()
    {
        return _preco;
    }

    public void setPreco(double _preco)
    {
        this._preco = _preco;
    }
    private String _nome;
    private String _desricao;
    private double _preco;
}
