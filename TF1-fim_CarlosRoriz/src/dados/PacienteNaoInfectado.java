package dados;

public class PacienteNaoInfectado extends Paciente {

	private Integer idade;

	

	public PacienteNaoInfectado(StringBuilder nome, char genero, int identificador, int idade) {
		super(nome, genero, identificador);
		setIdade(idade);
	}



	public Integer getIdade() {
		return idade;
	}



	public void setIdade(int idade) {
		this.idade = idade;
	}



	public String toString() {
	
		String idade;
		String sexo;
		
		if(getGenero() == 'F')
			sexo = "FEMININO";
			else
				sexo = "MASCULINO";
		
			idade = String.valueOf(getIdade());

		return  "ID: " + getIdentificador()+"\n" + "Nome: " + getNome()+"\n" + "Genero: " + sexo+"\n" +
				"Idade: " + idade;
	}


}
