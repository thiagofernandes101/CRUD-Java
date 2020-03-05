/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao.ec6.crud.acesso;

import br.com.comuns.crud.ec6.vos.acesso.Usuario;
import br.com.comuns.ec6.crud.basis.Entidade;
import br.com.dao.ec6.crud.basis.DAO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriell
 */
public class UsuarioTextoDAO extends DAO
{

    private final ConcurrentHashMap<String, Usuario> usuarios = new ConcurrentHashMap<>();

    public UsuarioTextoDAO()
    {
        super(Usuario.class);
//        Usuario masterUser = new Usuario();
//        masterUser.setLogin("master");
//        masterUser.setSenha("master");
//        usuarios.put("master", masterUser);
    }

    @Override
    public Entidade seleciona(int id)
    {
        // Não há retorno por id
        return null;
    }

    @Override
    public Entidade localiza(String codigo) throws SQLException
    {
        Entidade entidade = usuarios.getOrDefault(codigo, null);
        Usuario usuario = new Usuario();
        try
        {
            try ( BufferedReader arquivoAcessoUsuario = new BufferedReader(new FileReader("C:\\Users\\thiag\\Documents\\Termomecanica\\EC6\\ProfessorGabrielLaraBatista\\CRUD-Java\\DesafioCRUD\\br.com.dao.ec6.crud\\Repositorio\\Login\\AcessoUsuario.txt")))
            {
                String linhaArquivo;
                while ((linhaArquivo = arquivoAcessoUsuario.readLine()) != null)
                {
                    linhaArquivo = linhaArquivo.trim();

                    String usuarioArquivo = linhaArquivo.split("|")[0];
                    String senhaArquivo = linhaArquivo.split("|")[0];

                    if (codigo == usuarioArquivo)
                    {
                        usuario.setLogin(usuarioArquivo);
                        usuario.setSenha(senhaArquivo);
                    }
                }
            }
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(UsuarioTextoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(UsuarioTextoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return entidade;
    }

    /* Opção 1 
     */
    @Override
    public ArrayList<Entidade> lista() throws SQLException
    {
        ArrayList<Entidade> entidades;

        entidades = new ArrayList();

        for (Usuario usuario : usuarios.values())
        {
            entidades.add(usuario);
        }

        return entidades;
    }

    @Override
    public void Incluir(Entidade entidade)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Atualizar(Entidade entidade)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Deletar(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List ObterTodos()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Entidade ObterEntidadePorId(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario ObterUsuarioParaAcesso() throws FileNotFoundException, IOException
    {
        Usuario usuario = new Usuario();
        
        try ( BufferedReader arquivoAcessoUsuario = new BufferedReader(new FileReader("C:\\Users\\thiag\\Documents\\Termomecanica\\EC6\\ProfessorGabrielLaraBatista\\CRUD-Java\\DesafioCRUD\\br.com.dao.ec6.crud\\Repositorio\\Login\\AcessoUsuario.txt")))
        {
            String linhaArquivo;
            while ((linhaArquivo = arquivoAcessoUsuario.readLine()) != null)
            {
                linhaArquivo = linhaArquivo.trim();

                
            }
        }
        
        return usuario;
    }
}
