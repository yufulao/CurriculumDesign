package mapper;

import org.apache.ibatis.annotations.Param;

import pojo.Role;


public interface RoleMapper {
	//用@Param("指定参数名") 来指定传入哪个参数
	Role selectRole(@Param("roleName")String roleName,@Param("rolePassword")String rolePassword);
	Role selectRoleByName(@Param("roleName")String roleName);
}
