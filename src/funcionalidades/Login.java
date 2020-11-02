package funcionalidades;

import java.util.InputMismatchException;
import java.util.Scanner;

import lib.UsuarioDAO;

/* Essa classe define os requisitos e o sistema de login.
 * @since 1ª entrega do 2º semestre da challenge 2020
 */

public class Login {
	Scanner sc;
	private int user;
	private int password;
	private Usuario usuario;
	private boolean valido = false;
	
	public Login(Scanner sc) {
		this.sc = sc;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	/** Método de pedir os dados de login ao usuário e validar para logar */
	public void logar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		try {	
			System.out.println("Digite seu usuário: \n");
			setUser(Integer.parseInt(sc.nextLine()));
		
			System.out.println("Digite sua senha: \n");
			setPassword(Integer.parseInt(sc.nextLine()));
			
			Usuario u = usuarioDAO.getUsuario(this.getUser());
			
			if (u != null && (u.getSenhaUsuario() == this.getPassword())) {
				this.setValido(true);
				this.usuario = u;
			} else {
				System.err.println("Credenciais invalidas");
			}
		} catch (NumberFormatException e) {
			System.err.println("Dados de login devem ser do tipo inteiro");
		}
	}
}
