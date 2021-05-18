package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.conexion.ConexionDAOUsuario;
import ec.edu.ups.pojo.Usuario;

/**
 * Servlet implementation class ControladorInicioTelefono
 */
@WebServlet("/ControladorInicioTelefono")
public class ControladorInicioTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControladorInicioTelefono() {
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
    	usuario = new ConexionDAOUsuario().read(usuario.getCedula());
    	sesion.setAttribute("usuario", usuario);
    	response.sendRedirect("/AgendaTelefonica/listaTelefono.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
