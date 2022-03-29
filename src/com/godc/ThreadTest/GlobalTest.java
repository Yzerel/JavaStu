package com.godc.ThreadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GlobalTest implements Runnable {
    /*
    * 创建多个线程，抢100张票，不能重复，不能超出*/
    private int tickets = 100;
    @Override
    public void run() {
        // 方法1：synchronized(obj){
        //          设计到使用共享变量的代码内容
        //      }
       /* synchronized (obj){
            getTickets();
        }*/
       // 方法2：synchronized 方法
//        getTickets2();
        // 方法3： locl锁
        getTickets3();
    }
    private final Object obj = new Object();
    private void getTickets(){
        while (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "正在抢第" + tickets + "张票");
            tickets--;
        }
    }

    // 方法2：synchronized 方法
    private synchronized void getTickets2(){
        while (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "正在抢第" + tickets + "张票");
            tickets--;
        }
    }

    // 方法3： locl锁
    Lock lock = new ReentrantLock();
    private void getTickets3() {
        lock.lock();
        while (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "正在抢第" + tickets + "张票");
            tickets--;
        }
        lock.unlock();
    }
}
