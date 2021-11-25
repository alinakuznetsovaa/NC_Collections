package com.homework3.performance;

import com.homework3.collections.MyLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class PerformanceLists {
    public static void myListAdd(int n){
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        Random r = new Random();
        long start = System.nanoTime();
        for(int i = 0; i < n; i++)
        {
            myList.add(r.nextInt(n));

        }
        long finish = System.nanoTime();

        System.out.println("My list add "+ n + " elemens: " + (finish - start) + " nsec");


    }

    public static void javaListAdd(int n){

        LinkedList<Integer> javaList = new LinkedList<>();
        Random r = new Random();
        long start = System.nanoTime();
        for(int i = 0; i < n; i++)
        {
            javaList.add(r.nextInt(n));

        }
        long finish = System.nanoTime();
        System.out.println("Java List add " + n + " elemens: " + (finish - start) + " nsec");


    }

    public static void arrayListAdd(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random r = new Random();

        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            arrayList.add(r.nextInt(n));
        }
        long finish = System.nanoTime();

        System.out.println("Array List add " + n + " elements: " + (finish - start) + " nsec");
    }

    public static void myListRemove(int n,int size){
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        Random r = new Random();


        for(int i = 0; i < size; i++){
            myList.add(i);
        }

        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            myList.remove(r.nextInt(n));
        }
        long finish = System.nanoTime();
        System.out.println("My list remove "+ n + " elemens: " + (finish - start) + " nsec");

    }

    public static void javaListRemove(int n, int size){
        LinkedList<Integer> javaList = new LinkedList<>();
        Random r = new Random();

        for(int i = 0; i < size; i++){
            javaList.add(i);
        }
        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            javaList.remove(r.nextInt(n));
        }
        long finish = System.nanoTime();
        System.out.println("Java list remove "+ n + " elemens: " + (finish - start) + " nsec");
    }

    public static void javaArrayListRemove(int n, int size){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random r = new Random();

        for(int i = 0; i < size; i++){
            arrayList.add(i);
        }

        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            arrayList.remove(r.nextInt(n));
        }
        long finish = System.nanoTime();
        System.out.println("Java Array list remove "+ n + " elemens: " + (finish - start) + " nsec");
    }

    public static void javaListGet(int n, int size){
        LinkedList<Integer> javaList = new LinkedList<>();
        Random r = new Random();

        for(int i = 0; i < size; i++){
            javaList.add(i);
        }

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            javaList.get(r.nextInt(n));
        }
        long finish = System.nanoTime();
        System.out.println("Java list get "+ n + " elemens: " + (finish - start) + " nsec");
    }

    public static void myListGet(int n, int size){
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        Random r = new Random();

        for(int i = 0; i < size; i++){
            myList.add(i);
        }

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            myList.get(r.nextInt(n));
        }
        long finish = System.nanoTime();
        System.out.println("My list get "+ n + " elemens: " + (finish - start) + " nsec");
    }

    public static void javaArrayListGet(int n, int size){
        ArrayList<Integer> javaArr = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < size; i++){
            javaArr.add(i);
        }

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            javaArr.get(r.nextInt(n));
        }
        long finish = System.nanoTime();

        System.out.println("Java Array list get "+ n + " elemens: " + (finish - start) + " nsec");
    }


}
