package main.java.com.vlad_kostromin.javacore.chapter22;

import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLConDemo {
    public static void main(String[] args) throws Exception {

        URL hp = new URI("https://www.google.com").toURL();
        HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();

        // вывести метод запроса
        System.out.println("Метод запроса: " + hpCon.getRequestMethod());

        // вывести код ответа
        System.out.println("Код ответа: " + hpCon.getResponseCode());

        //вывести ответное сообщение
        System.out.println("Ответное сообщение: " + hpCon.getResponseMessage());

        //получить список полей и множество ключей из заголовка
        Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
        Set<String> hdrField = hdrMap.keySet();
        System.out.println("\nДалее следует заголовок:");

        // вывести все ключи и значения из заголовка
        for (String key : hdrField) {
            System.out.println("Ключ: " + key + " Значение: " + hdrMap.get(key));
        }
    }
}
