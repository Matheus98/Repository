package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {

		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
		} catch (SQLException e) {
			System.out.println("Erro de conexão");
			throw new RuntimeException(e);
		}
	}

}
