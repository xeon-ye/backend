package com.ruoyi.project.mobile.controller;

import java.util.List;

import com.ruoyi.project.mobile.service.WxUserInfoService;
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
import com.ruoyi.project.mobile.domain.WxUserInfoEntity;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 微信用户表Controller
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
@RestController
@RequestMapping("/mobile/info")
public class WxUserInfoEntityController extends BaseController
{
    @Autowired
    private WxUserInfoService wxUserInfoEntityService;

    /**
     * 查询微信用户表列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(WxUserInfoEntity wxUserInfoEntity)
    {
        startPage();
        List<WxUserInfoEntity> list = wxUserInfoEntityService.selectWxUserInfoEntityList(wxUserInfoEntity);
        return getDataTable(list);
    }

    /**
     * 导出微信用户表列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:info:export')")
    @Log(title = "微信用户表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(WxUserInfoEntity wxUserInfoEntity)
    {
        List<WxUserInfoEntity> list = wxUserInfoEntityService.selectWxUserInfoEntityList(wxUserInfoEntity);
        ExcelUtil<WxUserInfoEntity> util = new ExcelUtil<WxUserInfoEntity>(WxUserInfoEntity.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取微信用户表详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(wxUserInfoEntityService.selectWxUserInfoEntityById(id));
    }

    /**
     * 新增微信用户表
     */
    @PreAuthorize("@ss.hasPermi('mobile:info:add')")
    @Log(title = "微信用户表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WxUserInfoEntity wxUserInfoEntity)
    {
        return toAjax(wxUserInfoEntityService.insertWxUserInfoEntity(wxUserInfoEntity));
    }

    /**
     * 修改微信用户表
     */
    @PreAuthorize("@ss.hasPermi('mobile:info:edit')")
    @Log(title = "微信用户表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WxUserInfoEntity wxUserInfoEntity)
    {
        return toAjax(wxUserInfoEntityService.updateWxUserInfoEntity(wxUserInfoEntity));
    }

    /**
     * 删除微信用户表
     */
    @PreAuthorize("@ss.hasPermi('mobile:info:remove')")
    @Log(title = "微信用户表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(wxUserInfoEntityService.deleteWxUserInfoEntityByIds(ids));
    }
}
