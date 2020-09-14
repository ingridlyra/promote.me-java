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
				String usuarioEnvio = result.getString("cd_login");
				String usuarioReceptor = result.getString("cd_login_receptor");
				String descricao = result.getString("ds_feedback");
				double nota = result.getDouble("vl_feedback");
				LocalDate dataEnvio = result.getDate("dt_envio").toLocalDate();
					
				connector.Close();
				return new Feedback(usuarioEnvio, usuarioReceptor, descricao, nota, dataEnvio);
		}
				
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	return null;
	}
}