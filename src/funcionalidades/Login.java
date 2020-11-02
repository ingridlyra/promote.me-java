package funcionalidades;

import java.util.InputMismatchException;
import java.util.Scanner;

import lib.UsuarioDAO;

/* Essa classe define os requisitos e o sistema de login.
 * @since 1ª entrega do 2º semestre da challenge 2020
 */

public class Login {
	private int user;
	private int password;
	private Usuario usuario;
	private boolean valido = false;
	
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
}
