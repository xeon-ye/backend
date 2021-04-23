package com.ruoyi.project.mobile.service.impl;

import java.util.List;

import com.ruoyi.project.miniapp.weixinpay.utils.WxUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.WxUserInfoEntityMapper;
import com.ruoyi.project.mobile.domain.WxUserInfoEntity;
import com.ruoyi.project.mobile.service.WxUserInfoService;

/**
 * 微信用户表Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
@Service
public class WxUserInfoServiceImpl implements WxUserInfoService
{
    @Autowired
    private WxUserInfoEntityMapper wxUserInfoEntityMapper;

    /**
     * 查询微信用户表
     * 
     * @param id 微信用户表ID
     * @return 微信用户表
     */
    @Override
    public WxUserInfoEntity selectWxUserInfoEntityById(Integer id)
    {
        return wxUserInfoEntityMapper.selectWxUserInfoEntityById(id);
    }

    /**
     * 查询微信用户表列表
     * 
     * @param wxUserInfoEntity 微信用户表
     * @return 微信用户表
     */
    @Override
    public List<WxUserInfoEntity> selectWxUserInfoEntityList(WxUserInfoEntity wxUserInfoEntity)
    {
        return wxUserInfoEntityMapper.selectWxUserInfoEntityList(wxUserInfoEntity);
    }

    /**
     * 新增微信用户表
     * 
     * @param wxUserInfoEntity 微信用户表
     * @return 结果
     */
    @Override
    public int insertWxUserInfoEntity(WxUserInfoEntity wxUserInfoEntity)
    {
        return wxUserInfoEntityMapper.insertWxUserInfoEntity(wxUserInfoEntity);
    }

    /**
     * 修改微信用户表
     * 
     * @param wxUserInfoEntity 微信用户表
     * @return 结果
     */
    @Override
    public int updateWxUserInfoEntity(WxUserInfoEntity wxUserInfoEntity)
    {
        return wxUserInfoEntityMapper.updateWxUserInfoEntity(wxUserInfoEntity);
    }

    /**
     * 批量删除微信用户表
     * 
     * @param ids 需要删除的微信用户表ID
     * @return 结果
     */
    @Override
    public int deleteWxUserInfoEntityByIds(Integer[] ids)
    {
        return wxUserInfoEntityMapper.deleteWxUserInfoEntityByIds(ids);
    }

    /**
     * 删除微信用户表信息
     * 
     * @param id 微信用户表ID
     * @return 结果
     */
    @Override
    public int deleteWxUserInfoEntityById(Integer id)
    {
        return wxUserInfoEntityMapper.deleteWxUserInfoEntityById(id);
    }



    /**
     * 根据openId查询是否存在用户信息
     * @param openId
     * @return
     * @author: lzq
     * @date: 2018年7月6日
     */
    @Override
    public WxUserInfoEntity findWxUserInfoByOpenId(String openId) {
        WxUserInfoEntity wxUserInfoEntity = this.wxUserInfoEntityMapper.findWxUserInfoEntityByOpenCode(openId);
        return wxUserInfoEntity;
    }

    /**
     * 插入用户信息，手机号，openId
     */
    @Override
    public int saveUserInfoAndPhoneAndOpenId(String openId, String userInfo) {
        WxUserInfoEntity wxUserInfoEntity;

        WxUtil wxUtil = new WxUtil();

        //用户基本信息
        JSONObject jsonObject1 = JSONObject.fromObject(userInfo);
        String nickName = jsonObject1.get("nickName").toString();


        String gender = jsonObject1.get("gender").toString();
        String language = jsonObject1.get("language").toString();
        String city = jsonObject1.get("city").toString();
        String province = jsonObject1.get("province").toString();
        String country = jsonObject1.get("country").toString();
        String avatarUrl = jsonObject1.get("avatarUrl").toString();

        //存入微信用户基本信息
        wxUserInfoEntity = this.findWxUserInfoByOpenId(openId);
        //如果当前用户信息不为空，修改原来的信息
        if (wxUserInfoEntity != null) {
            wxUserInfoEntity.setId(wxUserInfoEntity.getId());
            wxUserInfoEntity.setNickName(nickName);
            wxUserInfoEntity.setGender(gender);
            wxUserInfoEntity.setLanguage(language);
            wxUserInfoEntity.setCity(city);
            wxUserInfoEntity.setProvince(province);
            wxUserInfoEntity.setCountry(country);
            wxUserInfoEntity.setAvatarUrl(avatarUrl);
            return this.wxUserInfoEntityMapper.updateWxUserInfoEntity(wxUserInfoEntity);
        } else{//如果当前用户信息为空，插入新的信息
            wxUserInfoEntity = new WxUserInfoEntity();
            wxUserInfoEntity.setOpenCode(openId);
            wxUserInfoEntity.setNickName(nickName);
            wxUserInfoEntity.setGender(gender);
            wxUserInfoEntity.setLanguage(language);
            wxUserInfoEntity.setCity(city);
            wxUserInfoEntity.setProvince(province);
            wxUserInfoEntity.setCountry(country);
            wxUserInfoEntity.setAvatarUrl(avatarUrl);//头像地址
            return this.wxUserInfoEntityMapper.insertWxUserInfoEntity(wxUserInfoEntity);
        }
    }
}
