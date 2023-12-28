package servlet;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Activity;
import pojo.User;
import pojo.Application;
import service.ActivityService;
import service.GameService;

@WebServlet("/mainViewUserServlet")
public class MainViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ActivityService activityService=new ActivityService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object obj= request.getSession().getAttribute("user");
		User user = (User) obj;
		// 现在 loggedInUser 变量中存储的就是 User 类型的对象，可以使用它了
		// 例如，可以使用 loggedInUser 的属性和方法
		String userName = user.getUserName();
		//System.out.println(userName);
		
		List<Activity> noApplyActivities=new ArrayList<>();
		List<Activity> hadApplyActivities=new ArrayList<>();
		
		//获取数据库的排行榜
		Activity[] activities=activityService.GetPassedActivity();
		for (Activity activity : activities) {
			noApplyActivities.add(activity);
		}
		
		Application[] applications=activityService.GetUserAppliedActivity(userName);
		for (Activity activity : activities) {
			for (Application application : applications) {
				if (activity.getActivityName().equals(application.getActivityName())) {
					noApplyActivities.remove(activity);
					hadApplyActivities.add(activity);
					break;
				}
			}
		}
		
		request.setAttribute("noApplyActivities", noApplyActivities);
		request.setAttribute("hadApplyActivities", hadApplyActivities);
		//转发到MainViewAdmin.jsp
		request.getRequestDispatcher("/MainViewUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
