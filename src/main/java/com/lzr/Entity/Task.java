package com.lzr.Entity;

/**
 * 任务
 * @author lzr
 * @date 2021.08.12
 */
public class Task {
    private String id;
    private String remarks;
    private String pointId;
    private String deadLine;

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", remarks='" + remarks + '\'' +
                ", pointId='" + pointId + '\'' +
                ", deadLine='" + deadLine + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPlaceId() {
        return pointId;
    }

    public void setPlaceId(String pointId) {
        this.pointId = pointId;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }
}
