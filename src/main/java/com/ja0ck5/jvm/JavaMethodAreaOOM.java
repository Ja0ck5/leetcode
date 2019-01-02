//package com.ja0ck5.jvm;
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//
///**
// * -XX:PermSize=1M -XX:MaxPermSize=1M -Xms1M -Xmx1M Java8 之后没有 永久区
// *
// * @author: Ja0ck5
// * @Description:
// * @Date: Created in 11:39 2018/10/9
// * @Modified By:
// */
//public class JavaMethodAreaOOM {
//
//	public static void main(String[] args) {
//		while (true) {
//			Enhancer enhancer = new Enhancer();
//			enhancer.setSuperclass(OOMObject.class);
//			enhancer.setUseCache(false);
//			enhancer.setCallback(
//					(MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o, args));
//			enhancer.create();
//		}
//	}
//
//	static class OOMObject {
//
//	}
//
//}
