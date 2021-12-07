package com.homework3.testing;

import com.homework3.collections.MyLinkedList;

public class TestMyLinkedList {

    public static void testMyLinkedList(){

        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.add(0,0);
        list.add(1);
        list.add(2,2);
        list.add(3,3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9,9);
        System.out.println(list);

        list.add(6,66);
        list.add(2,66);
        System.out.println(list);



        System.out.println(list.get(0));
        System.out.println(list.get(6));
        System.out.println(list.get(9));

        System.out.println(list.indexOf(0));
        System.out.println(list.indexOf(6));
        System.out.println(list.indexOf(9));

        System.out.println(list.remove(0));
        System.out.println(list);

        System.out.println(list.remove(6));
        System.out.println(list);

        System.out.println(list.remove(7));
        System.out.println(list);

        list.set(0,9);
        list.set(5,9);
        list.set(8,9);
        System.out.println(list);

        list.clear();
        System.out.println(list);

    }
}
