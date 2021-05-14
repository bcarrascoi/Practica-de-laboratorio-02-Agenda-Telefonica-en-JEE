package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.PatronDAO;
import ec.edu.ups.dao.TelefonoDAO;

@WebServlet("/ControladorCrearTablaTelefono")
public class ControladorCrearTablaTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TelefonoDAO telefonoDAO;
    
    public ControladorCrearTablaTelefono() {
    	telefonoDAO = PatronDAO.getPatronDAO().getTelefonoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = null;
		try {
			telefonoDAO.createTable();
			url="/index.html";
		}catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
