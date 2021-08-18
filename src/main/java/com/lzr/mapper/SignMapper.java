package com.lzr.mapper;


import com.lzr.Entity.Sign;
import com.lzr.Entity.signInf;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author lzr
 * @date 2021/08/10
 * @version 1.0
 * 签到信息相关的持久层操作
 */
@Repository
@Mapper
public interface SignMapper {
    /**
     *
     * @param s
     */
    @Insert("insert into sign(signTime,userName,signPlace) values(#{signTime},#{userName},#{signPlace})")
    public void sign(signInf s);//@ todo 迁移到UserMapper中去

    /**
     * 根据任务id获取签到学生
     * @param taskId 打卡任务ID
     * @return 该任务下所有已签到学生
     */
    @Select("select id,userName,taskId,signTime from sign where taskId=#{taskId}")
    List<Sign> getSignStudentByTaskId(String taskId);


}
