package main.java.com.vlad_kostromin.javacore.chapter22;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLConnectionDemo {
    public static void main(String[] args) throws Exception {
        int c;
        URL hp = new URI("http://www.internic.net").toURL();
        URLConnection hpCon = hp.openConnection();

        // получить дату
        long d= hpCon.getDate();
        if(d == 0) {
            System.out.println("Сведения о дате отсутсуют.");
        } else {
            System.out.println("Дата: " + new Date(d));
        }

        // получить тип содержимого
        System.out.println("Тип содержимого: " + hpCon.getContentType());

        // получить дату срока действия ресурса
        d = hpCon.getExpiration();
        if(d == 0) {
            System.out.println("Сведения о сроке действия отсутсуют.");
        } else {
            System.out.println("Срок действия истекает: " + new Date(d));
        }

        // получить дату последней модификации
        d = hpCon.getLastModified();
        if(d == 0) {
            System.out.println("Сведения о последей модификации отсутсуют.");
        } else {
            System.out.println("Дата последней модификации: " + new Date(d));
        }

        // получить длину содержимого
        long len = hpCon.getContentLengthLong();
        if(len == -1) {
            System.out.println("Длина содержимого недоступна.");
        } else {
            System.out.println("Длина содержимого: " + len);
        }

        if(len != 0) {
            System.out.println("=== Содержимое ===");
            InputStream input = hpCon.getInputStream();
            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
            input.close();
        } else {
            System.out.println("Содержимое недоступно");
        }
    }
}
