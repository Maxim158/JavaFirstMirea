package ru.mirea.task15.opt1;

import java.io.*;

public class InputFile {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream fileOut = new FileOutputStream("C:\\Users\\IVC1-5\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task15\\Text.txt");

        while (true)
        {
            String data = reader.readLine();
            if(data.equals("exit")){
                break;
            }
            else {
                fileOut.write((data +"\r\n").getBytes());
            }
        }
        fileOut.close();
        reader.close();
    }
}
