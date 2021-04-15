package com.ruoyi.project.mobile.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.mobile.domain.PurchaseDetailEntity;
import com.ruoyi.project.mobile.service.IPurchaseDetailEntityService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 商品购买记录Controller
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
@RestController
@RequestMapping("/mobile/detail")
public class PurchaseDetailEntityController extends BaseController
{
    @Autowired
    private IPurchaseDetailEntityService purchaseDetailEntityService;

    /**
     * 查询商品购买记录列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:detail:list')")
    @GetMapping("/list")
    public TableDataInfo list(PurchaseDetailEntity purchaseDetailEntity)
    {
        startPage();
        List<PurchaseDetailEntity> list = purchaseDetailEntityService.selectPurchaseDetailEntityList(purchaseDetailEntity);
        return getDataTable(list);
    }

    /**
     * 导出商品购买记录列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:detail:export')")
    @Log(title = "商品购买记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PurchaseDetailEntity purchaseDetailEntity)
    {
        List<PurchaseDetailEntity> list = purchaseDetailEntityService.selectPurchaseDetailEntityList(purchaseDetailEntity);
        ExcelUtil<PurchaseDetailEntity> util = new ExcelUtil<PurchaseDetailEntity>(PurchaseDetailEntity.class);
        return util.exportExcel(list, "detail");
    }

    /**
     * 获取商品购买记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:detail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(purchaseDetailEntityService.selectPurchaseDetailEntityById(id));
    }

    /**
     * 新增商品购买记录
     */
    @PreAuthorize("@ss.hasPermi('mobile:detail:add')")
    @Log(title = "商品购买记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PurchaseDetailEntity purchaseDetailEntity)
    {
        return toAjax(purchaseDetailEntityService.insertPurchaseDetailEntity(purchaseDetailEntity));
    }

    /**
     * 修改商品购买记录
     */
    @PreAuthorize("@ss.hasPermi('mobile:detail:edit')")
    @Log(title = "商品购买记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PurchaseDetailEntity purchaseDetailEntity)
    {
        return toAjax(purchaseDetailEntityService.updatePurchaseDetailEntity(purchaseDetailEntity));
    }

    /**
     * 删除商品购买记录
     */
    @PreAuthorize("@ss.hasPermi('mobile:detail:remove')")
    @Log(title = "商品购买记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(purchaseDetailEntityService.deletePurchaseDetailEntityByIds(ids));
    }
}
