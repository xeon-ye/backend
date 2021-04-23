package com.ruoyi.project.mobile.service;

import java.util.List;
import com.ruoyi.project.mobile.domain.SendMsgEntity;

/**
 * 短信发送记录Service接口
 * 
 * @author ruoyi
 * @date 2021-04-21
 */
public interface ISendMsgEntityService 
{
    /**
     * 查询短信发送记录
     * 
     * @param id 短信发送记录ID
     * @return 短信发送记录
     */
    public SendMsgEntity selectSendMsgEntityById(Integer id);

    /**
     * 查询短信发送记录列表
     * 
     * @param sendMsgEntity 短信发送记录
     * @return 短信发送记录集合
     */
    public List<SendMsgEntity> selectSendMsgEntityList(SendMsgEntity sendMsgEntity);

    /**
     * 新增短信发送记录
     * 
     * @param sendMsgEntity 短信发送记录
     * @return 结果
     */
    public int insertSendMsgEntity(SendMsgEntity sendMsgEntity);

    /**
     * 修改短信发送记录
     * 
     * @param sendMsgEntity 短信发送记录
     * @return 结果
     */
    public int updateSendMsgEntity(SendMsgEntity sendMsgEntity);

    /**
     * 批量删除短信发送记录
     * 
     * @param ids 需要删除的短信发送记录ID
     * @return 结果
     */
    public int deleteSendMsgEntityByIds(Integer[] ids);

    /**
     * 删除短信发送记录信息
     * 
     * @param id 短信发送记录ID
     * @return 结果
     */
    public int deleteSendMsgEntityById(Integer id);
}
