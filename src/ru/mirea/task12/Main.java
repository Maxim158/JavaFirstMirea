package ru.mirea.task12;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputList input = new InputList();
        System.out.print("Input count of students: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student listOfStudent[] = new Student[n];
        input.input(listOfStudent, n);


        /*
        System.out.println("---Not Sorted---");
        for (int i = 0; i < n;i++) {
            System.out.println(listOfStudent[i]);               //NOT SORTED ARRAY
        }
        */


        /*
        System.out.println("---Sorted by ID---");
        Sorting sort = new Sorting();                       //СОРТИРОВКА ПО ID
        sort.selectionSort(listOfStudent);
        for (int i = 0; i < n;i++) {
            System.out.println(listOfStudent[i]);
        }
        */

        /*
        System.out.println("---Sorted by Score---");
        QuickSort quick = new QuickSort();
        quick.quickSort(listOfStudent,0,n-1);           //СОРТИРОВКА ПО БАЛЛАМ
        for (int i = 0; i < n;i++) {
            System.out.println(listOfStudent[i]);
        }
        */

        System.out.print("Input count of students: ");      //MERGE
        int n2 = sc.nextInt();
        Student listOfStudent2[] = new Student[n2];
        input.input(listOfStudent2, n2);

        int mergen = n+n2;
        Student mergedList[] = new Student[mergen];
        for (int i = 0; i < n; i++) {
            mergedList[i] = listOfStudent[i];
        }
        for (int i = 0; i < n2; i++) {
            mergedList[i+n] = listOfStudent2[i];
        }

        MergeSort merge = new MergeSort();
        merge.mergeSort(mergedList, mergen);
        for (int i = 0; i < mergen;i++) {
            System.out.println(mergedList[i]);
        }
    }
}
