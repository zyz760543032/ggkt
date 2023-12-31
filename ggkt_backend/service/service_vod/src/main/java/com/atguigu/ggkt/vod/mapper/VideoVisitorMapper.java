package com.atguigu.ggkt.vod.mapper;

import com.atguigu.ggkt.model.vod.VideoVisitor;
import com.atguigu.ggkt.vo.vod.VideoVisitorCountVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 视频来访者记录表 Mapper 接口
 * </p>
 *
 * @author zyz
 * @since 2023-07-04
 */
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {
    ////显示统计数据
    List<VideoVisitorCountVo> findCount(Long courseId, String startDate, String endDate);
}
