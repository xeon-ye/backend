package com.ruoyi.project.mobile.controller;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.mobile.domain.PlaceEntity;
import com.ruoyi.project.mobile.service.PlaceService;
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
import com.ruoyi.project.mobile.domain.StudentEntity;
import com.ruoyi.project.mobile.service.StudentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 学员Controller
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
@RestController
@RequestMapping("/mobile/student")
public class StudentEntityController extends BaseController
{
    @Autowired
    private StudentService studentEntityService;
    @Autowired
    private PlaceService placeService;

    /**
     * 查询学员列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:student:list')")
    @GetMapping("/list")
    public TableDataInfo list(StudentEntity studentEntity)
    {
        startPage();
        List<Map<String,Object>> list = studentEntityService.selectAllStudents(studentEntity);
        return getDataTable(list);
    }

    /**
     * 导出学员列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:student:export')")
    @Log(title = "学员", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(StudentEntity studentEntity)
    {
        List<StudentEntity> list = studentEntityService.selectStudentEntityList(studentEntity);
        ExcelUtil<StudentEntity> util = new ExcelUtil<StudentEntity>(StudentEntity.class);
        return util.exportExcel(list, "student");
    }

    /**
     * 获取学员详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:student:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(studentEntityService.selectStudentEntityById(id));
    }

    /**
     * 新增学员
     */
    @PreAuthorize("@ss.hasPermi('mobile:student:add')")
    @Log(title = "学员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StudentEntity studentEntity)
    {
        return toAjax(studentEntityService.insertStudentEntity(studentEntity));
    }

    /**
     * 修改学员
     */
    @PreAuthorize("@ss.hasPermi('mobile:student:edit')")
    @Log(title = "学员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StudentEntity studentEntity)
    {
        return toAjax(studentEntityService.updateStudentEntity(studentEntity));
    }

    /**
     * 删除学员
     */
    @PreAuthorize("@ss.hasPermi('mobile:student:remove')")
    @Log(title = "学员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(studentEntityService.deleteStudentEntityByIds(ids));
    }

    /**
     * 查询所有场地(下拉列表用)
     * @return
     */
    @GetMapping("/getPlaceList")
    public List<PlaceEntity> getPlaceList()
    {
        return this.placeService.findAllPlace();
    }

    /**
     * 查询所有学员(下拉列表用)
     * @return
     */
    @GetMapping("/getStudentList")
    public List<StudentEntity> getStudentList(StudentEntity studentEntity)
    {
        return this.studentEntityService.selectStudentEntityList(studentEntity);
    }

}
