package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    private static final String URL  = "jdbc:mysql://localhost:3306/projetofinal";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void main(String[] args) {
        try {
            Connection c = getConexao();
            System.out.println("Conexão bem-sucedida!");
            c.close();
        } catch (SQLException e) {
            System.err.println("Erro na conexão: " + e.getMessage());
        }
    }
}
