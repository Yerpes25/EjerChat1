package vista;

import java.util.List;

import javax.swing.JOptionPane;

import modelos.Proyecto;

public class MostrarProyectos {
	
	public void MuestraProyecto(Proyecto p) {
		JOptionPane.showMessageDialog(null, p.toString());
	}
	
	public void MuestraTodosProyectos(List<Proyecto> p) {
		String salida = "";
		for(Proyecto p1 : p) {
			salida += p1.toString() + "\n";
		}
		JOptionPane.showMessageDialog(null, salida);
	}
}
