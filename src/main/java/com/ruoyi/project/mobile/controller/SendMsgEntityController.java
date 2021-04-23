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
import com.ruoyi.project.mobile.domain.SendMsgEntity;
import com.ruoyi.project.mobile.service.ISendMsgEntityService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 短信发送记录Controller
 * 
 * @author ruoyi
 * @date 2021-04-21
 */
@RestController
@RequestMapping("/mobile/msg")
public class SendMsgEntityController extends BaseController
{
    @Autowired
    private ISendMsgEntityService sendMsgEntityService;

    /**
     * 查询短信发送记录列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:msg:list')")
    @GetMapping("/list")
    public TableDataInfo list(SendMsgEntity sendMsgEntity)
    {
        startPage();
        List<SendMsgEntity> list = sendMsgEntityService.selectSendMsgEntityList(sendMsgEntity);
        return getDataTable(list);
    }

    /**
     * 导出短信发送记录列表
     */
    @PreAuthorize("@ss.hasPermi('mobile:msg:export')")
    @Log(title = "短信发送记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SendMsgEntity sendMsgEntity)
    {
        List<SendMsgEntity> list = sendMsgEntityService.selectSendMsgEntityList(sendMsgEntity);
        ExcelUtil<SendMsgEntity> util = new ExcelUtil<SendMsgEntity>(SendMsgEntity.class);
        return util.exportExcel(list, "msg");
    }

    /**
     * 获取短信发送记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('mobile:msg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(sendMsgEntityService.selectSendMsgEntityById(id));
    }

    /**
     * 新增短信发送记录
     */
    @PreAuthorize("@ss.hasPermi('mobile:msg:add')")
    @Log(title = "短信发送记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SendMsgEntity sendMsgEntity)
    {
        return toAjax(sendMsgEntityService.insertSendMsgEntity(sendMsgEntity));
    }

    /**
     * 修改短信发送记录
     */
    @PreAuthorize("@ss.hasPermi('mobile:msg:edit')")
    @Log(title = "短信发送记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SendMsgEntity sendMsgEntity)
    {
        return toAjax(sendMsgEntityService.updateSendMsgEntity(sendMsgEntity));
    }

    /**
     * 删除短信发送记录
     */
    @PreAuthorize("@ss.hasPermi('mobile:msg:remove')")
    @Log(title = "短信发送记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(sendMsgEntityService.deleteSendMsgEntityByIds(ids));
    }
}
