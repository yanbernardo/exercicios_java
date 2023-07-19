package ex_03;

public class Programador extends Funcionario{
	

	public Programador(String nome, Integer idade, Double salario) {
		super(nome, idade, salario);
	}

	@Override
	Double calcularSalario(Double horasTrabalhadas) {
		return super.getSalario()*horasTrabalhadas;
	}
	
	
}
