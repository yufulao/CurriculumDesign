package mapper;

import org.apache.ibatis.annotations.Param;

import pojo.Admin;


public interface AdminMapper {
	//用@Param("指定参数名") 来指定传入哪个参数
	Admin selectAdmin(@Param("adminName")String adminName,@Param("adminPassword")String adminPassword);
	Admin selectAdminByName(@Param("adminName")String adminName);
}
