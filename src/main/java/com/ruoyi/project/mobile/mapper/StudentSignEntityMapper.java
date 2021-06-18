package com.ruoyi.project.mobile.mapper;

import java.util.List;
import com.ruoyi.project.mobile.domain.StudentSignEntity;

/**
 * 学员签到Mapper接口
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
public interface StudentSignEntityMapper 
{
    /**
     * 查询学员签到
     * 
     * @param id 学员签到ID
     * @return 学员签到
     */
    public StudentSignEntity selectStudentSignEntityById(Integer id);

    /**
     * 查询学员签到列表
     * 
     * @param studentSignEntity 学员签到
     * @return 学员签到集合
     */
    public List<StudentSignEntity> selectStudentSignEntityList(StudentSignEntity studentSignEntity);

    /**
     * 查询学员签到列表新
     *
     * @param studentSignEntity 学员签到
     * @return 学员签到集合
     */
    public List<StudentSignEntity> selectStudentSignNew(StudentSignEntity studentSignEntity);

    /**
     * 根据手机号查询签到列表
     * @param tel
     * @return
     */
    public List<StudentSignEntity> selectStudentSignByTel(String tel);

    /**
     * 教练查询上课记录
     * @param tel
     * @return
     */
    public List<StudentSignEntity> coachFindSignDetails(String tel);


    /**
     * 新增学员签到
     * 
     * @param studentSignEntity 学员签到
     * @return 结果
     */
    public int insertStudentSignEntity(StudentSignEntity studentSignEntity);

    /**
     * 修改学员签到
     * 
     * @param studentSignEntity 学员签到
     * @return 结果
     */
    public int updateStudentSignEntity(StudentSignEntity studentSignEntity);

    /**
     * 删除学员签到
     * 
     * @param id 学员签到ID
     * @return 结果
     */
    public int deleteStudentSignEntityById(Integer id);

    /**
     * 批量删除学员签到
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStudentSignEntityByIds(Integer[] ids);

    /**
     * 根据日期查询营业额
     * @return
     */
    public String queryIncomeByDate(String startDate,String endDate);


}
