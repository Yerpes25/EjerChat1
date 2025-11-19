package vista;

import java.util.List;

import javax.swing.JOptionPane;

import modelos.Empleado;

public class MostrarEmpleados {
	
	public void MuestraUnEmpleado(Empleado e) {
		JOptionPane.showMessageDialog(null, e.toString());
	}
	
	public void MuestraTodosLosEmpleados(List<Empleado> e) {
		String salida = "";
		for(Empleado e1 : e) {
			salida += e1.toString() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, salida);
	}
}
