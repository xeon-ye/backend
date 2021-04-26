package com.ruoyi.project.mobile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.TuitionEntityMapper;
import com.ruoyi.project.mobile.domain.TuitionEntity;
import com.ruoyi.project.mobile.service.TuitionService;

/**
 * 缴费信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
@Service
public class TuitionServiceImpl implements TuitionService
{
    @Autowired
    private TuitionEntityMapper tuitionEntityMapper;

    /**
     * 查询缴费信息
     * 
     * @param id 缴费信息ID
     * @return 缴费信息
     */
    @Override
    public TuitionEntity selectTuitionEntityById(Integer id)
    {
        return tuitionEntityMapper.selectTuitionEntityById(id);
    }

    /**
     * 查询缴费信息列表
     * 
     * @param tuitionEntity 缴费信息
     * @return 缴费信息
     */
    @Override
    public List<TuitionEntity> selectTuitionEntityList(TuitionEntity tuitionEntity)
    {
        return tuitionEntityMapper.selectAllTuitionList(tuitionEntity);
    }

    @Override
    public List<TuitionEntity> selectAllTuitionByPhone(String tel) {
        return tuitionEntityMapper.selectAllTuitionByPhone(tel);
    }

    /**
     * 新增缴费信息
     * 
     * @param tuitionEntity 缴费信息
     * @return 结果
     */
    @Override
    public int insertTuitionEntity(TuitionEntity tuitionEntity)
    {
        return tuitionEntityMapper.insertTuitionEntity(tuitionEntity);
    }

    /**
     * 修改缴费信息
     * 
     * @param tuitionEntity 缴费信息
     * @return 结果
     */
    @Override
    public int updateTuitionEntity(TuitionEntity tuitionEntity)
    {
        return tuitionEntityMapper.updateTuitionEntity(tuitionEntity);
    }

    /**
     * 批量删除缴费信息
     * 
     * @param ids 需要删除的缴费信息ID
     * @return 结果
     */
    @Override
    public int deleteTuitionEntityByIds(Integer[] ids)
    {
        return tuitionEntityMapper.deleteTuitionEntityByIds(ids);
    }

    /**
     * 删除缴费信息信息
     * 
     * @param id 缴费信息ID
     * @return 结果
     */
    @Override
    public int deleteTuitionEntityById(Integer id)
    {
        return tuitionEntityMapper.deleteTuitionEntityById(id);
    }
}
