package interfaceGrafica;



import javax.swing.JInternalFrame;

import dados.Hospital;

import dados.PacienteInfectado;
import entrada.Leitura;
import saida.Visao;
import validacoes.Validacao;

import javax.swing.JPanel;

import conexao.PacienteDAO;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import javax.swing.DefaultComboBoxModel;

public class CadastroInfec extends JInternalFrame {

	public CadastroInfec(Hospital pacientes, String nome, char sexo) {
		setTitle("Cadastro");
		setBounds(100, 100, 220, 144);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Situacao:");
		lblNewLabel.setBounds(10, 11, 63, 14);
		panel.add(lblNewLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "TRATANDO", "CURADO", "FALECIDO"}));
		comboBox.setBounds(10, 36, 86, 20);
		panel.add(comboBox);
		this.setLocation(55, 40);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final int MINIMO = 1;
				char situacao = 'c';

				if(Validacao.validaErroSituacao(comboBox.getSelectedItem().toString()) == true) {
					if(comboBox.getSelectedIndex() == 1) 
						situacao = 'E';	
					else if(comboBox.getSelectedIndex() == 2)
						situacao = 'C';
					else if(comboBox.getSelectedIndex() == 3)
						situacao = 'F';
					
					PacienteInfectado pacienteInfectado = new PacienteInfectado(new StringBuilder(nome), sexo, pacientes.getPacientes().size() + MINIMO, situacao );
						
					
					
					new PacienteDAO().cadastrarInfectado(pacienteInfectado);
					
					comboBox.setSelectedIndex(0);
					Visao.mensagemInfo("Cadastro efetuado com sucesso!", "CADASTRO");
					dispose();
				}
				
			
				
			}
			
			
			
		});
		
		
		
		btnNewButton.setBounds(106, 11, 92, 51);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Leitura.lerConfirmacao("Deseja cancelar o cadastro?") == 0) {
					dispose();
				}
			}
		});
		btnNewButton_1.setBounds(7, 80, 89, 23);
		panel.add(btnNewButton_1);

	}

}
