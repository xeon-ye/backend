package com.ruoyi.project.mobile.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.project.mobile.domain.StudentEntity;

/**
 * 学员Service接口
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
public interface StudentService
{
    /**
     * 查询学员
     * 
     * @param id 学员ID
     * @return 学员
     */
    public StudentEntity selectStudentEntityById(Integer id);

    /**
     * 查询学员列表
     * 
     * @param studentEntity 学员
     * @return 学员集合
     */
    public List<StudentEntity> selectStudentEntityList(StudentEntity studentEntity);

    /**
     * 查询学员列表（关联场地表）
     *
     * @param studentEntity 学员
     * @return 学员集合
     */
    public List<Map<String,Object>> selectAllStudents(StudentEntity studentEntity);

    /**
     * 新增学员
     * 
     * @param studentEntity 学员
     * @return 结果
     */
    public int insertStudentEntity(StudentEntity studentEntity);

    /**
     * 修改学员
     * 
     * @param studentEntity 学员
     * @return 结果
     */
    public int updateStudentEntity(StudentEntity studentEntity);

    /**
     * 批量删除学员
     * 
     * @param ids 需要删除的学员ID
     * @return 结果
     */
    public int deleteStudentEntityByIds(Integer[] ids);

    /**
     * 删除学员信息
     * 
     * @param id 学员ID
     * @return 结果
     */
    public int deleteStudentEntityById(Integer id);


    /**
     * 查询手机号下绑定的学员
     * @param phone
     * @return
     */
    List<StudentEntity> findStudentByPhone(String phone);

    /**
     * 查询场地下绑定的学员
     * @param placeId
     * @return
     */
    List<StudentEntity> findStudentByPlace(String placeId);
}
