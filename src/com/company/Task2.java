
package com.company;


import java.io.IOException;


public class Task2 {

    public static void main(String[] args) {
        FileManager newFile = new FileManager("task_2_addresses.txt", "task_2_addresses_result_");
        try {
            newFile.fileCreater("Адрес|Количество жителей|Тип дома", "_________________________________");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            newFile.originalFileParser();
        } catch (IOException e) {
            e.printStackTrace();
        }
        newFile.sort();
        newFile.inputNewFile();
    }
}