package com.kkb.util;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author APPDE
 * @date 2022/4/24 19:03
 * @Version 1.0
 **/
public class ExpressUtil {

    public String queryNum(String number) {

        String host = "https://ali-deliver.showapi.com";
        String path = "/showapi_expInfo";
        String method = "GET";
        String appcode = "74bffa35c0124bbe8809c562b1621a83";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("com", "auto");
        querys.put("nu", number);
        querys.put("receiverPhone", "receiverPhone");
        querys.put("senderPhone", "senderPhone");
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //获取response的body
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "查询失败";
    }
}
