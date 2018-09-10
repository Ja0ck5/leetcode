package com.ja0ck5.javadeathmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

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

	public static <T> T retrieveFutureResult(Future<T> future) throws InterruptedException {
		try {
			return future.get();
		} catch (ExecutionException ex) {
			Exception sourceException = (Exception) ex.getCause();
			Logger.getGlobal().throwing("Main", "retrieveFutureResult", sourceException);
			return null;
		}
	}
}
