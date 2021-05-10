package com.ruoyi.project.mobile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.BtnMenuEntityMapper;
import com.ruoyi.project.mobile.domain.BtnMenuEntity;
import com.ruoyi.project.mobile.service.IBtnMenuEntityService;

/**
 * 首页按钮权限Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-26
 */
@Service
public class BtnMenuEntityServiceImpl implements IBtnMenuEntityService 
{
    @Autowired
    private BtnMenuEntityMapper btnMenuEntityMapper;

    /**
     * 查询首页按钮权限
     * 
     * @param id 首页按钮权限ID
     * @return 首页按钮权限
     */
    @Override
    public BtnMenuEntity selectBtnMenuEntityById(Long id)
    {
        return btnMenuEntityMapper.selectBtnMenuEntityById(id);
    }

    /**
     * 查询首页按钮权限列表
     * 
     * @param btnMenuEntity 首页按钮权限
     * @return 首页按钮权限
     */
    @Override
    public List<BtnMenuEntity> selectBtnMenuEntityList(BtnMenuEntity btnMenuEntity)
    {
        return btnMenuEntityMapper.selectBtnMenuEntityList(btnMenuEntity);
    }

    /**
     * 新增首页按钮权限
     * 
     * @param btnMenuEntity 首页按钮权限
     * @return 结果
     */
    @Override
    public int insertBtnMenuEntity(BtnMenuEntity btnMenuEntity)
    {
        return btnMenuEntityMapper.insertBtnMenuEntity(btnMenuEntity);
    }

    /**
     * 修改首页按钮权限
     * 
     * @param btnMenuEntity 首页按钮权限
     * @return 结果
     */
    @Override
    public int updateBtnMenuEntity(BtnMenuEntity btnMenuEntity)
    {
        return btnMenuEntityMapper.updateBtnMenuEntity(btnMenuEntity);
    }

    /**
     * 批量删除首页按钮权限
     * 
     * @param ids 需要删除的首页按钮权限ID
     * @return 结果
     */
    @Override
    public int deleteBtnMenuEntityByIds(Long[] ids)
    {
        return btnMenuEntityMapper.deleteBtnMenuEntityByIds(ids);
    }

    /**
     * 删除首页按钮权限信息
     * 
     * @param id 首页按钮权限ID
     * @return 结果
     */
    @Override
    public int deleteBtnMenuEntityById(Long id)
    {
        return btnMenuEntityMapper.deleteBtnMenuEntityById(id);
    }
}
