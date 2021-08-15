package com.lzr.mapper;

import com.lzr.Entity.Point;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 对打卡点进行持久化操作
 * @author lzr
 * @date 2021.08.12
 */
@Repository
@Mapper
public interface PointMapper {
    /**
     * 新增打卡点信息
     * @param point 打卡点信息
     */
    @Insert("insert into point (id,lng,lat,collectorName,collectorId,title) values(#{id},#{lng},#{lat},#{collectorName},#{collectorId},#{title})")
    void addPoint(Point point);

    /**
     * 删除打卡点
     * @param id 打卡点id
     */
    @Delete("delete from point where id=#{id}")
    void deletePoint(String id);

    /**
     * 获取所有打卡点
     * @return 所有打卡点
     */
    @Select("select id,lat,lng,title from point")
    List<Point> getPoints();

    /**
     *  根据打卡点id获取打卡点详细信息
     * @param id 打卡点id
     * @return 打卡点
     */
    @Select("select lat,lng,title from point where id=#{id}")
    Point getPointById(String id);
}
