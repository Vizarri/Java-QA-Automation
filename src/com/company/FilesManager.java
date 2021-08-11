package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FilesManager {
    public PrintWriter createrNameNewFile(String newFilesName, String dateForFileName) {
        try {
            return new PrintWriter(String.format("%s %s .txt", newFilesName, dateForFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
