package main.java.com.vlad_kostromin.javacore.chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileWithMR {
    public static void main(String[] args) {
        int i;

        //сначала убедиться, что указаны имена обоих файлов
        if(args.length != 2) {
            System.out.println("Использование: CopyFile откуда куда");
            return;
        }
        //копирование файла
        try (FileInputStream fin = new FileInputStream(args[0]);
        FileOutputStream fout = new FileOutputStream(args[1])){

            do {
                i = fin.read();
                if(i != -1) fout.write(i);
            } while (i != -1);

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }
    }
}
