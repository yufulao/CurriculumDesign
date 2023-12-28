package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Activity;
import pojo.User;
import service.ActivityService;
import service.UserService;

@WebServlet(urlPatterns = "/roleApplyServlet")
public class RoleApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActivityService activityService = new ActivityService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接受用户名和密码
		request.setCharacterEncoding("UTF-8");
		String activityName = request.getParameter("activityName");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		Integer peopleCountMax = 0;
		String requirement = request.getParameter("requirement");
		String activityIntroduction = request.getParameter("activityIntroduction");
		
		if (activityName==null||activityName=="") {
			RegisterFail("activityName_msg","活动名为空",request,response);
			return;
		}
		if (startTime==null||startTime=="") {
			RegisterFail("startTime_msg","开始时间为空",request,response);
			return;
		}
		if (endTime==null||endTime=="") {
			RegisterFail("endTime_msg","结束时间为空",request,response);
			return;
		}
		try {
			peopleCountMax = Integer.parseInt(request.getParameter("peopleCountMax"));
		} catch (NumberFormatException e) {
			RegisterFail("peopleCountMax_msg","人数上限不合规，需要是数字且不大于6位",request,response);
			return;
		}
		if (requirement==null||requirement=="") {
			RegisterFail("requirement_msg","活动场地为空",request,response);
			return;
		}
		if (activityIntroduction==null) {
			activityIntroduction="";
		}
		System.out.println(activityName+"  "+startTime+"  "+endTime+"  "+peopleCountMax+"  "+requirement+"  "+activityIntroduction);
		
		Activity activity=new Activity();
		activity.setActivityName(activityName);
		activity.setStartTime(startTime);
		activity.setEndTime(endTime);
		activity.setPeopleCountMax(peopleCountMax);
		activity.setRequirement(requirement);
		activityService.RoleApply(activity);
		request.getRequestDispatcher("/MainViewRole.jsp").forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	private void RegisterFail(String msgKey,String msgValue,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//request.setAttribute("register_msg", "用户名已存在");
		request.setAttribute(msgKey, msgValue);
		request.getRequestDispatcher("/MainViewRole.jsp").forward(request, response);
	}

}
