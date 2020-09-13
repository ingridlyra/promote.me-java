package DAO;

import java.sql.SQLException;

import java.sql.ResultSet;
import Utils.Connector;
import br.com.me.promote.Usuario;

public class UsuarioDAO {
	public Usuario getUsuario(int cd_login) {		
		try {
			Connector connector = new Connector();
			ResultSet result = connector.ExecuteQuery("SELECT * FROM T_PM_USUARIO WHERE cd_login=" + cd_login);
			
			while (result.next()) {
				Integer login = result.getInt("cd_login");
				Integer senhaUsuario = result.getInt("cd_senha");
				String nomeUsuario = result.getString("nm_usuario");
				
				connector.Close();
				return new Usuario(login, nomeUsuario, senhaUsuario);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}