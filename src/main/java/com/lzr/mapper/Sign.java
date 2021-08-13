package com.lzr.mapper;


import com.lzr.Entity.signInf;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.lzr.Entity.dto.signList;

/**
 * @author lzr
 * @date 2021/08/10
 * @version 1.0
 */
@Repository
@Mapper
public interface Sign {
    /**
     * 检查用户是否登录
     * @param openid 微信openid
     * @param time 时间
     * @return
     */
    @Select("select s.id from user u ,sign s where u.openid=#{openid} and u.userName=s.userName and s.signTime like CONCAT(#{time},'%')")
    public Object checkSign(@Param("openid") String openid,@Param("time") String time);

    /**
     *
     * @param s
     */
    @Insert("insert into sign(signTime,userName,signPlace) values(#{signTime},#{userName},#{signPlace})")
    public void sign(signInf s);
    @Select("select s.signTime,s.userName,s.signPlace from sign s where  s.signTime like CONCAT(#{time},'%')")
    public signList[] getSignList(String time);
}
