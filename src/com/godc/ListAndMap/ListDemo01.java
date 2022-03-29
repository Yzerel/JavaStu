package com.godc.ListAndMap;

import org.junit.Test;

import java.util.*;

public class ListDemo01 {
    /* list集合： 有序， 有索引， ,
    查找时：list集合可以通过索引查找
    增删时：list集合会创建一个新的集合，然后复制原集合的元素，在复制时增加或删除对应位置的元素
    List<String> list = new List<>(); // List为一个接口， 需要通过实现类使用
    常用实现类有： ArrayList（查找快， 增删慢），LinkedList（查找慢， 增删快）
    */
    @Test
    public void MapTest(){
        Map<Integer, String> map = new HashMap<>();
        map.put(3, "ccc");
        map.put(1, "aaa");
        map.put(2, "bbb");
        System.out.println(map); // map是无序的
        String s = map.get(3); // map不能用索引取值，只能用key匹配

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        System.out.println("==========使用迭代器输出");
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("==========使用entrySet方法遍历取值输出");
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("***************");

        String remove = map.remove(1);// 根据key移除元素，返回value
        System.out.println(remove); // aaa
        String remove2 = map.remove(1); // 输出的 key不存在时返回null
        System.out.println(remove2); // null
        boolean ccc = map.remove(1, "ccc"); // 根据 key-value 删除，删除成功返回ture，不存在则返回false
        System.out.println(ccc); // false
    }
    @Test
    public void arrayListTest() {
        /*
        List被子类重写的常用方法：
        public void add(int index, E element): 在索引位置增加元素，原该位置以及后面的元素的索引均向后挪一位
        public boolean add(E e): 在集合末尾添加元素，成功则返回true
        public E get(int index)：根据索引位置返回对应的元素
        public boolean remove(Object o)：删除与参数对应的第一个元素,删除成功返回ture,未能匹配返回false
        public E remove(int index)：删除指定所以的元素，返回值为被删除的元素
        public boolean removeAll(Collection<?> c)：参数也为一个集合，删除与集合中匹配的所有元素
                        addAll(Collection<?> c)：与removeAll方法相同，不过是向集合内添加多个元素
        public E set(int index, E element): 将指定索引位置的元素进行替换，返回被替换的元素
       */
        ArrayList<String> list = new ArrayList<>();
        list.add(0, "a");
        list.add(0, "b");
        list.add(1, "c");
        boolean d = list.add("d");
        list.add("a");
        list.add("a");
        System.out.println(list); // [b, c, a, d, a, a]
        System.out.println(d); // true
        String s = list.get(0);
        System.out.println(s); // b
        boolean a = list.remove("a");
        System.out.println(a);
        System.out.println(list); // [b, c, d, a, a]
//        boolean b1 = list.removeAll(Arrays.asList("a", "b", "c"));
//        System.out.println(b1); // true
//        System.out.println(list); // [d]
//         若想删除集合中的所有“a”的内容，可以只在集合中存放一个a，
//        此时建议使用 Collections.singletonList（）
        boolean b2 = list.removeAll(Collections.singletonList("a"));
        System.out.println(list); // [b, c, d]
        String f1 = list.set(0, "f");
        System.out.println(f1); // b
        System.out.println(list); // [f, c, d]

        System.out.println("===================");
        ArrayList<String> arraylist = list;
        String f = arraylist.set(0, "f");
        arraylist.remove(0);

    }

    @Test
    public void linkListTest() {
        /*
        * LinkedList: 查找慢，增删快，一个元素的数据样式为： 本元素的地址_元素内容_下一个元素的地址
        * 常在更改较为频繁时使用的集合
        * 常用方法：
        * add()：空参集合末尾添加元素，与 addLast()相同
        * add(int index, E element): 集合指定位置添加元素
        * push(): 集合开头添加元素，与 addFirst()相同
        * removeFirst():删除第一个元素，返回被删除的元素
        * removeLast():删除最后元素，返回被删除的元素
        * remove(): 空参表示删除第一个元素，返回被删除的元素
        * E remove(int index)：删除指定所以的元素，返回值为被删除的元素
        * boolean remove(Object o)：删除与参数内容相同的第一个元素，删除成功返回ture,未能匹配返回false
        * boolean removeFirstOccurrence(Object o)：删除与参数内容相同的第一个元素，删除成功返回ture,未能匹配返回false
        * boolean removeLastOccurrence(Object o)：删除与参数内容相同的最后一个元素，删除成功返回ture,未能匹配返回false
        * E set(int index, E element): 将指定索引位置的元素进行替换，返回被替换的元素
        * E pop(): 弹出集合中的第一个元素，集合中会删除该元素
        * boolean isEmpty()：判断该集合是否为空，即长度是否==0，为空则返回ture
         * */
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("a");
        linkedList.push("b");
        linkedList.addFirst("c");
        linkedList.addLast("d");
        linkedList.add(2, "a");
        System.out.println(linkedList); // [c, b, a, a, d]
        String remove = linkedList.remove();
        System.out.println(remove);


        System.out.println(linkedList);// [b, a, a, d]
        boolean b = linkedList.remove("a");
        System.out.println(linkedList); //[b, a, d]
        String pop = linkedList.pop();
        System.out.println(pop); // b
        System.out.println(linkedList); // [a, d]
        boolean empty = linkedList.isEmpty();

        System.out.println("*******测试 poll 与 remove的区别******");
        LinkedList<String> linkedList2 = new LinkedList<>();
        String poll = linkedList2.poll();// 空列表时，poll会返回null
        System.out.println(poll);
        String remove1 = linkedList2.remove();// 空列表时，remove会报NoSuchElementException异常
        System.out.println(remove1);
        System.out.println("*************");
    }
}
