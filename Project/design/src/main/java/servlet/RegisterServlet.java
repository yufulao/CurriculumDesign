package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import service.UserService;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接受用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Integer userSid = 0;
		String userEmail = request.getParameter("userEmail");
		Integer userTel = 0;
		String userIdentityCard = request.getParameter("userIdentityCard");
		String userIntroduction = request.getParameter("userIntroduction");
		
		if (password==null||password=="") {
			RegisterFail("password_msg","密码为空",request,response);
			return;
		}
		try {
		    userSid = Integer.parseInt(request.getParameter("userSid"));
		} catch (NumberFormatException e) {
			RegisterFail("userSid_msg","学号不合规，需要是数字且不大于10位",request,response);
			return;
		}
		if (userEmail==null||userEmail=="") {
			RegisterFail("userEmail_msg","邮箱为空",request,response);
			return;
		}
		try {
			userTel = Integer.parseInt(request.getParameter("userTel"));
		} catch (NumberFormatException e) {
			RegisterFail("userTel_msg","电话不合规，需要是数字且不大于10位",request,response);
			return;
		}
		if (userIdentityCard==null||userIdentityCard=="") {
			RegisterFail("userIdentityCard_msg","身份证号为空",request,response);
			return;
		}
		
		User user=new User();
		user.setUserName(username);
		user.setUserPassword(password);
		user.setUserSid(userSid);
		user.setUserEmail(userEmail);
		user.setUserTel(userTel);
		user.setUserIdentityCard(userIdentityCard);
		user.setUserIntroduction(userIntroduction);
		boolean isSuccess= userService.Register(user);
		
		if (isSuccess) {
			//传入注册成功提示话
			request.setAttribute("register_msg", "注册成功");
			//跳转login.jsp页面
			request.getRequestDispatcher("/loginUser.jsp").forward(request, response);
		}
		else {
			//跳转失败，跳转回register.jsp页面
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	private void RegisterFail(String msgKey,String msgValue,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//request.setAttribute("register_msg", "用户名已存在");
		request.setAttribute(msgKey, msgValue);
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

}
