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
import com.ruoyi.project.mobile.domain.PlaceEntity;
import com.ruoyi.project.mobile.service.PlaceService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 场地Controller
 * 
 * @author ruoyi
 * @date 2021-03-19
 */
@RestController
@RequestMapping("/mobile/place")
public class PlaceEntityController extends BaseController
{
    @Autowired
    private PlaceService placeEntityService;

    /**
     * 查询场地列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:place:list')")
    @GetMapping("/list")
    public TableDataInfo list(PlaceEntity placeEntity)
    {
        startPage();
        List<PlaceEntity> list = placeEntityService.selectPlaceEntityList(placeEntity);
        return getDataTable(list);
    }

    /**
     * 导出场地列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:place:export')")
    @Log(title = "场地", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PlaceEntity placeEntity)
    {
        List<PlaceEntity> list = placeEntityService.selectPlaceEntityList(placeEntity);
        ExcelUtil<PlaceEntity> util = new ExcelUtil<PlaceEntity>(PlaceEntity.class);
        return util.exportExcel(list, "place");
    }

    /**
     * 获取场地详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:place:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(placeEntityService.selectPlaceEntityById(id));
    }

    /**
     * 新增场地
     */
    @PreAuthorize("@ss.hasPermi('mobile:place:add')")
    @Log(title = "场地", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PlaceEntity placeEntity)
    {
        return toAjax(placeEntityService.insertPlaceEntity(placeEntity));
    }

    /**
     * 修改场地
     */
    @PreAuthorize("@ss.hasPermi('mobile:place:edit')")
    @Log(title = "场地", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PlaceEntity placeEntity)
    {
        return toAjax(placeEntityService.updatePlaceEntity(placeEntity));
    }

    /**
     * 删除场地
     */
    @PreAuthorize("@ss.hasPermi('mobile:place:remove')")
    @Log(title = "场地", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(placeEntityService.deletePlaceEntityByIds(ids));
    }
}
