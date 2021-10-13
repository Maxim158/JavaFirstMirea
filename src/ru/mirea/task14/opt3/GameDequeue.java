package ru.mirea.task14.opt3;


import java.util.ArrayDeque;
import java.util.Deque;
public class GameDequeue {
    Deque<Integer> first = new ArrayDeque<>();
    Deque<Integer> second = new ArrayDeque<>();
    String talon1 = "";
    String talon2 = "";

    public GameDequeue(String fp, String sp) {
        if (fp.length() == sp.length()) {
            for (int i = fp.length()-1; i >= 0; i--) {
                this.first.addLast(Integer.parseInt(fp.substring(i, i + 1)));
                this.second.addLast(Integer.parseInt(sp.substring(i, i + 1)));
            }
        }
        else{
            System.out.println("Incorrect Input");
        }
    }

    public GameDequeue(int size) {
        for (int i = 0; i < size; i++) {
            this.first.addLast((int)((Math.random() * 9)));
            this.second.addLast((int)((Math.random() * 9)));
        }
    }

    public String play(){
        int count = 0;
        while(count < 106 && first.size()+talon1.length() != 0 && second.size() + talon2.length() != 0){
            if(first.peekFirst() == second.peekFirst()) {
                talon1 += first.peekFirst();
                talon2 += second.peekFirst();
            }
            else if ((first.peekFirst() > second.peekFirst() || (first.peekFirst() == 0 && second.peekFirst() == 9 )) && (second.peekFirst() != 0 && first.peekFirst() != 9)) {
                talon1 += first.peekFirst();
                talon1 += second.peekFirst();
            }else {
                talon2 += first.peekFirst();
                talon2 += second.peekFirst();
            }
            first.removeFirst();
            second.removeFirst();
            if (first.isEmpty()) {
                for (int i = talon1.length()-1; i >= 0; i--) {
                    this.first.addLast(Integer.parseInt(talon1.substring(i, i + 1)));
                }
                talon1 = "";
            }
            if (second.isEmpty()) {
                for (int i = talon2.length()-1; i >= 0; i--) {
                    this.second.addLast(Integer.parseInt(talon2.substring(i, i + 1)));
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
        System.out.println(new GameDequeue("13579", "24680").play());
        System.out.println(new GameDequeue(5).play());
    }
}