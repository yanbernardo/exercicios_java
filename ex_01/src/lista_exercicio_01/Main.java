
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Integer sum = 0;
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Quantidade de elementos no Array: ");
		int n = sc.nextInt();
		
		int[] array = new int[n];
		
		for (int i=0; i < array.length; i++) {
			System.out.printf("Digite o %dº valor: %n", i+1);
			array[i] = sc.nextInt();
		}
		
		System.out.println();
		System.out.println(Arrays.toString(array));
		
		for (int i=0; i<array.length; i++) {
			sum += array[i];
		}
		System.out.printf("Soma: %d", sum);
		
		
		sc.close();
	}

}
