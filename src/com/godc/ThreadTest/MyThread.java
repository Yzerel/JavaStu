package com.godc.ThreadTest;

public class MyThread extends Thread {
    @Override
    public void run() {
//        super.run();
//        for (int i = 0; i < 20; i++) {
//            System.out.println("run:" + i);
//            if (i >= 15){
//                throw new RuntimeException("i太大");
//            }
//        }
        System.out.println(this.getName());
    }
}
