package com.ja0ck5.jvm;

/**
 * -Xss128k
 * 
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 9:44 2018/10/9
 * @Modified By:
 */
public class JavaVMStackSOF {

	private int stackLength = 1;

	public void stackLeak() {
        stackLength++;
        stackLeak();
	}

	public static void main(String[] args) {
		JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
		try {

			javaVMStackSOF.stackLeak();
		} catch (Throwable e) {
			System.out.println("stack length:" + javaVMStackSOF.stackLength);
			throw e;
		}
	}

}
