package v2.com.company.payroll.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String logInURI = req.getContextPath() + "/user-login";
		
		HttpSession session = req.getSession();
		
		boolean loggedIn = session != null;
		boolean loginRequest = req.getRequestURI().equals(logInURI);
		if(loggedIn || loginRequest) {
			chain.doFilter(request, response);
		} else {
			resp.sendRedirect(logInURI);
		}
	}
}