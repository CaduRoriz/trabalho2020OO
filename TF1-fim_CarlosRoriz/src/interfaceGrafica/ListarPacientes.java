package interfaceGrafica;



import javax.swing.JInternalFrame;

import dados.Hospital;
import dados.Paciente;
import dados.PacienteInfectado;
import dados.PacienteNaoInfectado;
import saida.Visao;
import validacoes.Validacao;

import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collections;

import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

public class ListarPacientes extends JInternalFrame {
	private JTable table;
	private JTextField textFieldNome;
	int contador = 0;

	public ListarPacientes(Hospital pacientes, int id, int tipo, int textFieldNom) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 356);

		
		
		this.setLocation(8, 40);
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel quantidadeNome = new JLabel("");
		quantidadeNome.setBounds(477, 4, 238, 14);
		desktopPane.add(quantidadeNome);
		
		JButton btnNewButton = new JButton("Listar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
				DefaultTableModel listagem = (DefaultTableModel) table.getModel();
				listagem.setNumRows(0);
				switch (tipo) {
				case (1):// listar todos

					if (pacientes.getPacientes().isEmpty() == true) {
						Visao.mensagemErro("Nao ha nenhum cadastro para ser listado", "ERRO");
						dispose();
					} else {
						for (Paciente paciente : pacientes.getPacientes()) {
							String idade = "", situacao = "", genero;
							if (paciente instanceof PacienteInfectado) {
								idade = " - ";
								if (paciente.getSituacaoMedica().toString().equals("E")) {
									situacao = "TRATANDO";
								} else if (paciente.getSituacaoMedica().toString().equals("C")) {
									situacao = "CURADO";
								} else {
									situacao = "FALECIDO";
								}

							} else if (paciente instanceof PacienteNaoInfectado) {
								situacao = " - ";
								idade = paciente.getIdade().toString();
							}
							if (paciente.getGenero() == 'M')
								genero = "MASCULINO";
							else
								genero = "FEMININO";

							Object[] dados = { paciente.getIdentificador(), paciente.getNome().toString().toUpperCase(),
									genero, idade, situacao };
							listagem.addRow(dados);
						}
					}

					break;

				case (3): // busca por nome
					Collections.sort(pacientes.getPacientes());
				contador = 0;
				if (pacientes.getPacientes().isEmpty() == true) {
					Visao.mensagemErro("Nao ha nenhum cadastro para ser listado", "ERRO");
					dispose();
				}else if(Validacao.validaBuscaNome(pacientes, textFieldNome.getText().toLowerCase()) == false) {
						Visao.mensagemErro(
								"Nao ha ninguem com: " + "'" + textFieldNome.getText() + "'" + " em seu nome", "ERRO");
					} else {
						
						quantidadeNome.setText("");
						
						for (Paciente paciente : pacientes.getPacientes()) {
							String idade1 = "", situacao1 = "", genero1;

							if (paciente.getNome().toString().toLowerCase()
									.contains(textFieldNome.getText().toLowerCase())) {
								contador++;
								if (paciente.getGenero() == 'M')
									genero1 = "MASCULINO";
								else
									genero1 = "FEMININO";

								if (paciente instanceof PacienteInfectado) {
									idade1 = " - ";
									if (paciente.getSituacaoMedica().toString().equals("T")) {
										situacao1 = "TRATANDO";
									} else if (paciente.getSituacaoMedica().toString().equals("C")) {
										situacao1 = "CURADO";
									} else
										situacao1 = "FALECIDO";
								} else if (paciente instanceof PacienteNaoInfectado) {
									situacao1 = " - ";
									idade1 = paciente.getIdade().toString();
								}

								Object[] dados = { paciente.getIdentificador(),
										paciente.getNome().toString().toUpperCase(), genero1, idade1, situacao1 };
								listagem.addRow(dados);

							}
						}
						quantidadeNome.setText("Ha " + contador +" pacientes com " + "'"+textFieldNome.getText().toLowerCase() +"'");
					}
				

				}

			}
		});
		btnNewButton.setBounds(378, 0, 89, 23);
		desktopPane.add(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 32, 816, 347);
		desktopPane.add(scrollPane_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Identificador", "Nome", "Genero", "Idade", "Situacao Medica" }));

		scrollPane.setViewportView(table);
		ImageIcon closeW = new ImageIcon(this.getClass().getResource("/cancel.png"));

		JButton closeButton = new JButton("Fechar");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		closeButton.setBounds(718, 2, 76, 19);
		desktopPane.add(closeButton);


		if (textFieldNom == 1) {
			JLabel lblNewLabel = new JLabel("Insira o Nome a ser pesquisado:");
			lblNewLabel.setBounds(10, 4, 185, 14);
			desktopPane.add(lblNewLabel);

			textFieldNome = new JTextField();
			textFieldNome.setBounds(195, 1, 160, 20);
			desktopPane.add(textFieldNome);
			textFieldNome.setColumns(10);
		}

	}
}
