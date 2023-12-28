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

@WebServlet("/mainViewAdminServlet")
public class MainViewAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ActivityService activityService=new ActivityService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取数据库的排行榜
		Activity[] activities=activityService.GetNoPassedActivity();
		request.setAttribute("activities", activities);
		//转发到MainViewAdmin.jsp
		request.getRequestDispatcher("/MainViewAdmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
