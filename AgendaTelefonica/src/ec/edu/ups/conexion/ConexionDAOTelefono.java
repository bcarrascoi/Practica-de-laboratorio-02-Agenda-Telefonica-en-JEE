package ec.edu.ups.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.pojo.Telefono;

public class ConexionDAOTelefono extends ConexionGenericaDAOTelefono<Telefono, Integer>implements TelefonoDAO{

	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS Telefono");
		conexion.update("CREATE TABLE Telefono (codigo INT NOT NULL , numeroTel VARCHAR(10), tipo VARCHAR (255), operadora VARCHAR(255) ,PRIMARY KEY(codigo))");
	}
	
	@Override
	public void create(Telefono telefono) {
		conexion.update("INSERT Telefono VALUES (" + telefono.getCodigo()+ ", '" + telefono.getNumeroTel() + "', '"
				+ telefono.getTipo()+"', '" + telefono.getOperadora()+ "', ' " + telefono.getUsuario_id() + "')");
		
	}


		
	
	@Override
	public Telefono read(Integer codigo) {
		Telefono telefono = null;
		ResultSet rs = conexion.query("SELECT * FROM Telefono WHERE codigo= "+ codigo);
		try {
			if(rs != null && rs.next()) {
				telefono = new Telefono(rs.getInt("codigo"), rs.getString("numeroTel"), rs.getString("tipo"),
				rs.getString("operadora"), rs.getInt("usuario_id"));	
			}
		}catch(SQLException e) {
			System.out.println("(ConexionDAOTelefono:read): " + e.getMessage());
		}
		return telefono;
	}

	@Override
	public void update(Telefono telefono) {
		conexion.update("UPDATE Telefono SET numeroTel ='" + telefono.getNumeroTel()
		+ "', tipo = '"+ telefono.getTipo() + "', operadora = '" + telefono.getOperadora() + "', usuario_id = '" + telefono.getUsuario_id()+ "' WHERE numeroTel = " + telefono.getNumeroTel());
	}

	@Override
	public void delete(Telefono telefono) {
		conexion.update("DELETE FROM Telefono WHERE numeroTel = " + telefono.getNumeroTel());
	}

	@Override
	public List<Telefono> find() {
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = conexion.query("SELECT * FROM Telefono f,Usuario u WHERE f.usuario_id = u.usuario_codigo");
		try {
			while (rs.next()) {
				list.add(new Telefono(rs.getInt("codigo"), rs.getString("numeroTel"),rs.getString("tipo"),
						rs.getString("operadora"), rs.getInt("usuario_id")));
			}
		} catch (SQLException e) {
			System.out.println("ConexionDAOTelefono:find: " + e.getMessage());
		}
		return list;
	}

	
}
