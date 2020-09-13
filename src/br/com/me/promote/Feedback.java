package br.com.me.promote;

import java.time.LocalDate;

public class Feedback {
	String usuarioEnvio;
	String mensagem;
	double nota;
	LocalDate dataEnvio;
	
	public Feedback(String usuarioEnvio, String mensagem, double nota, LocalDate dataEnvio) {
		this.usuarioEnvio = usuarioEnvio;
		this.mensagem = mensagem;
		this.nota = nota;
		this.dataEnvio = dataEnvio;
	}
	
	//TODO: aqui ficará os dados de feedback e o sistema que mostrará se foi enviado ou não, 
	//assim como de notificar caso não tenha sido enviado

}
