package com.ruoyi.project.mobile.mapper;

import java.util.List;
import com.ruoyi.project.mobile.domain.StorageEntity;

/**
 * 商品库存Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-23
 */
public interface StorageEntityMapper 
{
    /**
     * 查询商品库存
     * 
     * @param id 商品库存ID
     * @return 商品库存
     */
    public StorageEntity selectStorageEntityById(Integer id);

    /**
     * 查询商品库存列表
     * 
     * @param storageEntity 商品库存
     * @return 商品库存集合
     */
    public List<StorageEntity> selectStorageEntityList(StorageEntity storageEntity);
    public List<StorageEntity> selectStorageEntityListNew(StorageEntity storageEntity);

    /**
     * 新增商品库存
     * 
     * @param storageEntity 商品库存
     * @return 结果
     */
    public int insertStorageEntity(StorageEntity storageEntity);

    /**
     * 修改商品库存
     * 
     * @param storageEntity 商品库存
     * @return 结果
     */
    public int updateStorageEntity(StorageEntity storageEntity);

    /**
     * 删除商品库存
     * 
     * @param id 商品库存ID
     * @return 结果
     */
    public int deleteStorageEntityById(Integer id);

    /**
     * 批量删除商品库存
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStorageEntityByIds(Integer[] ids);
}
