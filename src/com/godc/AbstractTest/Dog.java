package com.godc.AbstractTest;

public class Dog extends Animal {
    String name = "狗";
    int age = 30;

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void getName(){
        System.out.println("成员方法输出：" + name);
    }

    public void superNum(){
        System.out.println(super.num);
    }
}
