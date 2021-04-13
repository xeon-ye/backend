package com.ruoyi.project.mobile.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.PlaceEntityMapper;
import com.ruoyi.project.mobile.domain.PlaceEntity;
import com.ruoyi.project.mobile.service.PlaceService;

/**
 * 场地Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-19
 */
@Service
public class PlaceServiceImpl implements PlaceService
{
    @Autowired
    private PlaceEntityMapper placeEntityMapper;

    /**
     * 查询场地
     * 
     * @param id 场地ID
     * @return 场地
     */
    @Override
    public PlaceEntity selectPlaceEntityById(Integer id)
    {
        return placeEntityMapper.selectPlaceEntityById(id);
    }

    /**
     * 查询场地列表
     * 
     * @param placeEntity 场地
     * @return 场地
     */
    @Override
    public List<PlaceEntity> selectPlaceEntityList(PlaceEntity placeEntity)
    {
        return placeEntityMapper.selectPlaceEntityList(placeEntity);
    }

    /**
     * 新增场地
     * 
     * @param placeEntity 场地
     * @return 结果
     */
    @Override
    public int insertPlaceEntity(PlaceEntity placeEntity)
    {
        return placeEntityMapper.insertPlaceEntity(placeEntity);
    }

    /**
     * 修改场地
     * 
     * @param placeEntity 场地
     * @return 结果
     */
    @Override
    public int updatePlaceEntity(PlaceEntity placeEntity)
    {
        return placeEntityMapper.updatePlaceEntity(placeEntity);
    }

    /**
     * 批量删除场地
     * 
     * @param ids 需要删除的场地ID
     * @return 结果
     */
    @Override
    public int deletePlaceEntityByIds(Integer[] ids)
    {
        return placeEntityMapper.deletePlaceEntityByIds(ids);
    }

    /**
     * 删除场地信息
     * 
     * @param id 场地ID
     * @return 结果
     */
    @Override
    public int deletePlaceEntityById(Integer id)
    {
        return placeEntityMapper.deletePlaceEntityById(id);
    }

    @Override
    public List<PlaceEntity> findAllPlace() {

        return placeEntityMapper.findAllPlace();
    }


}
