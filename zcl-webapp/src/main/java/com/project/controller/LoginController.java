package com.project.controller;

import com.project.entity.User;
import com.project.util.DingUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * JAVAWeb-Advanced .
 *
 * @description: .
 * @author: ChengLin Zhu .
 * @date: 19-1-30 .
 */
@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private DingUtils dingUtils;

	private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	// /user/test?id=1
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String test(HttpServletRequest request, Model model) {
		String code = request.getParameter("code");
		String timestamp = String.valueOf((new Date()).getTime());
		LOGGER.info("timestamp:{}", timestamp);
		// 根据timestamp, appSecret计算签名值
		String urlEncodeSignature;
		JSONObject resultJson = new JSONObject();
		try {
			urlEncodeSignature = dingUtils.getSignnature(timestamp);
			String urlStr = "https://oapi.dingtalk.com/sns/getuserinfo_bycode?signature=kKlP1QmmiNR4VF&timestamp=1527130370219&accessKey=yourAppId";
			String url = urlStr.replaceAll("yourAppId", dingUtils.appId).replaceAll("1527130370219", timestamp).replaceAll("kKlP1QmmiNR4VF", urlEncodeSignature);
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("tmp_auth_code", code);
			String body = jsonObject.toString();
			post.setEntity(new StringEntity(body));
			HttpResponse response = httpClient.execute(post);
			resultJson = new JSONObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		model.addAttribute("resultJson", resultJson);
		return "home";
	}
}
