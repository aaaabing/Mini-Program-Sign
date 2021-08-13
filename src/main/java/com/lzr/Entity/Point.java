package com.lzr.Entity;

import org.apache.ibatis.annotations.Insert;

import javax.validation.constraints.NotBlank;

/**
 * @author lzr
 * @date 2021.08.12
 * @version 1.0
 *   打卡点
 */
public class Point {
    private String id;

    private String name;

    @NotBlank(groups = Insert.class,message = "经度不能为空")
    private String lat;

    @NotBlank(groups = Insert.class,message = "纬度不能为空")
    private String lng;

    @NotBlank(groups = Insert.class,message = "打卡点名称不能为空")
    private String title;

    private String collectorName;

    private Long collectorId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public Long getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(Long collectorId) {
        this.collectorId = collectorId;
    }
    @Override
    public String toString() {
        return "Point{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", title='" + title + '\'' +
                ", collectorName='" + collectorName + '\'' +
                ", collectorId='" + collectorId + '\'' +
                '}';
    }
}
