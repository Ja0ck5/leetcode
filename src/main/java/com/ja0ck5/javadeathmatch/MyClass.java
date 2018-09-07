package com.ja0ck5.javadeathmatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 10:01 2018/9/7
 * @Modified By:
 */
public class MyClass {

    private String name;

    public static void main(String[] args) {
        MyClass m1 = new MyClass();
        MyClass m2 = new MyClass();

        m1.name = m2.name = "m1";
        callMe(m1,m2);
        System.out.println(m1 + " & " + m2);
        System.out.println(m1.name + " & " + m2.name);
    }

    public static <T> List<T> getFlatternedList(final List<List<T>> lists){
        List<T> flattenedList = new ArrayList<>();
        for (List<T> list : lists) {
            for (T element : list) {
                flattenedList.add(element);
            }
        }
        return flattenedList;
    }

    private static void callMe(MyClass ... m){
        m[0] = m[1];
        m[1].name = "new name";
        System.out.println("m1:" + m[0]);
        System.out.println("m2:" + m[1]);
    }

}
