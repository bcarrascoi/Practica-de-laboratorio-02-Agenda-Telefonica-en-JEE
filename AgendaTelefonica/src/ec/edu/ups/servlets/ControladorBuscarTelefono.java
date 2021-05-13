package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.PatronDAO;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.pojo.Telefono;

@WebServlet("/ControladorBuscarTelefono")
public class ControladorBuscarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TelefonoDAO telefonoDAO;
    private Telefono telefono;
    
    public ControladorBuscarTelefono() {
    telefonoDAO = PatronDAO.getPatronDAO().getTelefonoDAO();
    telefono = new Telefono();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = null;
		
		try {
			int codigo = Integer.valueOf(request.getParameter("codigo"));
			telefono = telefonoDAO.read(codigo);
			request.setAttribute("telefono", telefono);
			url= "/JSPs/buscar_telefono.jsp";
		}catch(Exception e) {
			url= "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	

}
