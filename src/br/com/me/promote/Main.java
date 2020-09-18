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
		System.out.println("*** Bem-vindx ao Promote.me \n ***");
		
		boolean isRunning = true;
		int opcao;
		Scanner sc1 = new Scanner(System.in);
		
		Usuario currentUser = new Usuario(1, null, 1, 1, null, null);
		
		while(isRunning) {
			System.out.print("Digite o número da opção que você deseja: \n 1- Perfil \n 2- Feedback \n");
			opcao = sc1.nextInt();
			
			
			if(opcao == 1) {
				int uOpc;
				System.out.print("Digite o número da opção que você deseja: \n 1- Visualizar seu perfil \n 2- Alterar senha \n");
				uOpc = sc1.nextInt();
				
				
				if(uOpc == 1) {
					System.out.print(currentUser.getNomeUsuario());
					System.out.print(currentUser.getLogin());
					System.out.print(currentUser.getCodigoVaga());
					System.out.print(currentUser.getDtAdmissaoVaga());
					
				} else if (uOpc == 2) {
					System.out.print("Digite uma nova senha (deve conter 4 dígitos e ser formada apenas por números) \n");
					int newSenha = sc1.nextInt();
					currentUser.setSenhaUsuario(newSenha);
					
				}  else {
					System.err.print("Não há essa opção no sistema, tente novamente \n");
				}
				
				
			} else if (opcao == 2) {
				int uOpc;
				System.out.print("Digite o número da opção que você deseja: \n 1- Visualizar feedbacks recebidos \n 2- Enviar feedback \n ");
				uOpc = sc1.nextInt();
				
				
				if(uOpc == 1) {
					//Visualizar feedbacks recebidos
				} else if (uOpc == 2) {
					System.out.print("Digite o seu feedback para " // TODO: SUBSTITUIR AQUI C O USUARIO DE DESTINO
							);
					System.out.print("Digite aqui a sua nota \n");
						//TODO:COLOCAR AQUI P ATRIBUIR AO USUARIO DE DESTINO
				} else {
					System.err.print("Não há essa opção no sistema, tente novamente \n");
				}
				
				
			} else {
				System.err.print("Não há essa opção no sistema, tente novamente");
			}
		}
		
		sc1.close();
		 
		

	}

}
