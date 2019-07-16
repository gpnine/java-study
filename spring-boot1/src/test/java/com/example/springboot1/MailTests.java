package com.example.springboot1;

import com.example.springboot1.bean.VelocityEngineBean;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.StringWriter;

/**
 * spring-boot1 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-7-16 .
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailTests {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngineBean velocityEngine;

	@Test
	public void sendSimpleMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("632571743@qq.com");
		message.setTo("632571743@qq.com");
		message.setSubject("主题：简单邮件");
		message.setText("hello,It is me!测试邮件内容");
		mailSender.send(message);
	}

	@Test
	public void sendAttachmentsMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("632571743@qq.com");
		helper.setTo("632571743@qq.com");
		helper.setSubject("主题：有附件");
		helper.setText("有附件的邮件");

		FileSystemResource file = new FileSystemResource(new File("./src/main/resources/static/weixin.png"));
		helper.addAttachment("附件-1.jpg", file);
		helper.addAttachment("附件-2.jpg", file);

		mailSender.send(mimeMessage);

	}

	@Test
	public void sendInlineMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("632571743@qq.com");
		helper.setTo("1255780376@qq.com");
		helper.setSubject("主题：嵌入静态资源");
		helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

		FileSystemResource file = new FileSystemResource(new File("./src/main/resources/static/weixin.png"));
		helper.addInline("weixin", file);

		mailSender.send(mimeMessage);

	}

	@Test
	public void sendTemplateMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("632571743@qq.com");
		helper.setTo("632571743@qq.com");
		helper.setSubject("主题：模板邮件");

		VelocityContext context = new VelocityContext();
		context.put("username", "朱成琳");
		StringWriter stringWriter = new StringWriter();
		// 需要注意第1个参数要全路径，否则会抛异常
		this.velocityEngine.mergeTemplate("./src/main/resources/templates/template.vm", "UTF-8", context, stringWriter);
		helper.setText(stringWriter.toString(), true);

		mailSender.send(mimeMessage);
	}
}
