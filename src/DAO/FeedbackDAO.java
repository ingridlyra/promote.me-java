package DAO;

import java.sql.SQLException;

import java.sql.ResultSet;
import Utils.Connector;
import br.com.me.promote.Feedback;

public class FeedbackDAO {	
public Feedback getFeedback() {		
	try {
		Connector connector = new Connector();
		ResultSet result = connector.ExecuteQuery("SELECT * FROM T_PM_FEEDBACK WHERE cd_feedback=" + cd_feedback);
				
		while (result.next()) {
			Integer login = result.getInt("cd_login");
			Integer senhaUsuario = result.getInt("cd_senha");
			String nomeUsuario = result.getString("nm_usuario");
					
			connector.Close();
			return new Usuario(login, nomeUsuario, senhaUsuario);
		}
				
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	return null;
	}
