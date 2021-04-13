package com.ruoyi.project.mobile.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.StudentEntityMapper;
import com.ruoyi.project.mobile.domain.StudentEntity;
import com.ruoyi.project.mobile.service.StudentService;

/**
 * 学员Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentEntityMapper studentEntityMapper;

    /**
     * 查询学员
     * 
     * @param id 学员ID
     * @return 学员
     */
    @Override
    public StudentEntity selectStudentEntityById(Integer id)
    {
        return studentEntityMapper.selectStudentEntityById(id);
    }

    /**
     * 查询学员列表
     * 
     * @param studentEntity 学员
     * @return 学员
     */
    @Override
    public List<StudentEntity> selectStudentEntityList(StudentEntity studentEntity)
    {
        return studentEntityMapper.selectStudentEntityList(studentEntity);
    }

    /**
     * 查询学员列表
     *
     * @param studentEntity 学员
     * @return 学员
     */
    @Override
    public List<Map<String,Object>> selectAllStudents(StudentEntity studentEntity)
    {
        return studentEntityMapper.selectAllStudents(studentEntity);
    }

    /**
     * 新增学员
     * 
     * @param studentEntity 学员
     * @return 结果
     */
    @Override
    public int insertStudentEntity(StudentEntity studentEntity)
    {
        return studentEntityMapper.insertStudentEntity(studentEntity);
    }

    /**
     * 修改学员
     * 
     * @param studentEntity 学员
     * @return 结果
     */
    @Override
    public int updateStudentEntity(StudentEntity studentEntity)
    {
        return studentEntityMapper.updateStudentEntity(studentEntity);
    }

    /**
     * 批量删除学员
     * 
     * @param ids 需要删除的学员ID
     * @return 结果
     */
    @Override
    public int deleteStudentEntityByIds(Integer[] ids)
    {
        return studentEntityMapper.deleteStudentEntityByIds(ids);
    }

    /**
     * 删除学员信息
     * 
     * @param id 学员ID
     * @return 结果
     */
    @Override
    public int deleteStudentEntityById(Integer id)
    {
        return studentEntityMapper.deleteStudentEntityById(id);
    }

    @Override
    public List<StudentEntity> findStudentByPhone(String phone) {
        List<StudentEntity> list = null;
        if(!phone.equals("")){
            list = this.studentEntityMapper.findStudentByPhone(phone);
        }
        return list;
    }

    @Override
    public List<StudentEntity> findStudentByPlace(String placeId) {
        return this.studentEntityMapper.findStudentByPlace(placeId);
    }
}
