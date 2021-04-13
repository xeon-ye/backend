package com.ruoyi.project.mobile.mapper;

import java.util.List;
import com.ruoyi.project.mobile.domain.CourseEntity;

/**
 * 课程信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
public interface CourseEntityMapper 
{
    /**
     * 查询课程信息
     * 
     * @param id 课程信息ID
     * @return 课程信息
     */
    public CourseEntity selectCourseEntityById(Integer id);

    /**
     * 查询课程信息列表
     * 
     * @param courseEntity 课程信息
     * @return 课程信息集合
     */
    public List<CourseEntity> selectCourseEntityList(CourseEntity courseEntity);

    /**
     * 新增课程信息
     * 
     * @param courseEntity 课程信息
     * @return 结果
     */
    public int insertCourseEntity(CourseEntity courseEntity);

    /**
     * 修改课程信息
     * 
     * @param courseEntity 课程信息
     * @return 结果
     */
    public int updateCourseEntity(CourseEntity courseEntity);

    /**
     * 删除课程信息
     * 
     * @param id 课程信息ID
     * @return 结果
     */
    public int deleteCourseEntityById(Integer id);

    /**
     * 批量删除课程信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCourseEntityByIds(Integer[] ids);
}
