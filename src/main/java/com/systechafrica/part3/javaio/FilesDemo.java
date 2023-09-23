package com.systechafrica.part3.javaio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FilesDemo {
    public static void main(String[] args) {
        // fileStreams();
        FilesDemo demo = new FilesDemo();
        try {
            demo.writeToFile();
            Thread.sleep(3000);
            demo.fileIo();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    private static void fileStreams() {
        String fileSeparator = System.getProperty("file.separator");
        File sample = new File("sampleA.txt");// file separotor ie /
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

    private void writeToFile() {
        try {
            // fileExists=(file.exists())?true:false;

            BufferedWriter writer = new BufferedWriter(new FileWriter("sampleA.txt",true));
            writer.write("\nCow is mooing");
            writer.close();
        }

        catch (

        IOException e) {
            e.printStackTrace();
        }
    }
}
