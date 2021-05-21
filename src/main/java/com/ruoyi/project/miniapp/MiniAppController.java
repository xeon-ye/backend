package com.ruoyi.project.miniapp;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.sign.Base64;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.miniapp.weixinpay.vo.Json;
import com.ruoyi.project.mobile.domain.*;
import com.ruoyi.project.mobile.service.*;
import com.ruoyi.project.system.domain.SysDictData;
import com.ruoyi.project.system.service.ISysDictDataService;
import com.ruoyi.project.system.service.ISysDictTypeService;
import com.ruoyi.project.tegxunyun.SendShorMsg;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.weixin4j.WeixinException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.text.DecimalFormat;
import java.util.*;

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
    @Autowired
    private ISysDictDataService dictDataService;
    @Autowired
    private ISysDictTypeService dictTypeService;
    @Autowired
    private ISendMsgEntityService sendMsgEntityService;
    @Autowired
    private IBtnMenuEntityService btnMenuEntityService;
    @Autowired
    private ChooseClassService chooseClassService;


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
     * 获取授权用户手机号
     *
     * @return
     */
    @RequestMapping("/getUserPhoneNumber")
    @ResponseBody
    public Object getUserPhoneNumber(String encryptedData, String sessionkey, String iv, String openid) {
        return this.weiXinPayService.getUserPhoneNumber(encryptedData, sessionkey, iv, openid);
    }


    /**
     * 保存用户信息
     */
    @RequestMapping("/saveUserInfo")
    @ResponseBody
    public int saveUserInfo(String openId, String userInfo) {

        return this.wxUserInfoService.saveUserInfoAndPhoneAndOpenId(openId, userInfo);
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
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findCoachAndClass/{state}")
    public List<Map<String, Object>> findCoachAndClass(@PathVariable String state) {
        return this.coachService.findCoachAndClass(state);
    }

    /**
     * 查询个人课程表(根据手机号)
     */
    @PostMapping("/findChooseClassRecordByPhone/{phone}/{state}")
    public List<ChooseClassEntity> findChooseClassRecordByPhone(@PathVariable String phone, @PathVariable String state) {
        List<ChooseClassEntity> listAll = new ArrayList<>();
        listAll = this.chooseClassService.findChooseClassRecordByPhone(phone, state);

        return listAll;
    }

    /**
     * 查询是否存在教练
     *
     * @return
     */
    @PostMapping("/findExistCoach/{phone}")
    public CoachEntity findExistCoach(@PathVariable String phone) {
        CoachEntity coachEntity = new CoachEntity();
        //手机号查询教练
        List<CoachEntity> coachEntitys = this.coachService.findCoachByPhone(phone);
        if (coachEntitys.size() > 0) {
            coachEntity = coachEntitys.get(0);
        }
        return coachEntity;
    }

    /**
     * 查询公告
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findGongGaoNotice/{type}")
    public List<NoticeEntity> findGongGaoNotice(@PathVariable Integer type) {
        return this.noticeService.findAllNoticeByType(type);
    }

    /**
     * 查询公告明细
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findNoticeDetail/{noticeId}")
    public NoticeEntity findNoticeDetail(@PathVariable Integer noticeId) {
        return this.noticeService.selectNoticeEntityById(noticeId);
    }

    /**
     * 查询消息列表
     *
     * @return
     */
    @PostMapping("/findXiaoxiListByTypeAndTel/{type}/{tel}")
    public List<NoticeEntity> findXiaoxiListByTypeAndTel(@PathVariable Integer type, @PathVariable String tel) {
        List<StudentEntity> studentEntityList = this.studentService.findStudentByPhone(tel);
        List<NoticeEntity> newnoticeEntityList = new ArrayList<>();
        if (studentEntityList.size() > 0) {
            for (StudentEntity stu : studentEntityList) {
                NoticeEntity noticeEntity = new NoticeEntity();
                noticeEntity.setType(String.valueOf(type));
                noticeEntity.setReceiveId(stu.getId());
                List<NoticeEntity> noticeEntityList = this.noticeService.selectNoticeEntityList(noticeEntity);
                newnoticeEntityList.addAll(noticeEntityList);
            }
        }
        return newnoticeEntityList;
    }

    /**
     * 查询学员列表
     */
    @PostMapping("/findStudentsList/{phone}/{placeId}")
    public List<StudentEntity> findStudentsList(@PathVariable String phone, @PathVariable String placeId) {
        List<StudentEntity> studentEntityList = null;
        //查询是否是教练
        List<CoachEntity> list = this.coachService.findCoachByPhone(phone);
        if (list.size() > 0) {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setPlaceId(placeId);
            studentEntityList = this.studentService.selectStudentEntityList(studentEntity);
        }
        return studentEntityList;
    }

    /**
     * 查询上课记录(根据学生id)
     */
    @PostMapping("/findClassRecord/{studentId}")
    public List<StudentSignEntity> findClassRecord(@PathVariable Integer studentId) {
        StudentSignEntity studentSignEntity = new StudentSignEntity();
        studentSignEntity.setStudentId(studentId);
        List<StudentSignEntity> list = this.studentSignService.selectStudentSignNew(studentSignEntity);
        return list;
    }

    /**
     * 查询个人上课记录(根据手机号)
     */
    @PostMapping("/findClassRecordByPhone/{phone}")
    public List<StudentSignEntity> findClassRecordByPhone(@PathVariable String phone) {
        List<StudentSignEntity> listAll = new ArrayList<>();
        listAll = this.studentSignService.selectStudentSignByTel(phone);

        return listAll;
    }


    /**
     * 查询缴费记录(根据手机号)
     */
    @PostMapping("/findTuiDetailsByPhone/{phone}")
    public List<TuitionEntity> findTuiDetailsByPhone(@PathVariable String phone) {
        List<TuitionEntity> listAll = new ArrayList<>();
        listAll = tuitionService.selectAllTuitionByPhone(phone);

        return listAll;
    }


    /**
     * 教练查询签到记录(根据手机号)
     */
    @PostMapping("/coachFindSignDetails/{phone}")
    public List<StudentSignEntity> coachFindSignDetails(@PathVariable String phone) {
        List<StudentSignEntity> listAll = new ArrayList<>();
        listAll = studentSignService.coachFindSignDetails(phone);

        return listAll;
    }

    /**
     * 查询手机号下绑定的学员
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/findStudentByPhone/{phone}")
    public List<StudentEntity> findStudentByPhone(@PathVariable String phone) {
        return this.studentService.findStudentByPhone(phone);
    }

    /**
     * 查询场地下的学员
     *
     * @return
     */
    @PostMapping("/queryStudentByPlace/{placeId}")
    public List<StudentEntity> queryStudentByPlace(@PathVariable String placeId) {
        return this.studentService.findStudentByPlace(placeId);
    }

    /**
     * 教练给学生签到
     *
     * @param
     * @param
     */
    @PostMapping("/studentSignByCoach")
    public AjaxResult studentSignByCoach(@RequestBody StudentSignEntity studentSignEntity) {
        Date date = DateUtil.date();
        String format = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
        String phone = studentSignEntity.getRemarks();
        //手机号查询教练
        List<CoachEntity> coachEntitys = this.coachService.findCoachByPhone(phone);
        studentSignEntity.setUserId(coachEntitys.get(0).getId());
        studentSignEntity.setSignTime(format);
        studentSignEntity.setRemarks("");

        try {
            CourseEntity courseEntity = this.courseService.selectCourseEntityById(studentSignEntity.getCourseId());
            StudentEntity studentEntity = this.studentService.selectStudentEntityById(studentSignEntity.getStudentId());

            //如果单价不为空,并且是单陪课
            if (studentEntity.getUnitPrice() != null && !studentEntity.getUnitPrice().equals("") && courseEntity.getId()!=1) {
                if(courseEntity.getClassHours().equals("1")){
                    studentEntity.setMoney(String.valueOf(Integer.parseInt(studentEntity.getMoney()) - Integer.parseInt(studentEntity.getUnitPrice())));
                    studentSignEntity.setMoney(studentEntity.getUnitPrice());//存入本节课价格
                }else{
                    String realMoney = Double.toString(Math.floor(Float.parseFloat(studentEntity.getUnitPrice())*Float.parseFloat(courseEntity.getClassHours())));
                    studentEntity.setMoney(String.valueOf(Integer.parseInt(studentEntity.getMoney()) - Integer.parseInt(subZeroAndDot(realMoney))));
                    studentSignEntity.setMoney(subZeroAndDot(realMoney));//存入本节课价格
                }

            } else {
                studentEntity.setMoney(String.valueOf(Integer.parseInt(studentEntity.getMoney()) - Integer.parseInt(courseEntity.getMoney())));
                studentSignEntity.setMoney(courseEntity.getMoney());//存入本节课价格
            }

            this.studentService.updateStudentEntity(studentEntity);
            this.studentSignService.insertStudentSignEntity(studentSignEntity);
            //发送短信
            sendYuEMsg(studentSignEntity, studentEntity.getParentTel());
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("签到失败");
        }
        return toAjax(1);
    }

    /**
     * 使用java正则表达式去掉多余的.与0
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s){
        if(s.indexOf(".") > 0){
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    /**
     * 查询场地列表
     *
     * @param placeEntity
     * @return
     */
    @PostMapping("/queryPlaces")
    public List<PlaceEntity> queryPlaces(@RequestBody PlaceEntity placeEntity, HttpServletRequest httpServletRequest) {
        List<PlaceEntity> list = this.placeService.selectPlaceEntityList(placeEntity);
        return list;
    }

    /**
     * 查询课程列表
     *
     * @param courseEntity
     * @return
     */
    @PostMapping("/queryCoures")
    public List<CourseEntity> queryCoures(@RequestBody CourseEntity courseEntity) {
        return this.courseService.selectCourseEntityList(courseEntity);
    }

    /**
     * 查询教练列表
     *
     * @param coachEntity
     * @return
     */
    @PostMapping("/queryCoach")
    public List<CoachEntity> queryCoach(@RequestBody CoachEntity coachEntity) {
        return this.coachService.selectCoachEntityList(coachEntity);
    }

    /**
     * 新增缴费记录
     *
     * @param
     * @return
     */
    @PostMapping("/addTuition/{studentId}/{money}/{orderNo}")
    public int addTuition(@PathVariable String studentId, @PathVariable String money, @PathVariable String orderNo) {
        Date date = DateUtil.date();
        String format = DateUtil.format(date, "yyyy-MM-dd");
        String desc = "";
        String newMoney = "";

        try {
            StudentEntity studentEntity = this.studentService.selectStudentEntityById(Integer.parseInt(studentId));
            if (studentEntity.getUnitPrice() != null && !studentEntity.getUnitPrice().equals("")) {
                studentEntity.setMoney(String.valueOf(Integer.parseInt(studentEntity.getMoney()) + Integer.parseInt(money)));
                desc = "冲" + money + ",不送,单节课" + studentEntity.getUnitPrice() + "元";
            } else {
                if (money.equals("1000")) {
                    newMoney = "1100";
                    desc = "冲1000送100";
                } else if (money.equals("3000")) {
                    newMoney = "3500";
                    desc = "冲3000送500";
                } else if (money.equals("5000")) {
                    newMoney = "6000";
                    desc = "冲5000送1000";
                } else if (money.equals("7000")) {
                    newMoney = "9500";
                    desc = "冲7000送2500";
                } else if (money.equals("9000")) {
                    newMoney = "13000";
                    desc = "冲9000送4000";
                } else {
                    newMoney = money;
                    desc = "自定义金额，冲" + money + "元,不送";
                }
                studentEntity.setMoney(String.valueOf(Integer.parseInt(studentEntity.getMoney()) + Integer.parseInt(newMoney)));
            }

            this.studentService.updateStudentEntity(studentEntity);
            TuitionEntity tuitionEntity = new TuitionEntity();
            tuitionEntity.setPayMoney(money);
            tuitionEntity.setPlaceId(Integer.parseInt(studentEntity.getPlaceId()));
            tuitionEntity.setStudentId(Integer.parseInt(studentId));
            tuitionEntity.setPayTime(format);
            tuitionEntity.setDescription(desc);
            tuitionEntity.setOrderno(orderNo);
            this.tuitionService.insertTuitionEntity(tuitionEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 新增缴费记录(根据手机号)
     *
     * @param
     * @return
     */
    @PostMapping("/addTuitionByPhone/{mobilePhone}/{money}/{orderNo}")
    public int addTuitionByPhone(@PathVariable String mobilePhone, @PathVariable String money, @PathVariable String orderNo) {
        Date date = DateUtil.date();
        String format = DateUtil.format(date, "yyyy-MM-dd");
        String desc = "";
        String newMoney = "";

        try {
            StudentEntity studentEntity = this.studentService.findStudentByPhone(mobilePhone).get(0);
            int yuanmoney = queryBalanceByPhone(studentEntity.getParentTel());
            if (studentEntity.getUnitPrice() != null && !studentEntity.getUnitPrice().equals("")) {
                studentEntity.setMoney(String.valueOf(Integer.parseInt(studentEntity.getMoney()) + Integer.parseInt(money)));
                desc = "冲" + money + ",不送,单节课" + studentEntity.getUnitPrice() + "元";
            } else {
                if (money.equals("1000")) {
                    newMoney = "1100";
                    desc = "充1000送100";
                } else if (money.equals("3000")) {
                    newMoney = "3500";
                    desc = "充3000送500";
                } else if (money.equals("5000")) {
                    newMoney = "6000";
                    desc = "充5000送1000";
                } else if (money.equals("7000")) {
                    newMoney = "9000";
                    desc = "充7000送2000";
                } else if (money.equals("9000")) {
                    newMoney = "12000";
                    desc = "充9000送3000";
                } else {
                    newMoney = money;
                    desc = "自定义金额，冲" + money + "元,不送";
                }
                studentEntity.setMoney(String.valueOf(Integer.parseInt(studentEntity.getMoney()) + Integer.parseInt(newMoney)));
            }

            this.studentService.updateStudentEntity(studentEntity);
            TuitionEntity tuitionEntity = new TuitionEntity();
            tuitionEntity.setPayMoney(money);
            tuitionEntity.setPlaceId(Integer.parseInt(studentEntity.getPlaceId()));
            tuitionEntity.setStudentId(studentEntity.getId());
            tuitionEntity.setPayTime(format);
            tuitionEntity.setDescription(desc);
            tuitionEntity.setOrderno(orderNo);
            this.tuitionService.insertTuitionEntity(tuitionEntity);

            sendTuitionSucMsg(studentEntity, money, String.valueOf(yuanmoney), studentEntity.getMoney());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    /**
     * 学员报名
     *
     * @param signUpEntity
     * @return
     */
    @PostMapping("/addSignUp")
    public int addSignUp(@RequestBody SignUpEntity signUpEntity) {
        Date date = DateUtil.date();
        String format = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
        try {
            signUpEntity.setSignTime(format);
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setParentTel(signUpEntity.getPhone());
            studentEntity.setName(signUpEntity.getName());
            studentEntity.setPlaceId("1");
            studentEntity.setRegistrTime(format);
            studentEntity.setMoney("0");
            this.studentService.insertStudentEntity(studentEntity);
            this.signUpEntityService.insertSignUpEntity(signUpEntity);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 查询所有商品
     *
     * @param storageEntity
     * @return
     */
    @PostMapping("/findAllStorages")
    public List<StorageEntity> findAllStorages(@RequestBody StorageEntity storageEntity) {
        return this.storageService.selectStorageEntityListNew(storageEntity);
    }

    /**
     * 查询首页菜单权限
     *
     * @param
     * @return
     */
    @PostMapping("/findAllBtnMenuByTel/{tel}")
    public List<BtnMenuEntity> findAllBtnMenu(@PathVariable String tel) {
        List<CoachEntity> coachEntityList = this.coachService.findCoachByPhone(tel);
        String type = "0";//普通用户
        if (coachEntityList.size() > 0) {
            type = "1";
        }
        BtnMenuEntity btnMenuEntity = new BtnMenuEntity();
        btnMenuEntity.setMenuRole(type);
        btnMenuEntity.setUseFlag("1");
        List<BtnMenuEntity> btnMenuEntityList = this.btnMenuEntityService.selectBtnMenuEntityList(btnMenuEntity);

        return btnMenuEntityList;
    }

    /**
     * 商品出库
     *
     * @param id
     * @param count
     * @return
     */
    @PostMapping("/outStorage/{id}/{count}/{tel}/{orderNo}")
    public AjaxResult outStorage(@PathVariable Integer id, @PathVariable String count, @PathVariable String tel, @PathVariable Integer orderNo) {
        BigDecimal count2 = new BigDecimal(count);
        Date date = DateUtil.date();
        String format = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
        try {
            StorageEntity storageEntity = this.storageService.selectStorageEntityById(id);
            if (storageEntity.getInventory() >= Integer.parseInt(count)) {
                storageEntity.setInventory(storageEntity.getInventory() - Integer.parseInt(count));
                storageService.updateStorageEntity(storageEntity);
                PurchaseDetailEntity purchaseDetailEntity = new PurchaseDetailEntity();
                purchaseDetailEntity.setBuyCount(count);
                purchaseDetailEntity.setBuyMoney(String.valueOf(storageEntity.getPrice().multiply(count2)));
                purchaseDetailEntity.setBuyTel(tel);
                purchaseDetailEntity.setBuyTime(format);
                purchaseDetailEntity.setStorageId(Long.valueOf(id));
                purchaseDetailEntity.setOrderno(orderNo);
                purchaseDetailEntityService.insertPurchaseDetailEntity(purchaseDetailEntity);
                return toAjax(1);
            } else {
                return AjaxResult.error("库存不足！");
            }
        } catch (Exception e) {
            return toAjax(0);
        }
    }


    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return 参数键值
     */
    @PostMapping("/getDictType/{dictType}")
    public List<SysDictData> getDictType(@PathVariable String dictType) {
        return dictTypeService.selectDictDataByType(dictType);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @PostMapping("/getDictLabel/{dictType}/{dictValue}")
    public String getDictLabel(@PathVariable String dictType, @PathVariable String dictValue) {
        return dictDataService.selectDictLabel(dictType, dictValue);
    }

    /**
     * 根据手机号查询余额
     *
     * @param phone
     * @return
     */
    @PostMapping("/queryBalanceByPhone/{phone}")
    public int queryBalanceByPhone(@PathVariable String phone) {
        List<StudentEntity> list = this.studentService.findStudentByPhone(phone);
        int money = 0;
        for (StudentEntity studentEntity : list) {
            money = money + Integer.parseInt(studentEntity.getMoney());
        }
        return money;
    }


    /**
     * 余额变动通知
     *
     * @param
     */
    public void sendYuEMsg(StudentSignEntity studentSignEntity, String tel) {
        StudentEntity studentEntity = this.studentService.selectStudentEntityById(studentSignEntity.getStudentId());

        int allMoney = queryBalanceByPhone(tel);
        try {
            Date date = DateUtil.date();
            String format = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
            Credential cred = new Credential("AKID2SdZGi9rYzqSpvhOybkeHfmcJl47lRiF", "R8ZjdJkwSt87WltukJdq1wb6SdaFi0xe");
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setReqMethod("POST");
            httpProfile.setConnTimeout(60);
            httpProfile.setEndpoint("sms.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            /* SDK 默认用 TC3-HMAC-SHA256 进行签名
             * 非必要请不要修改该字段 */
            clientProfile.setSignMethod("HmacSHA256");
            clientProfile.setHttpProfile(httpProfile);
            SmsClient client = new SmsClient(cred, "ap-guangzhou", clientProfile);
            SendSmsRequest req = new SendSmsRequest();
            String appid = "1400510386";
            req.setSmsSdkAppid(appid);
            /* 短信签名内容: 使用 UTF-8 编码，必须填写已审核通过的签名，可登录 [短信控制台] 查看签名信息 */
            String sign = "零之启乒乓";
            req.setSign(sign);
            /* 国际/港澳台短信 senderid: 国内短信填空，默认未开通，如需开通请联系 [sms helper] */
            String senderid = "";
            req.setSenderId(senderid);
            /* 用户的 session 内容: 可以携带用户侧 ID 等上下文信息，server 会原样返回 */
            /* 短信码号扩展号: 默认未开通，如需开通请联系 [sms helper] */
            /* 模板 ID: 必须填写已审核通过的模板 ID，可登录 [短信控制台] 查看模板 ID */
            String templateID = "932023";
            req.setTemplateID(templateID);
            /* 下发手机号码，采用 e.164 标准，+[国家或地区码][手机号]
             * 例如+8613711112222， 其中前面有一个+号 ，86为国家码，13711112222为手机号，最多不要超过200个手机号*/
            String[] phoneNumbers = {"+86" + studentEntity.getParentTel()};
            req.setPhoneNumberSet(phoneNumbers);
            /* 模板参数: 若无模板参数，则设置为空*/
//            String[] templateParams = {studentEntity.getName(),format,String.valueOf(studentSignEntity.getMoney()),studentEntity.getMoney()};
            String[] templateParams = {studentEntity.getName(), format, String.valueOf(studentSignEntity.getMoney()), String.valueOf(allMoney)};
            req.setTemplateParamSet(templateParams);
            SendSmsResponse res = client.SendSms(req);
            // 输出 JSON 格式的字符串回包
            System.out.println(SendSmsResponse.toJsonString(res));
            // 可以取出单个值，您可以通过官网接口文档或跳转到 response 对象的定义处查看返回字段的定义
            System.out.println(res.getRequestId());


            SendMsgEntity sendMsgEntity = new SendMsgEntity();
            sendMsgEntity.setContent("您好，您的孩子" + studentEntity.getName() + "于" + format + "签到，本节价格为"
                    + studentSignEntity.getMoney() + "元，剩余金额为" + allMoney + "元");
            sendMsgEntity.setSendTime(format);
            sendMsgEntity.setSendMobile(studentEntity.getParentTel());
            this.sendMsgEntityService.insertSendMsgEntity(sendMsgEntity);


        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
    }


    /**
     * 充值成功通知
     *
     * @param
     */
    public void sendTuitionSucMsg(StudentEntity studentEntity, String money, String yuanmoney, String newMoney) {
        try {
            int allMoney = queryBalanceByPhone(studentEntity.getParentTel());
            Date date = DateUtil.date();
            String format = DateUtil.format(date, "yyyy-MM-dd HH:mm:ss");
            Credential cred = new Credential("AKID2SdZGi9rYzqSpvhOybkeHfmcJl47lRiF", "R8ZjdJkwSt87WltukJdq1wb6SdaFi0xe");
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setReqMethod("POST");
            httpProfile.setConnTimeout(60);
            httpProfile.setEndpoint("sms.tencentcloudapi.com");
            ClientProfile clientProfile = new ClientProfile();
            /* SDK 默认用 TC3-HMAC-SHA256 进行签名
             * 非必要请不要修改该字段 */
            clientProfile.setSignMethod("HmacSHA256");
            clientProfile.setHttpProfile(httpProfile);
            SmsClient client = new SmsClient(cred, "ap-guangzhou", clientProfile);
            SendSmsRequest req = new SendSmsRequest();
            String appid = "1400510386";
            req.setSmsSdkAppid(appid);
            /* 短信签名内容: 使用 UTF-8 编码，必须填写已审核通过的签名，可登录 [短信控制台] 查看签名信息 */
            String sign = "零之启乒乓";
            req.setSign(sign);
            /* 国际/港澳台短信 senderid: 国内短信填空，默认未开通，如需开通请联系 [sms helper] */
            String senderid = "";
            req.setSenderId(senderid);
            /* 用户的 session 内容: 可以携带用户侧 ID 等上下文信息，server 会原样返回 */
            /* 短信码号扩展号: 默认未开通，如需开通请联系 [sms helper] */
            /* 模板 ID: 必须填写已审核通过的模板 ID，可登录 [短信控制台] 查看模板 ID */
            String templateID = "933073";
            req.setTemplateID(templateID);
            /* 下发手机号码，采用 e.164 标准，+[国家或地区码][手机号]
             * 例如+8613711112222， 其中前面有一个+号 ，86为国家码，13711112222为手机号，最多不要超过200个手机号*/
            String[] phoneNumbers = {"+86" + studentEntity.getParentTel()};
            req.setPhoneNumberSet(phoneNumbers);
            /* 模板参数: 若无模板参数，则设置为空*/
            String[] templateParams = {format, money, yuanmoney, String.valueOf(allMoney)};
            req.setTemplateParamSet(templateParams);
            SendSmsResponse res = client.SendSms(req);
            // 输出 JSON 格式的字符串回包
            System.out.println(SendSmsResponse.toJsonString(res));
            // 可以取出单个值，您可以通过官网接口文档或跳转到 response 对象的定义处查看返回字段的定义
            System.out.println(res.getRequestId());


            SendMsgEntity sendMsgEntity = new SendMsgEntity();
            sendMsgEntity.setContent("尊敬的客户，您好，您于" + format + "成功充值" + money + "元，充值前账户余额为" + yuanmoney + "元，充值后账户余额为" + allMoney + "元，感谢您对我们的信赖");
            sendMsgEntity.setSendTime(format);
            sendMsgEntity.setSendMobile(studentEntity.getParentTel());
            this.sendMsgEntityService.insertSendMsgEntity(sendMsgEntity);

        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
    }

}
