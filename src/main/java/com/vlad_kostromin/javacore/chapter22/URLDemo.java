package main.java.com.vlad_kostromin.javacore.chapter22;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

// демострация применения класса URL
public class URLDemo {
    public static void main(String[] args) throws Exception {
        URL hp = new URI("http://www.HerbSchildt.com/Articles").toURL();

        System.out.println("Протокол: " + hp.getProtocol());
        System.out.println("Порт: " + hp.getPort()); // -1 потому что порт явно не установлен

        System.out.println("Хост: " + hp.getHost());
        System.out.println("Файл: " + hp.getFile());
        System.out.println("Полная форма: " + hp.toExternalForm());
    }
}
