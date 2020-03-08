/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnumEstadoConsole;

import EstadoConsole.EstadoConsoleBemVindo;
import EstadoConsole.EstadoConsoleGerente;
import EstadoConsole.EstadoConsoleLogin;
import EstadoConsole.EstadoConsoleVendedor;
import EstadoConsole.MaquinaEstadoConsole;

/**
 *
 * @author thiag
 */
public enum EnumEstadoConsole
{
    BemVindo(new EstadoConsoleBemVindo()),
    Login(new EstadoConsoleLogin()),
    Vendedor(new EstadoConsoleVendedor()),
    Gerente(new EstadoConsoleGerente());
    
    private final MaquinaEstadoConsole _maquinaEstadoConsole;
    
    EnumEstadoConsole(MaquinaEstadoConsole maquinaEstadoConsole)
    {
        this._maquinaEstadoConsole = maquinaEstadoConsole;
    }
    
    public MaquinaEstadoConsole getMaquinaEstadoConsole()
    {
        return this._maquinaEstadoConsole;
    }
}
