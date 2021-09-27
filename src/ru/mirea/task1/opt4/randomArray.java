package ru.mirea.task1.opt4;

import java.lang.*;
import java.util.*;
public class randomArray {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] Array1 = new int[10];
        int[] Array2 = new int[10];
        for (int i = 0; i < 10; i++) {
            Array1[i] = rand.nextInt(200);
            Array2[i] = (int) (Math.random() * 1000);
            System.out.println(Array1[i] + "|" + Array2[i]);
        }
        Arrays.sort(Array1);
        Arrays.sort(Array2);
        System.out.println("______________________");
        for (int i = 0; i < 10; i++) {
            System.out.println(Array1[i] + "|" + Array2[i]);
        }
    }
}
