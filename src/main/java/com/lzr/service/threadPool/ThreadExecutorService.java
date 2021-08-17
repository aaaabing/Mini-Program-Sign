package com.lzr.service.threadPool;

/**
 * 线程池的业务类
 * @date 2021.08.17
 * @author lzr
 */
public interface ThreadExecutorService {
    /**
     * 导出打卡Excel通过邮件异步发送
     * @param email 邮件地址
     */
    void exportEmail(String email);
}
