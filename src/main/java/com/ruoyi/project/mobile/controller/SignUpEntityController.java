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
import com.ruoyi.project.mobile.domain.SignUpEntity;
import com.ruoyi.project.mobile.service.ISignUpEntityService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 学员报名Controller
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
@RestController
@RequestMapping("/mobile/up")
public class SignUpEntityController extends BaseController
{
    @Autowired
    private ISignUpEntityService signUpEntityService;

    /**
     * 查询学员报名列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:up:list')")
    @GetMapping("/list")
    public TableDataInfo list(SignUpEntity signUpEntity)
    {
        startPage();
        List<SignUpEntity> list = signUpEntityService.selectSignUpEntityList(signUpEntity);
        return getDataTable(list);
    }

    /**
     * 导出学员报名列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:up:export')")
    @Log(title = "学员报名", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SignUpEntity signUpEntity)
    {
        List<SignUpEntity> list = signUpEntityService.selectSignUpEntityList(signUpEntity);
        ExcelUtil<SignUpEntity> util = new ExcelUtil<SignUpEntity>(SignUpEntity.class);
        return util.exportExcel(list, "up");
    }

    /**
     * 获取学员报名详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:up:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(signUpEntityService.selectSignUpEntityById(id));
    }

    /**
     * 新增学员报名
     */
    @PreAuthorize("@ss.hasPermi('mobile:up:add')")
    @Log(title = "学员报名", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SignUpEntity signUpEntity)
    {
        return toAjax(signUpEntityService.insertSignUpEntity(signUpEntity));
    }

    /**
     * 修改学员报名
     */
    @PreAuthorize("@ss.hasPermi('mobile:up:edit')")
    @Log(title = "学员报名", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SignUpEntity signUpEntity)
    {
        return toAjax(signUpEntityService.updateSignUpEntity(signUpEntity));
    }

    /**
     * 删除学员报名
     */
    @PreAuthorize("@ss.hasPermi('mobile:up:remove')")
    @Log(title = "学员报名", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(signUpEntityService.deleteSignUpEntityByIds(ids));
    }
}
