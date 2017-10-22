package filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
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

import com.e_Look.member.model.MemberVO;

/**
 * Servlet Filter implementation class CreateCourseFilter
 */
@WebFilter(filterName = "CreateCourseFilter", dispatcherTypes = { DispatcherType.REQUEST })
public class CreateCourseFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		if (req instanceof HttpServletRequest && resp instanceof HttpServletResponse) {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) resp;
			if(request.getServletPath().indexOf("CreateCourse.jsp")!=-1||request.getServletPath().indexOf("member")!=-1){
				HttpSession session = request.getSession();
				MemberVO memberVO=(MemberVO)session.getAttribute("LoginOK");
				if(memberVO==null){
					session.setAttribute("loginerr", "123");
					response.sendRedirect(request.getHeader("referer"));
				}else{
					
					chain.doFilter(request, response);
				}
			}else { 
			chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}