package com.godc.ThreadTest;

public class MyRunable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
            // 父类方法没有抛出异常，所以重写的子类方法必须自己处理异常，不能抛出
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
