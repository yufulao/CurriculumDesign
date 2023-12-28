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

@WebServlet(urlPatterns = "/ajaxRegistServlet")
public class AjaxRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收用户名
		String username = request.getParameter("username");
		// 查询
		boolean flag;
		SqlSession sqlSession = factory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User u = mapper.selectUserByName(username);
		if (u == null) {
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
