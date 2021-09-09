package dados;

public class Paciente implements Comparable<Paciente>{
	
	private StringBuilder nome;
	private Character sexo;
	private Integer identificador;
	
	
	public Paciente(StringBuilder nome, char genero, int identificador) {
		super();
		setNome(nome);
		setGenero(genero);
		setIdentificador(identificador);
	}
	
	
	public StringBuilder getNome() {
		return nome;
	}
	
	
	public void setNome(StringBuilder nome) {
		this.nome = nome;
	}
	
	
	public Character getGenero() {
		return sexo;
	}
	public void setGenero(char genero) {
		this.sexo = genero;
	}
	public Integer getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public Integer getIdade() {
		return 0;
	}

	public void setIdade(int idade) {
		
	}
	
	public Character getSituacaoMedica() {
		return null;
	}

	public void setSituacaoMedica(StringBuilder situacaoMedica) {
	}

	@Override
	public int compareTo(Paciente paciente) {
		
		return this.getNome().toString().compareTo(paciente.getNome().toString());
	}




	
	
	

}
