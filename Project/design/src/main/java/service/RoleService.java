package service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mapper.RoleMapper;
import pojo.Role;
import pojo.SqlSessionFactoryUtil;

public class RoleService {
	SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

	// 登录方法
	public Role Login(String roleName, String rolePassword) {
		SqlSession sqlSession = factory.openSession();
		RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
		Role user = mapper.selectRole(roleName, rolePassword);
		//System.out.println(user.getRoleName()+"  "+user.getRolePassword());
		sqlSession.close();
		return user;
	}
}
