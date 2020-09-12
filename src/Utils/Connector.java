package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Connector {
	Connection con;
	String oracleServer = "oracle.fiap.com.br";
	String databaseName = "orcl";
	String databaseUser = "RM84810";
	String databasePass = "170100";
	
	public Connector() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.con = DriverManager.getConnection("jdbc:oracle:thin:@" + oracleServer + ":1521:" + databaseName,  databaseUser, databasePass);
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle Driver Class not found");
			e.printStackTrace();
		}		
	}
	
	public ResultSet ExecuteQuery(String query) {
		try {
			Statement stmt = con.createStatement();
			return stmt.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar query");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void Close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
