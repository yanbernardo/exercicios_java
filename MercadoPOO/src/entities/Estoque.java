package entities;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
	
	List<Object> listaEstoque = new ArrayList<>();
	
	public Estoque() {
		
	}
	
	public Estoque(String nomeProduto, Double precoProduto, Integer quantidade) {
		listaEstoque.add(new Produto(nomeProduto, precoProduto));
		listaEstoque.add(quantidade);
	}
	
	public void novoProduto(String nomeProduto, Double precoProduto, int quantidade) {
		listaEstoque.add(new Produto(nomeProduto, precoProduto));
		listaEstoque.add(quantidade);
	}
	
	public void abastecerProduto(Integer idProduto, int quantidade) {
		for (int i=0 ; i < listaEstoque.size() ; i++) {
			if (listaEstoque.get(i) instanceof Produto) {
				if (((Produto) listaEstoque.get(i)).getIdProduto() == idProduto) {
					listaEstoque.set(i+1, (int) listaEstoque.get(i+1) + quantidade);
				}
			}
		}
	}
	
	public boolean retirarProduto(Produto produto, Integer quantity) {
		for (int i=0; i<listaEstoque.size(); i++) {
			if (i % 2 == 0) {
				if (((Produto) listaEstoque.get(i)).getIdProduto() == produto.getIdProduto()) {
					if((int)listaEstoque.get(i+1) >= quantity) {
						listaEstoque.set(i+1, (int)listaEstoque.get(i+1) - quantity);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public String listarEstoque(boolean comCabecalho) {
		StringBuilder listaEstoqueList = new StringBuilder();
		if (comCabecalho) {
			listaEstoqueList.append("\n\n============================================================\n");
			listaEstoqueList.append("                          Produtos                          \n");
			listaEstoqueList.append("============================================================\n\n");
			
		}
		listaEstoqueList.append("ID | NOME              | QTD |                 |   PREÇO   |\n\n");

		for (int i=0 ; i < listaEstoque.size() ; i++) {
			if (i % 2 == 1) { //Se o index for Impar, é a quantidade
				listaEstoqueList.append(String.format("%5d| %20s%.2f\n", listaEstoque.get(i), "R$ ", ((Produto) listaEstoque.get(i-1)).getPrecoProduto()));
			} else { // Se não (caso par) é o Produto
				listaEstoqueList.append(String.format("%-3d| %-18s|",((Produto) listaEstoque.get(i)).getIdProduto(), ((Produto) listaEstoque.get(i)).getNomeProduto()) );
			}
		}
		listaEstoqueList.append("============================================================\n");
		return listaEstoqueList.toString();
	}
	
	public Produto getProduto(Integer id) {
		Produto produto = null;
		for (int i=0; i<listaEstoque.size(); i++) {
			if (i % 2 == 0) {
				if (((Produto) listaEstoque.get(i)).getIdProduto() == id) {
					produto = (Produto) listaEstoque.get(i);
				}
				
			}
		}
		return produto;
	}

}

