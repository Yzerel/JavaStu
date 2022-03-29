package com.godc.InterfaceTest;

import org.junit.Test;

public class MainTest {

    @Test
    public void test01(){

        Teacher teacher = new Teacher();

        teacher.method(); // 执行实现类重写的抽象方法

//        teacher.methonStatic(); // 不能通过 实现类对象.静态方法 的方式访问接口的静态方法
        Employee.methonStatic(); // 接口的静态方法只能通过 接口名称.静态方法名 访问

//        Employee.methodDeault(); // 接口的默认方法需要通过创建 实现类对象进行调用
        teacher.methodDeault(); // 通过实现类访问默认方法
    }

    @Test
    public void test02(){
        // 多态的使用
        // 1. 父 = new 子
        Employee employee = new Teacher();

        employee.method(); // 使用方法时，看 new 的对象是谁，则用谁这边的方法，没有则向上找
        employee.methodDeault();
//        employee.methodzi();
        System.out.println(employee.num);
    }


}
