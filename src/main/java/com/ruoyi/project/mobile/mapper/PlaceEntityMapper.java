package com.ruoyi.project.mobile.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.mobile.domain.PlaceEntity;

/**
 * 场地Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-19
 */
public interface PlaceEntityMapper 
{
    /**
     * 查询场地
     * 
     * @param id 场地ID
     * @return 场地
     */
    public PlaceEntity selectPlaceEntityById(Integer id);

    /**
     * 查询场地列表
     * 
     * @param placeEntity 场地
     * @return 场地集合
     */
    public List<PlaceEntity> selectPlaceEntityList(PlaceEntity placeEntity);

    /**
     * 新增场地
     * 
     * @param placeEntity 场地
     * @return 结果
     */
    public int insertPlaceEntity(PlaceEntity placeEntity);

    /**
     * 修改场地
     * 
     * @param placeEntity 场地
     * @return 结果
     */
    public int updatePlaceEntity(PlaceEntity placeEntity);

    /**
     * 删除场地
     * 
     * @param id 场地ID
     * @return 结果
     */
    public int deletePlaceEntityById(Integer id);

    /**
     * 批量删除场地
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePlaceEntityByIds(Integer[] ids);

    /**
     * 查询所有场地(下拉列表用)
     * @return
     */
    List<PlaceEntity> findAllPlace();

}
