package com.lzr.service.excel.impl;


import com.lzr.Entity.Sign;
import com.lzr.mapper.SignMapper;
import com.lzr.mapper.TaskMapper;
import com.lzr.service.excel.ExcelService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * ExcelService的实现类
 * @author lzr
 * @date 2021.08.17
 */
@Component
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    SignMapper signMapper;

    @Autowired
    TaskMapper taskMapper;

    /** 文件路径前缀*/
    private static final String PREFIX="src/main/resources/Excel/";

    /** 文件路径后缀*/
    private static final String SUFFIX=".xlsx";
    @Override
    public void createExcel(String taskId) {
        List<Sign> signList=signMapper.getSignStudentByTaskId(taskId);
        XSSFWorkbook Excel = new XSSFWorkbook();
        Sheet sheet = Excel.createSheet("打卡");
        Row titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("序号");
        titleRow.createCell(1).setCellValue("打卡人");
        titleRow.createCell(2).setCellValue("打卡时间");
        titleRow.createCell(3).setCellValue("状态");
        signList.forEach(e->{
            int cell=sheet.getPhysicalNumberOfRows();
            Row row = sheet.createRow(cell);//从第二行开始保存数据
            row.createCell(0).setCellValue(cell);
            row.createCell(1).setCellValue(e.getUserName());
            row.createCell(2).setCellValue(e.getSignTime());
            row.createCell(3).setCellValue("已打卡");
        });
        String filePath=PREFIX+taskMapper.getTaskById(taskId).getRemarks()+SUFFIX;
        try {
            OutputStream outputStream = new FileOutputStream(filePath);
            Excel.write(outputStream);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteExcel(String fileName) {

    }
}
