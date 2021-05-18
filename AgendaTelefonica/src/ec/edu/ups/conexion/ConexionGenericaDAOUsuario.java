package ec.edu.ups.conexion;

import ec.edu.ups.dao.GenericaDAOUsuario;

public abstract class ConexionGenericaDAOUsuario <T, cedula> implements GenericaDAOUsuario<T, String>{
	protected Conexion conexion = Conexion.getJDBC1();
}

