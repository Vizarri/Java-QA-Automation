package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileManager {
    String originalFileName;
    String newFileName;
    String readLine;
    int firstArr = 0;
    List<List<String>> twoDimArray = new ArrayList<>();
    BufferedReader readerFile = null;
    PrintWriter newFile = null;

    public void arrayAdder(List<List<String>> array) {
        array.add(new ArrayList<String>());
        this.twoDimArray = array;
    }

    public FileManager(String originalFileName, String newFileName) {
        this.originalFileName = originalFileName;
        this.newFileName = newFileName;
    }

    public void fileCreater(String stringCaps, String stringCaps2) throws IOException {
        readerFile = new BufferedReader(new FileReader(originalFileName));
        newFile = new PrintWriter(newFileName + DateTimeFormats.dateFileName + ".txt");
        newFile.println(stringCaps);
        newFile.println(stringCaps2);
        // заглушки для шапки таблицы
        String tableHeader = readerFile.readLine();
        String tableHeader2 = readerFile.readLine();

    }


    public void originalFileParser() throws IOException {
        while (((readLine = readerFile.readLine()) != null)) {
            //если строка содержит нужный мне символ-то:
            //1. Записываю в массиов[0][0] саму читаемую строку
            //2.Записываю в массив [0][1] количество жителей для читаемой строки
            if (readLine.contains("|")) {
                arrayAdder(twoDimArray);
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

    public void sort() {
        Collections.sort(twoDimArray, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> firstArray, List<String> secondArray) {
                // Replacements for using Double.parseDouble(string) later
                String value1 = firstArray.get(1);
                String value2 = secondArray.get(1);

                if (Double.parseDouble(value1) < Double.parseDouble(value2))
                    return -1;
                else if (Double.parseDouble(value1) > Double.parseDouble(value2))
                    return 1;
                else
                    return 0;
            }
        });
    }

    public void inputNewFile() {
        for (int i = 0; i < twoDimArray.toArray().length; i++) {
            {
                newFile.println(twoDimArray.get(i).get(0));
            }
        }
        newFile.close();
    }
}
