package ec.edu.ups.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.DAOTelefono;
import ec.edu.ups.pojo.Telefono;

public class ConexionDAOTelefono extends ConexionGenericaDAOTelefono<Telefono, Integer> implements DAOTelefono {

	@Override
	public void createTable() {
		conexion.update("DROP TABLE IF EXISTS Telefono");
		conexion.update("CREATE TABLE Telefono(`codigo` int(11) NOT NULL AUTO_INCREMENT,\r\n" + 
				"		  `numeroTel` varchar(20) CHARACTER SET utf8 NOT NULL,\r\n" + 
				"		  `tipo` varchar(20) CHARACTER SET utf8 NOT NULL,\r\n" + 
				"		  `operadora` varchar(20) CHARACTER SET utf8 NOT NULL,\r\n" + 
				"		  `usuario_cedula` varchar(10) CHARACTER SET utf8 NOT NULL,\r\n" + 
				"		  PRIMARY KEY (`codigo`),\r\n" + 
				"		  UNIQUE KEY `telefonos_UK` (`numeroTel`),\r\n" + 
				"		  KEY `telefonos_FK` (`usuario_cedula`),\r\n" + 
				"		  CONSTRAINT `telefonos_FK` FOREIGN KEY (`usuario_cedula`) REFERENCES `usuario` (`cedula`)\r\n" + 
				"		) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;\r\n");
	
	}

	@Override
	public void create(Telefono telefono, String cedulaUsuario) {
		conexion.update("INSERT Telefono VALUES ("+ telefono.getNumeroTel() + "', '"
				+ telefono.getTipo() + "', '" + telefono.getOperadora() + "', '"+ cedulaUsuario+"')");
	}
	
	
	@Override
	public Telefono read(Integer codigo) {
		Telefono telefono = null;
		ResultSet rs = conexion.query("SELECT * FROM Telefono WHERE codigo= " + codigo);
		try {
			if (rs != null && rs.next()) {
				telefono = new Telefono();
				telefono.setCodigo(rs.getInt("codigo"));
				telefono.setNumeroTel(rs.getString("numeroTel"));
				telefono.setTipo(rs.getString("tipo"));
				telefono.setOperadora(rs.getString("operadora"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error al buscar el codigo del telefono: " + e.getMessage());
		}
		return telefono;
	}

	@Override
	public void update(Telefono telefono) {
		conexion.update("UPDATE Telefono SET ='" + "numeroTel = '" +telefono.getNumeroTel()+ "', tipo = '"
				+ telefono.getTipo() + "', operadora = '" + telefono.getOperadora() + "', cedula = '"
				+ telefono.getUsuario().getCedula() + "' WHERE codigo = " + telefono.getCodigo());
	}

	@Override
	public void delete(Telefono codigo) {
		conexion.update("DELETE FROM Telefono WHERE codigo = " + codigo);
	}

	@Override
	public List<Telefono> listar(String tel) {
		List<Telefono> list = new ArrayList<>();
		ResultSet rs = conexion.query("SELECT * FROM Telefono where numeroTel = '"+ tel + "'" +
		"OR usuario_cedula = '" + tel + "' ");
		try {
			while (rs.next()) {
				Telefono telefono = new Telefono();
				telefono.setCodigo(rs.getInt("codigo"));
				telefono.setNumeroTel(rs.getString("numeroTel"));
				telefono.setTipo(rs.getString("tipo"));
				telefono.setOperadora(rs.getString("operadora"));
				list.add(telefono);
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL CONSULTAR LA LISTA DE TELEFONOS: " + e.getMessage());
		}
		return list;
	}

}
