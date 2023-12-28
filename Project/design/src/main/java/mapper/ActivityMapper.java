package mapper;
import org.apache.ibatis.annotations.Param;

import pojo.Activity;
import pojo.Application;

public interface ActivityMapper {
		Activity[] selectActivity();
		Activity[] selectNoPassedActivity();
		void passActivity(@Param("activityName")String activityName);
		Activity[] selectPassedActivity();
		void addApplication(@Param("activityName")String activityName,@Param("userName")String userName);
		void cancelApplication(@Param("activityName")String activityName,@Param("userName")String userName);
		Application[] selectUserAppliedActivity(@Param("userName")String userName);
		void addPeopleCount(@Param("activityName")String activityName);
		void cutPeopleCount(@Param("activityName")String activityName);
		void roleApply(@Param("activityName")String activityName,@Param("startTime")String startTime,@Param("endTime")String endTime
				,@Param("peopleCountMax")Integer peopleCountMax,@Param("requirement")String requirement,@Param("activityIntroduction")String activityIntroduction);
		Activity selectActivityByFullName(@Param("activityName")String activityName);
		Activity[] selectActivityByName(@Param("activityName")String activityName);
		//void addGamer(@Param("gamername")String gamername,@Param("scord")int scord);
		//void deletGamer(@Param("gamername")String gamername,@Param("scord")int scord);
}
