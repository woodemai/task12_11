package ru.smirnov.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Utils {
    public static String readLineFromFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.readLine();
        }

    }


}