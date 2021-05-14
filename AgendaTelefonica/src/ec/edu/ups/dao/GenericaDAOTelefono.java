package ec.edu.ups.dao;

import java.util.List;

public interface GenericaDAOTelefono <T, ID> {

	public void createTable();

	public void create(T entity);

	public T read(Integer id);

	public void update(T entity);

	public void delete(T entity);

	public List<T> find();
	
}
