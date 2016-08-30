package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import br.com.fiap.modelo.Cliente;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {
    private Connection connection;
    PreparedStatement p;
    String sql;
    ResultSet rs;
    
    public void setCliente(Cliente cliente){
        connection = Conexao.getConnection();
        sql = "Insert Into POO_CLIENTE Values(?,?,?,?,?)";
        
        try {
            p = connection.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEndereco());
            p.setDate(3, cliente.getNascimento());
            p.setString(4, cliente.getFone());
            p.setString(5, cliente.getCaminho());
            
            p.execute();
        }
        catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Cliente\n"+e);
        }
    }
    
     public Cliente getCliente(String nome){
         Cliente cliente = null;
         
         connection = Conexao.getConnection();
         sql = "Select * From POO_CLIENTE where nome="+nome;
         
         try{
             
         }
         catch (Exception e){
             
         }
         
         return cliente;
     }
}
