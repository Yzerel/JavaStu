package com.godc.ObjectTest;

public class OrderFu{

    static {
        System.out.println("父类静态代码块 FuA1 执行");
    }
    public OrderFu(){
        System.out.println("父类构造方法 FuD1 执行");
    }
    {
        System.out.println("父类非静态代码块 FuB1 执行");
    }

    public static void method1(){
        System.out.println("父类的静态方法执行");
    }
}
