package com.ruoyi.project.mobile.controller;

import java.util.List;

import com.ruoyi.project.mobile.domain.CourseEntity;
import com.ruoyi.project.mobile.service.CoachService;
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
import com.ruoyi.project.mobile.domain.CoachEntity;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 教练信息Controller
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
@RestController
@RequestMapping("/mobile/coach")
public class CoachEntityController extends BaseController
{
    @Autowired
    private CoachService coachEntityService;

    /**
     * 查询教练信息列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:coach:list')")
    @GetMapping("/list")
    public TableDataInfo list(CoachEntity coachEntity)
    {
        startPage();
        List<CoachEntity> list = coachEntityService.selectCoachEntityList(coachEntity);
        return getDataTable(list);
    }

    /**
     * 导出教练信息列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:coach:export')")
    @Log(title = "教练信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CoachEntity coachEntity)
    {
        List<CoachEntity> list = coachEntityService.selectCoachEntityList(coachEntity);
        ExcelUtil<CoachEntity> util = new ExcelUtil<CoachEntity>(CoachEntity.class);
        return util.exportExcel(list, "coach");
    }

    /**
     * 获取教练信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:coach:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(coachEntityService.selectCoachEntityById(id));
    }

    /**
     * 新增教练信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:coach:add')")
    @Log(title = "教练信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CoachEntity coachEntity)
    {
        return toAjax(coachEntityService.insertCoachEntity(coachEntity));
    }

    /**
     * 修改教练信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:coach:edit')")
    @Log(title = "教练信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CoachEntity coachEntity)
    {
        return toAjax(coachEntityService.updateCoachEntity(coachEntity));
    }

    /**
     * 删除教练信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:coach:remove')")
    @Log(title = "教练信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(coachEntityService.deleteCoachEntityByIds(ids));
    }


    /**
     * 查询全部教练（下拉列表）
     * @param coachEntity
     * @return
     */
    @GetMapping("/queryCoach")
    public List<CoachEntity> queryCoach(CoachEntity coachEntity){
        return this.coachEntityService.selectCoachEntityList(coachEntity);
    }
}
