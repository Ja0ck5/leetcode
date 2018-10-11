package com.ja0ck5.jvm;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * [GC (Allocation Failure) [PSYoungGen: 8192K->760K(9216K)] 12288K->4856K(19456K), 0.1935904 secs] [Times: user=0.25 sys=0.02, real=0.19 secs]
 * Heap
 *  PSYoungGen      total 9216K, used 1007K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 8192K, 3% used [0x00000000ff600000,0x00000000ff63df70,0x00000000ffe00000)
 *   from space 1024K, 74% used [0x00000000ffe00000,0x00000000ffebe010,0x00000000fff00000)
 *   to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
 *  ParOldGen       total 10240K, used 4096K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
 *   object space 10240K, 40% used [0x00000000fec00000,0x00000000ff000010,0x00000000ff600000)
 *  Metaspace       used 3358K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 369K, capacity 388K, committed 512K, reserved 1048576K
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 14:34 2018/10/11
 * @Modified By:
 */
public class Allocation {

	private static final int _1MB = 1024 * 1024;

	public static void testAllocation() {
		byte[] alc1, alc2, alc3, alc4;

		alc1 = new byte[2 * _1MB];
		alc2 = new byte[2 * _1MB];
		alc3 = new byte[2 * _1MB];
		alc4 = new byte[4 * _1MB];// first time Minor GC
	}

    public static void main(String[] args) {
        testAllocation();
    }

}
