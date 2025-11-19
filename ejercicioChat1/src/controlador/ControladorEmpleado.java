package controlador;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import daos.EmpleadosDaos;
import modelos.Empleado;
import vista.MostrarEmpleados;
import vista.PideDatosEmpleado;

public class ControladorEmpleado {
	private EmpleadosDaos daoj;
	
	public ControladorEmpleado() {
		try {
			daoj = EmpleadosDaos.getInstance();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nuevoEmpleado() {
		Empleado e;
		Empleado e1 = null;
		int id;
		
		PideDatosEmpleado datosEm = new PideDatosEmpleado();
		MostrarEmpleados mostrarEm = new MostrarEmpleados();
		
		id = datosEm.pideCodigo();
		
		if(e1 != null) {
			JOptionPane.showMessageDialog(null, "El codigo ya existe en la BD");
		}
		
	}
}
