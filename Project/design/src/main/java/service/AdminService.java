package service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mapper.AdminMapper;
import pojo.SqlSessionFactoryUtil;
import pojo.Admin;

public class AdminService {
	SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

	// 登录方法
	public Admin Login(String adminName, String adminPassword) {
		SqlSession sqlSession = factory.openSession();
		AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
		Admin user = mapper.selectAdmin(adminName, adminPassword);
		sqlSession.close();
		return user;
	}
}
