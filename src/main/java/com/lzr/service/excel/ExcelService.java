package com.lzr.service.excel;

/**
 * 生成Excel业务
 * @author lzr
 * @date 2021.08.17
 */
public interface ExcelService {
    /**
     * 生成Excel
     * @param taskId 打卡任务id
     */
    void createExcel(String taskId);

    /**
     * 删除本地email
     * @param fileName 文件名
     */
    void deleteExcel(String fileName);
}
