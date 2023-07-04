package com.atguigu.ggkt.vod.controller;


import com.atguigu.ggkt.exception.GgktException;
import com.atguigu.ggkt.model.vod.Teacher;
import com.atguigu.ggkt.result.Result;
import com.atguigu.ggkt.vo.vod.TeacherQueryVo;
import com.atguigu.ggkt.vod.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author zyz
 * @since 2023-07-01
 */
@RestController
@Log4j
@Api(tags = "讲师管理接口")

@RequestMapping("/admin/vod/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @ApiOperation("查询所有讲师")
    @GetMapping("findAll")
    public Result<List<Teacher>> findAllTeacher() {
        List<Teacher> list = teacherService.list();
        return Result.ok(list);
    }


    @DeleteMapping("remove/{id}")
    @ApiOperation("讲师逻辑删除")
    public Result<Object> removeTeacher(@PathVariable Long id) {
        boolean isSuccess = teacherService.removeById(id);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @ApiOperation("条件分页查询")
    @PostMapping("findQueryPage/{currentPage}/{limit}") //虽然是查询操作，但是得用post而非get，否则响应体无法携带数据
    public Result<IPage<Teacher>> findPage(
    @ApiParam(name = "currentPage", value = "当前页", required = true) @PathVariable Long currentPage,
    @ApiParam(name = "limit", value = "页大小", required = true) @PathVariable Long limit,
    @ApiParam(name = "vo", value = "查询条件", required = false) @RequestBody(required = false) TeacherQueryVo teacherQueryVo) {


        Page<Teacher> pageParam = new Page<>(currentPage, limit);
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();

            String name = teacherQueryVo.getName();//讲师名称
            Integer level = teacherQueryVo.getLevel();//讲师级别
            String joinDateBegin = teacherQueryVo.getJoinDateBegin();//开始时间
            String joinDateEnd = teacherQueryVo.getJoinDateEnd();//结束时间

            //封装条件
            wrapper.like(!StringUtils.isEmpty(name), "name", name);
            wrapper.eq(!StringUtils.isEmpty(level), "level", level);
            wrapper.eq(!StringUtils.isEmpty(joinDateBegin), "join_date", joinDateBegin);
            wrapper.eq(!StringUtils.isEmpty(joinDateEnd), "join_date", joinDateEnd);


        //调用方法得到分页查询结果
        IPage<Teacher> pageModel = teacherService.page(pageParam, wrapper);
        return Result.ok(pageModel);

    }

    @ApiOperation("添加讲师")
    @PostMapping("saveTeacher")
    public Result<Object> saveTeacher(@RequestBody(required = true) Teacher teacher) throws InterruptedException {
        boolean isSuccess = teacherService.save(teacher);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @ApiOperation("根据id查询讲师")
    @GetMapping("getTeacher/{id}")
    public Result<Teacher> getTeacher(@PathVariable Long id) {
        Teacher result = teacherService.getById(id);
        return result != null ? Result.ok(result) : Result.fail();
    }

    @ApiOperation("修改讲师")
    @PutMapping("updateTeacher")
    public Result<Object> updateTeacher(@RequestBody(required = true) Teacher teacher) {
        boolean isSuccess = teacherService.updateById(teacher);
        return isSuccess ? Result.ok() : Result.fail();
    }

    @ApiOperation("批量删除讲师")
    @DeleteMapping("removeBatch")
    public Result<Object> removeBatch(@RequestBody List<Long> idList) {
        boolean isSuccess = teacherService.removeByIds(idList);
        return isSuccess ? Result.ok() : Result.fail();
    }
}

