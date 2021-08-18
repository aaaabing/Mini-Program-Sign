package com.lzr.service.email;

/**
 * @author 刘曾瑞
 * @date 2021.08.18
 * 发送邮件业务接口
 */
public interface EmailService {

    /**
     * 发送邮件并根据邮件名添加附件
     * @param filePath 文件名
     */
    void sendEmail(String filePath);
}
