package dados;

public class PacienteInfectado extends Paciente {

	private Character situacaoMedica;
	
	public PacienteInfectado(StringBuilder nome, char sexo, Integer identificador, char situacaoMedica) {
		super(nome, sexo, identificador);
		setSituacaoMedica(situacaoMedica);
	}

	public Character getSituacaoMedica() {
		return this.situacaoMedica;
	}

	public void setSituacaoMedica(Character situacaoMedica) {
		this.situacaoMedica = situacaoMedica;
	}

	public String toString() {

		String situacao;
		String genero;
		

		
		if(getSituacaoMedica() == 'E') {
			situacao = "EM TRATANDO";
		}else if(getSituacaoMedica() == 'C') {
			situacao = "CURADO";
		}else 
			situacao = "FALECIDO";
		
		if(getGenero() == 'F')
			genero = "FEMININO";
		else
			genero = "MASCULINO";

		return  "ID: " + getIdentificador()+"\n" + "Nome: " + getNome()+"\n" + "Genero: " + genero +"\n" +
		"Situacao Medica: " + situacao;

	}
	

}
