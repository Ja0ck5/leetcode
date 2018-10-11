package com.ja0ck5.jvm;

/**
 * 1. 对象可在被GC 时自我拯救。
 * 2. 这种自救的机会只有一次，因为一个对象的 finalize() 方法最多只会被系统自动调用一次
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 16:36 2018/10/9
 * @Modified By:
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes, I am still alive:)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次拯救自己
        SAVE_HOOK = null;
        System.gc();
        // 因为 finalize 方法优先级很低，所以暂停 0.5s 等它
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no ,I am dead :(");
        }

        // 代码与上面完全相同，但这次自救失败
        SAVE_HOOK = null;
        System.gc();
        // 因为 finalize 方法优先级很低，所以暂停 0.5s 等它
        // 因为一个对象的 finalize() 方法最多只会被系统自动调用一次,所以此时自救失败
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no ,I am dead :(");
        }

    }
}
