package com.ruoyi.project.mobile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.SignUpEntityMapper;
import com.ruoyi.project.mobile.domain.SignUpEntity;
import com.ruoyi.project.mobile.service.ISignUpEntityService;

/**
 * 学员报名Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
@Service
public class SignUpEntityServiceImpl implements ISignUpEntityService 
{
    @Autowired
    private SignUpEntityMapper signUpEntityMapper;

    /**
     * 查询学员报名
     * 
     * @param id 学员报名ID
     * @return 学员报名
     */
    @Override
    public SignUpEntity selectSignUpEntityById(Long id)
    {
        return signUpEntityMapper.selectSignUpEntityById(id);
    }

    /**
     * 查询学员报名列表
     * 
     * @param signUpEntity 学员报名
     * @return 学员报名
     */
    @Override
    public List<SignUpEntity> selectSignUpEntityList(SignUpEntity signUpEntity)
    {
        return signUpEntityMapper.selectSignUpEntityList(signUpEntity);
    }

    /**
     * 新增学员报名
     * 
     * @param signUpEntity 学员报名
     * @return 结果
     */
    @Override
    public int insertSignUpEntity(SignUpEntity signUpEntity)
    {
        return signUpEntityMapper.insertSignUpEntity(signUpEntity);
    }

    /**
     * 修改学员报名
     * 
     * @param signUpEntity 学员报名
     * @return 结果
     */
    @Override
    public int updateSignUpEntity(SignUpEntity signUpEntity)
    {
        return signUpEntityMapper.updateSignUpEntity(signUpEntity);
    }

    /**
     * 批量删除学员报名
     * 
     * @param ids 需要删除的学员报名ID
     * @return 结果
     */
    @Override
    public int deleteSignUpEntityByIds(Long[] ids)
    {
        return signUpEntityMapper.deleteSignUpEntityByIds(ids);
    }

    /**
     * 删除学员报名信息
     * 
     * @param id 学员报名ID
     * @return 结果
     */
    @Override
    public int deleteSignUpEntityById(Long id)
    {
        return signUpEntityMapper.deleteSignUpEntityById(id);
    }
}
