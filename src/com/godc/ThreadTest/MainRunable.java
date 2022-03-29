package com.godc.ThreadTest;

public class MainRunable {
    public static void main(String[] args) {
        MyRunable myRunable = new MyRunable();
        new Thread(myRunable).start(); // Runnable 接口创建多线程的方法1
        new Thread(myRunable,"第二个线程").start(); // Runnable 接口创建多线程的方法2

        try {
            Thread.sleep(2000); // 暂停一下等前面两个跑完
            // 在 MyRunable 中添加sleep后可见，各线程的执行顺序为随机的
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----------------");
        Thread thread1 = new Thread(myRunable);
        Thread thread2 = new Thread(myRunable,"第4个线程");

        thread1.start();
        thread2.start();

    }
}
