package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Connector {
	private Connection con;
	private String oracleServer = "oracle.fiap.com.br";
	private String databaseName = "orcl";
	private String databaseUser = "RM84810";
	private String databasePass = "170100";
	
	private static Connector instancia = null;
	
	public synchronized static Connector getInstancia() {
		if(instancia == null) {
			try {
				instancia = new Connector();
			} catch (SQLException e) {
				System.out.println("Já existe uma instância!");
				e.printStackTrace();
			}
		}
		
		return instancia;
	}
	
	
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
	
	public Boolean ExecuteUpdate(String query) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar query");
			e.printStackTrace();
			return false;
		}
		
		return true;
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
