package main.java.com.vlad_kostromin.javacore.chapter29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

// Применить итератор в потоке данных
public class StreamIteratorDemo {
    public static void main(String[] args) {
        // создать список символьных строк
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Альфа");
        myList.add("Бета");
        myList.add("Гамма");
        myList.add("Дельта");
        myList.add("Кси");
        myList.add("Омега");

        // получить итератор для потока данных
        Stream<String> myStream = myList.stream();
        Iterator<String> itr = myStream.iterator();

        // перебрать элементы в потоке данных
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
