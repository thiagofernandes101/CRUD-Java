/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud;

import ConfiguracaoCrud.Configuracao;
import Enum.TipoRepositorio;
import EnumEstadosConsole.EnumEstadoConsole;
import EstadosConsole.MaquinaEstadoConsole;

/**
 *
 * @author 082170029
 */
public class ProgramaPrincipal {

    public static MaquinaEstadoConsole maquinaEstadoConsole;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean saida = false;

        Configuracao.ObterInstancia().setDataBase(TipoRepositorio.MySql);
        maquinaEstadoConsole = EnumEstadoConsole.BemVindo.getMaquinaEstadoConsole();

        while (!saida)
        {
            saida = maquinaEstadoConsole.ExecutarMaquinaEstado();
        }
    }
    
}
