package com.company;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stopStreet = scanner.nextLine();
        String readLine = null;
        String dateFileName = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        BufferedReader readerFile = null;
        try {
            readerFile = new BufferedReader(new FileReader("task_2_addresses.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        PrintWriter newFile = null;
        try {
            newFile = new PrintWriter("task_1_addresses_result_" + dateFileName + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!((readLine = readerFile.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!readLine.contains(stopStreet))
                newFile.println(readLine);

        }
        newFile.close();
    }
}
