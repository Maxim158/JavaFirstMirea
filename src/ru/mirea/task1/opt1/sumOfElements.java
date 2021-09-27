package ru.mirea.task1.opt1;

import java.util.*;
public class sumOfElements {
    public static int sumOfArrayWhile(int [] a)
    {
        int sum =0;
        int i=0;
        while(i < a.length)
        {
            sum+=a[i];
            i++;
        }
        return sum;
    }

    public static int sumOfArrayDoWhile(int [] a) {
        int sum =0;
        int i=0;
        do {
            sum +=a[i];
            i++;
        } while (i < a.length);
        return sum;
    }
    public static int sumOfArrayFor(int [] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum +=a[i];
        }
        return sum;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n =0;
        System.out.printf("Введите количество элементов: ");
        if(sc.hasNextInt()){
            n = sc.nextInt();
        }
        else System.out.printf("Вы ввели нецелое число");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(sumOfArrayWhile(a));
        System.out.println(sumOfArrayDoWhile(a));
        System.out.println(sumOfArrayFor(a));
    }
}