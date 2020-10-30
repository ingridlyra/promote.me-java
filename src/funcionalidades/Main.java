package funcionalidades;

import java.time.LocalDate;
import java.util.Scanner;

import lib.FeedbackDAO;
import lib.UsuarioDAO;

/* Essa classe é a classe principal do sistema, sendo responsável pela conexão direta com o usuário e por chamar todas as funções do sistema.
 * @since 1ª entrega do 2º semestre da challenge 2020
 */

public class Main {	
	public static void main(String[] args) {
		UsuarioDAO userDAO = new UsuarioDAO();
		FeedbackDAO feedbackDAO = new FeedbackDAO();
	
		System.out.println("*** \nBem-vindx ao Promote.me \n ***");
		
		boolean isRunning = true;
		int opcao;
		Scanner sc1 = new Scanner(System.in);
		
		/** A partir daqui, há um menu de opções para o usuário.
		 * As opções para o usuário serão relacionadas ao próprio perfil(opção 1) ou a feedbacks(opção 2):
		 * dentro da opção 1, o usuário poderá visualizar as informações do seu perfil ou alterar a senha(visto que a ideia é que novos usuários
		 * sejam cadastrados diretamente no banco de dados).
		 * Na opção 2, o usuário poderá escolher visualizar os feedbacks que ele recebeu, ou enviar um feedback para alguém da sua equipe   */
		
		Login sessao = new Login(sc1);
		while(!sessao.isValido()) {
			sessao.logar();			
		}
		
		System.out.println("Bem-vindo, " + sessao.getUsuario().getNomeUsuario() + "!");
		
		while(isRunning) {
			System.out.println("Digite o número da opção que você deseja: \n 1- Perfil \n 2- Feedback \n");
			opcao = sc1.nextInt();
			
			
			if(opcao == 1) {
				int uOpc;
				System.out.println("Digite o número da opção que você deseja: \n 1- Visualizar seu perfil \n 2- Alterar senha \n");
				uOpc = sc1.nextInt();
				
				
				if(uOpc == 1) {
					System.out.println("Nome: " + sessao.getUsuario().getNomeUsuario());
					System.out.println("Login: " + sessao.getUsuario().getLogin());
					System.out.println("Cargo: " + sessao.getUsuario().getCodigoVaga());
					System.out.println("Data de admissão: " + sessao.getUsuario().getDtAdmissaoVaga());
					
				} else if (uOpc == 2) {
					System.out.print("Digite uma nova senha (deve conter 4 dígitos e ser formada apenas por números) \n");
					int newSenha = sc1.nextInt();
					sessao.getUsuario().setSenhaUsuario(newSenha);
					userDAO.UpdateUsuario(sessao.getUsuario());
					
				}  else {
					System.err.print("Não há essa opção no sistema, tente novamente \n");
				}
				
				
			} else if (opcao == 2) {
				int uOpc;
				System.out.print("Digite o número da opção que você deseja: \n 1- Visualizar feedbacks recebidos \n 2- Enviar feedback \n ");
				uOpc = sc1.nextInt();
				
				
				if(uOpc == 1) {
					feedbackDAO.getFeedbacks(sessao.getUsuario().getLogin()).forEach(feedback -> {
						Usuario enviador = userDAO.getUsuario(feedback.getUsuarioEnvio());
						System.out.println("Enviado por: " + enviador.getNomeUsuario());
						System.out.println("Nota: " + feedback.getNota());
						System.out.println("Mensagem: " + feedback.getMensagem() + "\n");
					});
				} else if (uOpc == 2) {
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
					
					
					Feedback newFeedback = new Feedback(sessao.getUsuario().getLogin(), usuarioReceptor, mensagem, nota, LocalDate.now());
				
					feedbackDAO.CreateFeedback(newFeedback);
				} else {
					System.err.print("Não há essa opção no sistema, tente novamente \n");
				}
				
				
			} else {
				System.err.print("Não há essa opção no sistema, tente novamente");
			}
		}
		
		sc1.close();
		 
		

	}

}
