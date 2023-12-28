package mapper;

import org.apache.ibatis.annotations.Param;

import pojo.User;


public interface UserMapper {
	//用@Param("指定参数名") 来指定传入哪个参数
	User selectUser(@Param("username")String username,@Param("password")String password);
	User selectUserByName(@Param("username")String username);
	void addUser(@Param("username")String username,@Param("password")String password,@Param("userSid")Integer userSid
			,@Param("userEmail")String userEmail,@Param("userTel")Integer userTel,@Param("userIdentityCard")String userIdentityCard
			,@Param("userIntroduction")String userIntroduction);
}
