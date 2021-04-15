package com.ruoyi.project.mobile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.PurchaseDetailEntityMapper;
import com.ruoyi.project.mobile.domain.PurchaseDetailEntity;
import com.ruoyi.project.mobile.service.IPurchaseDetailEntityService;

/**
 * 商品购买记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
@Service
public class PurchaseDetailEntityServiceImpl implements IPurchaseDetailEntityService 
{
    @Autowired
    private PurchaseDetailEntityMapper purchaseDetailEntityMapper;

    /**
     * 查询商品购买记录
     * 
     * @param id 商品购买记录ID
     * @return 商品购买记录
     */
    @Override
    public PurchaseDetailEntity selectPurchaseDetailEntityById(Long id)
    {
        return purchaseDetailEntityMapper.selectPurchaseDetailEntityById(id);
    }

    /**
     * 查询商品购买记录列表
     * 
     * @param purchaseDetailEntity 商品购买记录
     * @return 商品购买记录
     */
    @Override
    public List<PurchaseDetailEntity> selectPurchaseDetailEntityList(PurchaseDetailEntity purchaseDetailEntity)
    {
        return purchaseDetailEntityMapper.selectPurchaseDetailEntityListNew(purchaseDetailEntity);
    }

    /**
     * 新增商品购买记录
     * 
     * @param purchaseDetailEntity 商品购买记录
     * @return 结果
     */
    @Override
    public int insertPurchaseDetailEntity(PurchaseDetailEntity purchaseDetailEntity)
    {
        return purchaseDetailEntityMapper.insertPurchaseDetailEntity(purchaseDetailEntity);
    }

    /**
     * 修改商品购买记录
     * 
     * @param purchaseDetailEntity 商品购买记录
     * @return 结果
     */
    @Override
    public int updatePurchaseDetailEntity(PurchaseDetailEntity purchaseDetailEntity)
    {
        return purchaseDetailEntityMapper.updatePurchaseDetailEntity(purchaseDetailEntity);
    }

    /**
     * 批量删除商品购买记录
     * 
     * @param ids 需要删除的商品购买记录ID
     * @return 结果
     */
    @Override
    public int deletePurchaseDetailEntityByIds(Long[] ids)
    {
        return purchaseDetailEntityMapper.deletePurchaseDetailEntityByIds(ids);
    }

    /**
     * 删除商品购买记录信息
     * 
     * @param id 商品购买记录ID
     * @return 结果
     */
    @Override
    public int deletePurchaseDetailEntityById(Long id)
    {
        return purchaseDetailEntityMapper.deletePurchaseDetailEntityById(id);
    }
}
