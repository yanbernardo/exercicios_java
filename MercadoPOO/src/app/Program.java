package app;


import java.util.Locale;
import java.util.Scanner;

import entities.Carrinho;
import entities.Estoque;
import entities.Pagamento;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		Carrinho carrinho = new Carrinho();
		Integer id;
		
		Estoque estoque = new Estoque();
		estoque.novoProduto("Arroz", 23.99, 10);
		estoque.novoProduto("Feij�o", 8.99, 10);
		estoque.novoProduto("A�ucar", 14.99, 10);
		estoque.novoProduto("Vinho", 99.99, 10);
		estoque.novoProduto("Cereal", 9.99, 10);
		estoque.novoProduto("Miojo", 1.99, 10);
		estoque.novoProduto("Sab�o", 2.99, 10);
		estoque.novoProduto("Leite", 4.57, 10);
		estoque.novoProduto("Oleo", 5.99, 10);
		estoque.novoProduto("Azeite", 12.99, 10);
		
		
		while (true) {
			System.out.println(estoque.listarEstoque(true));
			while (true) {
				System.out.println("Digite o ID do produto desejado: ");
				id = sc.nextInt();
				if (estoque.getProduto(id) == null) {
					System.out.println("ID Fora do Range! Tente novamente...");
				} else {
					break;
				}
			}
			System.out.println("Digite a quantidade: ");
			Integer qnt = sc.nextInt();
			sc.nextLine();
			
			if (estoque.retirarProduto(estoque.getProduto(id), qnt)) { //Fun��o verifica se tem a quantidade solicitada em estoque e retira a mesma (retorna true ou false se conseguir ou n�o)
				carrinho.addProdCarrinho(estoque.getProduto(id), qnt);
			} else {
				System.out.println("Desculpe! N�o temos essa quantidade em estoque.");
			}
			
			
			System.out.println("Deseja continuar?:");
			System.out.println("[S] Sim\n[N] N�o");
			
			if (sc.nextLine().toLowerCase().charAt(0) == 'n') {
				break;
			} else {
				System.out.println("Repetindo...");
				continue;
			}
		}
		System.out.println(estoque.listarEstoque(true));
		System.out.println(carrinho.listarCarrinho(true));
		
		System.out.println("Op��es de Pagamento:");
		System.out.println("    [1]� vista (dinheiro, pix ou cast�o Mastercard) tem 20% de desconto.");
		System.out.println("    [2]� vista no cr�dito tem 10% de desconto.");
		System.out.println("    [3]Parcelado em at� 3x sem desconto;");
		System.out.println("\nQual seria a forma de pagamento?");
		
		Pagamento pagamento = new Pagamento(sc.nextInt(), carrinho);
		System.out.println(pagamento.gerarNotaFiscal());
		
		
		sc.close();
	}

}
