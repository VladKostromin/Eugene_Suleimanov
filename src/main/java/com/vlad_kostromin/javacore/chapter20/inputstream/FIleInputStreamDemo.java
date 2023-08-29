package main.java.com.vlad_kostromin.javacore.chapter20.inputstream;

import java.io.FileInputStream;
import java.io.IOException;

/*
Продемострировать применение класса FileInputStream
В этой программе используется оператор try с ресурсами.
 */
public class FIleInputStreamDemo {
    public static void main(String[] args) {
        int size;

        // Для автоматического закрытия потока ввода
        // используется оператор try с ресурсами
        try(FileInputStream fileInputStream = new FileInputStream("src/main/java/com/vlad_kostromin/javacore/chapter20/FIleInputStreamDemo.java")) {
            System.out.println("Общее количество доступных байтов: " + (size = fileInputStream.available()));
            int n = size / 40;
            System.out.println("Первые " + n + " байтов, " + "прочитанных из файла по очереди методом read()");
            for (int i = 0; i < n; i++) {
                System.out.print((char) fileInputStream.read());
            }
            System.out.println("\nВсе еще доступно: " + fileInputStream.available());
            System.out.println("Чтение следующих " + n + " байтов по очереди методом read(b[])");
            byte[] b = new byte[n];
            if(fileInputStream.read() != n) {
                System.err.println("Нельзя прочитать " + n + " байтов.");
            }
            System.out.println(new String(b,0, n));
            System.out.println("\nВсе еще доступно: " + (size = fileInputStream.available()));
            System.out.println("Пропустить половину оставшихся байтов методом skip()");
            fileInputStream.skip(size/2);
            System.out.println("Все еще доступно: " + fileInputStream.available());
            System.out.println("Чтение " + n / 2 + " байтов, размещаемых в конце массива");
            if(fileInputStream.read(b, n / 2, n/ 2) != n / 2) {
                System.err.println("Нельзя прочитать " + n / 2 + " байтов");
            }
            System.out.println(new String(b, 0 , b.length));
            System.out.println("\nВсе еще доступно: " + fileInputStream.available());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
        }

    }
}
