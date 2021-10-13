package ru.mirea.task14.opt2;

import java.util.LinkedList;
import java.util.Queue;

public class GameQueue {
    Queue<Integer> first = new LinkedList<Integer>();
    Queue<Integer> second = new LinkedList<>();
    String talon1 = "";
    String talon2 = "";

    public GameQueue(String fp, String sp) {
        if (fp.length() == sp.length()) {
            for (int i = fp.length()-1; i >= 0; i--) {
                this.first.offer(Integer.parseInt(fp.substring(i, i + 1)));
                this.second.offer(Integer.parseInt(sp.substring(i, i + 1)));
            }
        }
        else{
            System.out.println("Incorrect Input");
        }
    }

    public GameQueue(int size) {
        for (int i = 0; i < size; i++) {
            this.first.offer((int)((Math.random() * 9)));
            this.second.offer((int)((Math.random() * 9)));
        }
    }

    public String play(){
        int count = 0;
        while(count < 106 && first.size()+talon1.length() != 0 && second.size() + talon2.length() != 0){
            if(first.peek() == second.peek()) {
                talon1 += first.peek();
                talon2 += second.peek();
            }
            else if ((first.peek() > second.peek() || (first.peek() == 0 && second.peek() == 9 )) && (second.peek() != 0 && first.peek() != 9)) {
                talon1 += first.peek();
                talon1 += second.peek();
            }else {
                talon2 += first.peek();
                talon2 += second.peek();
            }
            first.poll();
            second.poll();
            if (first.isEmpty()) {
                for (int i = talon1.length()-1; i >= 0; i--) {
                    this.first.offer(Integer.parseInt(talon1.substring(i, i + 1)));
                }
                talon1 = "";
            }
            if (second.isEmpty()) {
                for (int i = talon2.length()-1; i >= 0; i--) {
                    this.second.offer(Integer.parseInt(talon2.substring(i, i + 1)));
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
        System.out.println(new GameQueue("13579", "24680").play());
        System.out.println(new GameQueue(5).play());
    }
}