package com.ruoyi.project.mobile.service;

import java.util.List;
import com.ruoyi.project.mobile.domain.ChooseClassEntity;

/**
 * 选课管理Service接口
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
public interface ChooseClassService
{
    /**
     * 查询选课管理
     * 
     * @param id 选课管理ID
     * @return 选课管理
     */
    public ChooseClassEntity selectChooseClassEntityById(Integer id);

    /**
     * 查询选课管理列表
     * 
     * @param chooseClassEntity 选课管理
     * @return 选课管理集合
     */
    public List<ChooseClassEntity> selectChooseClassEntityList(ChooseClassEntity chooseClassEntity);

    /**
     * 新增选课管理
     * 
     * @param chooseClassEntity 选课管理
     * @return 结果
     */
    public int insertChooseClassEntity(ChooseClassEntity chooseClassEntity);

    /**
     * 修改选课管理
     * 
     * @param chooseClassEntity 选课管理
     * @return 结果
     */
    public int updateChooseClassEntity(ChooseClassEntity chooseClassEntity);

    /**
     * 批量删除选课管理
     * 
     * @param ids 需要删除的选课管理ID
     * @return 结果
     */
    public int deleteChooseClassEntityByIds(Integer[] ids);

    /**
     * 删除选课管理信息
     * 
     * @param id 选课管理ID
     * @return 结果
     */
    public int deleteChooseClassEntityById(Integer id);

    /**
     * 查询个人课程表(根据手机号)
     */
    public List<ChooseClassEntity> findChooseClassRecordByPhone(String tel,String state);
}
