package com.ruoyi.project.tegxunyun;

import cn.hutool.core.date.DateUtil;
import com.ruoyi.project.mobile.domain.SendMsgEntity;
import com.ruoyi.project.mobile.domain.StudentEntity;
import com.ruoyi.project.mobile.domain.StudentSignEntity;
import com.ruoyi.project.mobile.service.ISendMsgEntityService;
import com.ruoyi.project.mobile.service.StudentService;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class SendShorMsg {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ISendMsgEntityService sendMsgEntityService;

}
