package com.ruoyi.project.mobile.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.mobile.domain.CoachEntity;

/**
 * 教练信息Service接口
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
public interface CoachService
{
    /**
     * 查询教练信息
     * 
     * @param id 教练信息ID
     * @return 教练信息
     */
    public CoachEntity selectCoachEntityById(Integer id);

    /**
     * 查询教练信息列表
     * 
     * @param coachEntity 教练信息
     * @return 教练信息集合
     */
    public List<CoachEntity> selectCoachEntityList(CoachEntity coachEntity);

    /**
     * 新增教练信息
     * 
     * @param coachEntity 教练信息
     * @return 结果
     */
    public int insertCoachEntity(CoachEntity coachEntity);

    /**
     * 修改教练信息
     * 
     * @param coachEntity 教练信息
     * @return 结果
     */
    public int updateCoachEntity(CoachEntity coachEntity);

    /**
     * 批量删除教练信息
     * 
     * @param ids 需要删除的教练信息ID
     * @return 结果
     */
    public int deleteCoachEntityByIds(Integer[] ids);

    /**
     * 删除教练信息信息
     * 
     * @param id 教练信息ID
     * @return 结果
     */
    public int deleteCoachEntityById(Integer id);

    /**
     * 查询教练和课程列表
     * @param state
     * @return
     */
    List<Map<String, Object>> findCoachAndClass(String state);

    /**
     * 根据手机号查询教练
     * @param phone
     * @return
     */
    List<CoachEntity> findCoachByPhone(String phone);


}
