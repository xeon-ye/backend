package com.ruoyi.project.baidu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.baidu.utils.Base64Util;
import com.ruoyi.project.baidu.utils.FileUtil;
import com.ruoyi.project.baidu.utils.GsonUtils;
import com.ruoyi.project.baidu.utils.HttpUtil;

@Service
public class ImageService {

    @Autowired
    private BdAuthService authService;

    public String classify(String imgUrl) {
    	// 请求url
    	String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/classification/lajikaohe";
        try {
            String localUrl = RuoYiConfig.getProfile() + imgUrl.substring(8);// 去掉/profile
            // 转成base64
            byte[] fileByte = FileUtil.readFileByBytes(localUrl);
            String base64 = Base64Util.encode(fileByte);

//            String imgParam = URLEncoder.encode(base64, "UTF-8");
            
            Map<String, Object> map = new HashMap<>();
            map.put("image", base64);
            map.put("top_num", "5");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = authService.getAuth();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
//            System.out.println(result);
            return result;
        } catch (Exception e) {
            System.out.println("调用百度图像识别失败！");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 图像分类
     * <p>
     * 0-其他 1-整体照片 2-桶身 3-桶口 4-公示栏 5-指示栏 6-宣传栏 7-大件/装修垃圾
     * 
     * @param imgUrl
     * @return
     * @throws IOException
     */
    public Map<String, Object> imgClassify(String imgUrl) {
        try {
            String result = classify(imgUrl);
            if(result == null) {
            	return null;
            }
            // 解析返回结果
            JSONObject json = JSON.parseObject(result);
            JSONArray resultArray = json.getJSONArray("results");
            if(resultArray!=null && resultArray.size()>0) {
            	JSONObject resultObj = resultArray.getJSONObject(0);
            	String name = resultObj.getString("name");
            	Double score = resultObj.getDouble("score");
            	Map<String, Object> map = new HashMap<String, Object>();
            	map.put("name", name);
            	map.put("score", score);
            	if("整体照片".equals(name)) {
            		map.put("type", "1");
            	}else if("桶身".equals(name)){
            		map.put("type", "2");
            	}else if("桶口".equals(name)){
            		map.put("type", "3");
            	}else if("公示栏".equals(name)){
            		map.put("type", "4");
            	}else if("指示栏".equals(name)){
            		map.put("type", "5");
            	}else if("宣传栏".equals(name)){
            		map.put("type", "6");
            	}else if("大件装修垃圾".equals(name)){
            		map.put("type", "7");
            		map.put("name", "大件/装修垃圾");
            	}else {
            		map.put("type", "0");
            		map.put("name", "其他");
            	}
            	return map;
            }else {
            	System.out.println("调用百度图像识别失败！"+result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return null;
    }

}
