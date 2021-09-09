package principal;



import interfaceGrafica.TelaPrincipal;

public class Principal {

	public static void main(String[] args) {	
	
		
		try {
			TelaPrincipal frame = new TelaPrincipal();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}	 
		 
	}
}
