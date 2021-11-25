package com.homework3.performance;

import java.util.*;

public class PerformanceMaps {
    public static void hashMapPut(int n){
        Integer[] nums = new Integer[n];
        for(int i = 0; i < n; i++){
            nums[i] = i;
        }


        HashMap<Integer,Integer> hashMap= new HashMap<>();
        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            hashMap.put(nums[i],nums[i]);
        }
        long finish = System.nanoTime();
        System.out.println("HashMap put " + n + " elements: " + (finish - start));
    }

    public static void linkedHashMapPut(int n){
        Integer[] nums = new Integer[n];
        for(int i = 0; i < n; i++){
            nums[i] = i;
        }

        LinkedHashMap<Integer,Integer> linkedHashMap= new LinkedHashMap<>();
        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            linkedHashMap.put(nums[i],nums[i]);
        }
        long finish = System.nanoTime();
        System.out.println("LinkedHashMap add " + n + " elements: " + (finish - start));
    }

    public static void treeMapPut(int n){
        Integer[] nums = new Integer[n];
        for(int i = 0; i < n; i++){
            nums[i] = i;
        }


        TreeMap<Integer,Integer> treeMap= new TreeMap<>();
        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            treeMap.put(nums[i],nums[i]);
        }
        long finish = System.nanoTime();
        System.out.println("TreeMap add " + n + " elements: " + (finish - start));
    }


    public static void hashMapRemove(int n, int size){
        Integer[] nums = new Integer[size];
        Random r = new Random();
        for(int i = 0; i < size; i++){
            nums[i] = i;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < size; i++){
            hashMap.put(nums[i],nums[i]);
        }

        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            hashMap.remove(nums[r.nextInt(size)]);
        }
        long finish = System.nanoTime();

        System.out.println("HashMap delete " + n + " elements: " + (finish - start));
    }

    public static void linkedHashMapRemove( int n,int size){
        Integer[] nums = new Integer[size];
        for(int i = 0; i < size; i++){
            nums[i] = i;
        }
        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
        for(int i = 0; i < size; i++){
            linkedHashMap.put(nums[i],nums[i]);
        }
        Random r = new Random();

        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            linkedHashMap.remove(nums[r.nextInt(size)]);
        }
        long finish = System.nanoTime();

        System.out.println("linkedHashMap delete " + n + " elements: " + (finish - start));
    }

    public static void treeMapRemove(int n, int size){
        Integer[] nums = new Integer[size];
        for(int i = 0; i < size; i++){
            nums[i] = i;
        }
        TreeMap<Integer,Integer> treeMap= new TreeMap<>();
        for(int i = 0; i < size; i++){
            treeMap.put(nums[i],nums[i]);
        }
        Random r = new Random();

        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            treeMap.remove(nums[r.nextInt(size)]);
        }
        long finish = System.nanoTime();

        System.out.println("treeMap  delete " + n + " elements: " + (finish - start));
    }


    public static void hashMapGet(int n, int size){
        Integer[] nums = new Integer[size];
        Random r = new Random();
        for(int i = 0; i < size; i++){
            nums[i] = i;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < size; i++){
            hashMap.put(nums[i],nums[i]);
        }

        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            hashMap.get(nums[r.nextInt(size)]);
        }
        long finish = System.nanoTime();

        System.out.println("HashMap get " + n + " elements: " + (finish - start));
    }

    public static void linkedHashMapGet( int n,int size){
        Integer[] nums = new Integer[size];
        for(int i = 0; i < size; i++){
            nums[i] = i;
        }
        LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
        for(int i = 0; i < size; i++){
            linkedHashMap.put(nums[i],nums[i]);
        }
        Random r = new Random();

        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            linkedHashMap.get(nums[r.nextInt(size)]);
        }
        long finish = System.nanoTime();

        System.out.println("linkedHashMap get " + n + " elements: " + (finish - start));
    }

    public static void treeMapGet(int n, int size){
        Integer[] nums = new Integer[size];
        for(int i = 0; i < size; i++){
            nums[i] = i;
        }
        TreeMap<Integer,Integer> treeMap= new TreeMap<>();
        for(int i = 0; i < size; i++){
            treeMap.put(nums[i],nums[i]);
        }
        Random r = new Random();

        long start = System.nanoTime();
        for(int i = 0; i < n; i++){
            treeMap.get(nums[r.nextInt(size)]);
        }
        long finish = System.nanoTime();

        System.out.println("treeMap  get " + n + " elements: " + (finish - start));
    }


}
