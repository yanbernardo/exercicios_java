package ex_03;

public class Gerente extends Funcionario{
	
	public Gerente(String nome, Integer idade, Double salario) {
		super(nome, idade, salario);
	}

	@Override
	Double calcularSalario(Double adicional) {
		return super.getSalario() + adicional;
	}
	
	
	
}
