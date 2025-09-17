package com.orgthirteen.Mapper;

import com.orgthirteen.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from sys_user where login_name = #{loginName}")
    User findByUsername(String loginName);

    void insert(User user);
    @Update("update sys_user set user_name = #{userName}, gender = #{gender}, avatar = #{avatar}, mobile = #{mobile}, status = #{status}, email = #{email},gmt_modified=#{gmtModified} where id = #{id}")
    void update(User user);
    @Select("select * from sys_user where id = #{id}")
    User findById(Integer id);
}
