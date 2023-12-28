package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Admin;
import pojo.Role;
import pojo.User;
import service.AdminService;
import service.RoleService;
import service.UserService;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private RoleService roleService = new RoleService();
	private AdminService adminService = new AdminService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接受用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		String loginType=request.getParameter("loginType");
		//System.out.println(username+"  "+password+"  "+loginType);
		
		// 调用service
		if (loginType.equals("user")) {
			User user = userService.Login(username, password);
			if (user != null) {
				// 登录成功
				//判断是否勾选复选框
				if ("1".equals(remember)) {
					//勾选了，发送cookie
					Cookie usernameCookie=new Cookie("username", username);
					Cookie passwordCookie=new Cookie("password", password);
					usernameCookie.setMaxAge(60*60*24*7);
					passwordCookie.setMaxAge(60*60*24*7);
					response.addCookie(usernameCookie);
					response.addCookie(passwordCookie);
				}
				//把user存到session
				HttpSession session = request.getSession();
				session.setAttribute("user", user);// json格式
				// 跳转到newServlet
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/mainViewUserServlet");
			} else {
				// 登录失败
				// 将登录失败的话存到request
				request.setAttribute("login_msg", "用户名密码错误");
				// 跳转回login页面
				request.getRequestDispatcher("/loginUser.jsp").forward(request, response);
			}
		}
		
		if (loginType.equals("admin")) {
			Admin user = adminService.Login(username, password);
			if (user != null) {
				// 登录成功
				//判断是否勾选复选框
				if ("1".equals(remember)) {
					//勾选了，发送cookie
					Cookie usernameCookie=new Cookie("username", username);
					Cookie passwordCookie=new Cookie("password", password);
					usernameCookie.setMaxAge(60*60*24*7);
					passwordCookie.setMaxAge(60*60*24*7);
					response.addCookie(usernameCookie);
					response.addCookie(passwordCookie);
				}
				//把user存到session
				HttpSession session = request.getSession();
				session.setAttribute("user", user);// json格式
				// 跳转到newServlet
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/mainViewAdminServlet");
			} else {
				// 登录失败
				// 将登录失败的话存到request
				request.setAttribute("login_msg", "用户名密码错误");
				// 跳转回login页面
				request.getRequestDispatcher("/loginAdmin.jsp").forward(request, response);
				return;
			}
		}
		
		if (loginType.equals("role")) {
			//System.out.println(username+"  "+password);
			Role user = roleService.Login(username, password);
			if (user != null) {
				// 登录成功
				//判断是否勾选复选框
				if ("1".equals(remember)) {
					//勾选了，发送cookie
					Cookie usernameCookie=new Cookie("username", username);
					Cookie passwordCookie=new Cookie("password", password);
					usernameCookie.setMaxAge(60*60*24*7);
					passwordCookie.setMaxAge(60*60*24*7);
					response.addCookie(usernameCookie);
					response.addCookie(passwordCookie);
				}
				//把user存到session
				HttpSession session = request.getSession();
				session.setAttribute("user", user);// json格式
				// 跳转到newServlet
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/mainViewRoleServlet");
			} else {
				// 登录失败
				// 将登录失败的话存到request
				request.setAttribute("login_msg", "用户名密码错误");
				// 跳转回login页面
				request.getRequestDispatcher("/loginRole.jsp").forward(request, response);
				return;
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
