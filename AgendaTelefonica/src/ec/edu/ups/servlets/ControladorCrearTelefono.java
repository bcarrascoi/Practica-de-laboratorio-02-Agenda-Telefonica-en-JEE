package ec.edu.ups.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.conexion.ConexionDAOTelefono;
import ec.edu.ups.dao.ConexionPatronDAO;
import ec.edu.ups.dao.PatronDAO;
import ec.edu.ups.pojo.Telefono;
import ec.edu.ups.pojo.Usuario;

@WebServlet("/ControladorCrearTelefono")
public class ControladorCrearTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ControladorCrearTelefono() {

		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	//String url = null;
		try {
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			ConexionDAOTelefono daoTelefono = new ConexionDAOTelefono();
			Telefono telefono = new Telefono();
			telefono.setNumeroTel(request.getParameter("numeroTel"));
			telefono.setTipo(request.getParameter("tipo"));
			telefono.setOperadora(request.getParameter("operadora"));
			daoTelefono.create(telefono, usuario.getCedula());
			request.setAttribute("mensaje", "CREADO OK");
			System.out.println("CREADO OK");
		} catch (Exception e) {
			request.setAttribute("mensaje", "ERROR");
			System.out.println("ERROR AL CREAR");
		}
		request.getRequestDispatcher("/JSPs/crear_telefono.jsp").forward(request, response);
	}

	
	}