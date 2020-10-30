package DAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.ResultSet;

import br.com.me.promote.Feedback;
import br.com.me.promote.Usuario;
import lib.Connector;

public class FeedbackDAO {
	String table = "T_PM_FEEDBACK";
	
	public Feedback getFeedback(int cd_feedback) {	
		try {
			Connector connector = new Connector();
			ResultSet result = connector.ExecuteQuery("SELECT * FROM " + table + " WHERE cd_feedback=" + cd_feedback);
				
			while (result.next()) {
				int usuarioEnvio = result.getInt("cd_login");
				int usuarioReceptor = result.getInt("cd_login_receptor");
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
	
	public ArrayList<Feedback> getFeedbacks(int login) {	
		ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
		
		try {
			Connector connector = new Connector();
			ResultSet result = connector.ExecuteQuery("SELECT * FROM " + table + " WHERE cd_login_receptor=" + login);
				
			while (result.next()) {
				int usuarioEnvio = result.getInt("cd_login");
				int usuarioReceptor = result.getInt("cd_login_receptor");
				String descricao = result.getString("ds_feedback");
				double nota = result.getDouble("vl_feedback");
				LocalDate dataEnvio = result.getDate("dt_envio").toLocalDate();

				feedbacks.add(new Feedback(usuarioEnvio, usuarioReceptor, descricao, nota, dataEnvio));
			}	

			connector.Close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return feedbacks;
	}
	
	public void CreateFeedback(Feedback feedback) {
		String query = "INSERT INTO " + table + " (cd_login, vl_feedback, ds_feedback, dt_envio, cd_login_receptor) "
	                   + "VALUES ("
				       + feedback.getUsuarioEnvio()                        + ", "
					   + feedback.getNota()                                + ", "
	                   + "'" + feedback.getMensagem() + "'"                + ", "
	                   + "(TO_DATE('" + feedback.getDataEnvio().toString() + "', 'yyyy-mm-dd')), "
	    			   + feedback.getUsuarioReceptor()
	                   + ")";

		try {
			Connector connector = new Connector();
			Boolean success = connector.ExecuteUpdate(query);
			
			if (success) {
				System.out.println("Feedback salvo!");
			} else {
				System.out.println("Algo deu errado");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}