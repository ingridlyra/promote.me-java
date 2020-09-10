package br.com.me.promote.principal;

public class Usuario {
	private String usuario;
	private String senha;
	private Categoria categoria;
	
	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	boolean Valido() {
		//TODO: COLOCAR AQUI OS CASOS DE USUARIOS INVALIDOS
		
		return true;	
	}
		
}
