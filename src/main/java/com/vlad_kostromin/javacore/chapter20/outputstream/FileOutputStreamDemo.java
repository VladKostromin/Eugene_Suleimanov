package main.java.com.vlad_kostromin.javacore.chapter20.outputstream;

import java.io.Console;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String source = "Now is the time for all good men\n" +
                " to come to the aid of their country\n" +
                " and pay their due taxes";
        byte buf[] = source.getBytes();
        FileOutputStream f0 = null;
        FileOutputStream f1 = null;
        FileOutputStream f2 = null;

        try {
            f0 = new FileOutputStream("src/main/java/com/vlad_kostromin/javacore/chapter20/files/file1.txt");
            f1 = new FileOutputStream("src/main/java/com/vlad_kostromin/javacore/chapter20/files/file2.txt");
            f2 = new FileOutputStream("src/main/java/com/vlad_kostromin/javacore/chapter20/files/file3.txt");

            // запись данных в первый фаил
            for (int i = 0; i < buf.length; i += 2) {
                f0.write(buf[i]);
            }

            // запис данных во второй фаил
            f1.write(buf);

            // запись данных в третий файл
             f2.write(buf, buf.length - buf.length / 4, buf.length / 4);
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        } finally {
            try {
                if(f0 != null) f0.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла file1.txt");
            }
            try {
                if(f1 != null) f1.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла file2.txt");
            }
            try {
                if(f2 != null) f2.close();
            } catch (IOException e) {
                System.out.println("Ошибка закрытия файла file3.txt");
            }
        }
    }
}
