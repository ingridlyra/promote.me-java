package br.com.me.promote;

import java.util.Scanner;

public class Logar {
	Scanner sc = new Scanner(System.in);
	private String user;
	private String password;
	private Usuario usuario;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	boolean logar() {
		System.out.println("Digite seu usuário: \n");
		setUser(sc.next());
	
		System.out.println("Digite sua senha: \n");
		setPassword(sc.next());
		
		if(usuario.Valido());
		
		//TODO: VALIDACAO DE USUARIO E SENHA
		return true;
		}
}
