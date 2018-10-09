package com.ja0ck5.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 10:20 2018/10/9
 * @Modified By:
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
//		String s1 = new StringBuilder("计算机").append("软件").toString();
//		System.out.println(s1.intern() == s1);// true
//
//		String s2 = new StringBuilder("ja").append("软件").toString();
//		System.out.println(s2.intern() == s2);// true
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);// false

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);// true

	}

	private static void onlyIntern() {
		List<String> list = new ArrayList<>();
		int i = 0;
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}

}
