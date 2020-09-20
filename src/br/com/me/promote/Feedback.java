package br.com.me.promote;

import java.time.LocalDate;

public class Feedback {
	int usuarioEnvio;
	int usuarioReceptor;
	String mensagem;
	double nota;
	LocalDate dataEnvio;
	
	public int getUsuarioEnvio() {
		return usuarioEnvio;
	}

	public void setUsuarioEnvio(int usuarioEnvio) {
		this.usuarioEnvio = usuarioEnvio;
	}

	public int getUsuarioReceptor() {
		return usuarioReceptor;
	}

	public void setUsuarioReceptor(int usuarioReceptor) {
		this.usuarioReceptor = usuarioReceptor;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Feedback(int usuarioEnvio, int usuarioReceptor, String mensagem, double nota, LocalDate dataEnvio) {
		this.usuarioEnvio = usuarioEnvio;
		this.usuarioReceptor = usuarioReceptor;
		this.mensagem = mensagem;
		this.nota = nota;
		this.dataEnvio = dataEnvio;
	}
	
	//TODO: aqui ficará os dados de feedback e o sistema que mostrará se foi enviado ou não, 
	//assim como de notificar caso não tenha sido enviado

}
