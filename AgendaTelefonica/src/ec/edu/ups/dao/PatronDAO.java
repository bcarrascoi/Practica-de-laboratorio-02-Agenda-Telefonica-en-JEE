package ec.edu.ups.dao;

public abstract class PatronDAO {

	protected static PatronDAO patron = new ConexionPatronDAO();
	
	public static PatronDAO getPatronDAO() {
		return patron;
	}
	
	public abstract void createTables();
	
	public abstract DAOUsuario getUsuarioDAO();
	
	public abstract DAOTelefono getTelefonoDAO();

}
