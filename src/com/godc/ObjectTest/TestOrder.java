package com.godc.ObjectTest;

public class TestOrder{
    static SoutA a1 = new SoutA("静态变量A1执行");
    static {
        System.out.println("静态代码块B1执行");
    }
    static SoutA a2 = new SoutA("静态变量A2执行");

    SoutA c1 = new SoutA("成员变量C1执行");
    {
        System.out.println("非静态代码块D1执行");
    }

    public TestOrder(){
        System.out.println("构造方法执行");
    }
    static {
        System.out.println("静态代码块B2执行");
    }
    {
        System.out.println("非静态代码块D2执行");
    }
    SoutA c2 = new SoutA("成员变量C2执行");
}

class SoutA{
    public SoutA(String obj){
        System.out.println(obj);
    }
}
