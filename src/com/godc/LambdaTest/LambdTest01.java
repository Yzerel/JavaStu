package com.godc.LambdaTest;

public class LambdTest01 {

    public static void showPerson(PersonInterface person){
        person.method01();
    }
    public static String showClass(String a, String b, ClassInterface cls){
        String clsname = cls.classname(a, b);
        return clsname;
    }

    public static void main(String[] args) {
        showPerson(new PersonInterface() {
            @Override
            public void method01() {
                System.out.println("匿名内部类实现接口的抽象方法");
            }
        });

        showPerson(()->System.out.println("lambda表达式实现接口中的抽象方法"));

        // 带参数的lambda表达式, 带返回值的lambda表达式
        String name = "mage";
        String className = "java";
        String s = showClass(name, className, (a, b) -> {
            String str = "姓名：" + a + "; 专业：" + b;
            return str;
        });
        System.out.println(s);

    }
}
