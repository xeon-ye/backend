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
import com.ruoyi.project.mobile.domain.StorageEntity;
import com.ruoyi.project.mobile.service.StorageService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 商品库存Controller
 * 
 * @author ruoyi
 * @date 2021-03-23
 */
@RestController
@RequestMapping("/mobile/storage")
public class StorageEntityController extends BaseController
{
    @Autowired
    private StorageService storageEntityService;

    /**
     * 查询商品库存列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:storage:list')")
    @GetMapping("/list")
    public TableDataInfo list(StorageEntity storageEntity)
    {
        startPage();
        List<StorageEntity> list = storageEntityService.selectStorageEntityList(storageEntity);
        return getDataTable(list);
    }

    /**
     * 导出商品库存列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:storage:export')")
    @Log(title = "商品库存", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(StorageEntity storageEntity)
    {
        List<StorageEntity> list = storageEntityService.selectStorageEntityList(storageEntity);
        ExcelUtil<StorageEntity> util = new ExcelUtil<StorageEntity>(StorageEntity.class);
        return util.exportExcel(list, "storage");
    }

    /**
     * 获取商品库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:storage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(storageEntityService.selectStorageEntityById(id));
    }

    /**
     * 新增商品库存
     */
    @PreAuthorize("@ss.hasPermi('mobile:storage:add')")
    @Log(title = "商品库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StorageEntity storageEntity)
    {
        return toAjax(storageEntityService.insertStorageEntity(storageEntity));
    }

    /**
     * 修改商品库存
     */
    @PreAuthorize("@ss.hasPermi('mobile:storage:edit')")
    @Log(title = "商品库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StorageEntity storageEntity)
    {
        return toAjax(storageEntityService.updateStorageEntity(storageEntity));
    }

    /**
     * 删除商品库存
     */
    @PreAuthorize("@ss.hasPermi('mobile:storage:remove')")
    @Log(title = "商品库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(storageEntityService.deleteStorageEntityByIds(ids));
    }

    /**
     *入库
     * @return
     */
    @PreAuthorize("@ss.hasPermi('mobile:storage:edit')")
    @Log(title = "入库商品", businessType = BusinessType.UPDATE)
    @PostMapping("/inStorage/{id}/{count}")
    public AjaxResult inStorage(@PathVariable Integer id,@PathVariable String count){
        StorageEntity storageEntity = this.storageEntityService.selectStorageEntityById(id);
        storageEntity.setInventory(storageEntity.getInventory()+Integer.parseInt(count));
        return toAjax(storageEntityService.updateStorageEntity(storageEntity));
    }

    /**
     * 出库
     * @return
     */
    @PreAuthorize("@ss.hasPermi('mobile:storage:edit')")
    @Log(title = "出库商品", businessType = BusinessType.UPDATE)
    @PostMapping("/outStorage/{id}/{count}")
    public AjaxResult outStorage(@PathVariable Integer id,@PathVariable String count){
        StorageEntity storageEntity = this.storageEntityService.selectStorageEntityById(id);
        if(storageEntity.getInventory()>=Integer.parseInt(count)){
            storageEntity.setInventory(storageEntity.getInventory()-Integer.parseInt(count));
        }else{
            return AjaxResult.error("库存不足！");
        }

        return toAjax(storageEntityService.updateStorageEntity(storageEntity));
    }

    /**
     * 查询商品下拉列表
     * @param storageEntity
     * @return
     */
    @PostMapping("/findStorageSelectList")
    public AjaxResult findStorageSelectList(@RequestBody StorageEntity storageEntity){
        return AjaxResult.success(this.storageEntityService.selectStorageEntityList(storageEntity));
    }
}
