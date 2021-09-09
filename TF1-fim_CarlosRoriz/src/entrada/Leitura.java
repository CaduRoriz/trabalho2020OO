package entrada;

import javax.swing.JOptionPane;

public class Leitura {
	public static String lerOpcoesSelect(String mensagem, String titulo, String[] opcoes) {
		return String.valueOf(JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.PLAIN_MESSAGE, null,
				opcoes, opcoes[0]));
	}

	public static String lerEntrada(String mensagem, String titulo) {
		return JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE);
	}
	
	public static int lerConfirmacao(String mensagem) {
		return JOptionPane.showConfirmDialog(null, mensagem); 
	}
	
	public static int lerBotoes(String[] botoes, String title, String mensagem) {
		return JOptionPane.showOptionDialog(null, mensagem, title,
				0, JOptionPane.PLAIN_MESSAGE, null, botoes, botoes[0]);
	}
}
