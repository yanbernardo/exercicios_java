package app;


import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Carrinho;
import entities.Estoque;
import entities.Pagamento;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
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
				try {
					id = sc.nextInt();
					sc.nextLine();
					if (estoque.getProduto(id) == null) {
						System.out.println("ID Fora do Range! Tente novamente...");
					} else {
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("ID inv�lido! Digite somente n�meros inteiros");
					System.out.println("============================================================");
					sc.nextLine();
				}
			}
			Integer qnt;
			while (true) {
				try {
					System.out.println("Digite a quantidade: ");
					qnt = sc.nextInt();
					sc.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Quantidade inv�lida! Digite somente n�meros inteiros!");
					sc.nextLine();
				}
			}

			
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
			
		Pagamento pagamento = new Pagamento();
		pagamento.setCompra(carrinho);
		while (true) {
			System.out.println("\nQual seria a forma de pagamento?");
			try {	
				pagamento.setMeioPagamento(sc.nextInt());
				if (pagamento.calcularDesconto() != null) {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Op��o inv�lida! Selecione apenas as op��es informadas acima.");
				sc.nextLine();
			}
		}
		System.out.println(pagamento.gerarNotaFiscal());

		
		
		sc.close();
	}

}
