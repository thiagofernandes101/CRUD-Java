/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracaoCrud;

import Enums.TipoRepositorio;

/**
 *
 * @author thiag
 */
public class Configuracao
{
    private static Configuracao instanciaUnica;
    private TipoRepositorio _tipoRepositorio;
    
    private Configuracao()
    {
        
    }
    
    public static synchronized Configuracao ObterInstancia()
    {
        if (instanciaUnica == null)
        {
            instanciaUnica = new Configuracao();
        }
        
        return instanciaUnica;
    }
    
    public TipoRepositorio getTipoRepositorio()
    {
        return _tipoRepositorio;
    }
    
    public void setDataBase(TipoRepositorio tipoRepositorio)
    {
        this._tipoRepositorio = tipoRepositorio;
    }
        
}
