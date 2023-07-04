package com.atguigu.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    @ExcelProperty(value = "用户编号", index = 0)
    private int id;
    @ExcelProperty(value = "用户名称", index = 1)
    private String name;
}
