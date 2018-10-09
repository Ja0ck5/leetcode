package com.ja0ck5.jvm;

import java.util.ArrayList;

/**
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 16:26 2018/10/8
 * @Modified By:
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }

}
