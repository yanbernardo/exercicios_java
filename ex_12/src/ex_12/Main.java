package ex_12;

import java.util.Locale;
import java.util.Scanner;

/*
Desafio 12: Palavra Mais Longa Dada uma frase, crie um programa em Java que
encontre a palavra mais longa presente nela.
*/

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		String maiorPalavra = "";
		
		System.out.println("Digite uma frase.");
		String[] fraseSeparada = sc.nextLine().split(" ");
		
		for (String palavra : fraseSeparada) {
			if (palavra.length() > maiorPalavra.length()) {
				maiorPalavra = palavra;
			}
		}
		
		System.out.printf("A maior palavra nesta frase é: %s", maiorPalavra);
		
		sc.close();

	}

}
