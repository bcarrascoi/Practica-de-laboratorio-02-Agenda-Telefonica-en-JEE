package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.PatronDAO;
import ec.edu.ups.dao.UsuarioDAO;

@WebServlet("/ControladorCrearTabla")
public class ControladorCrearTabla extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO;
    
    public ControladorCrearTabla() {
    	usuarioDAO = PatronDAO.getPatronDAO().getUsuarioDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = null;
		try {
			usuarioDAO.createTable();
			url="/index.html";
		}catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
