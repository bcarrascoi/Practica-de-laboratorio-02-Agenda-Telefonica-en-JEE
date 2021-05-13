package ec.edu.ups.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.pojo.Usuario;

public class ConexionDAOUsuario extends ConexionGenericaDAOUsuario<Usuario, String> implements UsuarioDAO {
	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS Usuario");
		conexion.update("CREATE TABLE Usuario (" + "CEDULA NOT NULL, " + "NOMBRE VARCHAR(255), APELLIDO VARCHAR(255)" 
				+ "CORREO VARCHAR(255), CONTRASENA(255)"
				+ ", PRIMARY KEY (CEDULA))");
	}

	@Override
	public void create(Usuario usuario) {
		conexion.update("INSERT Usuario VALUES (" + usuario.getCedula() + "', '" + usuario.getNombre() + "', '"
				+ usuario.getApellido() + "', '" + usuario.getCorreo() + "', '" + usuario.getContrasena() + "')");
	}

	@Override
	public Usuario read(String cedula) {
		Usuario usuario = null;
		ResultSet rs = conexion.query("SELECT * FROM Usuario WHERE cedula=" + cedula);
		try {
			if (rs != null && rs.next()) {
				usuario = new Usuario(rs.getString("cedula"), rs.getString("nombre"), rs.getString("apellido"),
						rs.getString("correo"), rs.getString("contrasena"));
			}
		} catch (SQLException e) {
			System.out.println("(ConexionDAO:read): " + e.getMessage());
		}
		return usuario;
	}

	@Override
	public void update(Usuario usuario) {
		conexion.update("UPDATE Usuario SET nombre = '" + usuario.getNombre()
				+ "', apellido = '" + usuario.getApellido() + "', correo = '" + usuario.getCorreo()
				+ "', contrasena = '" + usuario.getContrasena() + "' WHERE cedula = " + usuario.getCedula());
	}

	@Override
	public void delete(Usuario usuario) {
		conexion.update("DELETE FROM Persona WHERE cedula = " + usuario.getCedula());
	}

	@Override
	public List<Usuario> find() {
		List<Usuario> list = new ArrayList<Usuario>();
		ResultSet rs = conexion.query("SELECT * FROM Usuario");
		try {
			while (rs.next()) {
				list.add(new Usuario(rs.getString("cedula"), rs.getString("nombre"),
						rs.getString("apellido"), rs.getString("correo"), rs.getString("contrasena")));
			}

		} catch (SQLException e) {
			System.out.println("ConexionDAO:find: " + e.getMessage());
		}
		return list;
	}
}
