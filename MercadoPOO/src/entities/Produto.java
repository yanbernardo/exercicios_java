package entities;
public class Produto {

	private String nomeProduto;
	private Double precoProduto;
	private static Integer instancia = 0;
	private static Double imposto = 0.09;
	private Integer idProduto;

	public Produto(String nomeProduto, Double precoProduto) {
		this.nomeProduto = nomeProduto;
		this.precoProduto = precoProduto;
		Produto.instancia++;
		this.idProduto = instancia;
		
	}

	public Produto() {
		Produto.instancia++;
		this.idProduto = instancia;
	}

	public String getNomeProduto() {
		return this.nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPrecoProduto() {
		return this.precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public Integer getIdProduto() {
		return this.idProduto;
	}
	
	public static Double getImposto() {
		return imposto;
	}
	
	public void setImposto(Double percentage) {
		Produto.imposto = percentage;
	}

}
