package com.lzr.mapper;

import com.lzr.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author lzr
 * @date 2021.08.13
 * 对用户进行持久化操作
 */
@Repository
@Mapper
public interface UserMapper {
    /**
     *  获取当前的登录用户
     * @param openid 微信openid
     * @return 当前登录用户
     */
    @Select("select id,userName,openid,role from user where openid=#{openid}")
     User getUser(String openid);

    /**
     *  注册
     * @param user 注册的用户
     */
    @Insert("insert into user(openid,userName) values(#{openid},#{userName})")
     void registerUser(User user);

    /**
     * 根据openid获取用户名
     * @param openid 微信openid
     * @return
     */
    @Select("select userName from user where openid=#{openid}")
     String getUserName(String openid);

    /**
     * 根据openid获取管理员
     * @param openid 微信openid
     * @return 管理员ID
     */
    @Select("select id from user where openid=#{openid} and role='admin'")
     String getAdmin(@Param("openid") String openid);
}
