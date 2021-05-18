package ec.edu.ups.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.PatronDAO;
import ec.edu.ups.dao.DAOTelefono;
import ec.edu.ups.pojo.Telefono;


@WebServlet("/ControladorListarTelefono")
public class ControladorListarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOTelefono telefonoDAO;
	private List<Telefono> listaTelefono;

    public ControladorListarTelefono() {
    	telefonoDAO = PatronDAO.getPatronDAO().getTelefonoDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String codigo = request.getParameter("codigo");
		try {
			listaTelefono = telefonoDAO.listar(codigo);
			System.out.println("TELEFONOS EXISTENTES: " + listaTelefono.size());
			request.setAttribute("telefono", listaTelefono);
			url= "/JSPs/listar_telefono.jsp";
		}catch(Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
