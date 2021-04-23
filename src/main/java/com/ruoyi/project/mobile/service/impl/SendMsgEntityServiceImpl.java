package com.ruoyi.project.mobile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.SendMsgEntityMapper;
import com.ruoyi.project.mobile.domain.SendMsgEntity;
import com.ruoyi.project.mobile.service.ISendMsgEntityService;

/**
 * 短信发送记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-21
 */
@Service
public class SendMsgEntityServiceImpl implements ISendMsgEntityService 
{
    @Autowired
    private SendMsgEntityMapper sendMsgEntityMapper;

    /**
     * 查询短信发送记录
     * 
     * @param id 短信发送记录ID
     * @return 短信发送记录
     */
    @Override
    public SendMsgEntity selectSendMsgEntityById(Integer id)
    {
        return sendMsgEntityMapper.selectSendMsgEntityById(id);
    }

    /**
     * 查询短信发送记录列表
     * 
     * @param sendMsgEntity 短信发送记录
     * @return 短信发送记录
     */
    @Override
    public List<SendMsgEntity> selectSendMsgEntityList(SendMsgEntity sendMsgEntity)
    {
        return sendMsgEntityMapper.selectSendMsgEntityList(sendMsgEntity);
    }

    /**
     * 新增短信发送记录
     * 
     * @param sendMsgEntity 短信发送记录
     * @return 结果
     */
    @Override
    public int insertSendMsgEntity(SendMsgEntity sendMsgEntity)
    {
        return sendMsgEntityMapper.insertSendMsgEntity(sendMsgEntity);
    }

    /**
     * 修改短信发送记录
     * 
     * @param sendMsgEntity 短信发送记录
     * @return 结果
     */
    @Override
    public int updateSendMsgEntity(SendMsgEntity sendMsgEntity)
    {
        return sendMsgEntityMapper.updateSendMsgEntity(sendMsgEntity);
    }

    /**
     * 批量删除短信发送记录
     * 
     * @param ids 需要删除的短信发送记录ID
     * @return 结果
     */
    @Override
    public int deleteSendMsgEntityByIds(Integer[] ids)
    {
        return sendMsgEntityMapper.deleteSendMsgEntityByIds(ids);
    }

    /**
     * 删除短信发送记录信息
     * 
     * @param id 短信发送记录ID
     * @return 结果
     */
    @Override
    public int deleteSendMsgEntityById(Integer id)
    {
        return sendMsgEntityMapper.deleteSendMsgEntityById(id);
    }
}
