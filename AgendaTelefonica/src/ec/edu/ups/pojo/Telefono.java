package ec.edu.ups.pojo;

import java.io.Serializable;

public class Telefono implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String numeroTel;
	private String tipo;
	private String operadora;
	private Usuario usuario;
	
	public Telefono() {
		
	}
	public Telefono(int codigo, String numeroTel, String tipo, String operadora, Usuario usuario) {
		super();
		this.setCodigo(codigo);
		this.setNumeroTel(numeroTel);
		this.setTipo(tipo);
		this.setOperadora(operadora);
		this.setUsuario(usuario);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Telefono [codigo=" + codigo + ", numeroTel=" + numeroTel + ", tipo=" + tipo + ", operadora=" + operadora
				+ ", usuario=" + usuario + "]";
	}
	
	
	
}
