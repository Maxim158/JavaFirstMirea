package ru.mirea.task14.opt1;

import java.util.Stack;
public class GameStack {
    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();
    String talon1 = "";
    String talon2 = "";

    public GameStack(String fp, String sp) {
        if (fp.length() == sp.length()) {
            for (int i = fp.length()-1; i >= 0; i--) {
                this.first.push(Integer.parseInt(fp.substring(i, i + 1)));
                this.second.push(Integer.parseInt(sp.substring(i, i + 1)));
            }
        }
        else{
            System.out.println("Incorrect Input");
        }
    }

    public GameStack(int size) {
        for (int i = 0; i < size; i++) {
            this.first.push((int)((Math.random() * 9)));
            this.second.push((int)((Math.random() * 9)));
        }
    }

    public String play(){
        int count = 0;
        while(count < 106 && first.size()+talon1.length() != 0 && second.size() + talon2.length() != 0){
            if(first.peek() == second.peek()) {
                talon1 += first.peek();
                talon2 += second.peek();
            }
            else if (first.peek() > second.peek() && (second.peek() != 0 && first.peek() != 9)) {
                talon1 += first.peek();
                talon1 += second.peek();
            }else {
                talon2 += first.peek();
                talon2 += second.peek();
            }
            first.pop();
            second.pop();
            if (first.isEmpty()) {
                for (int i = talon1.length()-1; i >= 0; i--) {
                    this.first.push(Integer.parseInt(talon1.substring(i, i + 1)));
                }
                talon1 = "";
            }
            if (second.isEmpty()) {
                for (int i = talon2.length()-1; i >= 0; i--) {
                    this.second.push(Integer.parseInt(talon2.substring(i, i + 1)));
                }
                talon2 = "";
            }
            count++;
        }
        if(count == 106) return "Botva " + count;
        if(first.isEmpty()) return "Second " + count;
        else return  "First " + count;
    }
    public static void main(String[] args) {
        System.out.println(new GameStack("13579", "24680").play());
        System.out.println(new GameStack(5).play());
    }
}