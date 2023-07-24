package entities;

public class Pagamento {
	private Integer meioPagamento;
	private Carrinho compra;
	
	
	public Pagamento(Integer meioPagamento, Carrinho compra) {
		this.meioPagamento = meioPagamento;
		this.compra = compra;
	}
	
	public Double calcularDesconto() {
		Double total = this.compra.calcularTotalcomImposto();
		if (meioPagamento == 1) {
			return total*0.2;
		} else if (meioPagamento == 2) {
			return total*0.1;
		} else if (meioPagamento == 3) {
			return 0.0;
		} else {
			System.out.println("Opção inválida");
			return null;
		}
		
	}
	
	public String gerarNotaFiscal() {
		if (this.calcularDesconto() != null) {
			StringBuilder sb = new StringBuilder();
			sb.append("\n\n========================================================================================\n");
			sb.append("===================================== NOTA FISCAL ======================================\n");
			sb.append("========================================================================================\n\n");
			sb.append(compra.listarCarrinho(false));
			sb.append(String.format("%-73s", "Valor tributário: "));
			sb.append(String.format("R$ %.2f\n", compra.calcularImposto()));
			sb.append(String.format("%-73s", "Desconto na compra: "));
			sb.append(String.format("R$ %.2f\n", this.calcularDesconto()));
			sb.append(String.format("%-73s", "Valor total a ser pago: "));
			sb.append(String.format("R$ %.2f\n", compra.calcularTotalcomImposto() - this.calcularDesconto()));
			sb.append("========================================================================================\n");
			return sb.toString();
		}
		return null;
	}
}
