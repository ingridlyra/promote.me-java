package DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import Utils.Connector;
import br.com.me.promote.Categoria;
import br.com.me.promote.Usuario;

public class UsuarioDAO {
	String table = "T_PM_USUARIO";
	
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
}