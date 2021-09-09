package interfaceGrafica;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import saida.Visao;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;
import java.awt.Color;


import conexao.PacienteDAO;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
//	Hospital pacientes;
	private JTextField buscaID;
	public TelaPrincipal() {
		
//		pacientes = pacientes1;
		
		setTitle("Inicio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(0, 0, 918, 406);
		contentPane.add(desktopPane);
		
		this.setLocationRelativeTo(null);
		
		JButton button = new JButton("Encerrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visao.mostraResultados(new PacienteDAO().retornaPacientesDoHospital());
				System.exit(0);
			}
		});
		button.setBounds(735, 361, 89, 23);
		desktopPane.add(button);

		JButton button_1 = new JButton("Cadastrar Paciente");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro telaCadastro = new Cadastro( new PacienteDAO().retornaPacientesDoHospital());
				desktopPane.add(telaCadastro);
				telaCadastro.show();
				

			}
		});
		button_1.setBounds(39, 9, 166, 23);
		desktopPane.add(button_1);

		JButton button_2 = new JButton("Listar Pacientes");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				ListarPacientes lista = new ListarPacientes(new PacienteDAO().retornaPacientesDoHospital(), 0, 1,0);
				
				desktopPane.add(lista);
				lista.show();
			
				
			}
		});
		button_2.setBounds(240, 9, 166, 23);
		desktopPane.add(button_2);

		JButton button_3 = new JButton("Buscar Paciente por ID");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				GetId colheId = new GetId(new PacienteDAO().retornaPacientesDoHospital());
				desktopPane.add(colheId);
				colheId.show();
				
	
				
				
			}
		});
		button_3.setBounds(439, 9, 166, 23);
		desktopPane.add(button_3);

		JButton button_4 = new JButton("Buscar Paciente por Nome");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
						ListarPacientes lista = new ListarPacientes(new PacienteDAO().retornaPacientesDoHospital(), 0, 3, 1);
						desktopPane.add(lista);
						lista.show();

					
			}
		});
		button_4.setBounds(639, 9, 191, 23);
		desktopPane.add(button_4);

		JLabel labelCadastro = new JLabel("");
		ImageIcon imagemCadastro = new ImageIcon(this.getClass().getResource("/user_add.png"));
		labelCadastro.setIcon(imagemCadastro);

		labelCadastro.setBounds(10, 9, 63, 19);
		desktopPane.add(labelCadastro);

		JLabel labelLista = new JLabel("");
		ImageIcon imagemLista = new ImageIcon(this.getClass().getResource("/application_view_list.png"));
		labelLista.setIcon(imagemLista);

		labelLista.setBounds(215, 9, 63, 21);
		desktopPane.add(labelLista);

		JLabel labelBuscaId = new JLabel("");
		ImageIcon imgID = new ImageIcon(this.getClass().getResource("/zoom.png"));
		labelBuscaId.setIcon(imgID);

		labelBuscaId.setBounds(416, 9, 46, 23);
		desktopPane.add(labelBuscaId);

		JLabel labelBuscaNome = new JLabel("");
		ImageIcon imgNom = new ImageIcon(this.getClass().getResource("/zoom_in.png"));
		labelBuscaNome.setIcon(imgNom);
		labelBuscaNome.setBounds(615, 9, 63, 23);
		desktopPane.add(labelBuscaNome);

		JLabel labelSus = new JLabel("");
		ImageIcon imga = new ImageIcon(this.getClass().getResource("/sus1.png"));
		labelSus.setIcon(imga);

		labelSus.setBounds(457, 99, 387, 200);
		desktopPane.add(labelSus);

		JLabel labelCorona = new JLabel("");
		ImageIcon imgCv = new ImageIcon(this.getClass().getResource("/download.jpg"));
		labelCorona.setIcon(imgCv);
		labelCorona.setBounds(-12, 151, 329, 274);
		desktopPane.add(labelCorona);
		
		JLabel corona2 = new JLabel("");
		ImageIcon imgCv2 = new ImageIcon(this.getClass().getResource("/download.jpg"));
		corona2.setIcon(imgCv2);
		corona2.setBounds(215, 11, 274, 225);
		desktopPane.add(corona2);
		
		
		JLabel lblNewLabel = new JLabel("by: Carlos Eduardo Miranda Roriz");
		lblNewLabel.setBounds(237, 376, 205, 14);
		desktopPane.add(lblNewLabel);
		
		/*buscaID = new JTextField();
		buscaID.setBounds(439, 43, 63, 20);
		desktopPane.add(buscaID);
		buscaID.setColumns(10);
		*/
		
		
		

	}
}

