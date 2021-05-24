package com.ruoyi.project.mobile.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mobile.mapper.StudentSignEntityMapper;
import com.ruoyi.project.mobile.domain.StudentSignEntity;
import com.ruoyi.project.mobile.service.StudentSignService;

/**
 * 学员签到Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-03-20
 */
@Service
public class StudentSignServiceImpl implements StudentSignService
{
    @Autowired
    private StudentSignEntityMapper studentSignEntityMapper;

    /**
     * 查询学员签到
     * 
     * @param id 学员签到ID
     * @return 学员签到
     */
    @Override
    public StudentSignEntity selectStudentSignEntityById(Integer id)
    {
        return studentSignEntityMapper.selectStudentSignEntityById(id);
    }

    /**
     * 查询学员签到列表
     * 
     * @param studentSignEntity 学员签到
     * @return 学员签到
     */
    @Override
    public List<StudentSignEntity> selectStudentSignEntityList(StudentSignEntity studentSignEntity)
    {
        return studentSignEntityMapper.selectStudentSignEntityList(studentSignEntity);
    }

    @Override
    public List<StudentSignEntity> selectStudentSignNew(StudentSignEntity studentSignEntity)
    {
        return studentSignEntityMapper.selectStudentSignNew(studentSignEntity);
    }

    @Override
    public List<StudentSignEntity> selectStudentSignByTel(String tel) {
        return studentSignEntityMapper.selectStudentSignByTel(tel);
    }

    @Override
    public List<StudentSignEntity> coachFindSignDetails(String tel) {
        return studentSignEntityMapper.coachFindSignDetails(tel);
    }


    /**
     * 新增学员签到
     * 
     * @param studentSignEntity 学员签到
     * @return 结果
     */
    @Override
    public int insertStudentSignEntity(StudentSignEntity studentSignEntity)
    {
        return studentSignEntityMapper.insertStudentSignEntity(studentSignEntity);
    }

    /**
     * 修改学员签到
     * 
     * @param studentSignEntity 学员签到
     * @return 结果
     */
    @Override
    public int updateStudentSignEntity(StudentSignEntity studentSignEntity)
    {
        return studentSignEntityMapper.updateStudentSignEntity(studentSignEntity);
    }

    /**
     * 批量删除学员签到
     * 
     * @param ids 需要删除的学员签到ID
     * @return 结果
     */
    @Override
    public int deleteStudentSignEntityByIds(Integer[] ids)
    {
        return studentSignEntityMapper.deleteStudentSignEntityByIds(ids);
    }

    /**
     * 删除学员签到信息
     * 
     * @param id 学员签到ID
     * @return 结果
     */
    @Override
    public int deleteStudentSignEntityById(Integer id)
    {
        return studentSignEntityMapper.deleteStudentSignEntityById(id);
    }

    @Override
    public Integer queryTodayIncome() {
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        String startDate = sdf.format(date)+" 00:00:00";
        String endDate = sdf.format(date)+" 23:59:59";
        Integer re = studentSignEntityMapper.queryTodayIncome(startDate,endDate);
        if(re==null){
           return 0;
        }else{
           return re;
        }
    }

    @Override
    public String queryMonthIncome() {
        //计算本月第一天
        Calendar firstDay=Calendar.getInstance();//获取当前时间
        firstDay.set(Calendar.DAY_OF_MONTH, 1);//日期设置为一号，就是第一天了
        String startDate = new SimpleDateFormat("yyyy-MM-dd").format(firstDay.getTime());
        //计算本月最后一天
        Calendar lastDay=Calendar.getInstance();//获取当前时间
        lastDay.add(Calendar.MONTH, 1);//月份设置为下个月
        lastDay.set(Calendar.DAY_OF_MONTH,1);//日期设置为1号
        lastDay.add(Calendar.DAY_OF_MONTH, -1);//倒回到前一天
        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(lastDay.getTime());
        String re = studentSignEntityMapper.queryMonthIncome(startDate,endDate);
        if(re==null){
            return "0";
        }else{
            return re;
        }
    }
}
