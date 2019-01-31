package com.zcl;

import com.project.util.DingUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * .
 *
 * @description: .
 * @author: ChengLin Zhu .
 * @date: 19-1-28 .
 */
public class TestDingLogin {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestDingLogin.class);

	@Autowired
	private DingUtils dingUtils;

	@Test
	public void login() throws IOException, JSONException, NoSuchAlgorithmException, InvalidKeyException {
		String timestamp = String.valueOf((new Date()).getTime());
		// 根据timestamp, appSecret计算签名值
		String urlEncodeSignature = getSignnature(timestamp);
		String urlStr = "https://oapi.dingtalk.com/sns/getuserinfo_bycode?signature=SIGNATURE&timestamp=TIMESTAMP&accessKey=yourAppId";
		String url = urlStr.replaceAll("yourAppId", DingUtils.appId).replaceAll("TIMESTAMP", timestamp).replaceAll("SIGNATURE", urlEncodeSignature);
		LOGGER.info("url:{}", url);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tmp_auth_code", DingUtils.code);
		String body = jsonObject.toString();
		post.setEntity(new StringEntity(body));
		HttpResponse response = httpClient.execute(post);
		JSONObject resultJson = new JSONObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
		LOGGER.info("resultJson:{}", resultJson);
	}

	@Test
	public void getResult() throws IOException, JSONException {
		String lastUrl = "https://oapi.dingtalk.com/sns/gettoken?appid=APPID&appsecret=APPSECRET";
		String url = lastUrl.replaceAll("APPID", DingUtils.appId).replaceAll("APPSECRET", DingUtils.appSecret);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = client.execute(httpGet);
		JSONObject resultJson = new JSONObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
		LOGGER.info("resultJson:{}", resultJson);
		String access_token = resultJson.optString("access_token");
		String getCodePath = "https://oapi.dingtalk.com/sns/get_persistent_code?access_token=ACCESS_TOKEN";
		String getCodeUrl = getCodePath.replaceAll("ACCESS_TOKEN", access_token);

		CloseableHttpClient client2 = HttpClients.createDefault();
		HttpPost post = new HttpPost(getCodeUrl);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("tmp_auth_code", DingUtils.code);
		String body = jsonObject.toString();
		post.setEntity(new StringEntity(body));
		HttpResponse response2 = client2.execute(post);
		JSONObject resultJson2 = new JSONObject(EntityUtils.toString(response2.getEntity(), "UTF-8"));
		LOGGER.info("resultJson2:{}", resultJson2);

	}

	private String getSignnature(String timestamp) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(new SecretKeySpec(DingUtils.appSecret.getBytes("UTF-8"), "HmacSHA256"));
		byte[] signatureBytes = mac.doFinal(timestamp.getBytes("UTF-8"));
		String signature = new String(Base64.encodeBase64(signatureBytes));
		return urlEncode(signature);
	}

	// encoding参数使用utf-8
	private String urlEncode(String value) {
		if (value == null) {
			return "";
		}
		try {
			String encoded = URLEncoder.encode(value, "UTF-8");
			return encoded.replace("+", "%20").replace("*", "%2A")
					.replace("~", "%7E").replace("/", "%2F");
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("FailedToEncodeUri", e);
		}
	}
}
