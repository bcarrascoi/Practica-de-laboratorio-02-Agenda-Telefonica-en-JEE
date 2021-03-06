package ec.edu.ups.dao;

import java.util.List;

public interface GenericaDAOUsuario <T, cedula> {

	public void createTable();
	
	public void create (T entity);
	
	public T read(String cedula);
	
	public T buscarCorreo(String correo, String contrasena);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public List<T> find(String cedula);
}
