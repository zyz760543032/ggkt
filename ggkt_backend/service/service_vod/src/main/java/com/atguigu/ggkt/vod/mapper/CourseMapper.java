package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.Course;
import com.atguigu.ggkt.vo.vod.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author zyz
 * @since 2023-07-03
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    //根据id获取课程发布信息
    CoursePublishVo selectCoursePublishVoById(Long id);

}
