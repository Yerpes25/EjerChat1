package vista;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import modelos.Proyecto;

public class PideProyectos {
	Proyecto p;
	
	public int pideIdProyecto() {
		int id = 0;
		
		do {
			id = Integer.parseInt(JOptionPane.showInputDialog("Dime la id del proyecto"));
		}while(id <= 0);
		
		return id;
	}
	
	public Proyecto pideDatosProyecto(int id) {
		String nombre = JOptionPane.showInputDialog("Dime el nombre del proyecto");
		String cliente = JOptionPane.showInputDialog("Dime el cliente del proyecto");
		String fecha = JOptionPane.showInputDialog("Dime la fecha del proyecto");
		LocalDate f_inicio = LocalDate.parse(fecha);
		double presupuesto = Double.parseDouble(JOptionPane.showInputDialog("Dime el presupuesto del proyecto"));
		
		p = new Proyecto();
		p.setId_proyecto(id);
		p.setNombre(nombre);
		p.setCliente(cliente);
		p.setF_inicio(f_inicio);
		p.setPresupuesto(presupuesto);
		
		return p;
	}
}
