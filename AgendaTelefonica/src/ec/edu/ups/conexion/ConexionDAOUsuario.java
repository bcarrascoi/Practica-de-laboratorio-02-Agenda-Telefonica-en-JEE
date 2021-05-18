package ec.edu.ups.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ec.edu.ups.dao.DAOUsuario;
import ec.edu.ups.pojo.Usuario;

public class ConexionDAOUsuario extends ConexionGenericaDAOUsuario<Usuario, String> implements DAOUsuario {

	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS Usuario");
		conexion.update("CREATE TABLE Usuario (\r\n" + "	  `cedula` varchar(10) CHARACTER SET utf8 NOT NULL,\r\n"
				+ "	  `nombre` varchar(30) CHARACTER SET utf8 NOT NULL,\r\n"
				+ "	  `apellido` varchar(30) CHARACTER SET utf8 NOT NULL,\r\n"
				+ "	  `correo` varchar(255) CHARACTER SET utf8 NOT NULL,\r\n"
				+ "	  `contrasena` varchar(255) CHARACTER SET utf8 NOT NULL,\r\n" + "	  PRIMARY KEY (`cedula`),\r\n"
				+ "	  UNIQUE KEY `usuarios_UN` (`correo`,`cedula`)\r\n"
				+ "	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;");
	}

	@Override
	public void create(Usuario usuario) {
		conexion.update("INSERT Usuario VALUES (" + usuario.getCedula() + ", '" + usuario.getNombre() + "', '"
				+ usuario.getApellido() + "', '" + usuario.getCorreo() + "', '" + usuario.getContrasena() + "')");
	}

	@Override
	public Usuario read(String cedula) {
		Usuario usuario = null;
		ResultSet rs = conexion.query("SELECT * FROM Usuario WHERE cedula=" + cedula);
		try {
			if (rs != null && rs.next()) {
				ConexionDAOTelefono daoTelefono = new ConexionDAOTelefono();
				usuario = new Usuario();
				usuario.setCedula(cedula);
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setContrasena(rs.getString("contrasena"));
				usuario.setTelefonos(daoTelefono.listar(cedula));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error al buscar por cédula: " + e.getMessage());
		}
		return usuario;
	}

	@Override
	public Usuario buscarCorreo(String correo, String contrasena) {
		Usuario usuario = null;
		ResultSet rs = conexion.query("SELECT * FROM Usuario WHERE correo ='" + correo + "'");
		try {
			if (rs != null && rs.next()) {
				ConexionDAOTelefono daoTelefono = new ConexionDAOTelefono();
				usuario = new Usuario();
				usuario.setCedula(rs.getString("cedula"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setCorreo(correo);
				usuario.setContrasena(contrasena);
				usuario.setTelefonos(daoTelefono.listar(rs.getString("cedula")));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error al buscar por cédula: " + e.getMessage());
		}
		return usuario;
	}

	@Override
	public void update(Usuario usuario) {
		conexion.update("UPDATE Usuario SET nombre= '" + usuario.getNombre() + "', apellido = '" + usuario.getApellido()
				+ "', correo = '" + usuario.getCorreo() + "', contrasena = '" + usuario.getContrasena()
				+ "' WHERE cedula = " + usuario.getCedula());
	}

	@Override
	public void delete(Usuario usuario) {
		conexion.update("DELETE FROM Usuario WHERE cedula = " + usuario.getCedula());
	}

	
	/*
	 * @Override public List<Usuario> find (String cedula) { List<Usuario> list =
	 * new ArrayList<>(); ResultSet rs =
	 * conexion.query("SELECT * FROM Usuario where cedula = '"+ cedula + "'"); try {
	 * while (rs.next()) { Usuario usuario = new Usuario();
	 * usuario.setCedula(cedula); usuario.setNombre(rs.getString("nombre"));
	 * usuario.setApellido(rs.getString("apellido"));
	 * usuario.setCorreo(rs.getString("correo"));
	 * usuario.setContrasena(rs.getString("contrasena")); list.add(usuario); }
	 * rs.close(); } catch (SQLException e) {
	 * System.out.println("ERROR AL CONSULTAR LA LISTA DE USUARIOS: " +
	 * e.getMessage()); } return list; }
	 */

	@Override
	public List<Usuario> find(String cedula) {
		List<Usuario> list = new ArrayList<Usuario>();
		ResultSet rs = conexion.query("SELECT * FROM Usuario where numero = '" + cedula);
		try {
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setCedula(cedula);
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellido(rs.getString("apellido"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setContrasena(rs.getString("contrasena"));
				list.add(usuario);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("" + e.getMessage());
		}
		return list;
	}
}
