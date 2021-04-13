package com.ruoyi.project.mobile.mapper;

import java.util.List;
import com.ruoyi.project.mobile.domain.NoticeEntity;

/**
 * 公告轮播Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
public interface NoticeEntityMapper 
{
    /**
     * 查询公告轮播
     * 
     * @param id 公告轮播ID
     * @return 公告轮播
     */
    public NoticeEntity selectNoticeEntityById(Integer id);

    /**
     * 查询公告轮播列表
     * 
     * @param noticeEntity 公告轮播
     * @return 公告轮播集合
     */
    public List<NoticeEntity> selectNoticeEntityList(NoticeEntity noticeEntity);

    /**
     * 新增公告轮播
     * 
     * @param noticeEntity 公告轮播
     * @return 结果
     */
    public int insertNoticeEntity(NoticeEntity noticeEntity);

    /**
     * 修改公告轮播
     * 
     * @param noticeEntity 公告轮播
     * @return 结果
     */
    public int updateNoticeEntity(NoticeEntity noticeEntity);

    /**
     * 删除公告轮播
     * 
     * @param id 公告轮播ID
     * @return 结果
     */
    public int deleteNoticeEntityById(Integer id);

    /**
     * 批量删除公告轮播
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNoticeEntityByIds(Integer[] ids);

    /**
     * 查询公告
     * @return
     */
    List<NoticeEntity> findAllNoticeByType(Integer type);
}
