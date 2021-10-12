package ru.mirea.task14.opt4;


import ru.mirea.task13.opt2.Linked;

import java.util.LinkedList;

public class GameDoubleList {
    LinkedList<Integer> first = new LinkedList<>();
    LinkedList<Integer> second = new LinkedList<>();
    String talon1 = "";
    String talon2 = "";

    public GameDoubleList(String fp, String sp) {
        if (fp.length() == sp.length()) {
            for (int i = fp.length()-1; i >= 0; i--) {
                this.first.add(Integer.parseInt(fp.substring(i, i + 1)));
                this.second.add(Integer.parseInt(sp.substring(i, i + 1)));
            }
        }
        else{
            System.out.println("Incorrect Input");
        }
    }

    public GameDoubleList(int size) {
        for (int i = 0; i < size; i++) {
            this.first.add((int)((Math.random() * 9)));
            this.second.add((int)((Math.random() * 9)));
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
            first.remove();
            second.remove();
            if (first.isEmpty()) {
                for (int i = talon1.length()-1; i >= 0; i--) {
                    this.first.add(Integer.parseInt(talon1.substring(i, i + 1)));
                }
                talon1 = "";
            }
            if (second.isEmpty()) {
                for (int i = talon2.length()-1; i >= 0; i--) {
                    this.second.add(Integer.parseInt(talon2.substring(i, i + 1)));
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
        System.out.println(new GameDoubleList("13579", "24680").play());
        System.out.println(new GameDoubleList(5).play());
    }
}