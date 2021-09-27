package ru.mirea.task10.opt2;

public class OneToN {
    public static String recursion(int n) {
        if(n == 1) {
            System.out.print("1");
        }else {
            System.out.print(recursion(n-1) + " " + n);
        }
        return "";
    }
    public static void main(String[] args) {
        recursion(5);
    }
}
