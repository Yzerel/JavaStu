package com.godc.AbstractTest;

import org.junit.Test;


public class DemoMain {

    @Test
    public void test01(){
        // 抽象类不能直接创建对象，但是可以直接通过抽象类使用其中的静态方法
        // 成员方法、变量等需要通过创建对象使用，所以不能直接使用
        Animal.Method(); // 抽象方法中的静态方法执行！！！

        Cat cat = new Cat();
        cat.Method(); // 子类对象也可以访问父类当中的静态方法，但是会在编译时自动调整为：Animal.Method();
    }

    @Test
    public void test02(){
        // 抽象类多态的使用
        // 1. 父类 = new 子类
        Animal animal = new Cat();

        System.out.println(animal.num); // 直接获取对象中的成员变量时，访问的是类的成员变量（父类），没有则向上找
//        animal.age; // 不能通过 访问子类中的成员变量，不过可以通过下面的方式访问：
//        System.out.println(((Cat) animal).age); // 通过父类对象访问子类中的成员方法和成员变量

        // 使用成员方法时，父类当中需要有改成员方法
        // 若子类有重写该成员方法，则优先使用子类的成员方法，没有则向上找
        System.out.println(animal.getNum()); // 通过方法访问成员变量时，优先
        animal.methonFu(); // 访问成员方法时，子类若没有覆盖重写，则访问的是父类中的成员方法
//        animal.methonZi(); // 不能通过此访问父类中没有的方法
        /*
        *总结：父类 = new 子类；
        * 1. 子类中的成员变量与成员方法名与父类相同的部分，访问成员变量优先看父类，访问成员方法优先看子类，没有则向上找
        * 2. 子类中的成员变量与成员方法名与父类不同的部分， 不能访问
        *  */
    }

    @Test
    public void test03(){
        // 抽象类多态的使用
        // 1. 子类 = new 父类
//        ErHaDog erHaDog = new Dog(); // 不能直接通过 new 父类 对象来创建子类
        // 需要对类型进行强转, 若是没有先创建子类对象就强转时， 使用时会报 ClassCastException 异常如下
        // java.lang.ClassCastException: com.godc.AbstractTest.Dog cannot be cast to com.godc.AbstractTest.ErHaDog
//        ErHaDog erHaDog = (ErHaDog) new Dog();
        // 正确创建方法
        Dog dog = new ErHaDog();
        ErHaDog erHaDog = (ErHaDog) dog;

        System.out.println(erHaDog.name); // 直接访问成员变量，输出为子类的成员变量（等号左边）
        System.out.println(erHaDog.num); // 当子类当中没有时， 则向上找（此处找到 Animal 类中的成员变量）

        erHaDog.getName(); // 访问成员方法时，依然是默认先看子类（左边）是否有覆盖重写此方法
        erHaDog.eat(); // 子类中没有时则向上找，找到最近的类输出
        erHaDog.getAnimalName(); // 没有时则向上找
        System.out.println(erHaDog.getNum()); // 没有时则向上找
        /*
         *总结：使用多态时，
         * 1. 访问成员变量时，均为优先看等号左边的成员变量， 没有则向上找
         * 2. 访问成员变量时
         *          若左边为父类没有该方法则报错；
         *          若父子均有的方法则优先用子类；
         *          若子类没有而父类有时，则向上找
         */
    }

    @Test
    public void test04(){
        // 跨越一个父类的多态时（子类 = new 与爷爷类）
        Animal animal = new ErHaDog();
        ErHaDog erHaDog = (ErHaDog) animal;
        erHaDog.eat(); // 访问成员方法时会通过继承的顺序向上查找 爷爷-父类-子类，此处输出的为 Dog类中重写的 eat方法

        System.out.println(erHaDog.name); // 访问成员变量时与前面保持一致

        // 爷爷类 = new 子类
        Animal animal2 = new ErHaDog();
        animal2.eat(); // 访问成员方法时也是从 new处开始访问成员方法，没有则根据继承关系，向上找
        // 强行通过父类访问子类对象的方法的方式： ((子类名) 父类对象名).子类方法名
        // 如此 Animal 对象访问 Dog 类中的 superNum 方法
        ((ErHaDog) animal2).superNum();

        System.out.println("***********");
        System.out.println("转型到 Dog 类" + ((Dog) animal2).name); // 通过转型到哪个类可以访问到具体哪个类的成员变量
        System.out.println("转型到 ErHaDog 类" + ((ErHaDog) animal2).name);

        System.out.println("==========");
        ((Dog) animal2).getName(); // 访问成员方法时，不管转型到哪里，都是从 new 子类() 处开始向上访问
        ((ErHaDog) animal2).getName();

        System.out.println("--------------");
        Dog dog = new Dog();
        dog.getName();
        Animal animal3 = dog;
        ((Dog) animal3).getName(); // 此处的访问便是从 dog 类开始

        // 当本来是父类的对象强转为子类对象时，也会发生类型异常：ClassCastException
        // ((ErHaDog) animal3).getName();
    }
}
