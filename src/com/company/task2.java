package com.company;



import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

class FileManager {
    String dateFileName = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    String originalFileName;
    String newFileName;
    String readLine;
    int firstArr = 0;
    ArrayList<ArrayList<String>> twoDimArray = new ArrayList<ArrayList<String>>();
    BufferedReader readerFile = null;
    PrintWriter newFile = null;

    public FileManager(String originalFileName, String newFileName) {
        this.originalFileName = originalFileName;
        this.newFileName = newFileName;
    }

    public void FileCreater() {
        try {
            readerFile = new BufferedReader(new FileReader(originalFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            newFile = new PrintWriter(newFileName + dateFileName + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        newFile.println("Адрес|Количество жителей|Тип дома");
        newFile.println("_________________________________");
        // заглушки для шапки таблицы
        try {
            String table_header = readerFile.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String table_header2 = readerFile.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OriginalFileParser() {
        while (true) {
            try {
                if (!((readLine = readerFile.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            //если строка содержит нужный мне символ-то:
            //1. Записываю в массиов[0][0] саму читаемую строку
            //2.Записываю в массив [0][1] количество жителей для читаемой строки
            if (readLine.contains("|")) {
                twoDimArray.add(new ArrayList<String>());
                twoDimArray.get(firstArr).add(readLine);
                String numPeople;
                numPeople = readLine.substring(readLine.indexOf('|') + 1, readLine.lastIndexOf('|') + 1);
                numPeople = numPeople.replaceAll("[|]", "");
                numPeople = numPeople.replaceAll("[ ]", "");
                twoDimArray.get(firstArr).add(numPeople);
                firstArr++;
            }
        }
    }

    public void Sort() {
        Collections.sort(twoDimArray, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> one, ArrayList<String> two) {
                // Replacements for using Double.parseDouble(string) later
                String value1 = one.get(1).replace(",", ".");
                String value2 = two.get(1).replace(",", ".");


                if (Double.parseDouble(value1) < Double.parseDouble(value2))
                    return -1;
                else if (Double.parseDouble(value1) > Double.parseDouble(value2))
                    return 1;
                else
                    return 0;
            }
        });
    }

    public void InputNewFile() {
        for (int i = 0; i < twoDimArray.toArray().length; i++) {
            {
                newFile.println(twoDimArray.get(i).get(0));
            }
        }
        newFile.close();
    }
}
public class task2 {

    public static void main(String[] args) {
        FileManager newFile = new FileManager("task_2_addresses.txt", "task_2_addresses_result_");
        newFile.FileCreater();
        newFile.OriginalFileParser();
        newFile.Sort();
        newFile.InputNewFile();
    }
}




