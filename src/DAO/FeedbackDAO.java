package DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import Utils.Connector;
import br.com.me.promote.Feedback;

public class FeedbackDAO {	
	public Feedback getFeedback(int cd_feedback) {		
		try {
			Connector connector = new Connector();
			ResultSet result = connector.ExecuteQuery("SELECT * FROM T_PM_FEEDBACK WHERE cd_feedback=" + cd_feedback);
				
			while (result.next()) {
				String usuarioEnvio = result.getString("usuarioEnvio");
				String mensagem = result.getString("ds_feedback");
				String nomeUsuario = result.getString("nm_usuario");
				double nota = result.getDouble("vl_feedback");
				LocalDate dataEnvio = result.getDate("vl_feedback").toLocalDate();
					
				connector.Close();
				return new Feedback(usuarioEnvio, mensagem, nota, dataEnvio);
		}
				
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	return null;
	}
}