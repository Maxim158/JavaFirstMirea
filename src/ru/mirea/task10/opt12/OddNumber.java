package ru.mirea.task10.opt12;

public class OddNumber {
public static void recursion() {
    java.util.Scanner in = new java.util.Scanner(System.in);
    int n = in.nextInt();
    if (n > 0) {
        if (n % 2 == 1) {
            System.out.println(n);
            recursion();
        } else {
            recursion();
        }
    }
}
    public static void main(String[] args) {
        recursion();
    }
}