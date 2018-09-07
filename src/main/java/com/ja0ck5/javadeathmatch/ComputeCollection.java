package com.ja0ck5.javadeathmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 10:23 2018/9/7
 * @Modified By:
 */
public class ComputeCollection {

	public static void main(String[] args) {
        Map<String, Object> collection = new TreeMap<>();

		System.out.println(
				collection.compute("foo", (k, v) -> (v == null) ? new ArrayList<Object>() : ((List) v).add("bar")));
		System.out.println(
				collection.compute("foo", (k, v) -> (v == null) ? new ArrayList<Object>() : ((List) v).add("ber")));

	}

}
