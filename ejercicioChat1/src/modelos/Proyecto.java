package modelos;

import java.time.LocalDate;

public class Proyecto {
	private int id_proyecto;
	private String nombre;
	private String cliente;
	private LocalDate f_inicio;
	private double presupuesto;
	
	public Proyecto(int id_proyecto, String nombre, String cliente, LocalDate f_inicio, double presupuesto) {
		super();
		this.id_proyecto = id_proyecto;
		this.nombre = nombre;
		this.cliente = cliente;
		this.f_inicio = f_inicio;
		this.presupuesto = presupuesto;
	}

	public Proyecto() {
		super();
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public LocalDate getF_inicio() {
		return f_inicio;
	}

	public void setF_inicio(LocalDate f_inicio) {
		this.f_inicio = f_inicio;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	@Override
	public String toString() {
		return "Proyecto [id_proyecto=" + id_proyecto + ", nombre=" + nombre + ", cliente=" + cliente + ", f_inicio="
				+ f_inicio + ", presupuesto=" + presupuesto + "]";
	}
}
