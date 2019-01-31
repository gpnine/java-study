package com.project.service;

import com.project.util.DingUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-30.
 */
@RequestMapping("/login")
public class LoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	private DingUtils dingUtils;

	public void login(HttpServletRequest request) throws JSONException, IOException, InvalidKeyException, NoSuchAlgorithmException {
		String code = request.getParameter("code");
		String timestamp = String.valueOf((new Date()).getTime());
		// 根据timestamp, appSecret计算签名值
		String urlEncodeSignature = dingUtils.getSignnature(timestamp);
		String urlStr = "https://oapi.dingtalk.com/sns/getuserinfo_bycode?signature=SIGNATURE&timestamp=TIMESTAMP&accessKey=yourAppId";
		String url = urlStr.replaceAll("yourAppId", DingUtils.appId).replaceAll("TIMESTAMP", timestamp).replaceAll("SIGNATURE", urlEncodeSignature);
		LOGGER.info("url:{}", url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tmp_auth_code", code);
		String body = jsonObject.toString();
		post.setEntity(new StringEntity(body));
		HttpResponse response = httpClient.execute(post);
		JSONObject resultJson = new JSONObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
		LOGGER.info("resultJson:{}", resultJson);
	}
}
