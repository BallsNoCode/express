package com.kkb.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * @author APPDE
 */
public class SMSUtil {

    public static boolean send(String phoneNumber, String code) {
        //修改发送签名和密钥
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "签名", "密钥");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysAction("SendSms");
        request.setSysVersion("2017-05-25");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "快递e栈");
        request.putQueryParameter("TemplateCode", "模板Code值");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            String json = response.getData();
            Gson g = new Gson();
            HashMap result = g.fromJson(json, HashMap.class);
            if ("OK".equals(result.get("Message"))) {
                return true;
            } else {
                System.out.println("短信发送失败，原因：" + result.get("Message"));
            }
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }

}
