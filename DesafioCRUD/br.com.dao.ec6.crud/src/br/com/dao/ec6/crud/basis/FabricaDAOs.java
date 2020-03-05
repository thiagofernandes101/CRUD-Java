/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.basis;

import br.com.comuns.crud.ec6.enums.EntidadesDisponiveis;
import br.com.comuns.crud.ec6.enums.TipoRepositorio;
import br.com.comuns.crud.ec6.vos.acesso.Usuario;
import br.com.dao.ec6.crud.acesso.UsuarioMySQLDAO;
import br.com.dao.ec6.crud.acesso.UsuarioTextoDAO;
import br.com.dao.ec6.crud.pedido.PedidoMySQLDAO;
import br.com.dao.ec6.crud.pedido.PedidoTextoDAO;
import br.com.dao.ec6.crud.produto.ProdutoMySQLDAO;
import br.com.dao.ec6.crud.produto.ProdutoTextoDAO;

/**
 *
 * @author gabriell
 */
public class FabricaDAOs {
    
    public static DAO Fabrica(EntidadesDisponiveis enumEntidade, TipoRepositorio repositorio) {
        switch (repositorio)
        {
            case TEXTO:
                return montaDAOTexto(enumEntidade);
            case MYSQL:
                return montaDAOMySQL(enumEntidade);
            default:
                return null;
        }
       
    }

    private static DAO montaDAOTexto(EntidadesDisponiveis enumEntidade) {
        DAO retorno;
        
        switch (enumEntidade)
        {
            case USUARIO:
                retorno = new UsuarioTextoDAO();
                break;
                
            case PEDIDO:
                retorno = new PedidoTextoDAO();
                break;
                
            case PRODUTO:
                retorno = new ProdutoTextoDAO();
                break;
                
            default:
                retorno = null;
                break;
        }
        
        return retorno;    
    }
    
    private static DAO montaDAOMySQL(EntidadesDisponiveis enumEntidade) {
        DAO retorno;
        
        switch (enumEntidade)
        {
            case USUARIO:
                retorno = new UsuarioMySQLDAO();
                break;
                
            case PEDIDO:
                retorno = new PedidoMySQLDAO();
                break;
                
            case PRODUTO:
                retorno = new ProdutoMySQLDAO();
                break;
                
            default:
                retorno = null;
                break;
        }
        
        return retorno;    
    }
    
}
