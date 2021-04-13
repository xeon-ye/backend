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
import com.ruoyi.project.mobile.domain.CourseEntity;
import com.ruoyi.project.mobile.service.CourseService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 课程信息Controller
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
@RestController
@RequestMapping("/mobile/course")
public class CourseEntityController extends BaseController
{
    @Autowired
    private CourseService courseEntityService;

    /**
     * 查询课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(CourseEntity courseEntity)
    {
        startPage();
        List<CourseEntity> list = courseEntityService.selectCourseEntityList(courseEntity);
        return getDataTable(list);
    }

    /**
     * 导出课程信息列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:course:export')")
    @Log(title = "课程信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CourseEntity courseEntity)
    {
        List<CourseEntity> list = courseEntityService.selectCourseEntityList(courseEntity);
        ExcelUtil<CourseEntity> util = new ExcelUtil<CourseEntity>(CourseEntity.class);
        return util.exportExcel(list, "course");
    }

    /**
     * 获取课程信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:course:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(courseEntityService.selectCourseEntityById(id));
    }

    /**
     * 新增课程信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:course:add')")
    @Log(title = "课程信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CourseEntity courseEntity)
    {
        return toAjax(courseEntityService.insertCourseEntity(courseEntity));
    }

    /**
     * 修改课程信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:course:edit')")
    @Log(title = "课程信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CourseEntity courseEntity)
    {
        return toAjax(courseEntityService.updateCourseEntity(courseEntity));
    }

    /**
     * 删除课程信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:course:remove')")
    @Log(title = "课程信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(courseEntityService.deleteCourseEntityByIds(ids));
    }

    /**
     * 查询全部课程（下拉列表）
     * @param courseEntity
     * @return
     */
    @GetMapping("/queryCoures")
    public List<CourseEntity> queryCoures(CourseEntity courseEntity){
        return this.courseEntityService.selectCourseEntityList(courseEntity);
    }
}
