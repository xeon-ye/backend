package com.ruoyi.project.mobile.mapper;

import java.util.List;
import com.ruoyi.project.mobile.domain.SignUpEntity;

/**
 * 学员报名Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-15
 */
public interface SignUpEntityMapper 
{
    /**
     * 查询学员报名
     * 
     * @param id 学员报名ID
     * @return 学员报名
     */
    public SignUpEntity selectSignUpEntityById(Long id);

    /**
     * 查询学员报名列表
     * 
     * @param signUpEntity 学员报名
     * @return 学员报名集合
     */
    public List<SignUpEntity> selectSignUpEntityList(SignUpEntity signUpEntity);

    /**
     * 新增学员报名
     * 
     * @param signUpEntity 学员报名
     * @return 结果
     */
    public int insertSignUpEntity(SignUpEntity signUpEntity);

    /**
     * 修改学员报名
     * 
     * @param signUpEntity 学员报名
     * @return 结果
     */
    public int updateSignUpEntity(SignUpEntity signUpEntity);

    /**
     * 删除学员报名
     * 
     * @param id 学员报名ID
     * @return 结果
     */
    public int deleteSignUpEntityById(Long id);

    /**
     * 批量删除学员报名
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSignUpEntityByIds(Long[] ids);
}
