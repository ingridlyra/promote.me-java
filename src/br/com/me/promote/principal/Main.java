package br.com.me.promote.principal;

import br.com.me.promote.system.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Logar acesso;
		Crescimento crescimento;
		Feedback feedback;
		Usuario usuario;
		
		
		
		System.out.println("*** Bem-vindx ao Promote.me \n ***");
		//TODO: CHAMAR AS CLASSES PRINCIPAIS
		
		boolean isRunning = true;
		int opcao;
		Scanner sc1 = new Scanner(System.in);
		
		while(isRunning) {
			System.out.print("Digite o número da opção que você deseja: \n 1- Perfil \n 2- Feedback \n 3 - Carreira\n");
			opcao = sc1.nextInt();
			
			
			if(opcao == 1) {
				int uOpc;
				System.out.print("Digite o número da opção que você deseja: \n 1- Visualizar seu perfil \n 2- Adicionar/remover skills \n 3 - Alterar senha \n");
				uOpc = sc1.nextInt();
				
				
				if(uOpc == 1) {
					//exibir o perfil
				} else if (uOpc == 2) {
					//Perguntar onde deseja add ou remover
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
					//exibir o perfil
				} else if (uOpc == 2) {
					//Perguntar onde deseja add ou remover
				} else if (uOpc == 3) {
					//Alterar senha do usuário
				} else {
					System.err.print("Não há essa opção no sistema, tente novamente");
				}
				
				
			} else if (opcao == 3) {
				//chamar aqui crescimento
			} else {
				System.err.print("Não há essa opção no sistema, tente novamente");
			}
		}
		
		sc1.close();
		 
		

	}

}
