package com.ruoyi.project.miniapp;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.miniapp.weixinpay.vo.Json;
import com.ruoyi.project.mobile.domain.*;
import com.ruoyi.project.mobile.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.weixin4j.WeixinException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 小程序 Controller
 *
 * @author ruoyi
 * @date 2021-03-10
 */
@RestController
@RequestMapping("/weixin")
public class MiniAppController extends BaseController {
    @Autowired
    private WeiXinPayService weiXinPayService;
    @Autowired
    private WxUserInfoService wxUserInfoService;
    @Autowired
    private CoachService coachService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private StudentSignService studentSignService;
    @Autowired
    private PlaceService placeService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TuitionService tuitionService;
    @Autowired
    private ISignUpEntityService signUpEntityService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private IPurchaseDetailEntityService purchaseDetailEntityService;


    /**
     * 小程序后台登录，向微信平台发送获取access_token请求，并返回openId
     *
     * @param code
     * @return openid
     * @throws WeixinException
     * @throws IOException
     * @author: lzq
     * @date: 2018年7月3日
     * @since Weixin4J 1.0.0
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String code) throws WeixinException, IOException {
        return this.weiXinPayService.login(code);
    }

    /**
     * 发起微信支付
     *
     * @param openid
     * @param request
     * @author: lzq
     * @date: 2018年7月3日
     */
    @RequestMapping("/wxPay")
    @ResponseBody
    public Json wxPay(String openid, HttpServletRequest request, String paidOrderId, String money) {
        return this.weiXinPayService.wxPay(openid, request, paidOrderId, money);
    }

    /**
     * 微信支付
     *
     * @throws Exception
     * @throws WeixinException
     * @author: lzq
     * @date: 2018年7月3日
     */
    @RequestMapping(value = "/wxNotify")
    @ResponseBody
    public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        this.weiXinPayService.wxNotify(request, response);
    }


    /**
     * 获取用户信息
     *
     * @throws WeixinException
     * @throws IOException
     * @author: lzq
     * @date: 2018年7月3日
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(String sessionkey, String encryptedData, String iv, String openid, String userInfos) {
        return this.weiXinPayService.getUserInfo(sessionkey, encryptedData, iv, openid, userInfos);
    }

    /**
     * 保存用户信息
     */
    @RequestMapping("/saveUserInfo")
    @ResponseBody
    public void saveUserInfo(String openId, String userInfo) {

        this.wxUserInfoService.saveUserInfoAndPhoneAndOpenId(openId, userInfo);
    }

    /**
     * 查询用户信息
     */
    @PostMapping("/findWxUserInfoByOpenId/{openId}")
    public WxUserInfoEntity findWxUserInfoByOpenId(@PathVariable String openId) {
        WxUserInfoEntity wxUserInfoEntity = this.wxUserInfoService.findWxUserInfoByOpenId(openId);
        return wxUserInfoEntity;
    }

    /**
     * 查询教练和课程列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/findCoachAndClass/{state}")
    public List<Map<String, Object>> findCoachAndClass(@PathVariable String state){
        return this.coachService.findCoachAndClass(state);
    }

    /**
     * 查询是否存在教练
     * @return
     */
    @PostMapping("/findExistCoach/{phone}")
    public CoachEntity findExistCoach(@PathVariable String phone){
        //手机号查询教练
        List<CoachEntity> coachEntitys = this.coachService.findCoachByPhone(phone);
        return coachEntitys.get(0);
    }

    /**
     * 查询公告
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/findGongGaoNotice/{type}")
    public List<NoticeEntity> findGongGaoNotice(@PathVariable Integer type){
        return this.noticeService.findAllNoticeByType(type);
    }

    /**
     * 查询学员列表
     */
    @PostMapping("/findStudentsList/{phone}/{placeId}")
    public List<StudentEntity> findStudentsList(@PathVariable String phone, @PathVariable String placeId){
        List<StudentEntity> studentEntityList =null;
        //查询是否是教练
        List<CoachEntity> list = this.coachService.findCoachByPhone(phone);
        if(list.size()>0){
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setPlaceId(placeId);
            studentEntityList = this.studentService.selectStudentEntityList(studentEntity);
        }
        return studentEntityList;
    }

    /**
     * 查询上课记录
     */
    @PostMapping("/findClassRecord/{studentId}")
    public List<StudentSignEntity> findClassRecord(@PathVariable Integer studentId){
        StudentSignEntity studentSignEntity = new StudentSignEntity();
        studentSignEntity.setStudentId(studentId);
        List<StudentSignEntity> list = this.studentSignService.selectStudentSignNew(studentSignEntity);
        return list;
    }

    /**
     * 查询手机号下绑定的学员
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/findStudentByPhone/{phone}")
    public List<StudentEntity> findStudentByPhone(@PathVariable String phone){
        return this.studentService.findStudentByPhone(phone);
    }

    /**
     * 查询场地下的学员
     * @return
     */
    @PostMapping("/queryStudentByPlace/{placeId}")
    public List<StudentEntity> queryStudentByPlace(@PathVariable String placeId){
        return this.studentService.findStudentByPlace(placeId);
    }

    /**
     * 教练给学生签到
     * @param
     * @param
     */
    @PostMapping("/studentSignByCoach")
    public AjaxResult studentSignByCoach(@RequestBody StudentSignEntity studentSignEntity){
        Date date = DateUtil.date();
        String format = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
        String phone = studentSignEntity.getRemarks();
        //手机号查询教练
        List<CoachEntity> coachEntitys = this.coachService.findCoachByPhone(phone);
        studentSignEntity.setUserId(coachEntitys.get(0).getId());
        studentSignEntity.setSignTime(format);
        studentSignEntity.setRemarks("");

        try {
            CourseEntity courseEntity =this.courseService.selectCourseEntityById(studentSignEntity.getCourseId());
            StudentEntity studentEntity = this.studentService.selectStudentEntityById(studentSignEntity.getStudentId());

            if(studentEntity.getUnitPrice()!=null && !studentEntity.getUnitPrice().equals("")  && studentSignEntity.getCourseId()==9){//如果单价不为空,并且是单陪课
                studentEntity.setMoney(String.valueOf(Integer.parseInt(studentEntity.getMoney())-Integer.parseInt(studentEntity.getUnitPrice())));
                studentSignEntity.setMoney(Integer.parseInt(studentEntity.getUnitPrice()));//存入本节课价格
            }else{
                studentEntity.setMoney(String.valueOf(Integer.parseInt(studentEntity.getMoney())-Integer.parseInt(courseEntity.getMoney())));
                studentSignEntity.setMoney(Integer.parseInt(courseEntity.getMoney()));//存入本节课价格
            }

            this.studentService.updateStudentEntity(studentEntity);
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error("签到失败");
        }
        return toAjax(this.studentSignService.insertStudentSignEntity(studentSignEntity));
    }

    /**
     * 查询场地列表
     * @param placeEntity
     * @return
     */
    @PostMapping("/queryPlaces")
    public List<PlaceEntity> queryPlaces(@RequestBody PlaceEntity placeEntity,HttpServletRequest httpServletRequest){
        List<PlaceEntity> list = this.placeService.selectPlaceEntityList(placeEntity);
        return list;
    }

    /**
     * 查询课程列表
     * @param courseEntity
     * @return
     */
    @PostMapping("/queryCoures")
    public List<CourseEntity> queryCoures(@RequestBody CourseEntity courseEntity){
        return this.courseService.selectCourseEntityList(courseEntity);
    }

    /**
     * 查询教练列表
     * @param coachEntity
     * @return
     */
    @PostMapping("/queryCoach")
    public List<CoachEntity> queryCoach(@RequestBody CoachEntity coachEntity){
        return this.coachService.selectCoachEntityList(coachEntity);
    }

    /**
     * 新增缴费记录
     * @param
     * @return
     */
    @PostMapping("/addTuition/{studentId}/{money}")
    public int addTuition(@PathVariable String studentId,@PathVariable String money){
        Date date = DateUtil.date();
        String format = DateUtil.format(date, "yyyy-MM-dd");
        String desc = "";
        String newMoney = "";

        try {
            StudentEntity studentEntity = this.studentService.selectStudentEntityById(Integer.parseInt(studentId));
            if(studentEntity.getUnitPrice()!=null && !studentEntity.getUnitPrice().equals("")){
                studentEntity.setMoney(String.valueOf(Integer.parseInt(studentEntity.getMoney())+Integer.parseInt(money)));
                desc = "冲"+money+",不送,单节课"+studentEntity.getUnitPrice()+"元";
            }else{
                if(money.equals("0.01")){
                    newMoney="1100";
                    desc = "冲1000送100";
                }else if(money.equals("3000")){
                    newMoney="3500";
                    desc = "冲3000送500";
                }else if(money.equals("5000")){
                    newMoney="6000";
                    desc = "冲5000送1000";
                }else if(money.equals("7000")){
                    newMoney="9500";
                    desc = "冲7000送2500";
                }else if(money.equals("9000")){
                    newMoney="13000";
                    desc = "冲9000送4000";
                }
                studentEntity.setMoney(String.valueOf(Integer.parseInt(studentEntity.getMoney())+Integer.parseInt(newMoney)));
            }

            this.studentService.updateStudentEntity(studentEntity);
            TuitionEntity tuitionEntity = new TuitionEntity();
            tuitionEntity.setPayMoney(money);
            tuitionEntity.setPlaceId(Integer.parseInt(studentEntity.getPlaceId()));
            tuitionEntity.setStudentId(Integer.parseInt(studentId));
            tuitionEntity.setPayTime(format);
            tuitionEntity.setDescription(desc);
            this.tuitionService.insertTuitionEntity(tuitionEntity);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    /**
     * 学员报名
     * @param signUpEntity
     * @return
     */
    @PostMapping("/addSignUp")
    public int addSignUp(@RequestBody SignUpEntity signUpEntity){
        Date date = DateUtil.date();
        String format = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
        signUpEntity.setSignTime(format);
        return this.signUpEntityService.insertSignUpEntity(signUpEntity);
    }

    /**
     * 查询所有商品
     * @param storageEntity
     * @return
     */
    @PostMapping("/findAllStorages")
    public List<StorageEntity> findAllStorages(@RequestBody StorageEntity storageEntity){
        return this.storageService.selectStorageEntityList(storageEntity);
    }

    /**
     * 商品出库
     * @param id
     * @param count
     * @return
     */
    @PostMapping("/outStorage/{id}/{count}/{tel}")
    public AjaxResult outStorage(@PathVariable Integer id,@PathVariable String count,@PathVariable String tel){
        BigDecimal count2 = new BigDecimal(count);
        Date date = DateUtil.date();
        String format = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
        try {
            StorageEntity storageEntity = this.storageService.selectStorageEntityById(id);
            if(storageEntity.getInventory()>=Integer.parseInt(count)){
                storageEntity.setInventory(storageEntity.getInventory()-Integer.parseInt(count));
                storageService.updateStorageEntity(storageEntity);
                PurchaseDetailEntity purchaseDetailEntity = new PurchaseDetailEntity();
                purchaseDetailEntity.setBuyCount(count);
                purchaseDetailEntity.setBuyMoney(String.valueOf(storageEntity.getPrice().multiply(count2)));
                purchaseDetailEntity.setBuyTel(tel);
                purchaseDetailEntity.setBuyTime(format);
                purchaseDetailEntity.setStorageId(Long.valueOf(id));
                purchaseDetailEntityService.insertPurchaseDetailEntity(purchaseDetailEntity);
                return toAjax(1);
            }else{
                return AjaxResult.error("库存不足！");
            }
        }catch (Exception e){
            return toAjax(0);
        }
    }



    @GetMapping(value = "/showImg")
    public void showImg(HttpServletResponse response, String pathName) {
        File imgFile = new File(pathName);
        FileInputStream fin = null;
        OutputStream output = null;
        try {
            output = response.getOutputStream();
            fin = new FileInputStream(imgFile);
            byte[] arr = new byte[1024 * 10];
            int n;
            while ((n = fin.read(arr)) != -1) {
                output.write(arr, 0, n);
            }
            output.flush();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            output.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
