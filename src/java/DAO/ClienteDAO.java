/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Pessoa;
import Model.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import Connection.FabricaConexao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rafael
 */
public class ClienteDAO
{
    private Connection connection;
    
    public void create(Cliente cliente)
    {
        new PessoaDAO().create(cliente);
        Connection conexao = FabricaConexao.getConexao();
        
        try
        {
            PreparedStatement ps = conexao.prepareCall("insert into cliente(cpf, produtoFavorito) values(?, ?);");
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getProdutoFavorito());
            
            ps.execute();
            FabricaConexao.fecharConexao();
        }
        catch (SQLException ex)
        {
            //Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
    }
    
    public ArrayList<Cliente> selectByName(String nome)
    {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        //teste
        String sql = "select p.cpf, p.nome, p.sexo, p.dataNasc, p.email, p.telefone, p.cep, p.rua, p.numero, p.bairro, p.cidade, p.estado, p.complemento, c.produtofavorito from pessoa p, cliente c where p.nome like ? and p.cpf = c.cpf;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, "%" + nome + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                Cliente cliente = new Cliente();
                
                cliente.setCpf(resultSet.getString(1));
                cliente.setNome(resultSet.getString(2));
                cliente.setSexo(resultSet.getString(3));
                cliente.setDataNasc(resultSet.getDate(4));
                cliente.setEmail(resultSet.getString(5));
                cliente.setTelefone(resultSet.getString(6));                
                cliente.setCep(resultSet.getString(7));
                cliente.setRua(resultSet.getString(8));
                cliente.setNumero(resultSet.getInt(9));
                cliente.setBairro(resultSet.getString(10));
                cliente.setCidade(resultSet.getString(11));
                cliente.setEstado(resultSet.getString(12));
                cliente.setComplemento(resultSet.getString(13));                
                cliente.setProdutoFavorito(resultSet.getString(14));
                
                clientes.add(cliente);
            }
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return clientes;
    }
    
    public ArrayList<Cliente> selectByCpf(String cpf)
    {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        
        String sql = "select p.cpf, p.nome, p.sexo, p.dataNasc, p.email, p.telefone, p.cep, p.rua, p.numero, p.bairro, p.cidade, p.estado, p.complemento, c.produtofavorito from pessoa p, cliente c where c.cpf like ? and p.cpf = c.cpf;";
        
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cpf + "%");
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next())
            {
                Cliente cliente = new Cliente();
                
                cliente.setCpf(resultSet.getString(1));
                cliente.setNome(resultSet.getString(2));
                cliente.setSexo(resultSet.getString(3));
                cliente.setDataNasc(resultSet.getDate(4));
                cliente.setEmail(resultSet.getString(5));
                cliente.setTelefone(resultSet.getString(6));                
                cliente.setCep(resultSet.getString(7));
                cliente.setRua(resultSet.getString(8));
                cliente.setNumero(resultSet.getInt(9));
                cliente.setBairro(resultSet.getString(10));
                cliente.setCidade(resultSet.getString(11));
                cliente.setEstado(resultSet.getString(12));
                cliente.setComplemento(resultSet.getString(13));                
                cliente.setProdutoFavorito(resultSet.getString(14));
                
                clientes.add(cliente);
            }
            preparedStatement.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return clientes;
    }
    
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
