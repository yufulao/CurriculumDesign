package service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mapper.ActivityMapper;
import mapper.GamerMapper;
import mapper.UserMapper;
import pojo.Activity;
import pojo.Application;
import pojo.Gamer;
import pojo.SqlSessionFactoryUtil;
import pojo.User;

public class ActivityService {
	SqlSessionFactory factory = SqlSessionFactoryUtil.getSqlSessionFactory();

	public Activity[] GetActivity() {
		SqlSession sqlSession = factory.openSession();
		ActivityMapper mapper = sqlSession.getMapper(ActivityMapper.class);
		Activity[] activities = mapper.selectActivity();
		sqlSession.close();
		return activities;
	}
	
	public Activity[] GetNoPassedActivity() {
		SqlSession sqlSession = factory.openSession();
		ActivityMapper mapper = sqlSession.getMapper(ActivityMapper.class);
		Activity[] activities = mapper.selectNoPassedActivity();
		sqlSession.close();
		return activities;
	}
	
	public void PassActivity(String activityName) {
		SqlSession sqlSession = factory.openSession();
		ActivityMapper mapper = sqlSession.getMapper(ActivityMapper.class);

		mapper.passActivity(activityName);
		sqlSession.commit();// 提交事务
		sqlSession.close();
	}
	
	public Activity[] GetPassedActivity() {
		SqlSession sqlSession = factory.openSession();
		ActivityMapper mapper = sqlSession.getMapper(ActivityMapper.class);
		Activity[] activities = mapper.selectPassedActivity();
		sqlSession.close();
		return activities;
	}
	
	public void AddApplication(String activityName,String userName) {
		SqlSession sqlSession = factory.openSession();
		ActivityMapper mapper = sqlSession.getMapper(ActivityMapper.class);
		mapper.addApplication(activityName,userName);
		mapper.addPeopleCount(activityName);
		sqlSession.commit();// 提交事务
		sqlSession.close();
	}
	
	public void CancelApplication(String activityName,String userName) {
		SqlSession sqlSession = factory.openSession();
		ActivityMapper mapper = sqlSession.getMapper(ActivityMapper.class);
		mapper.cancelApplication(activityName,userName);
		mapper.cutPeopleCount(activityName);
		sqlSession.commit();// 提交事务
		sqlSession.close();
	}
	
	public Application[] GetUserAppliedActivity(String userName) {
		SqlSession sqlSession = factory.openSession();
		ActivityMapper mapper = sqlSession.getMapper(ActivityMapper.class);
		Application[] applications = mapper.selectUserAppliedActivity(userName);
		sqlSession.close();
		return applications;
	}
	
	public void RoleApply(Activity activity) {
		SqlSession sqlSession = factory.openSession();
		ActivityMapper mapper = sqlSession.getMapper(ActivityMapper.class);
		mapper.roleApply(activity.getActivityName(),activity.getStartTime(),activity.getEndTime()
				,activity.getPeopleCountMax(),activity.getRequirement(),activity.getActivityIntroduction());
		sqlSession.commit();// 提交事务
		sqlSession.close();
	}
	
	public Activity selectActivityByFullName(String activityName) {
		SqlSession sqlSession = factory.openSession();
		ActivityMapper mapper = sqlSession.getMapper(ActivityMapper.class);
		Activity activity = mapper.selectActivityByFullName(activityName);
		sqlSession.close();
		return activity;
	}
	
	

	public Activity[] SearchActivity(String activityName) {
		SqlSession sqlSession = factory.openSession();
		ActivityMapper mapper = sqlSession.getMapper(ActivityMapper.class);
		Activity[] activities = mapper.selectActivityByName(activityName);
		sqlSession.close();
		return activities;
	}
	
	
	
	
	

	public void AddGamer(Gamer gamer) {
		SqlSession sqlSession = factory.openSession();
		GamerMapper mapper = sqlSession.getMapper(GamerMapper.class);

		mapper.addGamer(gamer.getGamername(), gamer.getScord());
		sqlSession.commit();// 提交事务
		sqlSession.close();
	}
	
	public void DeletGamer(Gamer gamer) {
		SqlSession sqlSession = factory.openSession();
		GamerMapper mapper = sqlSession.getMapper(GamerMapper.class);

		mapper.deletGamer(gamer.getGamername(), gamer.getScord());
		sqlSession.commit();// 提交事务
		sqlSession.close();
	}
}
