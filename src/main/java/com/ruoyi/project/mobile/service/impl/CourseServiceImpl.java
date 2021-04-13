package com.ruoyi.project.mobile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.CourseEntityMapper;
import com.ruoyi.project.mobile.domain.CourseEntity;
import com.ruoyi.project.mobile.service.CourseService;

/**
 * 课程信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
@Service
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseEntityMapper courseEntityMapper;

    /**
     * 查询课程信息
     * 
     * @param id 课程信息ID
     * @return 课程信息
     */
    @Override
    public CourseEntity selectCourseEntityById(Integer id)
    {
        return courseEntityMapper.selectCourseEntityById(id);
    }

    /**
     * 查询课程信息列表
     * 
     * @param courseEntity 课程信息
     * @return 课程信息
     */
    @Override
    public List<CourseEntity> selectCourseEntityList(CourseEntity courseEntity)
    {
        return courseEntityMapper.selectCourseEntityList(courseEntity);
    }

    /**
     * 新增课程信息
     * 
     * @param courseEntity 课程信息
     * @return 结果
     */
    @Override
    public int insertCourseEntity(CourseEntity courseEntity)
    {
        return courseEntityMapper.insertCourseEntity(courseEntity);
    }

    /**
     * 修改课程信息
     * 
     * @param courseEntity 课程信息
     * @return 结果
     */
    @Override
    public int updateCourseEntity(CourseEntity courseEntity)
    {
        return courseEntityMapper.updateCourseEntity(courseEntity);
    }

    /**
     * 批量删除课程信息
     * 
     * @param ids 需要删除的课程信息ID
     * @return 结果
     */
    @Override
    public int deleteCourseEntityByIds(Integer[] ids)
    {
        return courseEntityMapper.deleteCourseEntityByIds(ids);
    }

    /**
     * 删除课程信息信息
     * 
     * @param id 课程信息ID
     * @return 结果
     */
    @Override
    public int deleteCourseEntityById(Integer id)
    {
        return courseEntityMapper.deleteCourseEntityById(id);
    }
}
