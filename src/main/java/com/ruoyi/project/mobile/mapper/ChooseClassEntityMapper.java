package com.ruoyi.project.mobile.mapper;

import java.util.List;
import com.ruoyi.project.mobile.domain.ChooseClassEntity;
import org.apache.poi.ss.formula.functions.Choose;
import org.springframework.data.repository.query.Param;

/**
 * 选课管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-21
 */
public interface ChooseClassEntityMapper 
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
     * 删除选课管理
     * 
     * @param id 选课管理ID
     * @return 结果
     */
    public int deleteChooseClassEntityById(Integer id);

    /**
     * 批量删除选课管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteChooseClassEntityByIds(Integer[] ids);

    /**
     * 根据教练id和周选择课程
     * @param coachId
     * @param week
     * @return
     */
    List<ChooseClassEntity> findChooseClassEntitiesByCoachId(int coachId,String week);
}
