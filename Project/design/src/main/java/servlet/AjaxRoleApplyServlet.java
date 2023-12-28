package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mapper.ActivityMapper;
import mapper.UserMapper;
import pojo.Activity;
import pojo.SqlSessionFactoryUtil;
import pojo.User;

@WebServlet(urlPatterns = "/ajaxRoleApplyServlet")
public class AjaxRoleApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收用户名
		String activityName = request.getParameter("activityName");
		// 查询
		boolean flag;
		SqlSession sqlSession = factory.openSession();
		ActivityMapper mapper = sqlSession.getMapper(ActivityMapper.class);
		Activity activity = mapper.selectActivityByFullName(activityName);
		if (activity == null) {
			// 用户名不存在
			sqlSession.close();
			flag = false;
		} else {
			// 用户名存在
			sqlSession.close();
			flag = true;
		}
		// 响应请求
		response.getWriter().write("" + flag);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
