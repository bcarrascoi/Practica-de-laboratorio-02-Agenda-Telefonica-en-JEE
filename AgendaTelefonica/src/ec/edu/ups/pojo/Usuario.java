package ec.edu.ups.pojo;

import java.io.Serializable;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int usuario_codigo;
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String contrasena;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(int usuario_codigo, String cedula, String nombre, String apellido, String correo, String contrasena) {
		this.setUsuario_codigo(usuario_codigo);
		this.setCedula(cedula);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCorreo(correo);
		this.setContrasena(contrasena);
	}

	public int getUsuario_codigo() {
		return usuario_codigo;
	}
	public void setUsuario_codigo(int usuario_codigo) {
		this.usuario_codigo = usuario_codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
}
