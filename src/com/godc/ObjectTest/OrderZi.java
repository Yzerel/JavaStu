package com.godc.ObjectTest;

public class OrderZi extends OrderFu{

    static {
        System.out.println("子类静态代码块 ZiA1 执行");
    }
    public OrderZi(){
        System.out.println("子类构造方法 ZiC1 执行");
    }
    {
        System.out.println("子类非静态代码块 ZiB1 执行");
    }
}
