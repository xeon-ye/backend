package com.ruoyi.project.mobile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.ChooseClassEntityMapper;
import com.ruoyi.project.mobile.domain.ChooseClassEntity;
import com.ruoyi.project.mobile.service.ChooseClassService;

/**
 * 选课管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
@Service
public class ChooseClassServiceImpl implements ChooseClassService
{
    @Autowired
    private ChooseClassEntityMapper chooseClassEntityMapper;

    /**
     * 查询选课管理
     * 
     * @param id 选课管理ID
     * @return 选课管理
     */
    @Override
    public ChooseClassEntity selectChooseClassEntityById(Integer id)
    {
        return chooseClassEntityMapper.selectChooseClassEntityById(id);
    }

    /**
     * 查询选课管理列表
     * 
     * @param chooseClassEntity 选课管理
     * @return 选课管理
     */
    @Override
    public List<ChooseClassEntity> selectChooseClassEntityList(ChooseClassEntity chooseClassEntity)
    {
        return chooseClassEntityMapper.selectChooseClassEntityList(chooseClassEntity);
    }

    /**
     * 新增选课管理
     * 
     * @param chooseClassEntity 选课管理
     * @return 结果
     */
    @Override
    public int insertChooseClassEntity(ChooseClassEntity chooseClassEntity)
    {
        return chooseClassEntityMapper.insertChooseClassEntity(chooseClassEntity);
    }

    /**
     * 修改选课管理
     * 
     * @param chooseClassEntity 选课管理
     * @return 结果
     */
    @Override
    public int updateChooseClassEntity(ChooseClassEntity chooseClassEntity)
    {
        return chooseClassEntityMapper.updateChooseClassEntity(chooseClassEntity);
    }

    /**
     * 批量删除选课管理
     * 
     * @param ids 需要删除的选课管理ID
     * @return 结果
     */
    @Override
    public int deleteChooseClassEntityByIds(Integer[] ids)
    {
        return chooseClassEntityMapper.deleteChooseClassEntityByIds(ids);
    }

    /**
     * 删除选课管理信息
     * 
     * @param id 选课管理ID
     * @return 结果
     */
    @Override
    public int deleteChooseClassEntityById(Integer id)
    {
        return chooseClassEntityMapper.deleteChooseClassEntityById(id);
    }

    @Override
    public List<ChooseClassEntity> findChooseClassRecordByPhone(String tel,String state) {
        return chooseClassEntityMapper.findChooseClassRecordByPhone(tel,state);
    }

    @Override
    public List<ChooseClassEntity> findChooseClassRecordByPhoneAndCoach(String tel,String state){
        return chooseClassEntityMapper.findChooseClassRecordByPhoneAndCoach(tel,state);
    }
}
