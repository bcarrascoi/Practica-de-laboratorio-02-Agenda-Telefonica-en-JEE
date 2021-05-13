package ec.edu.ups.conexion;

import ec.edu.ups.dao.GenericaDAOUsuario;

public abstract class ConexionGenericaDAOUsuario <T, Cedula> implements GenericaDAOUsuario<T, Cedula>{
	protected Conexion conexion = Conexion.getJDBC1();
}

