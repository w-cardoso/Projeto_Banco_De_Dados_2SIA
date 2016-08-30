package br.com.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {    
    private static Connection connection;    
    private static String url = "jdbc:oracle:thin:@192.168.60.15:1521:ORCL";
    private static String usuario = "OPS$RM74007";
    private static String senha = "020897";
    
    public static Connection getConnection() {
	if (connection == null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(url, usuario, senha);
            } 
            catch(ClassNotFoundException e) {}
            catch(SQLException e) {}
        }        
        return connection;
    }    
}