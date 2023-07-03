package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Chapter;
import com.atguigu.ggkt.vo.vod.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author zyz
 * @since 2023-07-03
 */
public interface ChapterService extends IService<Chapter> {
    //章节小结列表
    List<ChapterVo> getNestedTreeList(Long courseId);
    public void removeChapterByCourseId(Long id);
}
