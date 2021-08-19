package com.lzr.service.threadPool.impl;

import com.lzr.Entity.Task;
import com.lzr.mapper.TaskMapper;
import com.lzr.service.email.EmailService;
import com.lzr.service.excel.ExcelService;
import com.lzr.service.threadPool.ThreadExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 线程池业务实现类
 * @author lzr
 * @date 2021.08.17
 */
@Component
public class ThreadExecutorServiceImpl implements ThreadExecutorService {

    @Autowired
    ExcelService excelService;

    @Autowired
    EmailService emailService;

    @Autowired
    TaskMapper taskMapper;

    /** 文件路径前缀*/
    private static final String PREFIX="src/main/resources/Excel/";

    /** 文件路径后缀*/
    private static final String SUFFIX=".xlsx";

    @Async("asyncServiceExecutor")
    @Override
    public void exportEmail(String email,String taskId) {
        excelService.createExcel(taskId);
        Task task=taskMapper.getTaskById(taskId);
        emailService.sendEmail(PREFIX+task.getRemarks()+SUFFIX);
        System.out.println(Thread.currentThread().getName()+" success");
    }
}
