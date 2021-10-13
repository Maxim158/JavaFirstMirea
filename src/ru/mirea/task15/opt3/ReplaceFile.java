package ru.mirea.task15.opt3;

import java.io.*;

public class ReplaceFile {
    public static void replaceSelected(String target, String replaceWith) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\IVC1-5\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task15\\Text.txt")))) {
            String S = null;
            StringBuffer inputBuffer = new StringBuffer();
            while ((S = reader.readLine()) != null) {
                inputBuffer.append(S);
                inputBuffer.append('\n');
            }
            String inputStr = inputBuffer.toString();
            reader.close();
            inputStr = inputStr.replace(target, replaceWith);

            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\IVC1-5\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task15\\Text.txt");
            fileOut.write(inputStr.getBytes());
            fileOut.close();
            reader.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void main(String[] args){
        replaceSelected("spok","Replaced");
    }
}
