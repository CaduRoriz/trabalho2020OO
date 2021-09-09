package conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import dados.Hospital;
import dados.PacienteInfectado;
import dados.PacienteNaoInfectado;
import saida.Visao;

public class PacienteDAO {
	private Connection conex = Conexao.getConnection();

	public void cadastrarInfectado(PacienteInfectado paciente) {
		String sql = "insert into pessoa(nome, genero, idade, saude) values (?,?,?,?)";

		try {

			PreparedStatement preparador = conex.prepareStatement(sql);
			preparador.setString(1, paciente.getNome().toString());
			preparador.setString(2, paciente.getGenero().toString());
			preparador.setString(3, null);
			preparador.setString(4, paciente.getSituacaoMedica().toString());

			preparador.execute();
		
			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
			Visao.mensagemConsole("ERRO " + e.getMessage());

		} finally {
			if (conex != null) {
				try {
					conex.close();
				} catch (SQLException er) {
					er.printStackTrace();
					Visao.mensagemConsole("Falha ao fechar a conexao" + er.getMessage());
				}
			}

		}

	}

	public void cadastrarNaoInfectado(PacienteNaoInfectado paciente) {
		String sql = "insert into pessoa(nome, genero, idade, saude) values (?,?,?,?)";

		try {

			PreparedStatement preparador = conex.prepareStatement(sql);
			preparador.setString(1, paciente.getNome().toString());
			preparador.setString(2, paciente.getGenero().toString());
			preparador.setString(3, paciente.getIdade().toString());
			preparador.setString(4, null);
			preparador.execute();

			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
			Visao.mensagemConsole("ERRO " + e.getMessage());

		} finally {
			if (conex != null) {
				try {
					conex.close();
				} catch (SQLException er) {
					er.printStackTrace();
					Visao.mensagemConsole("Falha ao fechar a conexao" + er.getMessage());
				}
			}

		}
	}

	public Hospital retornaPacientesDoHospital() {
		Hospital pacientes = new Hospital();
		String sql = "select * from pessoa";

		try {
			
			PreparedStatement preparador = conex.prepareStatement(sql);
			ResultSet lista = preparador.executeQuery();
			
			while (lista.next()) {
				
				String nome = lista.getString("nome");
				String sexo = lista.getString("genero");
				String idade = lista.getString("idade");
				String situacaoMedica = lista.getString("saude");
				int id = lista.getInt("idPessoa");

				if(situacaoMedica == null) {
					pacientes.setPaciente(new PacienteNaoInfectado(new StringBuilder(nome), sexo.charAt(0), id, Integer.parseInt(idade)));
					
				}
				else {
					pacientes.setPaciente(new PacienteInfectado(new StringBuilder(nome), sexo.charAt(0), id, situacaoMedica.charAt(0)));
				}
				
						
			}
				

			preparador.close();
		} catch (SQLException e) {
			e.printStackTrace();
			Visao.mensagemConsole("Deu erro" + e.getMessage());
		} finally {
			if (conex != null) {
				try {
					conex.close();
				} catch (SQLException er) {
					er.printStackTrace();
					Visao.mensagemConsole("Falha ao fechar a conexao" + er.getMessage());
				}
			}
		}

		return pacientes;

	}

}
