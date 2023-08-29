package main.java.com.vlad_kostromin.javacore.chapter20.reader;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("src/main/java/com/vlad_kostromin/javacore/chapter20/FileReaderDemo.java")) {
            int c;
            //прочитать и вывести содержимое файла
            while ((c = fr.read()) != -1) System.out.print((char) c);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
