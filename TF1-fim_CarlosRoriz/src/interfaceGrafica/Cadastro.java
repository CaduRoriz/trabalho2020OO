package interfaceGrafica;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import dados.Hospital;
import entrada.Leitura;
import validacoes.Validacao;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import javax.swing.JDesktopPane;

public class Cadastro extends JInternalFrame {
	private JTextField textNome;

	public Cadastro(Hospital pacientes) {
		setTitle("CADASTRO");

		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setClosable(true);
		setBounds(100, 100, 330, 293);
		getContentPane().setLayout(null);

		JDesktopPane desktopPaneCadastro = new JDesktopPane();
		desktopPaneCadastro.setBackground(Color.WHITE);
		desktopPaneCadastro.setBounds(0, 0, 325, 285);
		getContentPane().add(desktopPaneCadastro);
		this.setLocation(251, 50);

		JLabel label = new JLabel("Nome");
		label.setBounds(10, 3, 46, 14);
		desktopPaneCadastro.add(label);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(10, 28, 275, 20);
		desktopPaneCadastro.add(textNome);

		JLabel label_1 = new JLabel("Sexo");
		label_1.setBounds(10, 87, 46, 14);
		desktopPaneCadastro.add(label_1);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(151, 84, 46, 20);
		desktopPaneCadastro.add(lblStatus);

		JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Selecione", "MASCULINO", "FEMININO" }));
		comboBox.setBounds(10, 126, 105, 20);
		desktopPaneCadastro.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();

		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Selecione", "INFECTADO", "NAO INFECTADO" }));
		comboBox_1.setBounds(151, 126, 105, 20);
		desktopPaneCadastro.add(comboBox_1);

		JButton button = new JButton("Continuar\r\n");
		button.addActionListener(new ActionListener() {

			String nome;
			char sexo;
			boolean status = false;

			boolean erroNome = false;
			boolean erroSexo = false;
			boolean erroStatus = false;
			String situacao;
			boolean continua;
			int idade;

			public void actionPerformed(ActionEvent e) {
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

					}
				});

				comboBox_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});

				if (Validacao.validaErroNome(textNome.getText()) == false) {
					nome = textNome.getText();
					erroNome = false;
				} else {
					erroNome = true;
				}

				if (Validacao.validaErroSexo(comboBox.getSelectedItem().toString()) == false) {
					if (comboBox.getSelectedIndex() == 1) {
						sexo = 'M';
					} else if (comboBox.getSelectedIndex() == 2) {
						sexo = 'F';
					}

					erroSexo = false;
				} else {

					erroSexo = true;
				}

				if (Validacao.validaErroStatus(comboBox_1.getSelectedIndex()))
					erroStatus = true;
				else {
					erroStatus = false;
					if (comboBox_1.getSelectedIndex() == 1) {
						status = true;
					} else if (comboBox_1.getSelectedIndex() == 2) {
						status = false;
					}
				}

				textNome.setText("");
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);

				if ((erroNome == false) && (erroSexo == false) && (erroStatus == false) && (status == false)) {
					CadastroNaoInfe cadastroNao = new CadastroNaoInfe(pacientes, nome, sexo);
					desktopPaneCadastro.add(cadastroNao);
					cadastroNao.setVisible(true);
				}

				if (erroNome == false && erroSexo == false && erroStatus == false && status == true) {
					CadastroInfec cadastroSim = new CadastroInfec(pacientes, nome, sexo);
					desktopPaneCadastro.add(cadastroSim);
					cadastroSim.setVisible(true);

				}

			}

		});
		button.setBounds(10, 157, 89, 65);
		desktopPaneCadastro.add(button);

		JButton calcel = new JButton("Cancelar");
		calcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Leitura.lerConfirmacao("Deseja cancelar o cadastro?") == 0) {
					dispose();
				}
			}
		});
		calcel.setBounds(226, 236, 89, 23);
		desktopPaneCadastro.add(calcel);

	}

}
