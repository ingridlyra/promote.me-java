package funcionalidades;

import lib.UsuarioDAO;

public class PerfilBO {

	void verPerfil(Usuario user) {
		System.out.println("Nome: " + user.getNomeUsuario());
		System.out.println("Login: " + user.getLogin());
		System.out.println("Cargo: " + user.getCodigoVaga());
		System.out.println("Data de admissão: " + user.getDtAdmissaoVaga());
	}
	
	void updateSenha(Usuario user, int newSenha) {
		UsuarioDAO userDAO = new UsuarioDAO();
		
		user.setSenhaUsuario(newSenha);
		userDAO.UpdateUsuario(user);	
	}
}
