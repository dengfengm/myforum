package com.cn.myforum.mapper;

import com.cn.myforum.bean.UserBean;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 获取所有用户
     *
     * @return
     */
    @Select(value = "select * from user")
    @Results(value = { @Result(column = "userName", property = "userName", jdbcType = JdbcType.VARCHAR)})
    List<UserBean> getUsers();

    /**
     * 修改用户信息
     *
     * @param user
     */
    @Update("update user set userName= #{userName} where userId=#{userId}")
    void update(UserBean user);

    /**
     * 删除用户
     *
     * @param id
     */
    @Delete("delete from user where userId=#{userId}")
    void del(String id);

    /**
     * 新增一条用户信息
     *
     * @param user
     */
    @Insert("insert into user(userName) values(#{userName})")
    @Options(useGeneratedKeys=true, keyProperty="userName", keyColumn="userName")
    void save(UserBean user);

}
