package com.homework3.performance;

import com.homework3.collections.MyLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class PerformanceLists {
    public static void myLinkedListAdd(int n){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        Random r = new Random();
        long start = System.nanoTime();
        for(int i = 0; i < n; i++)
        {
            myLinkedList.add(r.nextInt(n));

        }
        long finish = System.nanoTime();

        System.out.println("My Linked List add "+ n + " elemens: " + (finish - start) + " nsec");


    }

    public static void linkedListAdd(int n){

        LinkedList<Integer> linkedList = new LinkedList<>();
        Random r = new Random();
        long start = System.nanoTime();
        for(int i = 0; i < n; i++)
        {
            linkedList.add(r.nextInt(n));

        }
        long finish = System.nanoTime();
        System.out.println("Linked List add " + n + " elemens: " + (finish - start) + " nsec");


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

    public static void myLinkedListRemove(int n, int size){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        Random r = new Random();


        for(int i = 0; i < size; i++){
            myLinkedList.add(i);
        }

        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            myLinkedList.remove(r.nextInt(n));
        }
        long finish = System.nanoTime();
        System.out.println("My Linked List remove "+ n + " elemens: " + (finish - start) + " nsec");

    }

    public static void linkedListRemove(int n, int size){
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random r = new Random();

        for(int i = 0; i < size; i++){
            linkedList.add(i);
        }
        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            linkedList.remove(r.nextInt(n));
        }
        long finish = System.nanoTime();
        System.out.println("Linked List remove "+ n + " elemens: " + (finish - start) + " nsec");
    }

    public static void arrayListRemove(int n, int size){
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
        System.out.println("Array List remove "+ n + " elemens: " + (finish - start) + " nsec");
    }

    public static void linkedListGet(int n, int size){
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random r = new Random();

        for(int i = 0; i < size; i++){
            linkedList.add(i);
        }

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linkedList.get(r.nextInt(n));
        }
        long finish = System.nanoTime();
        System.out.println("Linked List get "+ n + " elemens: " + (finish - start) + " nsec");
    }

    public static void myLinkedListGet(int n, int size){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        Random r = new Random();

        for(int i = 0; i < size; i++){
            myLinkedList.add(i);
        }

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            myLinkedList.get(r.nextInt(n));
        }
        long finish = System.nanoTime();
        System.out.println("My Linked List get "+ n + " elemens: " + (finish - start) + " nsec");
    }

    public static void arrayListGet(int n, int size){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < size; i++){
            arrayList.add(i);
        }

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            arrayList.get(r.nextInt(n));
        }
        long finish = System.nanoTime();

        System.out.println("Array list get "+ n + " elemens: " + (finish - start) + " nsec");
    }


}
