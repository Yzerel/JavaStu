package com.godc.ThreadTest;

import java.util.Arrays;
import java.util.Set;

public abstract class MainThread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
//        myThread.start(); // 一个线程对象只能使用一次，重复使用会报运行异常 IllegalThreadStateException
        new MyThread().start(); // 可以多次创建对象进行使用相同线程的内容

//        for (int i = 0; i < 20; i++) {
//            System.out.println("main:" + i);
//        }

        MyThread myThread2 = new MyThread();
        myThread2.start();
    }

}
