package com.lzr.mapper;

import com.lzr.Entity.Point;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}
