package com.godc.ObjectTest;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.util.Date;

public class MainClass {

    @Test
    public void test01(){
        ZiClass ziClass1 = new ZiClass("aaa", 10);
        ZiClass ziClass2 = new ZiClass("bbb", 20);
        ZiClass ziClass3 = new ZiClass("aaa", 10);

        // 当父类当中重写了 toString，子类当中没有重写时，访问到的是父类中的方法和变量，输出的均为父类的属性内容
        System.out.println(ziClass1);
        System.out.println(ziClass2);
        System.out.println("======================");
        System.out.println(ziClass1.equals(ziClass2));
        System.out.println("=====================");
        System.out.println(ziClass1.equals(ziClass1));

//        System.out.println(ziClass1 == ziClass3); // 就算两个对象的内容一样，直接进行比较时使用的依旧是地址的比较

        System.out.println("***********************");
        String a = "123";
        String b = "123";
        System.out.println(a == (b)); // true, 固定字符串比较时，引用都指向一个字符串
        System.out.println(a == (b + "")); // false，字符串比较时也是对字符串的地址值进行比较
        System.out.println(a.equals(b + "")); // equals则会对完整的字符串进行比较

        System.out.println("---------------");
        int aint = 10;
        int bint = 20;
        System.out.println( aint == (bint/2));
        System.out.println( aint == (bint - 10) ); // 为基本类型是， 则是对两边的值进行比较

    }

    @Test
    public void test02(){
        Date date = new Date(); // 空参构造默认为当前时间 Tue Dec 21 22:24:58 CST 2021
        System.out.println(date.getTime()); // 返回对象时间的毫秒值(1640096698092)
        System.out.println(date);
        date.setTime(0L); // 设置时间
        System.out.println(date); // 参数 long 类型为0 时代表 1970-01-01 08:00:00 （东八区）
        date.setTime(-1L);
        System.out.println(date); // 传递负数时，则是从默认起点往前的毫秒值


    }

}
