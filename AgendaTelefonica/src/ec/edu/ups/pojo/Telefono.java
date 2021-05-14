package ec.edu.ups.pojo;

import java.io.Serializable;

public class Telefono implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String numeroTel;
	private String tipo;
	private String operadora;
	private int usuario_id;
	
	public Telefono() {
		
	}

	public Telefono(int codigo, String numeroTel, String tipo, String operadora, int usuario_id) {
		this.setCodigo(codigo);
		this.setNumeroTel(numeroTel);
		this.setTipo(tipo);
		this.setOperadora(operadora);
		this.setUsuario_id(usuario_id);
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
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	@Override
	public String toString() {
		return "Telefono [codigo=" + codigo + ", numeroTel=" + numeroTel + ", tipo=" + tipo + ", operadora=" + operadora
				+ ", usuario_id=" + usuario_id + "]";
	}
	
	
	
}
