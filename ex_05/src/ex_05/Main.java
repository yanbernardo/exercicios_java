package ex_05;

import java.util.Locale;
import java.util.Scanner;

public class Main {

	
	/* Desafio 5: Verificar Palíndromo Crie um programa em Java que verifique se uma
palavra é um palíndromo. Um palíndromo é uma palavra que é lida da mesma forma
tanto da esquerda para a direita como da direita para a esquerda
*/
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String reverso = "", palavra;
		
		System.out.println("Digite uma palavra para testar se é um palíndromo: ");
		palavra = sc.nextLine();
		
		for (int i= palavra.length() - 1; i >= 0; i--) {
			reverso += palavra.charAt(i);
		}
		
		System.out.printf("Palavra invertida: %s\n", reverso.toUpperCase());
		
		if (palavra.toUpperCase().equals(reverso.toUpperCase())) {
			System.out.printf("%s é um palíndromo", palavra);
		} else {
			System.out.printf("%s NÃO é um palíndromo", palavra);
		}
		
		
		sc.close();
	}

}