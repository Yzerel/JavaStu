package com.godc.AbstractTest;

public abstract class Animal {
    int num = 10;
    String name = "动物";

    public int getNum(){
        return num;
    }

    public void getAnimalName(){
        System.out.println("成员方法输出：" + name);
    }

    public abstract void eat();

    public static void Method(){
        System.out.println("抽象方法中的静态方法执行！！！");
    };

    public void methonFu(){
        System.out.println("父类特有方法");
    }
}
