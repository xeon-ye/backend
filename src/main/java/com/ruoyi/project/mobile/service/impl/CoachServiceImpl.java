package com.ruoyi.project.mobile.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.project.mobile.domain.ChooseClassEntity;
import com.ruoyi.project.mobile.mapper.ChooseClassEntityMapper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.CoachEntityMapper;
import com.ruoyi.project.mobile.domain.CoachEntity;
import com.ruoyi.project.mobile.service.CoachService;

/**
 * 教练信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
@Service
public class CoachServiceImpl implements CoachService
{
    @Autowired
    private CoachEntityMapper coachEntityMapper;
    @Autowired
    private ChooseClassEntityMapper chooseClassEntityMapper;

    /**
     * 查询教练信息
     * 
     * @param id 教练信息ID
     * @return 教练信息
     */
    @Override
    public CoachEntity selectCoachEntityById(Integer id)
    {
        return coachEntityMapper.selectCoachEntityById(id);
    }

    /**
     * 查询教练信息列表
     * 
     * @param coachEntity 教练信息
     * @return 教练信息
     */
    @Override
    public List<CoachEntity> selectCoachEntityList(CoachEntity coachEntity)
    {
        return coachEntityMapper.selectCoachEntityListNew(coachEntity);
    }

    /**
     * 新增教练信息
     * 
     * @param coachEntity 教练信息
     * @return 结果
     */
    @Override
    public int insertCoachEntity(CoachEntity coachEntity)
    {
        return coachEntityMapper.insertCoachEntity(coachEntity);
    }

    /**
     * 修改教练信息
     * 
     * @param coachEntity 教练信息
     * @return 结果
     */
    @Override
    public int updateCoachEntity(CoachEntity coachEntity)
    {
        return coachEntityMapper.updateCoachEntity(coachEntity);
    }

    /**
     * 批量删除教练信息
     * 
     * @param ids 需要删除的教练信息ID
     * @return 结果
     */
    @Override
    public int deleteCoachEntityByIds(Integer[] ids)
    {
        return coachEntityMapper.deleteCoachEntityByIds(ids);
    }

    /**
     * 删除教练信息信息
     * 
     * @param id 教练信息ID
     * @return 结果
     */
    @Override
    public int deleteCoachEntityById(Integer id)
    {
        return coachEntityMapper.deleteCoachEntityById(id);
    }

    @Override
    public List<Map<String, Object>> findCoachAndClass(String state) {
        Map<String, java.lang.Object> result = new HashedMap();
        List<Map<String, java.lang.Object>> newcoachList = new ArrayList<>();
        List<Map<String, java.lang.Object>> coachList = this.coachEntityMapper.findCoachEntityByOnWork(0);

        for (int i = 0; i < coachList.size(); i++) {
            Map<String, java.lang.Object> coachMap2 = new HashMap<>();
            Map<String, java.lang.Object> coachMap = coachList.get(i);
            List<ChooseClassEntity> classList = this.chooseClassEntityMapper.findChooseClassEntitiesByCoachId(Integer.parseInt(coachMap.get("id").toString()),state);
            if(classList.size()>0){
                coachMap2.put("coachMap",coachMap);
                coachMap2.put("classList",classList);
                newcoachList.add(coachMap2);
            }
        }

        result.put("code", 0);
        result.put("data", newcoachList);
        result.put("count", newcoachList.size());
        return newcoachList;
    }

    @Override
    public List<CoachEntity> findCoachByPhone(String phone) {
        return this.coachEntityMapper.findCoachByPhone(phone);
    }
}
