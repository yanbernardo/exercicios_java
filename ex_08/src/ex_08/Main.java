package ex_08;

import java.util.Locale;
import java.util.Scanner;

public class Main {

		/*Desafio 8: Palavra Invertida Crie um programa em Java que inverta uma palavra.*/
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String reverso = "", palavra;
		
		System.out.println("Digite uma palavra para inverte-la: ");
		palavra = sc.nextLine();
		
		for (int i= palavra.length() - 1; i >= 0; i--) {
			reverso += palavra.charAt(i);
		}
		
		System.out.printf("Palavra invertida: %s\n", reverso.toUpperCase());
		
	}

}