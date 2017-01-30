/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class FabricaConexao
{
    private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:mysql://localhost/projetoLP3";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    
    public static Connection getConexao()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
        }
        catch(SQLException exception)
        {
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, exception);
        }
        catch(ClassNotFoundException exception)
        {
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, exception);
        }
        
        return conexao;
    }
    
    public static void fecharConexao()
    {
        if(conexao != null)
        {
            try
            {
                conexao.close();
                conexao = null;
            }
            catch(SQLException exception)
            {
                Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }
}
