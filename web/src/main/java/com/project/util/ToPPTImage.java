package com.project.util;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * .
 * 创建学员时创建用户
 *
 * @author Chenglin Zhu
 * @date 19-01-29 下午14:00
 */
public class ToPPTImage {

	private static final Logger LOGGER = LoggerFactory.getLogger(ToPPTImage.class);

	private void toImage2007(InputStream is) throws IOException {
		XMLSlideShow ppt = new XMLSlideShow(is);
		is.close();
		Dimension pgsize = ppt.getPageSize();
		LOGGER.info("pgsize:{}", pgsize.width + "--" + pgsize.height);
		for (int i = 0; i < ppt.getSlides().size(); i++) {
			//防止中文乱码
			for (XSLFShape shape : ppt.getSlides().get(i).getShapes()) {
				if (shape instanceof XSLFTextShape) {
					XSLFTextShape tsh = (XSLFTextShape) shape;
					for (XSLFTextParagraph p : tsh) {
						for (XSLFTextRun r : p) {
							r.setFontFamily("宋体");
						}
					}
				}
			}
			// 根据流转RGB图片
			BufferedImage img = new BufferedImage(pgsize.width, pgsize.height, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics = img.createGraphics();
			// clear the drawing area
			// 设置背景为白色
			// graphics.setPaint(Color.white);
			ppt.getSlides().get(i).getBackground().setFillColor(Color.white);
			graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width, pgsize.height));
			ppt.getSlides().get(i).draw(graphics);
			String fileName = "07-" + (i + 1) + ".png";
			// 将每张图片成流上传到文件服务器
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
			ImageIO.write(img, "png", imageOutput);
			InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		}
	}
}
