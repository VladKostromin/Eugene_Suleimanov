package main.java.com.vlad_kostromin.javacore.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TinyEdit {
    // простейший текстовый редактор
    public static void main(String[] args) throws IOException {
        // создать поток ввода типа BufferedReader
        // используя стандапртный поток ввода System.in
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = new String[100];
        System.out.println("Введите строки текста.");
        System.out.println("Введите 'стоп' для завершения.");
        for (int i = 0; i < str.length; i++) {
            str[i] = br.readLine();
            if(str[i].equals("стоп")) break;
        }
        System.out.println("\nСодержимое вашего файла:");
        // выводим текстовые строки
        for (int i = 0; i < str.length; i++) {
            if(str[i].equals("стоп")) break;
            System.out.println(str[i]);
        }
    }
}
