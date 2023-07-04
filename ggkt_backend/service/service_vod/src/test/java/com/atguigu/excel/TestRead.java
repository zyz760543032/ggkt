package com.atguigu.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestRead {
    public static void main(String[] args) {
        String filePath = "./test.xlsx";
        EasyExcel.read(filePath,User.class,new ExcelListener()).sheet().doRead();
    }
}
