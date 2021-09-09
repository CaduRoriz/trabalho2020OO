package interfaceGrafica;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dados.Hospital;
import dados.Paciente;
import saida.Visao;
import validacoes.Validacao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GetId extends JInternalFrame {
	private JTextField textFieldId;

	public GetId(Hospital pacientes) {
		setBounds(325, 100, 170, 134);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Insira o ID a ser buscado");
		lblNewLabel.setBounds(10, 11, 144, 14);
		panel.add(lblNewLabel);

		textFieldId = new JTextField();
		textFieldId.setBounds(10, 36, 48, 20);
		panel.add(textFieldId);
		textFieldId.setColumns(10);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Validacao.validaEntradaIdentificador(textFieldId.getText(), pacientes) == false) {

					for (Paciente paciente : pacientes.getPacientes()) {
						if (paciente.getIdentificador() == Integer.parseInt(textFieldId.getText())) {
							Visao.mensagem(paciente.toString());
						}
					}
				}
				dispose();

			}
		});
		btnNewButton.setBounds(65, 36, 79, 20);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 70, 92, 23);
		panel.add(btnNewButton_1);

	}

}
