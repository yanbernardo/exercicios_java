package ex_10;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int max, min;
		
		System.out.println("Quanto n�meros ter� no Array?");
		
		int[] numeros = new int[sc.nextInt()];
		
		for (int i=0; i<=numeros.length-1; i++) {
			System.out.printf("Digite o %d� n�mero: ", i+1);
			numeros[i] = sc.nextInt();
		}
		Arrays.sort(numeros);
		min = 0;
		max = numeros.length-1;
		int teste;
		
		System.out.println("Qual n�mero voc� quer procurar neste array? ");
		int pesquisar = sc.nextInt();
		
		while (true) {
			teste = (max + min)/2;
			
			if (numeros[teste] == pesquisar) {
				System.out.printf("N�mero %d encontrado na posi��o %d", pesquisar, teste);
				break;
			}
			if (max == min+1) {
				System.out.println("N�mero n�o encontrado!");
				break;
			}
			if (numeros[teste] > pesquisar) {
				max = teste;
			} 
			if (numeros[teste] < pesquisar){
				min = teste;
			}

			
			System.out.println("Encontrei " +numeros[teste]+ " na posi��o " + teste);
			System.out.printf("Valor M�ximo: %d\nValor M�nimo: %d\n\n", max, min);
		}
		
		
		
		sc.close();
	}

}