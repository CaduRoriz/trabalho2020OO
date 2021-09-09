package saida;

import java.text.DecimalFormat;


import javax.swing.JOptionPane;

import dados.Hospital;
import dados.Paciente;
import dados.PacienteNaoInfectado;


public class Visao {
	
	public static void mensagemInfo(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	public static void mensagemErro(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.ERROR_MESSAGE);
	}

	public static void mensagemAviso(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.WARNING_MESSAGE);
	}
	public static void mensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem, "",JOptionPane.PLAIN_MESSAGE);
	}
	public static void mensagemConsole(String mensagem) {
		System.out.println(mensagem);
	}

	public static void limpaTela(int linhas) {
		for (int i = 0; i < linhas; i++) {
			System.out.println();
		}
	}

	public static void mostraResultados(Hospital pacientes) {
		DecimalFormat formato = new DecimalFormat("00");
		int naoContaminados = 0;
		int contaminadosCurados = 0;
		int contaminadosEmTratamento = 0;
		int mulheresFalecidas = 0;
		int homensFalecidos = 0;

		
		for (Paciente paciente : pacientes.getPacientes()) {

			if (paciente instanceof PacienteNaoInfectado ){
				naoContaminados++;
			} else {
				if (paciente.getSituacaoMedica().toString().equals("E")) {
					contaminadosEmTratamento++;
				} else if (paciente.getSituacaoMedica().toString().equals("C")) {
					contaminadosCurados++;
				} else {
					if (paciente.getGenero().toString().equals("M")) {
						homensFalecidos++;
					} else if (paciente.getGenero().toString().equals("F")) {
						mulheresFalecidas++;
					}
				}
			}

		}

		limpaTela(3);
		mensagemConsole("                  " + formato.format(naoContaminados) + " = NAO CONTAMINADOS\n" +"                  " + formato.format(contaminadosEmTratamento)+ " = EM TRATAMENTO\n"
				+ "                  " +formato.format(contaminadosCurados) + " =  CURADOS\n" +"                  " + formato.format(mulheresFalecidas)+ " = MULHERES CONTAMINADAS FALECIDAS\n"
				+"                  " + formato.format(homensFalecidos) + " = HOMENS CONTAMINADOS FALECIDOS\n" + "                  " +"----------------------------------------------\n");
		System.err.println("                  " +formato.format(pacientes.getPacientes().size()) + " = TOTAL DE PESSOAS CADASTRADAS " );
	}

	

	


}
