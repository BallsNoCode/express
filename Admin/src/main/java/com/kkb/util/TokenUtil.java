package com.kkb.util;

import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class TokenUtil {


	private static String token;
	private static long oldTime = 0;
	public String getToken2() {
		long newTime = System.currentTimeMillis();
		if (newTime - oldTime >= 7100000) {
			oldTime = newTime;
			try {
				setToken();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return token;
	}

	public static String getToken() {
		long newTime = System.currentTimeMillis();
		if (newTime - oldTime >= 7100000) {
			oldTime = newTime;
			try {
				setToken();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return token;
	}


	private static void setToken() throws Exception {
		String appid = "wxda16ffd678ae37f7";
		String secret = "3665bf2b4790512cf63ee66fb5061781";
		URL url = new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String text = null;
		while((text = br.readLine())!=null) {
			sb.append(text);
		}
		System.out.println(sb.toString());
		br.close();
		JSONObject obj = new JSONObject(sb.toString());
		token = obj.getString("access_token");
	}
}
