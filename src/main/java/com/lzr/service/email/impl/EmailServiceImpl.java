package com.lzr.service.email.impl;

import com.lzr.service.email.EmailService;
import com.lzr.util.FileUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import javax.mail.MessagingException;

/**
 * @author 刘曾瑞
 * @date 2021.08.18
 * 发送邮件业务实现类
 */
@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSenderImpl mailSender;
    @Override
    public void sendEmail(String filePath) {
        //true表示支持复杂类型
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailSender.createMimeMessage(), true);
            File file=new File(filePath);
            FileItem fileItem = FileUtils.createFileItem(file);
            MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
            messageHelper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
            messageHelper.setFrom("3063115730@qq.com");
            messageHelper.setTo("1183934860@qq.com");
            messageHelper.setSubject("打卡名单查收");
            messageHelper.setText("您好：\n" +
                    "请查看的轮滑社打卡名单");
            mailSender.send(messageHelper.getMimeMessage());
        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
