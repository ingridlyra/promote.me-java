package br.com.me.promote;

import java.time.LocalDate;

public class Usuario {
	private int login;
	private String nomeUsuario;
	private int senhaUsuario;
	private int codigoVaga;
	private Categoria categoria;
	private LocalDate dtAdmissaoVaga;
	
	public Usuario(int login, String nome, int senha, int codigoVaga, Categoria categoria, LocalDate dtAdmissaoVaga) {
		this.login = login;
		this.nomeUsuario = nome;
		this.senhaUsuario = senha;
		this.codigoVaga = codigoVaga;
		this.categoria = categoria;
		this.dtAdmissaoVaga = dtAdmissaoVaga;
	}
	
	public int getLogin() {
		return login;
	}


	public void setLogin(int login) {
		login = login;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public int getSenhaUsuario() {
		return senhaUsuario;
	}


	public void setSenhaUsuario(int senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public LocalDate getDtAdmissaoVaga() {
		return dtAdmissaoVaga;
	}


	public void setDtAdmissaoVaga(LocalDate dtAdmissaoVaga) {
		this.dtAdmissaoVaga = dtAdmissaoVaga;
	}


	public int getCodigoVaga() {
		return codigoVaga;
	}

	public void setCodigoVaga(int codigoVaga) {
		this.codigoVaga = codigoVaga;
	}
	
	boolean Valido() {
		//TODO: COLOCAR AQUI OS CASOS DE USUARIOS INVALIDOS A PARTIR DO BANCO
		
		return true;	
	}
		
}
