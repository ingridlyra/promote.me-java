package br.com.me.promote;

import java.time.LocalDate;
import java.util.Scanner;

import DAO.UsuarioDAO;

public class Main {
	
	public static void test() {
		UsuarioDAO userDAO = new UsuarioDAO();
		
		Usuario us = new Usuario(3, "carlito", 1234, 10, Categoria.colaborador, LocalDate.now());
		
		userDAO.CreateUsuario(us);
		
		us.setNomeUsuario("jose");
		userDAO.UpdateUsuario(us);
		
		Usuario a = userDAO.getUsuario(3);
		
		System.out.println(a.getNomeUsuario());
		
		userDAO.DeleteUsuario(3);

		Usuario b = userDAO.getUsuario(3);
		
		if (b == null) {
			System.out.println("deletado");
		}
	}

	public static void main(String[] args) {
		Logar acesso;
		Feedback feedback;
		Usuario usuario;
		
		System.out.println("*** Bem-vindx ao Promote.me \n ***");
		//TODO: CHAMAR AS CLASSES PRINCIPAIS
		
		boolean isRunning = true;
		int opcao;
		Scanner sc1 = new Scanner(System.in);
		
		while(isRunning) {
			System.out.print("Digite o número da opção que você deseja: \n 1- Perfil \n 2- Feedback \n");
			opcao = sc1.nextInt();
			
			
			if(opcao == 1) {
				int uOpc;
				System.out.print("Digite o número da opção que você deseja: \n 1- Visualizar seu perfil \n 2- Adicionar/remover skills \n 3 - Alterar senha \n");
				uOpc = sc1.nextInt();
				
				
				if(uOpc == 1) {
					//exibir o perfil
				} else if (uOpc == 2) {
					//Perguntar onde deseja add ou remover skills
				} else if (uOpc == 3) {
					//Alterar senha do usuário
				} else {
					System.err.print("Não há essa opção no sistema, tente novamente");
				}
				
				
			} else if (opcao == 2) {
				int uOpc;
				System.out.print("Digite o número da opção que você deseja: \n 1- Visualizar feedbacks recebidos \n 2- Enviar feedback \n ");
				uOpc = sc1.nextInt();
				
				
				if(uOpc == 1) {
					//Visualizar feedbacks recebidos
				} else if (uOpc == 2) {
					//Enviar um feedback
				} else {
					System.err.print("Não há essa opção no sistema, tente novamente");
				}
				
				
			} else {
				System.err.print("Não há essa opção no sistema, tente novamente");
			}
		}
		
		sc1.close();
		 
		

	}

}
