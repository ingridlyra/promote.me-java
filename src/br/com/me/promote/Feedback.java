package br.com.me.promote;

import java.time.LocalDate;

public class Feedback {
	String usuarioEnvio;
	String usuarioReceptor;
	String mensagem;
	double nota;
	LocalDate dataEnvio;
	
	public String getUsuarioEnvio() {
		return usuarioEnvio;
	}

	public void setUsuarioEnvio(String usuarioEnvio) {
		this.usuarioEnvio = usuarioEnvio;
	}

	public String getUsuarioReceptor() {
		return usuarioReceptor;
	}

	public void setUsuarioReceptor(String usuarioReceptor) {
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

	public Feedback(String usuarioEnvio, String usuarioReceptor, String mensagem, double nota, LocalDate dataEnvio) {
		this.usuarioEnvio = usuarioEnvio;
		this.mensagem = mensagem;
		this.nota = nota;
		this.dataEnvio = dataEnvio;
	}
	
	//TODO: aqui ficará os dados de feedback e o sistema que mostrará se foi enviado ou não, 
	//assim como de notificar caso não tenha sido enviado

}
