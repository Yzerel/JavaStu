package com.godc.AbstractTest;

public class Cat extends Animal{
    int num = 20;
    int age = 30;

    @Override
    public int getNum(){
        return num;
    }

    @Override
    public void eat() {
        System.out.println("猫出鱼");
    }

    public void methonZi(){
        System.out.println("子类特有方法");
    }
}
