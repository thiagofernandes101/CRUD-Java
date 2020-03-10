/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import EstadoConsole.MaquinaEstadoConsole;

/**
 *
 * @author 082170029
 */
public class ProgramaPrincipal
{
    public static MaquinaEstadoConsole maquinaEstadoConsole;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        boolean saida = false;

        Configuracao.ObterInstancia().setDataBase(TipoRepositorio.MySql);
        maquinaEstadoConsole = EnumEstadoConsole.EnumEstadoConsole.BemVindo.getMaquinaEstadoConsole();

        while (!saida)
        {
            saida = maquinaEstadoConsole.ExecutarMaquinaEstado();
        }
    }
    
}
