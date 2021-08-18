package com.lzr.service.managerService;

import com.lzr.Entity.Point;

/**
 * @author  lzr
 * @date 2921.08.12
 * @version 1.0
 * 管理员操作的接口
 */
public interface ManagerService {
    /**
     * 保存打卡点
     * @param point 打卡点信息
     */
    void addCollectCardPoints(Point point);

    /**
     * 删除打卡点
     * @param id 打卡点id
     */
    void deleteCollectCardPoints(String id);

//    void releaseTask();
//
//    void deleteTask();
//
//    void updateTask();

}
