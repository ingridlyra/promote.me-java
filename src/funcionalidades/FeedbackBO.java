package funcionalidades;

import java.time.LocalDate;
import java.util.Scanner;

import lib.FeedbackDAO;
import lib.UsuarioDAO;

public class FeedbackBO {
	
	FeedbackDAO feedbackDAO = new FeedbackDAO();
	UsuarioDAO userDAO = new UsuarioDAO();

	void VerFeedback(Usuario user) {	
		feedbackDAO.getFeedbacks(user.getLogin()).forEach(feedback -> {
			Usuario enviador = userDAO.getUsuario(feedback.getUsuarioEnvio());
			System.out.println("Enviado por: " + enviador.getNomeUsuario());
			System.out.println("Nota: " + feedback.getNota());
			System.out.println("Mensagem: " + feedback.getMensagem() + "\n");
		});
	}
	
	void enviarFeedback(Usuario user, Scanner sc1) {
		int usuarioReceptor;
		double nota;
		String mensagem;
		
		userDAO.getAllUsuarios().forEach(usuario -> {
			System.out.println(usuario.getNomeUsuario() + " " + usuario.getLogin());
		});
		
		System.out.println("Para qual usuário deseja enviar um feedback?");
		usuarioReceptor = sc1.nextInt();
		
		System.out.println("Digite o seu feedback para " + usuarioReceptor);
		sc1.nextLine();
		String[] parts = sc1.nextLine().split("\\s+");
		mensagem = String.join(" ",  parts);
		
		System.out.println("Digite aqui a sua nota");
		nota = sc1.nextDouble();
		
		
		Feedback newFeedback = new Feedback(user.getLogin(), usuarioReceptor, mensagem, nota, LocalDate.now());
	
		feedbackDAO.CreateFeedback(newFeedback);
		
	}
	
}
