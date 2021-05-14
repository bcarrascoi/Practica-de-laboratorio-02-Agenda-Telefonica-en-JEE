package ec.edu.ups.conexion;

import ec.edu.ups.dao.GenericaDAOUsuario;

public abstract class ConexionGenericaDAOUsuario <T, ID> implements GenericaDAOUsuario<T, ID>{
	protected Conexion conexion = Conexion.getJDBC1();
}

