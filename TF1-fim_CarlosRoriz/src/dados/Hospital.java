package dados;

import java.util.ArrayList;

public class Hospital {
	public ArrayList<Paciente> pacientes;
	
	public Hospital() {
		pacientes = new ArrayList<Paciente>();
			
	}
	
	public void setPaciente(Paciente pessoa) {
		pacientes.add(pessoa);
	}
	
	public ArrayList<Paciente> getPacientes(){
		return pacientes;
	}
	
	public Paciente getPaciente(int indice) {
		return pacientes.get(indice);
	}
	

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	

	
}
