package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.PatronDAO;
import ec.edu.ups.dao.DAOTelefono;
import ec.edu.ups.pojo.Telefono;

@WebServlet("/ControladorEliminarTelefono")
public class ControladorEliminarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DAOTelefono telefonoDAO; 
    private Telefono telefono;
   
    public ControladorEliminarTelefono() {
        telefonoDAO = PatronDAO.getPatronDAO().getTelefonoDAO();
        telefono = new Telefono();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = null;
	try {
		telefono.setCodigo(Integer.valueOf(request.getParameter("codigo")));
		telefonoDAO.delete(telefono);
		url = "/usuario_menu.html";
	}catch(Exception e) {
		url = "/JSPs/error.jsp";
	}
	getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
