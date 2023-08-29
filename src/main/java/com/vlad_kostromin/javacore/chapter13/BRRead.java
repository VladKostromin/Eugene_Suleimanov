package main.java.com.vlad_kostromin.javacore.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRRead {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите символы, 'q' - доя выхода.");
        //читать символы
        do {
            c = (char) bufferedReader.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
