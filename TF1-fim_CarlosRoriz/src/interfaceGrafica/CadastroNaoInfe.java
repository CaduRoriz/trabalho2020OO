package interfaceGrafica;



import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import dados.Hospital;

import dados.PacienteNaoInfectado;
import entrada.Leitura;
import saida.Visao;
import validacoes.Validacao;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import conexao.PacienteDAO;

//import conexao.PessoaDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroNaoInfe extends JInternalFrame {
	private JTextField textIdade;

	public CadastroNaoInfe(Hospital pacientes, String nome, char sexo) {
		setTitle("Cadastro");
		setBounds(100, 100, 220, 130);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Idade:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);

		textIdade = new JTextField();
		textIdade.setBounds(10, 25, 86, 20);
		panel.add(textIdade);
		textIdade.setColumns(10);
		this.setLocation(55, 40);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final int MINIMO = 1;

				if (Validacao.validaErroIdade(textIdade.getText()) == false) {
					
	
					PacienteNaoInfectado paciente = new PacienteNaoInfectado(new StringBuilder(nome), sexo, (pacientes.getPacientes().size() + MINIMO) , Integer.parseInt(textIdade.getText()) );

					paciente.setIdade(Integer.parseInt(textIdade.getText()));
					
					
					new PacienteDAO().cadastrarNaoInfectado(paciente);
					
					
					Visao.mensagemInfo("Cadastro efetuado com sucesso!", "CADASTRO");
					dispose();
				}
				textIdade.setText("");

			}
		});
		btnNewButton.setBounds(106, 7, 92, 56);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Leitura.lerConfirmacao("Deseja cancelar o cadastro?") == 0) {
					dispose();
				}
			}
		});
		btnNewButton_1.setBounds(10, 66, 89, 23);
		panel.add(btnNewButton_1);

	}
}
