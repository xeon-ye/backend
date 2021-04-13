package com.ruoyi.project.mobile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.StorageEntityMapper;
import com.ruoyi.project.mobile.domain.StorageEntity;
import com.ruoyi.project.mobile.service.StorageService;

/**
 * 商品库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-23
 */
@Service
public class StorageServiceImpl implements StorageService
{
    @Autowired
    private StorageEntityMapper storageEntityMapper;

    /**
     * 查询商品库存
     * 
     * @param id 商品库存ID
     * @return 商品库存
     */
    @Override
    public StorageEntity selectStorageEntityById(Integer id)
    {
        return storageEntityMapper.selectStorageEntityById(id);
    }

    /**
     * 查询商品库存列表
     * 
     * @param storageEntity 商品库存
     * @return 商品库存
     */
    @Override
    public List<StorageEntity> selectStorageEntityList(StorageEntity storageEntity)
    {
        return storageEntityMapper.selectStorageEntityList(storageEntity);
    }

    /**
     * 新增商品库存
     * 
     * @param storageEntity 商品库存
     * @return 结果
     */
    @Override
    public int insertStorageEntity(StorageEntity storageEntity)
    {
        return storageEntityMapper.insertStorageEntity(storageEntity);
    }

    /**
     * 修改商品库存
     * 
     * @param storageEntity 商品库存
     * @return 结果
     */
    @Override
    public int updateStorageEntity(StorageEntity storageEntity)
    {
        return storageEntityMapper.updateStorageEntity(storageEntity);
    }

    /**
     * 批量删除商品库存
     * 
     * @param ids 需要删除的商品库存ID
     * @return 结果
     */
    @Override
    public int deleteStorageEntityByIds(Integer[] ids)
    {
        return storageEntityMapper.deleteStorageEntityByIds(ids);
    }

    /**
     * 删除商品库存信息
     * 
     * @param id 商品库存ID
     * @return 结果
     */
    @Override
    public int deleteStorageEntityById(Integer id)
    {
        return storageEntityMapper.deleteStorageEntityById(id);
    }
}
