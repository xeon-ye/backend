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
import com.ruoyi.project.mobile.domain.NoticeEntity;
import com.ruoyi.project.mobile.service.NoticeService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 公告轮播Controller
 * 
 * @author ruoyi
 * @date 2021-03-22
 */
@RestController
@RequestMapping("/mobile/notice")
public class NoticeEntityController extends BaseController
{
    @Autowired
    private NoticeService noticeEntityService;

    /**
     * 查询公告轮播列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(NoticeEntity noticeEntity)
    {
        startPage();
        List<NoticeEntity> list = noticeEntityService.selectNoticeEntityList(noticeEntity);
        return getDataTable(list);
    }

    /**
     * 导出公告轮播列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:notice:export')")
    @Log(title = "公告轮播", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(NoticeEntity noticeEntity)
    {
        List<NoticeEntity> list = noticeEntityService.selectNoticeEntityList(noticeEntity);
        ExcelUtil<NoticeEntity> util = new ExcelUtil<NoticeEntity>(NoticeEntity.class);
        return util.exportExcel(list, "notice");
    }

    /**
     * 获取公告轮播详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:notice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(noticeEntityService.selectNoticeEntityById(id));
    }

    /**
     * 新增公告轮播
     */
    @PreAuthorize("@ss.hasPermi('mobile:notice:add')")
    @Log(title = "公告轮播", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NoticeEntity noticeEntity)
    {
        return toAjax(noticeEntityService.insertNoticeEntity(noticeEntity));
    }

    /**
     * 修改公告轮播
     */
    @PreAuthorize("@ss.hasPermi('mobile:notice:edit')")
    @Log(title = "公告轮播", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NoticeEntity noticeEntity)
    {
        return toAjax(noticeEntityService.updateNoticeEntity(noticeEntity));
    }

    /**
     * 删除公告轮播
     */
    @PreAuthorize("@ss.hasPermi('mobile:notice:remove')")
    @Log(title = "公告轮播", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(noticeEntityService.deleteNoticeEntityByIds(ids));
    }
}
