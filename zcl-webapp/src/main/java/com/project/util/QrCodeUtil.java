package com.project.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * zcl-webapp .
 *
 * @description: .
 * @author: ChengLin Zhu .
 * @date: 19-2-20 .
 */
public class QrCodeUtil {

	public static void main(String[] args) {
		String url = "http://www.baidu.com";
		String path = FileSystemView.getFileSystemView().getHomeDirectory() + File.separator + "testQrcode";
		String fileName = "temp.jpg";
		createQrCode(url, path, fileName);
	}

	private static void createQrCode(String url, String path, String fileName) {
		try {
			Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
			hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 400, 400, hints);
			File file = new File(path, fileName);
			if (file.exists() || ((file.getParentFile().exists() || file.getParentFile().mkdirs()) && file.createNewFile())) {
				writeToFile(bitMatrix, "jpg", file, fileName);
				System.out.println("搞定：" + file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void writeToFile(BitMatrix matrix, String format, File file, String fileName) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, file)) {
			throw new IOException("Could not write an image of format " + format + " to " + file);
		} else {
//		    将二维码图片转成流,拷贝成其他文件
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageOutputStream imageOutput = ImageIO.createImageOutputStream(byteArrayOutputStream);
			ImageIO.write(image, format, imageOutput);
			InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
			File systemFile = new File("/home/homolo/testQrcode1/" + fileName);
			OutputStream output = new FileOutputStream(systemFile);
			IOUtils.copy(inputStream, output);
		}
	}

	void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format " + format);
		}
	}

	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	private static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}
}
