package com.homework3.performance;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

public class PerformanceSets {
    public static void hashSetAdd(int n){
        Integer[] nums = new Integer[n];
        for(int i = 0; i < n; i++){
            nums[i] = i;
        }


        HashSet<Integer> hashSet= new HashSet<>();
        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            hashSet.add(nums[i]);
        }
        long finish = System.nanoTime();
        System.out.println("HashSet add " + n + " elements: " + (finish - start));
    }

    public static void linkedHashSetAdd(int n){
        Integer[] nums = new Integer[n];
        for(int i = 0; i < n; i++){
            nums[i] = i;
        }

        LinkedHashSet<Integer> linkedHashSet= new LinkedHashSet<>();
        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            linkedHashSet.add(nums[i]);
        }
        long finish = System.nanoTime();
        System.out.println("LinkedHashSet add " + n + " elements: " + (finish - start));
    }

    public static void treeSetAdd(int n){
        Integer[] nums = new Integer[n];
        for(int i = 0; i < n; i++){
            nums[i] = i;
        }


        TreeSet<Integer> treeSet= new TreeSet<>();
        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            treeSet.add(nums[i]);
        }
        long finish = System.nanoTime();
        System.out.println("TreeSet add " + n + " elements: " + (finish - start));
    }


    public static void hashSetRemove(int n, int size){
        Integer[] nums = new Integer[size];
        for(int i = 0; i < size; i++){
            nums[i] = i;
        }
        HashSet<Integer> hashSet= new HashSet<>();
        for(int i = 0; i < size; i++){
            hashSet.add(nums[i]);
        }


        Random r = new Random();
        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            hashSet.remove(nums[r.nextInt(size)]);
        }
        long finish = System.nanoTime();

        System.out.println("HashSet delete " + n + " elements: " + (finish - start));
    }

    public static void linkedHashSetRemove( int n,int size){
        Integer[] nums = new Integer[size];
        for(int i = 0; i < size; i++){
            nums[i] = i;
        }
        LinkedHashSet<Integer> linkedHashSet= new LinkedHashSet<>();
        for(int i = 0; i < size; i++){
            linkedHashSet.add(nums[i]);
        }
        Random r = new Random();

        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            linkedHashSet.remove(nums[r.nextInt(size)]);
        }
        long finish = System.nanoTime();

        System.out.println("linkedHashSet delete " + n + " elements: " + (finish - start));
    }

    public static void treeSetRemove(int n, int size){
        Integer[] nums = new Integer[size];
        for(int i = 0; i < size; i++){
            nums[i] = i;
        }
        TreeSet<Integer> treeSet= new TreeSet<>();
        for(int i = 0; i < size; i++){
            treeSet.add(nums[i]);
        }
        Random r = new Random();

        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            treeSet.remove(nums[r.nextInt(size)]);
        }
        long finish = System.nanoTime();

        System.out.println("treeSet  delete " + n + " elements: " + (finish - start));
    }

}
