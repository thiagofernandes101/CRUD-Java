/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO.Conteudo;

import VO.Padrao.PadraoVO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 082170029
 */
public class Pedido extends PadraoVO {

    public Pedido() {
        listaProdutos = new ArrayList<Produto>();
    }

    public String getDescricao() {
        return _descricao;
    }

    public void setDescricao(String _descricao) {
        this._descricao = _descricao;
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    private String _descricao;
    private List<Produto> listaProdutos;
}
