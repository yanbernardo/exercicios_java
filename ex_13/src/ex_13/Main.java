package ex_13;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int[][] matriz1 = new int[2][2];
		int[][] matriz2 = new int[2][2];
		int[][] matriz3 = new int[2][2];
		
		System.out.println("-=-=-=-=-=-=-=-=-=-=-= Definindo a primeira Matriz -=-=-=-=-=-=-=-=-=-=-=");
		
		for (int i=0 ; i<matriz1.length; i++) {
			for (int j=0; j<matriz1[i].length; j++) {
				System.out.printf("\nDigite o %dº valor da %dª linha: ", j+1, i+1);
				matriz1[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("-=-=-=-=-=-=-=-=-=-=-= Definindo a segunda Matriz -=-=-=-=-=-=-=-=-=-=-=");
		
		for (int i=0 ; i<matriz2.length; i++) {
			for (int j=0; j<matriz2[i].length; j++) {
				System.out.printf("\nDigite o %dº valor da %dª linha: ", j+1, i+1);
				matriz2[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("-=-=-=-=-=-=-=-=-=-=-= Matrizes -=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("Matriz 1:");
		
		for (int i=0; i<matriz1.length; i++) {
			System.out.println(Arrays.toString(matriz1[i]));
		}
		
		System.out.println("Matriz 2:");
		
		for (int i=0; i<matriz2.length; i++) {
			System.out.println(Arrays.toString(matriz2[i]));
		}
		
		System.out.println("-=-=-=-=-=-=-=-=-=-=-= Somando Matrizes... -=-=-=-=-=-=-=-=-=-=-=");
		
		for (int i=0 ; i<matriz3.length; i++) {
			for (int j=0; j<matriz3[i].length; j++) {
				matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
			}
		}
		
		System.out.println("Matrizes somadas: ");
		for (int i=0; i<matriz3.length; i++) {
			System.out.println(Arrays.toString(matriz3[i]));
		}

		sc.close();

	}

}
