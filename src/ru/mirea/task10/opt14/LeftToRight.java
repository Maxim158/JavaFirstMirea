package ru.mirea.task10.opt14;

public class LeftToRight {
    public static String recursion(int n) {
        if (n < 10) {
            return Integer.toString(n);
        }
        else {
            return recursion(n / 10) + " " + n % 10;
        }
    }
    public static void main(String[] args) {
        System.out.println(recursion(153));
    }
}