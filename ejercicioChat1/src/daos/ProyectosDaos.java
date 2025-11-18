package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import modelos.Proyecto;

public class ProyectosDaos {
	private Connection con = null; //Crear una conexion a null
	private static ProyectosDaos instance = null; //Crear una instancia
	
	public ProyectosDaos() throws SQLException {
		con = Conexion.getConnection(); //Iniciamos el constructor
	}
	
	//Metodo para comprobar si la instancia esta creada
	public static ProyectosDaos getIntance() throws SQLException {
		if(instance == null) {
			instance = new ProyectosDaos();
		}
		return instance;
	}
	
	//Metodo para insertar proyectos en la BD
	public void insert(Proyecto p) throws SQLException {
		if(p.getId_proyecto() <= 0) {
			return;
		}
		
		PreparedStatement ps = con.prepareStatement("insert into (id_proyecto, nombre, cliente, f_inicio, presupuesto)"
				+ " values (?,?,?,?,?)");
		
		ps.setInt(1, p.getId_proyecto());
		ps.setString(2, p.getNombre());
		ps.setString(3, p.getCliente());
		ps.setDate(4, p.getF_inicio());
		ps.setDouble(5, p.getPresupuesto());
		
		ps.executeUpdate();
		ps.close();
	}
	
	//Metodo para listar todos los productos
	public List<Proyecto> findAll() throws SQLException {
		PreparedStatement ps = con.prepareStatement("select * from proyectos");
		
		ResultSet rs = ps.executeQuery();
		
		List<Proyecto> result = null;
		while(rs.next()) {
			if(result == null) {
				result = new ArrayList<Proyecto>();
			}
			
			result.add(new Proyecto(rs.getInt("id_proyecto"), rs.getString("nombre"), rs.getString("cliente"), 
					rs.getDate("f_inicio"), rs.getDouble("presupuesto")));
		}
		
		rs.close();
		ps.close();
		return result;
	}
	
	//Metodo para buscar proyecto por ID
	public Proyecto findByPk(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement("select * from proyectos where id_proyecto = ?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		Proyecto p = null;
		if(rs.next()) {
			p = new Proyecto(rs.getInt("id_proyecto"), rs.getString("nombre"), rs.getString("cliente"), 
					rs.getDate("f_inicio"), rs.getDouble("presupuesto"));
		}
		
		rs.close();
		ps.close();
		return p;
	}
	
	//Metodo para eliminar proyectos
	public void delete(int id) throws SQLException {
		if(id <= 0) {
			return;
		}
		
		PreparedStatement ps = con.prepareStatement("delete from proyectos where id_proyecto = ?");
		ps.setInt(1, id);
		actualizarIdProyectos(id);
		ps.executeUpdate();
		ps.close();
	}

	//Metodo para actualizar id_proyecto en empleados
	private void actualizarIdProyectos(int id) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = con.prepareStatement("update empleados set id_proyecto = null where id_proyecto = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}
	
	//Metodo para cerrar el programa
	public void cerrarPrograma() throws SQLException {
		con.close();
	}
}
