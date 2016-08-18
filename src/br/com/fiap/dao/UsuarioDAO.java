package br.com.fiap.dao;
import br.com.fiap.conexao.Conexao;
import java.sql.Connection;
import br.com.fiap.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class UsuarioDAO {
    
    private Connection conexao;
    
    public boolean pesquisarUsuario(Usuario usuario){
        boolean achou = false;
        try {
            conexao = Conexao.getConnection();
            String sql = "SELECT * FROM POO_USUARIO WHERE login = ? and senha = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, usuario.getLogin());
            p.setString(2, usuario.getSenha());
            ResultSet rs = p.executeQuery();
            
            if(rs.next()){
                achou = true;
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuario/n"+e);
        }
        finally{
            try {
                conexao.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão/n"+e);
            }
        }
        return achou;
    }
}
