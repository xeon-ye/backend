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
import com.ruoyi.project.mobile.domain.TuitionEntity;
import com.ruoyi.project.mobile.service.TuitionService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 缴费信息Controller
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
@RestController
@RequestMapping("/mobile/tuition")
public class TuitionEntityController extends BaseController
{
    @Autowired
    private TuitionService tuitionEntityService;

    /**
     * 查询缴费信息列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:tuition:list')")
    @GetMapping("/list")
    public TableDataInfo list(TuitionEntity tuitionEntity)
    {
        startPage();
        List<TuitionEntity> list = tuitionEntityService.selectTuitionEntityList(tuitionEntity);
        return getDataTable(list);
    }

    /**
     * 导出缴费信息列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:tuition:export')")
    @Log(title = "缴费信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TuitionEntity tuitionEntity)
    {
        List<TuitionEntity> list = tuitionEntityService.selectTuitionEntityList(tuitionEntity);
        ExcelUtil<TuitionEntity> util = new ExcelUtil<TuitionEntity>(TuitionEntity.class);
        return util.exportExcel(list, "tuition");
    }

    /**
     * 获取缴费信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:tuition:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(tuitionEntityService.selectTuitionEntityById(id));
    }

    /**
     * 新增缴费信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:tuition:add')")
    @Log(title = "缴费信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TuitionEntity tuitionEntity)
    {
        return toAjax(tuitionEntityService.insertTuitionEntity(tuitionEntity));
    }

    /**
     * 修改缴费信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:tuition:edit')")
    @Log(title = "缴费信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TuitionEntity tuitionEntity)
    {
        return toAjax(tuitionEntityService.updateTuitionEntity(tuitionEntity));
    }

    /**
     * 删除缴费信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:tuition:remove')")
    @Log(title = "缴费信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(tuitionEntityService.deleteTuitionEntityByIds(ids));
    }
}
