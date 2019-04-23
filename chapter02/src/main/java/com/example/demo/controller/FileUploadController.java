package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * chapter02 .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-4-22 .
 */
@RestController
public class FileUploadController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

	@PostMapping("/upload")
	public String upload(MultipartFile uploadFile, HttpServletRequest req) {
		String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
		String format = sdf.format(new Date());
		File folder = new File(realPath + format);
		if (!folder.isDirectory()) {
			folder.mkdirs();
		}
		String oldName = uploadFile.getOriginalFilename();
		String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
		try {
			uploadFile.transferTo(new File(folder, newName));
			String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + newName;
			return filePath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "上传失败！";
	}

	@PostMapping("/uploads")
	public String uploads(MultipartFile[] uploadFiles, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("/uploadFile/");
		String format = sdf.format(new Date());
		File folder = new File(path + format);
		if (!folder.isDirectory()) {
			folder.mkdirs();
		}
		for (MultipartFile uploadFile : uploadFiles) {
			String oldName = uploadFile.getOriginalFilename();
			String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
			try {
				uploadFile.transferTo(new File(folder, newName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "上传成功！";
	}
}
