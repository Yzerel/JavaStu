package com.godc.InterfaceTest;

public class Teacher implements Employee {

    int num = 20;

    @Override
    public void method() {
        System.out.println("实现类 tescher 执行了抽象方法");
    }

    public static void methodzi(){
        System.out.println("子类特有方法");
    }

}
