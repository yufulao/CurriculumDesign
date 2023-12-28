package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginFilter implements Filter {
	// 登录验证的过滤器

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;// 强转
		// 不需要拦截的文件路径
		String[] urls = { "/loginUser.jsp","/loginAdmin.jsp","/loginRole.jsp", "/loginServlet", "/register.jsp", "/registerServlet", "/imgs", "/css",
				"/ajaxRegistServlet", "/file.jsp", "/uploadServlet", "/downloadServlet", "/download.jsp" ,"/test"};
		// 获取当前资源路径
		String url = req.getRequestURL().toString();
		// 遍历查找
		for (String u : urls) {
			if (url.contains(u)) {
				chain.doFilter(request, response);// 放行
				return;
			}
		}

		// 获取session里有没有user
		HttpSession session = req.getSession();
		Object user = session.getAttribute("user");
		if (user != null) {
			// 登录过了
			chain.doFilter(request, response);// 放行
		} else {
			// 没登录，传入提示话，跳转到登录页面
			req.setAttribute("login_msg", "未登录状态");
			req.getRequestDispatcher("/loginUser.jsp").forward(req, response);
		}
	}

	@Override
	public void destroy() {

	}

}
