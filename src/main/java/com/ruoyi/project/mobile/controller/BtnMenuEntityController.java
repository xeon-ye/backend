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
import com.ruoyi.project.mobile.domain.BtnMenuEntity;
import com.ruoyi.project.mobile.service.IBtnMenuEntityService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 首页按钮权限Controller
 * 
 * @author ruoyi
 * @date 2021-04-26
 */
@RestController
@RequestMapping("/mobile/menubtn")
public class BtnMenuEntityController extends BaseController
{
    @Autowired
    private IBtnMenuEntityService btnMenuEntityService;

    /**
     * 查询首页按钮权限列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:menubtn:list')")
    @GetMapping("/list")
    public TableDataInfo list(BtnMenuEntity btnMenuEntity)
    {
        startPage();
        List<BtnMenuEntity> list = btnMenuEntityService.selectBtnMenuEntityList(btnMenuEntity);
        return getDataTable(list);
    }

    /**
     * 导出首页按钮权限列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:menubtn:export')")
    @Log(title = "首页按钮权限", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(BtnMenuEntity btnMenuEntity)
    {
        List<BtnMenuEntity> list = btnMenuEntityService.selectBtnMenuEntityList(btnMenuEntity);
        ExcelUtil<BtnMenuEntity> util = new ExcelUtil<BtnMenuEntity>(BtnMenuEntity.class);
        return util.exportExcel(list, "menubtn");
    }

    /**
     * 获取首页按钮权限详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:menubtn:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(btnMenuEntityService.selectBtnMenuEntityById(id));
    }

    /**
     * 新增首页按钮权限
     */
    @PreAuthorize("@ss.hasPermi('mobile:menubtn:add')")
    @Log(title = "首页按钮权限", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BtnMenuEntity btnMenuEntity)
    {
        return toAjax(btnMenuEntityService.insertBtnMenuEntity(btnMenuEntity));
    }

    /**
     * 修改首页按钮权限
     */
    @PreAuthorize("@ss.hasPermi('mobile:menubtn:edit')")
    @Log(title = "首页按钮权限", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BtnMenuEntity btnMenuEntity)
    {
        return toAjax(btnMenuEntityService.updateBtnMenuEntity(btnMenuEntity));
    }

    /**
     * 删除首页按钮权限
     */
    @PreAuthorize("@ss.hasPermi('mobile:menubtn:remove')")
    @Log(title = "首页按钮权限", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(btnMenuEntityService.deleteBtnMenuEntityByIds(ids));
    }
}
