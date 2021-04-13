package com.ruoyi.project.mobile.service;

import java.util.List;
import com.ruoyi.project.mobile.domain.WxUserInfoEntity;

/**
 * 微信用户表Service接口
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
public interface WxUserInfoService
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
     * 批量删除微信用户表
     * 
     * @param ids 需要删除的微信用户表ID
     * @return 结果
     */
    public int deleteWxUserInfoEntityByIds(Integer[] ids);

    /**
     * 删除微信用户表信息
     * 
     * @param id 微信用户表ID
     * @return 结果
     */
    public int deleteWxUserInfoEntityById(Integer id);


    /**
     * 根据openId查询是否存在用户信息
     * @param openId 用户唯一id
     * @return 用户信息
     * @author: lzq
     * @date: 2018年7月6日
     */
    WxUserInfoEntity findWxUserInfoByOpenId(String openId);

    /**
     * 插入用户信息，手机号，openId
     * @param openId 用户唯一Id
     * @param userInfo  用户信息
     */
    void saveUserInfoAndPhoneAndOpenId(String openId, String userInfo);
}
