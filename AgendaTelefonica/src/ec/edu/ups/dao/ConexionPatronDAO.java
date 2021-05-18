package ec.edu.ups.dao;

import ec.edu.ups.conexion.ConexionDAOUsuario;
import ec.edu.ups.conexion.ConexionDAOTelefono;

public class ConexionPatronDAO extends PatronDAO {

	@Override
	public void createTables() {
		this.getUsuarioDAO().createTable();
		this.getTelefonoDAO().createTable();
	}
	
	@Override
	public DAOUsuario getUsuarioDAO() {
		return new ConexionDAOUsuario();
	}
	
	@Override
	public DAOTelefono getTelefonoDAO() {
		return new ConexionDAOTelefono();
	}
}
