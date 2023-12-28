package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mapper.UserMapper;
import pojo.SqlSessionFactoryUtil;
import pojo.User;
import service.ActivityService;

@WebServlet(urlPatterns = "/ajaxPassActivityServlet")
public class AjaxPassActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ActivityService activityService = new ActivityService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String activityName = request.getParameter("activityName");
		System.out.println(activityName+"被录入");
		activityService.PassActivity(activityName);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
