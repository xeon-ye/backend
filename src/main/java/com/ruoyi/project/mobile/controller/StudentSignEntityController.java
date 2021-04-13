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
import com.ruoyi.project.mobile.domain.StudentSignEntity;
import com.ruoyi.project.mobile.service.StudentSignService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 学员签到Controller
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
@RestController
@RequestMapping("/mobile/sign")
public class StudentSignEntityController extends BaseController
{
    @Autowired
    private StudentSignService studentSignEntityService;

    /**
     * 查询学员签到列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:sign:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudentSignEntity studentSignEntity)
    {
        startPage();
        List<StudentSignEntity> list = studentSignEntityService.selectStudentSignNew(studentSignEntity);
        return getDataTable(list);
    }

    /**
     * 导出学员签到列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:sign:export')")
    @Log(title = "学员签到", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(StudentSignEntity studentSignEntity)
    {
        List<StudentSignEntity> list = studentSignEntityService.selectStudentSignNew(studentSignEntity);
        ExcelUtil<StudentSignEntity> util = new ExcelUtil<StudentSignEntity>(StudentSignEntity.class);
        return util.exportExcel(list, "sign");
    }

    /**
     * 获取学员签到详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:sign:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(studentSignEntityService.selectStudentSignEntityById(id));
    }

    /**
     * 新增学员签到
     */
    @PreAuthorize("@ss.hasPermi('mobile:sign:add')")
    @Log(title = "学员签到", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentSignEntity studentSignEntity)
    {
        return toAjax(studentSignEntityService.insertStudentSignEntity(studentSignEntity));
    }

    /**
     * 修改学员签到
     */
    @PreAuthorize("@ss.hasPermi('mobile:sign:edit')")
    @Log(title = "学员签到", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentSignEntity studentSignEntity)
    {
        return toAjax(studentSignEntityService.updateStudentSignEntity(studentSignEntity));
    }

    /**
     * 删除学员签到
     */
    @PreAuthorize("@ss.hasPermi('mobile:sign:remove')")
    @Log(title = "学员签到", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(studentSignEntityService.deleteStudentSignEntityByIds(ids));
    }
}
