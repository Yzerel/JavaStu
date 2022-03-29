package com.godc.ThreadTest;

public class MainGlobal {

    public static void main(String[] args) {
        GlobalTest globalTest = new GlobalTest();

        new Thread(globalTest, "1号窗口").start();
        new Thread(globalTest, "2号窗口").start();
        new Thread(globalTest, "3号窗口").start();
    }
}
