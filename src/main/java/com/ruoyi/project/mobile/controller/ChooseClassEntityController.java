package com.ruoyi.project.mobile.controller;

import java.util.List;

import com.ruoyi.project.mobile.service.ChooseClassService;
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
import com.ruoyi.project.mobile.domain.ChooseClassEntity;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 选课管理Controller
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
@RestController
@RequestMapping("/mobile/class")
public class ChooseClassEntityController extends BaseController
{
    @Autowired
    private ChooseClassService chooseClassEntityService;

    /**
     * 查询选课管理列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:class:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChooseClassEntity chooseClassEntity)
    {
        startPage();
        List<ChooseClassEntity> list = chooseClassEntityService.selectChooseClassEntityList(chooseClassEntity);
        return getDataTable(list);
    }

    /**
     * 导出选课管理列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:class:export')")
    @Log(title = "选课管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ChooseClassEntity chooseClassEntity)
    {
        List<ChooseClassEntity> list = chooseClassEntityService.selectChooseClassEntityList(chooseClassEntity);
        ExcelUtil<ChooseClassEntity> util = new ExcelUtil<ChooseClassEntity>(ChooseClassEntity.class);
        return util.exportExcel(list, "class");
    }

    /**
     * 获取选课管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:class:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(chooseClassEntityService.selectChooseClassEntityById(id));
    }

    /**
     * 新增选课管理
     */
    @PreAuthorize("@ss.hasPermi('mobile:class:add')")
    @Log(title = "选课管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChooseClassEntity chooseClassEntity)
    {
        return toAjax(chooseClassEntityService.insertChooseClassEntity(chooseClassEntity));
    }

    /**
     * 修改选课管理
     */
    @PreAuthorize("@ss.hasPermi('mobile:class:edit')")
    @Log(title = "选课管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChooseClassEntity chooseClassEntity)
    {
        return toAjax(chooseClassEntityService.updateChooseClassEntity(chooseClassEntity));
    }

    /**
     * 删除选课管理
     */
    @PreAuthorize("@ss.hasPermi('mobile:class:remove')")
    @Log(title = "选课管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(chooseClassEntityService.deleteChooseClassEntityByIds(ids));
    }
}
