package com.ruoyi.project.mobile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.NoticeEntityMapper;
import com.ruoyi.project.mobile.domain.NoticeEntity;
import com.ruoyi.project.mobile.service.NoticeService;

/**
 * 公告轮播Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
@Service
public class NoticeServiceImpl implements NoticeService
{
    @Autowired
    private NoticeEntityMapper noticeEntityMapper;

    /**
     * 查询公告轮播
     * 
     * @param id 公告轮播ID
     * @return 公告轮播
     */
    @Override
    public NoticeEntity selectNoticeEntityById(Integer id)
    {
        return noticeEntityMapper.selectNoticeEntityById(id);
    }

    /**
     * 查询公告轮播列表
     * 
     * @param noticeEntity 公告轮播
     * @return 公告轮播
     */
    @Override
    public List<NoticeEntity> selectNoticeEntityList(NoticeEntity noticeEntity)
    {
        return noticeEntityMapper.selectNoticeEntityList(noticeEntity);
    }

    /**
     * 新增公告轮播
     * 
     * @param noticeEntity 公告轮播
     * @return 结果
     */
    @Override
    public int insertNoticeEntity(NoticeEntity noticeEntity)
    {
        return noticeEntityMapper.insertNoticeEntity(noticeEntity);
    }

    /**
     * 修改公告轮播
     * 
     * @param noticeEntity 公告轮播
     * @return 结果
     */
    @Override
    public int updateNoticeEntity(NoticeEntity noticeEntity)
    {
        return noticeEntityMapper.updateNoticeEntity(noticeEntity);
    }

    /**
     * 批量删除公告轮播
     * 
     * @param ids 需要删除的公告轮播ID
     * @return 结果
     */
    @Override
    public int deleteNoticeEntityByIds(Integer[] ids)
    {
        return noticeEntityMapper.deleteNoticeEntityByIds(ids);
    }

    /**
     * 删除公告轮播信息
     * 
     * @param id 公告轮播ID
     * @return 结果
     */
    @Override
    public int deleteNoticeEntityById(Integer id)
    {
        return noticeEntityMapper.deleteNoticeEntityById(id);
    }

    @Override
    public List<NoticeEntity> findAllNoticeByType(Integer type) {
        return noticeEntityMapper.findAllNoticeByType(type);
    }
}
