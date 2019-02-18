package com.project.controller;

import com.project.util.DingUtils;
import com.project.util.JNDIConnect;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	@Autowired
	private JNDIConnect jndiConnect;

	private static final String appSecret = "guV3zjYlLG2JHtKDcBhzgCxwGZDPwhSdy5BpIrgbd8bJo1yvYxQfGSpjgqyVfxkF";
	private static final String appId = "dingbxtvhkymfl0hzcjn";
	private static final String urlStr = "https://oapi.dingtalk.com/sns/getuserinfo_bycode?signature=SIGNATURE&timestamp=TIMESTAMP&accessKey=yourAppId";
	private static final String tokenStr = "https://oapi.dingtalk.com/gettoken?appkey=APPKEY&appsecret=APPSECRET";
	private static final String useridByUnionidStr = "https://oapi.dingtalk.com/user/getUseridByUnionid?unionid=UNIONID&access_token=ACCESS_TOKEN";
	private static final String userStr = "https://oapi.dingtalk.com/user/get?access_token=ACCESS_TOKEN&userid=USERID";

	// /user/test?id=1
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String test(HttpServletRequest request, Model model) throws IOException, JSONException, InvalidKeyException, NoSuchAlgorithmException {
		String code = request.getParameter("code");
		// 根据timestamp, appSecret计算签名值
		String timestamp = String.valueOf((new Date()).getTime());
		String urlEncodeSignature = dingUtils.getSignnature(timestamp);
		String userInfoUrl = urlStr.replaceAll("yourAppId", DingUtils.youAppId).replaceAll("TIMESTAMP", timestamp).replaceAll("SIGNATURE", urlEncodeSignature);
		//获取unionid
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tmp_auth_code", code);
		String body = jsonObject.toString();
		JSONObject userInforesultJson = postApiResponse(userInfoUrl, body);
		JSONObject userInfoJson = userInforesultJson.optJSONObject("user_info");
		if (userInfoJson == null) {
			model.addAttribute("userInforesultJson", userInforesultJson);
			return "home";
		}
		String unionid = userInfoJson.optString("unionid");
		//获取access_token
		String tokenUrl = tokenStr.replaceAll("APPKEY", appId).replaceAll("APPSECRET", appSecret);
		JSONObject resultJson = getApiResponse(tokenUrl);
		String access_token = resultJson.optString("access_token");
		//获取userid
		String useridByUnionidUrl = useridByUnionidStr.replaceAll("UNIONID", unionid).replaceAll("ACCESS_TOKEN", access_token);
		JSONObject json = getApiResponse(useridByUnionidUrl);
		String userid = json.optString("userid");
		if (StringUtils.isBlank(userid)) {
			model.addAttribute("json", json);
		}
		String userUrl = userStr.replaceAll("ACCESS_TOKEN", access_token).replaceAll("USERID", userid);
		JSONObject userJson = getApiResponse(userUrl);
		List<Map<String, Object>> list = jndiConnect.jndiConnect();
		model.addAttribute("list", list);
		model.addAttribute("userJson", userJson);
		model.addAttribute("userInforesultJson", userInforesultJson);
		model.addAttribute("userid", userid);
		return "home";
	}

	private JSONObject getApiResponse(String tokenUrl) throws IOException, JSONException {
		CloseableHttpClient getTokenClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(tokenUrl);
		HttpResponse response = getTokenClient.execute(httpGet);
		return new JSONObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
	}

	private JSONObject postApiResponse(String userInfoUrl, String body) throws IOException, JSONException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(userInfoUrl);
		post.setEntity(new StringEntity(body));
		HttpResponse response = httpClient.execute(post);
		return new JSONObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
	}

	@RequestMapping(value = "/jndi", method = RequestMethod.GET)
	public String testJndi(Model model) {
		List<Map<String, Object>> list = jndiConnect.jndiConnect();
		model.addAttribute("list", list);
		return "home";
	}
}
