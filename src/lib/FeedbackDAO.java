package lib;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import funcionalidades.Feedback;
import funcionalidades.Usuario;

import java.sql.ResultSet;

/* Essa classe cria um objeto do tipo Feedback a partir da tabela T_PM_FEEDBACK do banco de dados, além de realizar o CRUD deste objeto.
 * @since 1ª entrega do 2º semestre da challenge 2020
 */

public class FeedbackDAO {
	String table = "T_PM_FEEDBACK";
	
	/** Método de criar um objeto Feedback (RESEARCH in CRUD) */
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
	
	/** Método de criar um array de feedbacks */
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
	/** Método de criar um Feedback (CREATE in CRUD) */
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
	
	/** É importante salientar que não há os métodos de update e delete nessa classe, pois a ideia é que, uma vez enviado um feedback, ele
	 * permaneça no banco de dados exatamente como enviado*/
	
	
}