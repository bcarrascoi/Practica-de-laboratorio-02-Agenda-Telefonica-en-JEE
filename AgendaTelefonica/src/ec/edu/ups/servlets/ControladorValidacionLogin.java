package ec.edu.ups.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class ControladorValidacionLogin
 */
@WebFilter("/ControladorValidacionLogin")
public class ControladorValidacionLogin implements Filter {

	public ControladorValidacionLogin() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpSession sesion = ((HttpServletRequest) request).getSession();

		if (sesion.getAttribute("usuario") != null) {

			chain.doFilter(request, response);

		} else {

			((HttpServletResponse) response).sendRedirect("/Calculadora/error.html");
			destroy();
		}
	}

	public void destroy() {
		System.out.println("Se ha destruido el filtro...");
	}

}
