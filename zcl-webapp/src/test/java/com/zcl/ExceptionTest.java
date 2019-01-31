package com.zcl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-11.
 */
public class ExceptionTest {
	public static void main(String[] args) {
		String file = "/home/homolo/桌面/zcl/exception/a.txt";
		FileReader reader;
		try {
			reader = new FileReader(file);
			Scanner in = new Scanner(reader);
			String string = in.next();
			reader.close();
			System.out.println(string + "不知道我有幸能够执行到不.....");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("对不起,你执行不到...");
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			System.out.println("finally 在执行...");
		}
	}
}
