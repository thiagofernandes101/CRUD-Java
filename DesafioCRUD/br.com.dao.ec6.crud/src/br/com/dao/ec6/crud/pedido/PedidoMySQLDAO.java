/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.pedido;

import br.com.comuns.crud.ec6.vos.conteudo.Pedido;
import br.com.comuns.ec6.crud.basis.Entidade;
import br.com.dao.ec6.crud.basis.MySQLDAO;

/**
 *
 * @author thiag
 */
public class PedidoMySQLDAO<E extends Entidade> extends MySQLDAO
{

    public PedidoMySQLDAO()
    {
        super(Pedido.class);
    }
}
