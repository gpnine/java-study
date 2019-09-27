package com.zcl;

import com.google.common.collect.Lists;
import com.project.entity.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.util.List;

/**
 * @description:
 * @author: ChengLin Zhu.
 * @date: 19-1-11.
 */
public class TestString {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestString.class);

	public static void main(String[] args) {
//		String a = "asdfasdf,";//[)
//		String b = "asdasdf";
//		LOGGER.info("a:{}", a.regionMatches(1, b, 1, 2));
//		System.out.println(a.startsWith("a", 0));

		List<User> userList1 = Lists.newArrayList();
		User user = new User();
		user.setUserName("aaa");
		User user2 = new User();
		user2.setUserName("ccc");
		User user3 = new User();
		user3.setUserName("ddd");

		userList1.add(user);
		userList1.add(user2);
		userList1.add(user3);
		List<User> userList2 = Lists.newArrayList();
		User user4 = new User();
		user4.setUserName("aaa");
		userList2.add(user4);
		User user5 = new User();
		user5.setUserName("ccc");
		userList2.add(user5);
		for (User u : userList1) {
			for (User u1 : userList2) {
				if (u == u1) {
					System.out.println(u);
				}
			}
		}
	}

	@Test
	public void test() {
		String a = "aaa";
		String b = "aaa";
		System.out.println(a.equals(b));
		System.out.println(a == b);
		User user = new User();
		user.setUserName("aaa");
		User user2 = new User();
		user2.setUserName("aaa");
		System.out.println(user.equals(user2));
		System.out.println(user == user2);
	}

	@Test
	public void testCode() {
		String code = "\\u0010F\\u0010C293\\u0010D310\\u0010C\\u0010D7880\\u0010E38\\u0010F40\\u0010E\\u0010F11301505599626\\u0010D292\\u0010B\\u0010A81\\u0010D\\u0010C\\u0010E5171\\u0010B\\u0010E\\u0010D45\\u0010D201\\u0010A\\u0010F\\u0010F171\\u0010F21\\u0010F7989638\\u0010C5\\u0010C\\u0010F\\u0010D\\u0010D\\u0010F1\\u0010B9122\\u0010A4541\\u001052\\u0010C\\u0010GQD\\u0010SW1V6\\u0010NV\\u0010Y\\u0010B\\u0010AU\\u0010X\\u001052\\u0010F\\u0010VE7\\u0010T\\u001052\\u0010BDAI\\u001052\\u0010B\\u0010D\\u0010J0\\u0010XNT7\\u001052\\u0010F\\u0010LL\\u0010G87R\\u0010Z\\u0010K\\u0010K\\u0010AAKEY\\u0010UT9N\\u0010LYZXO\\u0010D\\u0010SX\\u0010KN\\u0010OD\\u0010E\\u0010Y\\u0010C\\u0010F\\u0010DVX\\u0010S\\u0010PD2\\u0010NV\\u0010B\\u0010JFR8RLY\\u0010ZHNF\\u0010O\\u0010TI\\u0010BB0EDQ2HG\\u0010YF\\u0010T\\u0010X\\u001052\\u0010B\\u0010Y\\u001052\\u0010B\\u0010Y\\u0010YW\\u0010CF8\\u0010GB\\u0010W3H\\u0010W\\u0010U\\u0010YVE\\u0010T\\u0010KK40\\u0010UO9\\u001052\\u0010F\\u0010QCFXUX\\u0010L\\u0010UP\\u0010R\\u0010B\\u001052\\u0010BLMK\\u0010M\\u0010V\\u0010GH\\u0010R\\u0010JOES\\u0010F\\u0010L8\\u0010I\\u0010ZU\\u0010PN8Q\\u0010J\\u0010L\\u0010T2\\u0010U\\u001053\\u0010D\\u001052\\u0010C1565948719422\\u001052\\u0010C1565934318000";
		System.out.println(URLDecoder.decode(code.replaceAll("\u00010F", "")));

	}

	@Test
	public void testString() {
		String s = new String("1");
		String s2 = "1";
		s.intern();
		System.out.println(s == s2); //false

		String s3 = new String("1") + new String("1");
		String s4 = "11";
		s3.intern();
		System.out.println(s3 == s4); //false
	}

	@Test
	public void testString1() {
		String s1 = new String("he") + new String("llo");
		String s2 = new String("h") + new String("ello");
		System.out.println(s1 == s2);// false
		String s3 = s1.intern();
		String s4 = s2.intern();
		System.out.println(s1 == s3);// true
		System.out.println(s1 == s4);// true
		System.out.println(s2 == s4);
	}


	@Test
	public void testVariant() {
		VariantTest variantTest = new VariantTest();
		VariantTest variantTest2 = new VariantTest();
		VariantTest variantTest3 = new VariantTest();
		VariantTest variantTest4 = new VariantTest();
	}
}
