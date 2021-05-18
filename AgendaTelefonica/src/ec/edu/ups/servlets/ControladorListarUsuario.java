package ec.edu.ups.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.PatronDAO;
import ec.edu.ups.dao.DAOUsuario;
import ec.edu.ups.pojo.Usuario;

@WebServlet("/ControladorListarUsuario")
public class ControladorListarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOUsuario usuarioDAO;
	private List<Usuario> listaUsuario;
	
    public ControladorListarUsuario() {
       usuarioDAO = PatronDAO.getPatronDAO().getUsuarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String url = null;
    	String cedula = request.getParameter("cedula");
    	try {
    		listaUsuario = usuarioDAO.find(cedula);
    		System.out.println("USUARIOS EXISTENTES: " + listaUsuario.size());
    		request.setAttribute("usuarios", listaUsuario);
    		url = "/JSPs/listar_usuario.jsp";
    	}catch(Exception e) {
    		url = "/JSPs/error_admin.jsp";
    	}
    	getServletContext().getRequestDispatcher(url).forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
