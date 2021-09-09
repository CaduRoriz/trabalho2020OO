package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import saida.Visao;

public class Conexao {
	public static Connection getConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3305/covid19?useTimezone=true&serverTimezone=UTC", "root", "kadu2203");
			

		} catch (SQLException e) {
			Visao.mensagemConsole("NAO CONECTOU \n" + e.getMessage());
			e.printStackTrace();
		}

		return con;
	}

}
