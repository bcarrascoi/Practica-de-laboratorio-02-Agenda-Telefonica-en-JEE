package ec.edu.ups.conexion;

import ec.edu.ups.dao.GenericaDAOTelefono;

public abstract class ConexionGenericaDAOTelefono <T, ID> implements GenericaDAOTelefono<T, ID>{
	protected Conexion conexion = Conexion.getJDBC1();

}
