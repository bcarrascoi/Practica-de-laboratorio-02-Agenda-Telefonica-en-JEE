package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.PatronDAO;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.pojo.Telefono;
import ec.edu.ups.pojo.Usuario;

@WebServlet("/ControladorCrearTelefono")
public class ControladorCrearTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TelefonoDAO telefonoDAO;
	private Telefono telefono;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	public ControladorCrearTelefono() {
		telefonoDAO = PatronDAO.getPatronDAO().getTelefonoDAO();
		telefono = new Telefono();
		usuarioDAO = PatronDAO.getPatronDAO().getUsuarioDAO();
		usuario = new Usuario();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//int codigo= telefonoDao.contadorTelefono()+1;//+1;
		String url = null;
		String cedula = request.getParameter("cedula");
		usuario = usuarioDAO.read(cedula);
		System.out.println(usuario.getUsuario_codigo());
		try {
			telefono.setUsuario_id(usuario.getUsuario_codigo());
			telefono.setCodigo(Integer.valueOf(request.getParameter("codigo")));
			telefono.setNumeroTel(request.getParameter("numeroTel"));
			telefono.setTipo(request.getParameter("tipo"));
			telefono.setOperadora(request.getParameter("operadora"));
		
				
			//Telefono telefono=new Telefono(Integer.valueOf(request.getParameter("codigo")), request.getParameter("numeroTel"), request.getParameter("tipo"), request.getParameter("operadora"), usuario.getUsuario_codigo());
				telefonoDAO.create(telefono);
				response.sendRedirect("/index.html");
				System.out.println("Guardar" + telefono);
			
		}catch(Exception e ) {
			url= "/JSPs/error.jsp";
		}
}

}