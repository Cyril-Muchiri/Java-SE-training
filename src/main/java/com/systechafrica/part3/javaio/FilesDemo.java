package com.systechafrica.part3.javaio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FilesDemo {
    public static void main(String[] args) {
        fileStreams();

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
}
