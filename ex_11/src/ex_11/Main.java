package ex_11;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int maiorValor = 0;

		
		
		System.out.println("Qual será o tamanho do Array a ser organizado?");
		int[] original = new int[sc.nextInt()];
		int[] organizado = new int[original.length];
		
		for (int i=0; i<original.length; i++) {
			System.out.printf("Digite o %dº valor: \n", i+1);
			original[i] = sc.nextInt();
			if (original[i] > maiorValor) {
				maiorValor = original[i];
			}
		}
		
		boolean[] organizador = new boolean[maiorValor];
		
		for (int i=0; i<original.length; i++) {
			organizador[original[i] - 1] = true;
		}

		int j = 0;
		for (int i=0; i<organizador.length; i++) {
			if (organizador[i] == true) {
				organizado[j] = i + 1;
				j++;
			}
		}
		
		System.out.println("Array organizado: " + Arrays.toString(organizado));
		sc.close();
	}

}
