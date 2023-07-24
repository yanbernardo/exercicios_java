package entities;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private List<Object> carrinho = new ArrayList<>();
	
	public Carrinho() {
		
	}
	
	public void addProdCarrinho(Produto produto, Integer qnt) {
		for (int i=0; i<carrinho.size(); i++) {
			if (i % 2 == 0) {
				if (((Produto) carrinho.get(i)).getNomeProduto() == produto.getNomeProduto()) {
					carrinho.set(i + 1, ((int)carrinho.get(i+1)) + qnt);
					return;
				}
			}
		}
		carrinho.add(produto);
		carrinho.add(qnt);
		return;
	}
	
	public Double calcularTotal() {
		Double somaTotal = 0.0;
		for (int i=0; i < carrinho.size(); i++) {
			if (i % 2 != 0) {
				somaTotal += ((int)carrinho.get(i))* ((Double)((Produto) carrinho.get(i-1)).getPrecoProduto());;
			}
		}
		return somaTotal;
	}
	
	public Double calcularImposto() {
		return this.calcularTotal()*Produto.getImposto();
	}
	
	public Double calcularTotalcomImposto() {
		return this.calcularTotal() + this.calcularImposto();
	}
	
	public Double calcularTotalItem(String nomeItem) {
		nomeItem = nomeItem.toLowerCase();
		for (int i=0; i<carrinho.size(); i++) {
			if (i%2==0) {
				if (((Produto) carrinho.get(i)).getNomeProduto().toLowerCase() == nomeItem) {
					return ((Produto)carrinho.get(i)).getPrecoProduto() * (Integer)carrinho.get(i+1);
				} 
			}
		}
		return null;
	}
	
	public Double calcularTotalItem(Produto object) {
		for (int i=0; i<=carrinho.size(); i++) {
			if (i%2 == 0) {
				if (((Produto) carrinho.get(i)).getNomeProduto().equals(object.getNomeProduto())) {
					return ((Produto) carrinho.get(i)).getPrecoProduto() *(Integer) carrinho.get(i+1);
				}
			}
		}
		return null;
	}
	
	public String listarCarrinho(boolean comCabecalho) {
		StringBuilder sb = new StringBuilder();
		if (comCabecalho) {
			sb.append("========================================================================================\n");
			sb.append(String.format("%50s", "CARRINHO\n"));
			sb.append("========================================================================================\n");

		}
		sb.append("\nProduto          Qtde. no Carrinho          Preço unit.(R$)         Preço Total (R$)\n");
		for (int i=0; i < carrinho.size(); i++) {
			if (i % 2 == 0) {
				sb.append(String.format("%-23s", ((Produto) carrinho.get(i)).getNomeProduto()));
			} else {
				sb.append(String.format("%-28s", carrinho.get(i)));
				sb.append(String.format("%-25s", ((Produto) carrinho.get(i-1)).getPrecoProduto()));
				sb.append(String.format("%.2f\n", this.calcularTotalItem(((Produto) carrinho.get(i-1)))));
			}
		}
		sb.append("----------------------------------------------------------------------------------------\n");

		
		sb.append(String.format("\n%-75s","Valor da compra sem Imposto:"));
		sb.append(String.format("%6s\n", String.format("%.2f", this.calcularTotal())));
		sb.append(String.format("%-74s", "Aplicado imposto de:"));
		sb.append(String.format("%6s%%\n", String.format("%.0f", Produto.getImposto()*100)));
		sb.append(String.format("%-75s", "Valor total da compra:"));
		sb.append(String.format("%6s\n", String.format("%.2f", this.calcularTotalcomImposto())));
		sb.append("----------------------------------------------------------------------------------------\n");

		return sb.toString();
	}
}
