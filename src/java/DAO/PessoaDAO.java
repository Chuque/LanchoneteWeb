/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.FabricaConexao;
import Model.Cliente;
import Model.Pessoa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class PessoaDAO
{
    

    
    public void create(Pessoa pessoa)
    {
        Connection conexao = FabricaConexao.getConexao();
        
        
        try
        {
            
            String sql = "insert into pessoa(cpf, nome, sexo, dataNasc, email, telefone, cep, rua, numero, bairro, cidade, estado, complemento) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conexao.prepareCall(sql);
            
            ps.setString(1, pessoa.getCpf());
            ps.setString(2, pessoa.getNome());
            ps.setString(3, pessoa.getSexo());
            ps.setDate(4, new Date(pessoa.getDataNasc().getTime()));
            ps.setString(5, pessoa.getEmail());
            ps.setString(6, pessoa.getTelefone());
            ps.setString(7, pessoa.getCep());
            ps.setString(8, pessoa.getRua());
            ps.setInt(9, pessoa.getNumero());
            ps.setString(10, pessoa.getBairro());
            ps.setString(11, pessoa.getCidade());
            ps.setString(12, pessoa.getEstado());
            ps.setString(13, pessoa.getComplemento());
            
            ps.execute();
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
    /*
    public void update(Pessoa pessoa, String cpfAntigo)
    {
        String sql = "update pessoa set cpf = ?, nome = ?, sexo = ?, dataNasc = ?, email = ?, telefone = ?, cep = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, complemento = ? where cpf = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, pessoa.getCpf());
            preparedStatement.setString(2, pessoa.getNome());
            preparedStatement.setString(3, pessoa.getSexo());
            preparedStatement.setDate(4, new Date(pessoa.getDataNasc().getTime()));
            preparedStatement.setString(5, pessoa.getEmail());
            preparedStatement.setString(6, pessoa.getTelefone());
            preparedStatement.setString(7, pessoa.getCep());
            preparedStatement.setString(8, pessoa.getRua());
            preparedStatement.setInt(9, pessoa.getNumero());
            preparedStatement.setString(10, pessoa.getBairro());
            preparedStatement.setString(11, pessoa.getCidade());
            preparedStatement.setString(12, pessoa.getEstado());
            preparedStatement.setString(13, pessoa.getComplemento());
            preparedStatement.setString(14, cpfAntigo);
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void delete(String cpf)
    {
        String sql = "delete from pessoa where cpf = ?;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cpf);
            
            preparedStatement.execute();
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
 */
   