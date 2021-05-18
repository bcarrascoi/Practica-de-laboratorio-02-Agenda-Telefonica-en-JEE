package ec.edu.ups.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOUsuario;
import ec.edu.ups.dao.PatronDAO;
import ec.edu.ups.pojo.Usuario;

/**
 * Servlet implementation class ControladorLogin
 */
@WebServlet("/ControladorLogin")
public class ControladorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;	
    public ControladorLogin() {
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String correo= request.getParameter("correo");
		String contrasena=request.getParameter("contrasena");
		
		DAOUsuario usuarioDao = PatronDAO.getPatronDAO().getUsuarioDAO();
		Usuario usuario = usuarioDao.buscarCorreo(correo,contrasena);
		
		try {
			String act = request.getParameter("action");
			if(act.equals("Iniciar Sesion")) {
				
				if(usuario != null) {
					request.getSession().setAttribute("correo",correo);
					response.sendRedirect("usuario_menu.html");
					//response.sendRedirect("listaTelefono.jsp");
				}else {
					request.setAttribute("error", "Aun no te has Registrado");
					response.sendRedirect("loginSesion.jsp");
				}
			}else if(act.equals("Registrarme")) {
				response.sendRedirect("/HTMLs/crear_usuario.html");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			out.println("error aqui: "+e );
		}
	}


}
