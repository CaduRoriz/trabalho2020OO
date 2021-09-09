package validacoes;

import java.text.NumberFormat;

import dados.Hospital;
import dados.Paciente;
import entrada.Leitura;

import saida.Visao;

public class Validacao {
	private final static int IDADEMINIMA = 0;
	private final static int IDADEMAXIMA = 130;

	final static int MINIMO = 1;

	public static boolean validaErroNome(String nome) { // nome e idade
		boolean erro;
		boolean isNumber = false;
		if (nome.isEmpty()) {
			Visao.mensagemErro("O nome nao pode ser vazio, tente novamente", "ERRO");
			erro = true;
		} else if (nome.length() < 3) {
			Visao.mensagemErro("O nome do paciente deve conter pelo menos 3 caracteres!", "ERRO");
			erro = true;
		} else if (nome.charAt(0) == ' ' || nome.charAt(nome.length() - 1) == ' ') {
			Visao.mensagemErro("O nome nao pode conter espaco no inicio ou no final", "ERRO");
			erro = true;
		} else
			erro = false;

		for (int i = 0; i < nome.length(); i++) {
			if (Character.isDigit(nome.charAt(i)) == true) {
				isNumber = true;

			}
		}
		if (isNumber == true) {
			Visao.mensagemErro("O nome nao pode conter numeros!", "ERRO");
			erro = true;
		}

		return erro;
	}

	public static boolean validaErroSexo(String sexo) {
		boolean erro = false;

		if (sexo == "Selecione") {
			Visao.mensagemErro("Selecione o sexo!", "ERRO");
			erro = true;
		}
		return erro;
	}

	public static boolean validaErroSituacao(String situacao) {

		boolean erro = false;
		if (situacao == "Selecione")
			Visao.mensagemErro("Selecione a situacao!", "ERRO");
		erro = true;
		return erro;
	}

	public static boolean validaErroIdade(String idade) {

		boolean erro = false;

		Integer aux;
		try {

			aux = Integer.parseInt(idade);
			if (aux > IDADEMAXIMA || aux < IDADEMINIMA) {
				Visao.mensagemErro("A idade deve estar entre: " + IDADEMINIMA + " e " + IDADEMAXIMA, "ERRO");
				erro = true;
			}

			if (idade.isEmpty() == true) {
				Visao.mensagemErro("Entre com a idade!", "ERRO");
				erro = true;
			}

		} catch (NumberFormatException e) {
			Visao.mensagemErro("A entrada da Idade deve ser apenas numerica", "ERRO");
			erro = true;
		}

		return erro;
	}

	public static boolean validaErroStatus(int statusInt) {
		boolean erro = false;
		if (statusInt == 0) {
			Visao.mensagemErro("Selecione um status", "ERRO");
			erro = true;
		} else
			erro = false;

		return erro;
	}

	public static boolean validaEntradaIdentificador(String id, Hospital pacientes) {
		boolean erro = false;

		try {

			if (Integer.parseInt(id) < MINIMO) {
				Visao.mensagemErro("Nao ha ID menor ou igual a 0", "ERRO");
			}

		} catch (NullPointerException er) {
			Visao.mensagemErro("A entrada nao pode ser vazia", "ERRO");

		} catch (NumberFormatException e) {
			Visao.mensagemErro("A entrada deve ser numerica!", "ERRO");
			erro = true;
		}
		if (erro == false) {
			boolean teste = false;
			for (Paciente paciente : pacientes.getPacientes()) {
				if (paciente.getIdentificador() == Integer.parseInt(id)) {
					teste = true;
				}
			}
			if(teste == false) {
				Visao.mensagemErro("O ID " + id + " nao consta nos registros", "ERRO");
				erro = true;
			}
		}

		return erro;
	}

	public static boolean validaParteNome(String nome, Hospital pacientes) { // nome e idade
		boolean erro = false;
		boolean isNumber = false;

		try {
			if (validaBuscaNome(pacientes, nome) == false) {
				Visao.mensagemErro("Nenhum nome do registro contem: " + nome, "ERRO");
				erro = true;
			}

			if (nome.isEmpty() == true) {
				Visao.mensagemErro("Entrada vazia !Informe a parte do nome na campo abaixo!", "ERRO");
				erro = true;
				if (Integer.parseInt(nome) > pacientes.getPacientes().size() - 1) {
					Visao.mensagemErro("ID informado nao cadastrado!", "ERRO");
					erro = true;
				}
			}

		} catch (NumberFormatException e) {
			Visao.mensagemErro("A entrada deve ser somente numerica e inteira", "ERRO");
			erro = true;
		}

		return erro;
	}

	public static boolean validaBuscaIdentificador(Hospital pacientes, int identificador) {
		for (Paciente paciente : pacientes.getPacientes()) {
			if (paciente.getIdentificador() == identificador)
				return true;
		}
		return false;
	}

	public static boolean validaBuscaNome(Hospital pacientes, String parteNome) {
		for (Paciente paciente : pacientes.getPacientes()) {
			if (paciente.getNome().toString().toLowerCase().contains(parteNome))
				return true;
		}
		return false;
	}

}
