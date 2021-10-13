package ru.mirea.task15.opt4;

import java.io.*;

public class WriteEndFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\IVC1-5\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task15\\Text.txt")))) {
            String S = null;
            StringBuffer inputBuffer = new StringBuffer();
            while ((S = reader.readLine()) != null) {
                inputBuffer.append(S);
                inputBuffer.append('\n');
            }
            BufferedReader sysReader = new BufferedReader(new InputStreamReader(System.in));
            OutputStream fileOut = new FileOutputStream("C:\\Users\\IVC1-5\\IdeaProjects\\JavaFirstMirea\\src\\ru\\mirea\\task15\\Text.txt");
            String inputStr = inputBuffer.toString();
            fileOut.write(inputStr.getBytes());
            while (true)
            {
                String data = sysReader.readLine();
                if(data.equals("exit")){
                    break;
                }
                else {
                    fileOut.write((data +"\r\n").getBytes());
                }
            }
            fileOut.close();
            reader.close();
            sysReader.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
