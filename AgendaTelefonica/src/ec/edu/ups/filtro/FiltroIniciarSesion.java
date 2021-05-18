package ec.edu.ups.filtro;

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
 * Servlet Filter implementation class FiltroIniciarSesion
 */
@WebFilter("/listaTelefono.jsp")
public class FiltroIniciarSesion implements Filter {

    public FiltroIniciarSesion() {
    }

	public void init(FilterConfig fConfig) throws ServletException {
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session= ((HttpServletRequest) request).getSession();
		if(session.getAttribute("correo")==null) {
			((HttpServletResponse) response).sendRedirect("loginSesion.jsp");
		}else {
			chain.doFilter(request, response);
		}
	        
	}
	public void destroy() {
		
	
	}
}
