package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] input = new int[10];
        for(int i=0; i<10; i++){
            input[i] = (int) (Math.random() * 200 - 100);
        }
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(input));
        System.out.println("Отсортированный массив");
        for (int i = 0; i < 10; i++) {
            input[i] = RandSelect(input, 0, 9, i);
            System.out.print(i+1+"-й Элемент массива: ");
            System.out.println(input[i]);
        }
    }
    public static int partition(int[] a, int left, int right, int pivotIndex) {
        int pivotValue = a[pivotIndex];
        swap(a, pivotIndex, right);
        int sindex = left;
        for (int i = left; i <= right; i++) {
            if (a[i] < pivotValue) {
                swap(a, sindex, i);
                sindex++;
            }
        }
        swap(a, right, sindex);
        return sindex;
    }
    public static void swap(int[] a, int firstIndex, int secondIndex) {
        int temp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = temp;
    }
    public static int TakeRandElement(int left, int right) {
        right -= left;
        return (int) (Math.random() * ++right) + left;
    }
    public static int RandSelect(int[] a, int left, int right, int k) {
        int pindex = TakeRandElement(left, right);
        pindex = partition(a, left, right, pindex);
        if (k == pindex) return a[pindex];
        else if (k > pindex) return RandSelect(a, pindex + 1, right, k);
        else return RandSelect(a, left, pindex - 1, k);
    }
}
