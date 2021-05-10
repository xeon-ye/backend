package com.ruoyi.project.mobile.service;

import java.util.List;
import com.ruoyi.project.mobile.domain.BtnMenuEntity;

/**
 * 首页按钮权限Service接口
 * 
 * @author ruoyi
 * @date 2021-04-26
 */
public interface IBtnMenuEntityService 
{
    /**
     * 查询首页按钮权限
     * 
     * @param id 首页按钮权限ID
     * @return 首页按钮权限
     */
    public BtnMenuEntity selectBtnMenuEntityById(Long id);

    /**
     * 查询首页按钮权限列表
     * 
     * @param btnMenuEntity 首页按钮权限
     * @return 首页按钮权限集合
     */
    public List<BtnMenuEntity> selectBtnMenuEntityList(BtnMenuEntity btnMenuEntity);

    /**
     * 新增首页按钮权限
     * 
     * @param btnMenuEntity 首页按钮权限
     * @return 结果
     */
    public int insertBtnMenuEntity(BtnMenuEntity btnMenuEntity);

    /**
     * 修改首页按钮权限
     * 
     * @param btnMenuEntity 首页按钮权限
     * @return 结果
     */
    public int updateBtnMenuEntity(BtnMenuEntity btnMenuEntity);

    /**
     * 批量删除首页按钮权限
     * 
     * @param ids 需要删除的首页按钮权限ID
     * @return 结果
     */
    public int deleteBtnMenuEntityByIds(Long[] ids);

    /**
     * 删除首页按钮权限信息
     * 
     * @param id 首页按钮权限ID
     * @return 结果
     */
    public int deleteBtnMenuEntityById(Long id);
}
