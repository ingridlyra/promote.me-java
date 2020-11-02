package funcionalidades;

import java.util.Scanner;

import lib.UsuarioDAO;

public class UsuarioBO {

	public void logar(Login login, Scanner sc) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		try {	
			System.out.println("Digite seu usuário: \n");
			login.setUser(Integer.parseInt(sc.nextLine()));
		
			System.out.println("Digite sua senha: \n");
			login.setPassword(Integer.parseInt(sc.nextLine()));
			
			Usuario u = usuarioDAO.getUsuario(login.getUser());
			
			if (u != null && (u.getSenhaUsuario() == login.getPassword())) {
				login.setValido(true);
				login.setUsuario(u);
			} else {
				System.err.println("Credenciais invalidas");
			}
		} catch (NumberFormatException e) {
			System.err.println("Dados de login devem ser do tipo inteiro");
		} 
	}
	
}
