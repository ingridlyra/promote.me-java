package lib;

import java.sql.SQLException;

import funcionalidades.Vaga;

import java.sql.ResultSet;

/* Essa classe cria um objeto do tipo Vaga a partir da tabela T_PM_VAGA do banco de dados, além de realizar o CRUD deste objeto.
 * @since 1ª entrega do 2º semestre da challenge 2020
 */
public class VagaDAO {
String table = "T_PM_VAGA";

	/** Método de criar um objeto Vaga (RESEARCH in CRUD)  
	 *  
	 * @return null
	 * 
	 * @throw SQLException
	 * */	
	public Vaga getVaga(int cd_vaga) {		
		try {
			Connector connector = new Connector();
			ResultSet result = connector.ExecuteQuery("SELECT * FROM " + table + " WHERE cd_vaga=" + cd_vaga);

			while (result.next()) {
				Integer cdVaga = result.getInt("cd_vaga");
				String titulo = result.getString("nm_vaga");
				Integer cd_carreira = result.getInt("cd_carreira");
				
				connector.Close();
				return new Vaga(cdVaga, titulo, cd_carreira);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/** Método de criar uma vaga (CREATE in CRUD) 
	 * 
	 * @return void
	 * 
	 * @throw SQLException
	 * */
	public void CreateUsuario(Vaga vaga) {
		String query = "INSERT INTO " + table + " (cd_vaga, nm_vaga, cd_carreira ) "
	                   + "VALUES ("
				       + vaga.getCdVaga()                            + ", "
	                   + vaga.getCarreira()                    + ", "
	                   + "'" + vaga.getTitulo() + "'"          + ", "
	                   + ")";

		try {
			Connector connector = new Connector();
			Boolean success = connector.ExecuteUpdate(query);
			
			if (success) {
				System.out.println("Vaga salva!");
			} else {
				System.out.println("Algo deu errado");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/** Método de atualizar uma vaga (UPDATE in CRUD) 
	 * 
	 * @return Boolean
	 * 
	 * @throw SQLException
	 * */
	public Boolean UpdateVaga(Vaga newVaga) {
		String query = "UPDATE " + table + " SET "
				+ "cd_vaga=" + newVaga.getCdVaga()     +  ","
				+ "cd_carreira=" + newVaga.getCarreira()  +  ","
				+ "nm_vaga='" + newVaga.getTitulo() + "',"
				+ "WHERE cd_vaga=" + newVaga.getCdVaga();

		try {
			Connector connector = new Connector();
			Boolean success = connector.ExecuteUpdate(query);
			
			if (success) {
				System.out.println("Vaga Atualizada!");
				return true;
			} else {
				System.out.println("Algo deu errado");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	/** Método de excluir uma vaga (DELETE in CRUD) 
	 *   
	 * @return Boolean
	 * 
	 * @throw SQLException
	 * */
	public Boolean DeleteVaga(int vaga) {
		String query = "DELETE FROM " + table + " WHERE cd_vaga=" + vaga;

		try {
			Connector connector = new Connector();
			Boolean success = connector.ExecuteUpdate(query);
			
			if (success) {
				System.out.println("Vaga Deletada!");
				return true;
			} else {
				System.out.println("Algo deu errado");
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}