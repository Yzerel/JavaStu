package com.godc.ObjectTest;

public class FuClass  extends Object{
    String name = "父类";
    int age = 10;

    @Override
    public String toString() {
        System.out.println("父类的 toString 方法启动");
        return "FuClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("执行了父类中重写的 equals 方法");
        System.out.println(this);
        System.out.println(obj);
        return (this == obj);
    }
}
