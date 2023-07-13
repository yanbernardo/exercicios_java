package ex_10;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int max, min;
		
		System.out.println("Quanto números terá no Array?");
		
		int[] numeros = new int[sc.nextInt()];
		
		for (int i=0; i<=numeros.length-1; i++) {
			System.out.printf("Digite o %dº número: ", i+1);
			numeros[i] = sc.nextInt();
		}
		Arrays.sort(numeros);
		min = 0;
		max = numeros.length-1;
		int teste;
		
		System.out.println("Qual número você quer procurar neste array? ");
		int pesquisar = sc.nextInt();
		
		while (true) {
			teste = (max + min)/2;
			
			if (numeros[teste] == pesquisar) {
				System.out.printf("Número %d encontrado na posição %d", pesquisar, teste);
				break;
			}
			if (max == min+1) {
				System.out.println("Número não encontrado!");
				break;
			}
			if (numeros[teste] > pesquisar) {
				max = teste;
			} 
			if (numeros[teste] < pesquisar){
				min = teste;
			}

			
			System.out.println("Encontrei " +numeros[teste]+ " na posição " + teste);
			System.out.printf("Valor Máximo: %d\nValor Mínimo: %d\n\n", max, min);
		}
		
		
		
		sc.close();
	}

}
