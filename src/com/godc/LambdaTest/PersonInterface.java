package com.godc.LambdaTest;

@FunctionalInterface // 判断当前接口是否为函数式接口的注解
public interface PersonInterface {
    int age = 10;
    String name = "asd";

    public abstract void method01();

    public default String getname(){
        return name;
    }
}
