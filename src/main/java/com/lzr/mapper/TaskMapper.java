package com.lzr.mapper;

import com.lzr.Entity.Task;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lzr
 * @date 2021.08.12
 * @version 1.0
 * 对研制任务的数据库操作
 */
@Repository
@Mapper
public interface TaskMapper {
    /**
     *  新键打卡任务
     * @param task 打卡任务
     */
    @Insert("insert into task(id,remarks,pointId,deadLine) values (#{id},#{remarks},#{pointId},#{deadLine})")
     void addTask(Task task);

    /**
     *  删除打卡任务
     * @param id 打卡任务id
     */
    @Delete("delete from task where id=#{id}")
     void deleteTask(String id);

    /**
     * 查询所有打卡任务
     * @return 打卡任务
     */
    @Select("select id,remarks,pointId,deadLine from task")
     List<Task> getTasks();
    //@Todo 对于过期的打卡任务，考虑是定时删除还是查询时判读

    /**
     * 根据打卡id获取打卡任务
     * @param id 任务id
     * @return
     */
    @Select("select id,remarks,pointId,deadLine from task where id=#{id}")
    Task getTaskById(String id);
}
