package com.ruoyi.project.mobile.mapper;

import java.util.List;
import com.ruoyi.project.mobile.domain.WxUserInfoEntity;

/**
 * 微信用户表Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
public interface WxUserInfoEntityMapper 
{
    /**
     * 查询微信用户表
     * 
     * @param id 微信用户表ID
     * @return 微信用户表
     */
    public WxUserInfoEntity selectWxUserInfoEntityById(Integer id);

    /**
     * 查询微信用户表列表
     * 
     * @param wxUserInfoEntity 微信用户表
     * @return 微信用户表集合
     */
    public List<WxUserInfoEntity> selectWxUserInfoEntityList(WxUserInfoEntity wxUserInfoEntity);

    /**
     * 新增微信用户表
     * 
     * @param wxUserInfoEntity 微信用户表
     * @return 结果
     */
    public int insertWxUserInfoEntity(WxUserInfoEntity wxUserInfoEntity);

    /**
     * 修改微信用户表
     * 
     * @param wxUserInfoEntity 微信用户表
     * @return 结果
     */
    public int updateWxUserInfoEntity(WxUserInfoEntity wxUserInfoEntity);

    /**
     * 删除微信用户表
     * 
     * @param id 微信用户表ID
     * @return 结果
     */
    public int deleteWxUserInfoEntityById(Integer id);

    /**
     * 批量删除微信用户表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxUserInfoEntityByIds(Integer[] ids);

    /**
     * 根据openId查询微信用户
     * @param openId
     * @return
     */
    WxUserInfoEntity findWxUserInfoEntityByOpenCode(String openId);
}
