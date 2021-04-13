package com.ruoyi.project.mobile.service;

import java.util.List;
import com.ruoyi.project.mobile.domain.TuitionEntity;

/**
 * 缴费信息Service接口
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
public interface TuitionService
{
    /**
     * 查询缴费信息
     * 
     * @param id 缴费信息ID
     * @return 缴费信息
     */
    public TuitionEntity selectTuitionEntityById(Integer id);

    /**
     * 查询缴费信息列表
     * 
     * @param tuitionEntity 缴费信息
     * @return 缴费信息集合
     */
    public List<TuitionEntity> selectTuitionEntityList(TuitionEntity tuitionEntity);

    /**
     * 新增缴费信息
     * 
     * @param tuitionEntity 缴费信息
     * @return 结果
     */
    public int insertTuitionEntity(TuitionEntity tuitionEntity);

    /**
     * 修改缴费信息
     * 
     * @param tuitionEntity 缴费信息
     * @return 结果
     */
    public int updateTuitionEntity(TuitionEntity tuitionEntity);

    /**
     * 批量删除缴费信息
     * 
     * @param ids 需要删除的缴费信息ID
     * @return 结果
     */
    public int deleteTuitionEntityByIds(Integer[] ids);

    /**
     * 删除缴费信息信息
     * 
     * @param id 缴费信息ID
     * @return 结果
     */
    public int deleteTuitionEntityById(Integer id);
}
