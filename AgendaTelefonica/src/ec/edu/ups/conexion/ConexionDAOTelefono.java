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
		conexion.update("CREATE TABLE Telefono (codigo INT NOT NULL , numero VARCHAR(10), tipo VARCHAR (255), operadora VARCHAR(255) ,PRIMARY KEY(codigo))");
	}
	
	@Override
	public void create(Telefono telefono) {
		conexion.update("INSERT Telefono VALUES (" + telefono.getCodigo()+ ", '" + telefono.getNumeroTel() + "', '"
				+ telefono.getTipo()+"', '" + telefono.getOperadora()+ "')");
		
	}

	@Override
	public Telefono read(Integer codigo) {
		Telefono telefono = null;
		ResultSet rs = conexion.query("SELECT * FROM Telefono WHERE codigo= "+ codigo);
		try {
			if(rs != null && rs.next()) {
				telefono = new Telefono(rs.getInt("codigo"), rs.getString("numero"), rs.getString("tipo"),
				rs.getString("operadora"));	
			}
		}catch(SQLException e) {
			System.out.println("(ConexionDAOTelefono:read): " + e.getMessage());
		}
		return telefono;
	}

	@Override
	public void update(Telefono telefono) {
		conexion.update("UPDATE Telefono SET numero ='" + telefono.getNumeroTel()
		+ "', tipo = '"+ telefono.getTipo() + "', operadora = '" + telefono.getOperadora() + "' WHERE codigo = " + telefono.getCodigo());
	}

	@Override
	public void delete(Telefono telefono) {
		conexion.update("DELETE FROM Telefono WHERE codigo = " + telefono.getCodigo());
		
	}

	@Override
	public List<Telefono> find() {
		List<Telefono> list = new ArrayList<Telefono>();
		ResultSet rs = conexion.query("SELECT * FROM Telefono");
		try {
			while (rs.next()) {
				list.add(new Telefono(rs.getInt("codigo"), rs.getString("numero"),rs.getString("tipo"),
						rs.getString("operadora")));
			}
		} catch (SQLException e) {
			System.out.println("ConexionDAOTelefono:find: " + e.getMessage());
		}
		return list;
	}

	
}
