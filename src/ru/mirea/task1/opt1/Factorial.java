package ru.mirea.task1.opt1;
import java.lang.*;
import java.util.Scanner;
public class Factorial {
    public static int Factorial(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.print("Input number: ");
        Scanner sc = new Scanner(System.in);
        int n;
        if (sc.hasNextInt()) {
            n = sc.nextInt();
            System.out.println(Factorial(n));
        }
        else {
            System.out.println("Incorrect Input");
        }
    }
}