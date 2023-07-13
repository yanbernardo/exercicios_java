package ex_15;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> letras = new HashMap<>();
		
		System.out.println("Digite uma frase: ");
		String[] frArr = sc.nextLine().toUpperCase().split(" ");
		
		for (int i=0; i<frArr.length; i++) {
			if (letras.containsKey(frArr[i])) {
				letras.put(frArr[i], letras.get(frArr[i])+1);
			} else {
				letras.put(frArr[i], 1);
			}
		}
		
		for (String letra : letras.keySet()) {
			Integer quantidade = letras.get(letra);
			System.out.println(letra + " aparece " + quantidade + " vez(es).");
		}
			
		sc.close();
	}

}
