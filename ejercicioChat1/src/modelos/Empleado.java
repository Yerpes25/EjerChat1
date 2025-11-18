package modelos;

public class Empleado {
	private int idEmpleado;
	private String dni;
	private String nombre;
	private String puesto;
	private double salario;
	private int id_proyecto;
	
	public Empleado(int idEmpleado, String dni, String nombre, String puesto, double salario, int id_proyecto) {
		super();
		this.idEmpleado = idEmpleado;
		this.dni = dni;
		this.nombre = nombre;
		this.puesto = puesto;
		this.salario = salario;
		this.id_proyecto = id_proyecto;
	}

	public Empleado() {
		super();
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(int id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", puesto=" + puesto + ", salario=" + salario
				+ ", id_proyecto=" + id_proyecto + "]";
	}
	
	
}
