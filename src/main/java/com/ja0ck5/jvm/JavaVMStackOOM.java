package com.ja0ck5.jvm;

/**
 * -Xss2M
 * 
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 10:07 2018/10/9
 * @Modified By:
 */
public class JavaVMStackOOM {

	private void dontStop() {
		while (true) {

		}
	}

	public void statckLeakByThread() {
		while (true) {
			new Thread(() -> dontStop()).start();
		}
	}

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.statckLeakByThread();
    }

}
