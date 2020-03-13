/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO.Acesso;

/**
 *
 * @author 082170029
 */
public class Usuario {

    private String _login;
    private String _senha;
    
    public Usuario(){
    
    }
    public Usuario(String login,String senha){
        setLogin(login);
        setSenha(senha);
    }
        

    public String getLogin()
    {
        return _login;
    }

    public void setLogin(String login)
    {
        this._login = login;
    }

    public String getSenha()
    {
        return _senha;
    }

    public void setSenha(String senha)
    {
        this._senha = senha;
    }
}
