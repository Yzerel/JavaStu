package com.godc.InterfaceTest;

public interface Employee {

    public static final int num = 10; // 接口中的变量默认修饰符（只能用这些修饰， 可不写）
    // final：最终的， 不可更改， 即 num 值不可再发生改变

    public abstract void method(); // 默认抽象方法的格式

    // 默认静态方法的格式, 且只能通过 接口名称.静态方法名 访问， 不能通过子类访问
    public static void methonStatic(){

        System.out.println("接口执行了静态方法");
    }

    // 默认方法的格式， 默认方法可以通过子类使用
    public default void methodDeault(){
        System.out.println("默认方法执行");
    }

}
