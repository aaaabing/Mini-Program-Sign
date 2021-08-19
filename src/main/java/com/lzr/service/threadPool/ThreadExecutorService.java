package com.lzr.service.threadPool;

import org.springframework.scheduling.annotation.Async;

/**
 * 线程池的业务类
 * @date 2021.08.17
 * @author lzr
 */
public interface ThreadExecutorService {
    /**
     * 导出打卡Excel通过邮件异步发送
     * @param email 邮件地址
     * @param taskId 打卡任务Id
     */
    @Async("asyncServiceExecutor")
    void exportEmail(String email,String taskId);
}
