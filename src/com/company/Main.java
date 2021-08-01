package com.company;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String stopStreet=scanner.nextLine();
        String readLine;
        String dateFileName = new SimpleDateFormat("dd.MM.yyyy").format(new Date());

        BufferedReader readerFile = new BufferedReader(new FileReader("task_2_addresses.txt"));

        PrintWriter newFile = new PrintWriter("task_1_addresses_result_"+dateFileName+".txt");
        while ((readLine = readerFile.readLine()) != null) {
            if (!readLine.contains(stopStreet))
                newFile.println(readLine);

        }
        newFile.close();
    }
}
