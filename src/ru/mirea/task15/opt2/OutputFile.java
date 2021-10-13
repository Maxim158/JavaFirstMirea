package ru.mirea.task15.opt2;

import java.io.*;

public class OutputFile {

    public static void main(String[] args) {

        try (FileInputStream fileIn = new FileInputStream("C:\\Users\\IVC1-5\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task15\\Text.txt")) {
            System.out.printf("File size: %d bytes \n", fileIn.available());

            int i = -1;
            while ((i = fileIn.read()) != -1) {

                System.out.print((char) i);
            }
            fileIn.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}