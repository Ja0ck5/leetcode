package com.ja0ck5.javadeathmatch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 10:17 2018/9/7
 * @Modified By:
 */
public class DoTheThing {

    private static int A = 3;

    public static void doTheThing(final Collection<? extends Object> c){
        c.remove(A);
        System.out.println(c);
    }

    public static void main(String[] args) {
        TreeSet<Integer> c2 = new TreeSet<>();
        c2.add(1);
        c2.add(2);
        c2.add(3);
        c2.add(4);
        doTheThing(new ArrayList<>(Collections.unmodifiableSet(c2)));
    }

}
