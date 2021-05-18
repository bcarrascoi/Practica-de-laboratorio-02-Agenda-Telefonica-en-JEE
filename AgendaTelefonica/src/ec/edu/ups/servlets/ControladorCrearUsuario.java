package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ec.edu.ups.dao.PatronDAO;
import ec.edu.ups.dao.DAOUsuario;
import ec.edu.ups.pojo.Usuario;

@WebServlet("/ControladorCrearUsuario")
public class ControladorCrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOUsuario usuarioDAO;
	private Usuario usuario;
	
	public ControladorCrearUsuario() {
		usuarioDAO = PatronDAO.getPatronDAO().getUsuarioDAO();
		usuario = new Usuario();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = null;
		try {
					usuario.setCedula(request.getParameter("cedula"));
					usuario.setNombre(request.getParameter("nombre"));
					usuario.setApellido(request.getParameter("apellido"));
					usuario.setCorreo(request.getParameter("correo"));
					usuario.setContrasena(request.getParameter("contrasena"));
			usuarioDAO.create(usuario);
			url= "/usuario_menu.html";
		}catch(Exception e) {
			url= "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	
}