package com.systechafrica.part3.javaio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilesDemo {
    public static void main(String[] args) {
        // fileStreams();
        FilesDemo demmo= new FilesDemo();
        try  {
            demmo.fileIo();
        } catch (Exception e) {
          e.getMessage();
        }
        

    }

    private static void fileStreams() {
        String fileSeparator = System.getProperty("file.separator");
        File sample = new File("sample.txt");// file separotor ie /
        if (sample.exists() && sample.isFile()) {
            System.out.println("exists!!");
            try {
                BufferedReader reader = new BufferedReader(new FileReader(sample));
                System.out.println(fileSeparator);
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("does not exist!");
        }
    }

    private void fileIo() throws IOException {
        File file = new File("sampleA.txt");
        
        if (file.exists()) {
            System.out.println("This file exists!!");
        } else {
            System.out.println("file does not exist");
            file.createNewFile();
        }

        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

    }
}
