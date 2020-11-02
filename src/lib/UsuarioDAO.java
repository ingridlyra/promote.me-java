package lib;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import funcionalidades.Categoria;
import funcionalidades.Usuario;

import java.sql.ResultSet;

/* Essa classe cria um objeto do tipo Usuario a partir da tabela T_PM_USUARIO do banco de dados, além de realizar o CRUD deste objeto.
 * @since 1ª entrega do 2º semestre da challenge 2020
 */

public class UsuarioDAO {
	String table = "T_PM_USUARIO";
	
	/** Método de criar um objeto Usuario (RESEARCH in CRUD) 
	 * 
	 *  @return null or Usuario
	 * 
	 * @throw SQLException
	 * */
	public Usuario getUsuario(int cd_login) {		
		try {
			Connector connector = new Connector();
			ResultSet result = connector.ExecuteQuery("SELECT * FROM " + table + " WHERE cd_login=" + cd_login);

			while (result.next()) {
				Integer login = result.getInt("cd_login");
				Integer cdVaga = result.getInt("cd_vaga");
				Integer senhaUsuario = result.getInt("cd_senha");
				String nomeUsuario = result.getString("nm_usuario");
				String categoriaString = result.getString("ds_categoria");
				LocalDate admissao = result.getDate("dt_admissao_vag").toLocalDate();
				
				connector.Close();
				return new Usuario(login, nomeUsuario, senhaUsuario, cdVaga, Categoria.valueOf(categoriaString), admissao);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/** Método de criar um array de usuarios 
	 * 
	 * @return ArrayList de usuarios
	 * 
	 * @throw SQLException
	 * */
	public ArrayList<Usuario> getAllUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Connector connector = new Connector();
			ResultSet result = connector.ExecuteQuery("SELECT * FROM " + table);

			while (result.next()) {
				Integer login = result.getInt("cd_login");
				Integer cdVaga = result.getInt("cd_vaga");
				Integer senhaUsuario = result.getInt("cd_senha");
				String nomeUsuario = result.getString("nm_usuario");
				String categoriaString = result.getString("ds_categoria");
				LocalDate admissao = result.getDate("dt_admissao_vag").toLocalDate();
				
				usuarios.add(new Usuario(login, nomeUsuario, senhaUsuario, cdVaga, Categoria.valueOf(categoriaString), admissao));
			}
			
			connector.Close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	
	/** Método de criar um Usuario (CREATE in CRUD) 
	 * 
	 * @return void
	 * 
	 * @throw SQLException
	 * */
	public void CreateUsuario(Usuario usuario) {
		String query = "INSERT INTO " + table + " (cd_login, cd_vaga, cd_senha, nm_usuario, ds_categoria, dt_admissao_vag) "
	                   + "VALUES ("
				       + usuario.getLogin()                            + ", "
					   + usuario.getCodigoVaga()                       + ", "
	                   + usuario.getSenhaUsuario()                     + ", "
	                   + "'" + usuario.getNomeUsuario() + "'"          + ", "
	                   + "'" + usuario.getCategoria().toString() + "'" + ", "
	                   + "(TO_DATE('" + usuario.getDtAdmissaoVaga().toString() + "', 'yyyy-mm-dd'))"
	                   + ")";

		try {
			Connector connector = new Connector();
			Boolean success = connector.ExecuteUpdate(query);
			
			if (success) {
				System.out.println("Usuario salvo!");
			} else {
				System.out.println("Algo deu errado");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** Método de atualizar um Usuario (UPDATE in CRUD) 
	 * 
	 * @return Boolean
	 * 
	 * @throw SQLException
	 * */
	public Boolean UpdateUsuario(Usuario newUsuario) {
		String query = "UPDATE " + table + " SET "
				+ "cd_vaga=" + newUsuario.getCodigoVaga()     +  ","
				+ "cd_senha=" + newUsuario.getSenhaUsuario()  +  ","
				+ "nm_usuario='" + newUsuario.getNomeUsuario() + "',"
				+ "dt_admissao_vag=(TO_DATE('" + newUsuario.getDtAdmissaoVaga().toString() + "', 'yyyy-mm-dd'))"
				+ "WHERE cd_login=" + newUsuario.getLogin();

		try {
			Connector connector = new Connector();
			Boolean success = connector.ExecuteUpdate(query);
			
			if (success) {
				System.out.println("Usuario Atualizado!");
				return true;
			} else {
				System.out.println("Algo deu errado");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	public Boolean DeleteUsuario(int login) {
		String query = "DELETE FROM " + table + " WHERE cd_login=" + login;

		try {
			Connector connector = new Connector();
			Boolean success = connector.ExecuteUpdate(query);
			
			if (success) {
				System.out.println("Usuario Deletado!");
				return true;
			} else {
				System.out.println("Algo deu errado");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}