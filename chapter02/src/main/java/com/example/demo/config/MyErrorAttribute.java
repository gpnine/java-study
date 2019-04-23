package com.example.demo.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * chapter02 .
 *
 * @description: 自定义error数据.
 * @author: Chenglin Zhu .
 * @date: 19-4-23 .
 */
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
		errorAttributes.put("custommsg", "出错拉！");
		errorAttributes.remove("error");
		return errorAttributes;
	}
}
