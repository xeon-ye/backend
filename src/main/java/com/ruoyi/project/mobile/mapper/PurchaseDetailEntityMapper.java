package com.ruoyi.project.mobile.mapper;

import java.util.List;
import com.ruoyi.project.mobile.domain.PurchaseDetailEntity;

/**
 * 商品购买记录Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
public interface PurchaseDetailEntityMapper 
{
    /**
     * 查询商品购买记录
     * 
     * @param id 商品购买记录ID
     * @return 商品购买记录
     */
    public PurchaseDetailEntity selectPurchaseDetailEntityById(Long id);

    /**
     * 查询商品购买记录列表
     * 
     * @param purchaseDetailEntity 商品购买记录
     * @return 商品购买记录集合
     */
    public List<PurchaseDetailEntity> selectPurchaseDetailEntityList(PurchaseDetailEntity purchaseDetailEntity);

    public List<PurchaseDetailEntity> selectPurchaseDetailEntityListNew(PurchaseDetailEntity purchaseDetailEntity);

    /**
     * 新增商品购买记录
     * 
     * @param purchaseDetailEntity 商品购买记录
     * @return 结果
     */
    public int insertPurchaseDetailEntity(PurchaseDetailEntity purchaseDetailEntity);

    /**
     * 修改商品购买记录
     * 
     * @param purchaseDetailEntity 商品购买记录
     * @return 结果
     */
    public int updatePurchaseDetailEntity(PurchaseDetailEntity purchaseDetailEntity);

    /**
     * 删除商品购买记录
     * 
     * @param id 商品购买记录ID
     * @return 结果
     */
    public int deletePurchaseDetailEntityById(Long id);

    /**
     * 批量删除商品购买记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePurchaseDetailEntityByIds(Long[] ids);
}
