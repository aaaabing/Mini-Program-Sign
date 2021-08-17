package com.lzr.service.threadPool.impl;

import com.lzr.service.threadPool.ThreadExecutorService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 线程池业务实现类
 * @author lzr
 * @date 2021.08.17
 */
@Component
public class ThreadExecutorServiceImpl implements ThreadExecutorService {

    @Async("asyncServiceExecutor")
    @Override
    public void exportEmail(String email) {

    }
}
