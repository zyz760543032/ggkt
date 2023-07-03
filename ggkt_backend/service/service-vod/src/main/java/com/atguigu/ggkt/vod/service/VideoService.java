package com.atguigu.ggkt.vod.service;

import com.atguigu.ggkt.model.vod.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author zyz
 * @since 2023-07-03
 */
public interface VideoService extends IService<Video> {
    public void removeVideoByCourseId(Long id) ;

}
