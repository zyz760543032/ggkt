package com.atguigu.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class TestWrite {


    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User data = new User();
            data.setId(i);
            data.setName("姓名"+i);
            list.add(data);
        }
        String fileName = "./testWrite.xlsx";
        EasyExcel.write(fileName, User.class)
        .sheet("写操作").doWrite(list);
    }
}
