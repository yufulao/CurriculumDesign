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

@WebServlet(urlPatterns = "/ajaxUserAffirmApplyActivityServlet")
public class AjaxUserAffirmApplyActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ActivityService activityService = new ActivityService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String activityName = request.getParameter("activityName");
		String userName= request.getParameter("userName");
		System.out.println("社员"+userName+"申请了参加"+activityName+"活动");
		activityService.AddApplication(activityName,userName);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
