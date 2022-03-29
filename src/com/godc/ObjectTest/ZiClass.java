package com.godc.ObjectTest;

public class ZiClass extends FuClass{
    String name = "子类";
    int age = 10;

    public ZiClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public ZiClass() {
    }

    @Override
    public String toString() {
        System.out.println("子类的 toString 方法启动");
        return "FuClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("执行了子类中重写的 equals 方法");
//        System.out.println(this); // 当子类中为重写 toString 方法时，用此方法访问到的依旧是父类当中的toString内容
//        System.out.println(obj);
//        return (this == obj); // 尽管重写了 toString 方法，此处比较的依旧为对象的地址值
        // 若想要对内容进行比较：比较属性的内容
        // 多态中父类对象想访问到子类对象时，需要先向下转型
        ZiClass ziClass2 = (ZiClass) obj;
        if(this.name.equals(ziClass2.name) && this.age == ziClass2.age){
            return true;
        }
        return false;
    }
}
