package vista;

import javax.swing.JOptionPane;

import modelos.Empleado;

public class PideDatosEmpleado {
	Empleado e;
	
	public int pideCodigo() {
		int cod = 0;
		
		do {
			cod = Integer.parseInt(JOptionPane.showInputDialog("Dime el codigo del empleado"));
		}while(cod >= 0);
		
		return cod;
	}
	
	public Empleado pideDatosEmpleado(int id) {
		String dni = JOptionPane.showInputDialog("Dime el dni del empleado");
		String nombre = JOptionPane.showInputDialog("Dime el nombre del empleado");
		String puesto = JOptionPane.showInputDialog("Dime el puesto del empleado");
		double salario = Double.parseDouble(JOptionPane.showInputDialog("Dime el salario del empleado"));
		int id_proyecto = Integer.parseInt(JOptionPane.showInputDialog("Dime la id del proyecto del empleado"));
		
		e = new Empleado();
		e.setIdEmpleado(id);
		e.setDni(dni);
		e.setNombre(nombre);
		e.setPuesto(puesto);
		e.setSalario(salario);
		e.setId_proyecto(id_proyecto);
		
		return e;
	}
	
	public double pedirSalario() {
		double salario = Double.parseDouble(JOptionPane.showInputDialog("Dime el salario"));
		
		return salario;
	}
}
