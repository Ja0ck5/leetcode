package com.ja0ck5.jvm;

/**
 * -XX:+PrintGC 输出GC日志
 * -XX:+PrintGCDetails 输出GC的详细日志
 * -XX:+PrintGCTimeStamps 输出GC的时间戳（以基准时间的形式）
 * -XX:+PrintGCDateStamps 输出GC的时间戳（以日期的形式，如 2013-05-04T21:53:59.234+0800）
 * -XX:+PrintHeapAtGC 在进行GC的前后打印出堆的信息
 * -Xloggc:../logs/gc.log 日志文件的输出路径
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 14:46 2018/10/9
 * @Modified By:
 */
public class ReferenceCountingGC {

	public Object instance = null;

	private static final int _1MB = 1024 * 1024;

	/**
	 * 仅仅为了占用内存，以便 GC 日志中看清楚是否被回收过
	 */
	private byte[] bigSize = new byte[2 * _1MB];

	public static void testGC() {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();

		objA.instance = objB;
		objB.instance = objA;

		objA = null;
		objB = null;

		System.gc();
	}

    public static void main(String[] args) {
        testGC();
    }

}
