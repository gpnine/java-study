package com.project.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
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

	public static final String youAppSecret = "-8P1emmPpIL3OcdjQLGJittrTRUZmMQUGzAGXCjzjkQLEffxxK6sCXfo-OXqGmq4";
	public static final String youAppId = "dingoavmpchp8ecm7tibsx";

	public String getSignnature(String timestamp) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(new SecretKeySpec(youAppSecret.getBytes("UTF-8"), "HmacSHA256"));
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

