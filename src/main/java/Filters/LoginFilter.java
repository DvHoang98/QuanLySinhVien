package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class HelloFilter
 */
@WebFilter(
		{"/SinhVien","/SinhVien/*","/Lop","/Lop/*",
			"/ChuyenNganh","/ChuyenNganh/*","/SinhVienLop","/SinhVienLop/*","/Mon","/Mon/*"})
public class LoginFilter extends HttpFilter implements Filter {
       

    public LoginFilter() {
        
    }

	public void destroy() {
		System.out.println("HelloFilter@destroy");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = rq.getSession(false);
//        String loginURI = rq.getContextPath() + "/login";
        boolean loggedIn = session != null && session.getAttribute("user") != null;
//        boolean loginRequest = rq.getRequestURI().equals(loginURI);

        if (loggedIn 
//        		|| loginRequest
        		) {
            chain.doFilter(request, response);
        } else {
        	System.out.println("chưa vào chuyển tiếp");
            res.sendRedirect("/Lab4_hoangdvph18776/login");
        }
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
