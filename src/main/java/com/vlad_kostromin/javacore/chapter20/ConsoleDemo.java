package main.java.com.vlad_kostromin.javacore.chapter20;

import java.io.Console;

public class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console con;

        //получить ссылку на консоль
        con = System.console();

        // выйим из программы, если консоль недоступна
        if (con == null) {
            System.out.println("Консоль не доступна");
            return;
        }

        //прочитать строку и вывести ее
        str = con.readLine("Введите строку: ");
        con.printf("Введенная вами строка:  %s\n", str);
    }
}
