package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import modelos.Empleado;

public class EmpleadosDaos {
	private Connection con = null;
	private static EmpleadosDaos instance = null;

	public EmpleadosDaos() throws SQLException {
		con = Conexion.getConnection();
	}

	public static EmpleadosDaos getInstance() throws SQLException {
		if (instance == null) {
			instance = new EmpleadosDaos();
		}
		return instance;
	}

	public void insert(Empleado e) throws SQLException {
		if (e.getIdEmpleado() <= 0) {
			return;
		}

		PreparedStatement ps = con.prepareStatement(
				"insert into (id_empleado, dni, nombre, puesto, salario, id_proyecto)" + " values(?,?,?,?,?,?)");

		ps.setInt(1, e.getIdEmpleado());
		ps.setString(2, e.getDni());
		ps.setString(3, e.getNombre());
		ps.setString(4, e.getPuesto());
		ps.setDouble(5, e.getSalario());
		ps.setInt(6, e.getId_proyecto());

		ps.executeUpdate();
		ps.close();
	}

	public void actualizarSalarioPorId(Empleado e) throws SQLException {
		if (e.getIdEmpleado() <= 0) {
			return;
		}

		PreparedStatement ps = con.prepareStatement("update empleados set salario = ? where id_empleado = ?");
		ps.setInt(2, e.getIdEmpleado());
		ps.setDouble(1, e.getSalario());

		ps.executeUpdate();
		ps.close();
	}

	public List<Empleado> findAll() throws SQLException {
		PreparedStatement ps = con.prepareStatement("select * from empleados");
		ResultSet rs = ps.executeQuery();
		List<Empleado> empleados = null;

		while (rs.next()) {
			empleados.add(new Empleado(rs.getInt("id_empleado"), rs.getString("dni"), rs.getString("nombre"),
					rs.getString("puesto"), rs.getDouble("salario"), rs.getInt("id_proyecto")));
		}

		rs.close();
		ps.close();
		return empleados;
	}

	public void delete(int id) throws SQLException {
		if (id <= 0) {
			return;
		}

		PreparedStatement ps = con.prepareStatement("delete from empleados where id_empleado = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}

	public List<Empleado> findBySalarioMinimo(double salario) throws SQLException {
		PreparedStatement ps = con.prepareStatement("select * from empleados where salario >= ?");
		ps.setDouble(1, salario);
		List<Empleado> e = null;
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			if (e == null) {
				e = new ArrayList<Empleado>();
			}

			e.add(new Empleado(rs.getInt("id_empleado"), rs.getString("dni"), rs.getString("nombre"),
					rs.getString("puesto"), rs.getDouble("salario"), rs.getInt("id_proyecto")));
		}
		
		rs.close();
		ps.close();
		return e;
	}
}
