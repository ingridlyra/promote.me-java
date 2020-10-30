package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/* Essa classe é a classe de conexão com o banco de dados e ela só pode ser instanciada uma única vez (Singleton)
 * @author Ingrid Lyra
 * @since 1ª entrega do 2º semestre da challenge 2020
 */

public class Connector {
	private Connection con;
	private String oracleServer = "oracle.fiap.com.br";
	private String databaseName = "orcl";
	private String databaseUser = "RM84810";
	private String databasePass = "170100";
	
	private static Connector instancia = null;
	
	/** Método de controle de instâncias
	 * @return instancia - uma instância, nula ou do objeto connector, que é a conexão com banco */
	
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
	
	/** Método de acesso ao banco*/	
	public Connector() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.con = DriverManager.getConnection("jdbc:oracle:thin:@" + oracleServer + ":1521:" + databaseName,  databaseUser, databasePass);
		} catch (ClassNotFoundException e) {
			System.out.println("Oracle Driver Class not found");
			e.printStackTrace();
		}		
	}
	/** Método de execução de querys
	 * @return null*/	
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
	
	/** Método para executar um update do banco através do código
	 * @return Boolean - se foi realizado o update ou não, se não houver nenhum erro, retorna true */
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
	
	/** Método de controle de fechamento da conexão com o banco*/
	public void Close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
