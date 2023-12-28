package service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mapper.UserMapper;
import pojo.SqlSessionFactoryUtil;
import pojo.User;

public class UserService {
	SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

	// 登录方法
	public User Login(String username, String password) {
		SqlSession sqlSession = factory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.selectUser(username, password);
		sqlSession.close();
		return user;
	}

	// 注册方法
	public boolean Register(User user) {
		SqlSession sqlSession = factory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User u = mapper.selectUserByName(user.getUserName());
		if (u==null) {
			//用户名不存在
			mapper.addUser(user.getUserName(), user.getUserPassword(), user.getUserSid(), user.getUserEmail(), user.getUserTel(), user.getUserIdentityCard(), user.getUserIntroduction());
			sqlSession.commit();//提交事务
			sqlSession.close();
			return true;
		}
		else {
			//用户名存在
			sqlSession.close();
			return false;
		}
	}
}
