package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Activity;
import pojo.Gamer;
import service.ActivityService;
import service.GameService;

@WebServlet("/mainViewRoleServlet")
public class MainViewRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ActivityService activityService=new ActivityService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//转发到MainViewAdmin.jsp
		request.getRequestDispatcher("/MainViewRole.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
