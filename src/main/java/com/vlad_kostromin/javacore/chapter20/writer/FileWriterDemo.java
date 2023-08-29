package main.java.com.vlad_kostromin.javacore.chapter20.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n" +
                " to come to the aid of their country\n" +
                " and pay their due taxes";
        char[] buffer = new char[source.length()];
        source.getChars(0, source.length(), buffer,0);

        try(FileWriter f0 = new FileWriter("src/main/java/com/vlad_kostromin/javacore/chapter20/files/file4.txt");
            FileWriter f1 = new FileWriter("src/main/java/com/vlad_kostromin/javacore/chapter20/files/file5.txt");
            FileWriter f2= new FileWriter("src/main/java/com/vlad_kostromin/javacore/chapter20/files/file6.txt")) {

            //вывести символы в первый файл
            for (int i = 0; i < buffer.length; i += 2) {
                f0.write(buffer[i]);
            }

            //вывести символы во второй файл
            f1.write(buffer);

            //вывести символы в трейтий файл
            f2.write(buffer, buffer.length - buffer.length/4, buffer.length / 4);
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
    }
}
