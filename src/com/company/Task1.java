package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class FilesManager {
    public PrintWriter createrNameNewFile(String newFilesName, String dateForFileName) {
        try {
            return new PrintWriter(String.format("%s %s .txt", newFilesName, dateForFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class Task1 {
    public static void main(String[] args) {
        NewFileFormater newFileFormater = new NewFileFormater();
        FilesManager newNameForFile = new FilesManager();
        try {
            newFileFormater.readerFile = new BufferedReader(new FileReader("task_2_addresses.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        newFileFormater.newFile = newNameForFile.createrNameNewFile("task_1_addresses_result_", DateTimeFormats.dateFileName);
        while (true) {
            try {
                if ((newFileFormater.readLine = newFileFormater.readerFile.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!newFileFormater.readLine.contains(newFileFormater.stopStreet))
                newFileFormater.newFile.println(newFileFormater.readLine);

        }
        newFileFormater.newFile.close();
    }

}
