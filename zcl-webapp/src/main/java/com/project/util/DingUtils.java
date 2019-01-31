package com.project.util;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * JAVAWeb-Advanced .
 *
 * @description: .
 * @author: ChengLin Zhu .
 * @date: 19-1-30 .
 */
@Component
public class DingUtils {

	public static final String appSecret = "1x3vO0od7q19TWlUKpaXbXX9zLGuowRBs_m_sesLAkec2y565Wul1H-6hYAAViiB";
	public static final String appId = "dingoamnvms8eqby0op9se";
	public static final String code = "e5c21ad5890b39f883f4342d8b30def3";

	public String getSignnature(String timestamp) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(new SecretKeySpec(appSecret.getBytes("UTF-8"), "HmacSHA256"));
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

