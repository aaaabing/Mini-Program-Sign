package com.lzr.Entity;

/**
 * @author lzr
 * @date 2021.08.15
 * 签到实体类
 */
public class Sign {
    private String id;
    private String signTime;
    private String userName;
    private String signPlace;
    private String taskId;

    @Override
    public String toString() {
        return "Sign{" +
                "id='" + id + '\'' +
                ", signTime='" + signTime + '\'' +
                ", userName='" + userName + '\'' +
                ", signPlace='" + signPlace + '\'' +
                ", taskId='" + taskId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSignPlace() {
        return signPlace;
    }

    public void setSignPlace(String signPlace) {
        this.signPlace = signPlace;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
