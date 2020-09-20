package br.com.me.promote;

import java.util.Scanner;

import DAO.UsuarioDAO;

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
	
	public void logar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		System.out.println("Digite seu usuário: \n");
		setUser(sc.nextInt());
	
		System.out.println("Digite sua senha: \n");
		setPassword(sc.nextInt());
		
		Usuario u = usuarioDAO.getUsuario(this.getUser());
		
		if (u != null && (u.getSenhaUsuario() == this.getPassword())) {
			this.setValido(true);
			this.usuario = u;
		} else {
			System.err.println("Credencias invalidas");
		}
	}
}
