package com.company;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;



public class Main {

    public static void main(String[] args) throws IOException {
        String readLine;
        String dateFileName = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        // двумерный массив и его счетчики
        String [][]twoDimArray = new String[4][2];
        int firstArr = 0;
        int secondArr = 0;

        //говорю- читай этот xt
        BufferedReader readerFile = new BufferedReader(new FileReader("task_2_addresses.txt"));
        // говорю- создавай новый txt с нужным мне именем и нужной шапкой
        PrintWriter newFile = new PrintWriter("task_2_addresses_result_" + dateFileName + ".txt");
        newFile.println("Адрес|Количество жителей|Тип дома");
        newFile.println("_________________________________");
        // заглушки для шапки таблицы
        String table_header=readerFile.readLine();
        String table_header2=readerFile.readLine();

        //читаю исходник xtx до тех пор пока не появится строка , которая= null
        while ((readLine = readerFile.readLine()) != null) {
            secondArr=0;
            //если строка содержит нужный мне символ-то:
            //1. Записываю в массиов[0][0] саму читаемую строку
            //2.Записываю в массив [0][1] количество жителей для читаемой строки
            if (readLine.contains("|") ) {

                twoDimArray[firstArr][secondArr] = readLine;
                secondArr++;
                String numPeople;
                numPeople = readLine.substring(readLine.indexOf('|') + 1, readLine.lastIndexOf('|') + 1);
                    numPeople= numPeople.replaceAll("[|]", "");
                    twoDimArray[firstArr][secondArr] = numPeople.replaceAll("[ ]", "");                      
                firstArr++;
            }
        }

        // Сортировка по 2 стобцу
        Arrays.sort(twoDimArray, Comparator.comparingInt(o -> Integer.parseInt ((o[1]))));
        // Вывод отсортированных первых столбцов массива в новый файл
                for (int i = 0; i < twoDimArray.length; i++) {{
                if (twoDimArray[i][0] != null) {
                    newFile.println(twoDimArray[i][0]);
                }
            }
        }
        newFile.close();
    }
}
