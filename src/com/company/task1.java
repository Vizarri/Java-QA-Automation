package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class FilesNameMaker{
    public PrintWriter createrNameNewFile (String newFilesName, String dateForFileName){
        try {
            return new PrintWriter( newFilesName+ dateForFileName + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stopStreet = scanner.nextLine();
        String readLine = null;
        final String dateFileName = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        BufferedReader readerFile = null;
        try {
            readerFile = new BufferedReader(new FileReader("task_2_addresses.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        PrintWriter newFile = null;
        FilesNameMaker newNameForFile=new FilesNameMaker();

        newFile= newNameForFile.createrNameNewFile("task_1_addresses_result_",dateFileName) ;
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
