package br.com.me.promote.system;

import java.util.ArrayList;

public class Vaga {
	private String titulo;
	private String descricao;
	private ArrayList<String> requisitos = new ArrayList<String>();
	private double salario;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ArrayList<String> getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(ArrayList<String> requisitos) {
		this.requisitos = requisitos;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	
	//TODO: CRIAR OS METODOS DE VAGA

}
